package org.teamn.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.teamn.common.Gender;

@Getter
@ToString
@EqualsAndHashCode
public class User {

    private String id;
    @Setter
    private String email;
    @Setter
    private Gender gender;
    @Setter
    private String dob;
    @Setter
    private String signUpTime;
    @Setter
    private PinCode pincode;

    public User(String id){
        this.id = id;
    }

}
