package org.teamn.common;


public enum  Gender {
    MALE("male"), FEMALE("female"),;

    private final String type;

    Gender(String s) {
        type = s;
    }

    public boolean equalsType(String otherName){
        return (otherName != null) && type.equals(otherName);
    }

    public String toString(){
        return type;
    }
}
