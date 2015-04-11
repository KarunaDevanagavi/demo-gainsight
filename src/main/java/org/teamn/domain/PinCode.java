package org.teamn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class PinCode {
    private Integer pin;
    @Setter
    private String divisionName;
    @Setter
    private String regionName;
    @Setter
    private String circleName;
    @Setter
    private String districtName;
    @Setter
    private String talukName;

    public PinCode(Integer pin){
        this.pin = pin;
    }
}
