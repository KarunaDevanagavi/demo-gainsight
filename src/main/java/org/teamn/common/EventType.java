package org.teamn.common;


public enum EventType {
    WEBPAGE("WebPage"), MOBILE("Mobile"),;

    private final String type;

    EventType(String s) {
        type = s;
    }

    public boolean equalsType(String otherName){
        return (otherName != null) && type.equals(otherName);
    }

    public String toString(){
        return type;
    }
}
