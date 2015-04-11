package org.teamn.operations;


import lombok.extern.slf4j.Slf4j;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.platform.Verticle;

@Slf4j
public class SearchData extends Verticle {

    @Override
    public void start() {
        super.start();
        JsonObject conf = container.config();
    }
}
