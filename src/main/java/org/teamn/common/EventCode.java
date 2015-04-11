package org.teamn.common;


public enum EventCode {
    LOGIN("Login")                  , SEARCH("Search"),
    PRODUCTPAGE("ProductPage")      , ADDTOCART("AddToCart"),
    REMOVEFROMCART("RemoveFromCart"), ORDERPLACED("OrderPlaced"),
    ORDERRETURN("OrderReturn")      , LOGOUT("LogOut");

    private final String code;

    EventCode(String s) {
        code = s;
    }

    public boolean equalsCode(String otherCode){
        return (otherCode != null) && code.equals(otherCode);
    }

    public String toString(){
        return code;
    }
}
