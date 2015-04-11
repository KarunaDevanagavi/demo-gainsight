package org.teamn;


import org.teamn.metrics.MetricsVerticle;
import org.teamn.elasticsearch.ElasticSearchVerticle;
import lombok.extern.slf4j.Slf4j;
import org.teamn.amqp.AmqpBridge;
import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.AsyncResultHandler;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.platform.Verticle;

@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
@Slf4j
public class Controller extends Verticle{

    @Override
    public void start() {
        super.start();
        JsonObject config = container.config();
        final JsonObject elasticConfig = config.getObject("elasticsearch");
        final JsonObject rabbitConfig = config.getObject("rabbit");
        final JsonObject metricsConfig = config.getObject("metrics");

        container.deployVerticle(ElasticSearchVerticle.class.getName(), elasticConfig, 1, new AsyncResultHandler<String>() {
            @Override
            public void handle(AsyncResult<String> esEvent) {
                if (esEvent.succeeded()){
                    log.info("deployed {} successfully, deployment id : {}", ElasticSearchVerticle.class.getName(), esEvent.result());
                }else if (esEvent.failed()){
                    log.info("failed to deploy {}, error : {}", ElasticSearchVerticle.class.getName(), esEvent.cause().getMessage());
                }
                container.deployVerticle(AmqpBridge.class.getName(), rabbitConfig, 1,  new AsyncResultHandler<String>() {
                    @Override
                    public void handle(AsyncResult<String> rabbitEvent) {
                        if (rabbitEvent.succeeded()){
                            log.info("deployed {} successfully, deployment id : {}", AmqpBridge.class.getName(), rabbitEvent.result());
                        }else if (rabbitEvent.failed()){
                            log.info("failed to deploy {}, error : {}", AmqpBridge.class.getName(), rabbitEvent.cause().getMessage());
                        }
                        container.deployVerticle(MetricsVerticle.class.getName(), metricsConfig, 1, new AsyncResultHandler<String>() {
                            @Override
                            public void handle(AsyncResult<String> metricsEvent) {
                                if (metricsEvent.succeeded()){
                                    log.info("deployed {} successfully, deployment id : {}", MetricsVerticle.class.getName(), metricsEvent.result());
                                } else if (metricsEvent.failed()){
                                    log.info("failed to deploy {}, error : {}", MetricsVerticle.class.getName(), metricsEvent.cause().getMessage());
                                }
//                                container.deployVerticle(MetricsVerticle.class.getName(), metricsConfig, 1, );
                            }
                        });
                    }
                });
            }
        });
    }
}
