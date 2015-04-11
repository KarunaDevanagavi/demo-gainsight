package org.teamn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.teamn.common.EventCode;
import org.teamn.common.EventType;
import org.teamn.helper.DateConversion;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
public class Activity {

    private Date time;
    private EventType eventType;
    private EventCode eventCode;
    private Product product;
    private User user;
    @Setter
    private String searchString;
    @Setter
    private String orderId;
    private String activityId;

    public Activity(String userId, String event, String eventType, String time) throws ParseException {
        setActivityId(userId, time);
        setEventType(eventType);
        setEvent(event);
        this.user = new User(userId);

    }

    public void setProduct(String sku){
        this.product = new Product(sku);
    }

    private void setActivityId(String userId,  String time) throws ParseException {
        this.time = DateConversion.stringToDate(time);
        this.activityId = userId + "-" + time;
    }

    private void setEventType(String eventType){
        if (Objects.equals(eventType, "WebPage"))
            this.eventType = EventType.WEBPAGE;
        else if (Objects.equals(eventType, "Mobile"))
            this.eventType = EventType.MOBILE;
    }
    private void setEvent(String event){
        if (Objects.equals(event, "Login"))
            this.eventCode = EventCode.LOGIN;
        else if (Objects.equals(event, "Search"))
            this.eventCode = EventCode.SEARCH;
        else if (Objects.equals(event, "ProductPage"))
            this.eventCode = EventCode.PRODUCTPAGE;
        else if (Objects.equals(event, "AddToCart"))
            this.eventCode = EventCode.ADDTOCART;
        else if (Objects.equals(event, "RemoveFromCart"))
            this.eventCode = EventCode.REMOVEFROMCART;
        else if (Objects.equals(event, "OrderPlaced"))
            this.eventCode = EventCode.ORDERPLACED;
        else if (Objects.equals(event, "OrderReturn"))
            this.eventCode = EventCode.ORDERRETURN;
        else if (Objects.equals(event, "LogOut"))
            this.eventCode = EventCode.LOGOUT;
    }
}
