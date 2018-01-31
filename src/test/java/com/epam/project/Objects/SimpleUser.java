package com.epam.project.Objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iana_Kasimova on 31-Jan-18.
 */
public class SimpleUser implements User{
    @Getter @Setter private String username;
    @Getter @Setter private String password;

    public SimpleUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public List<String> toListOfCred(){
        List<String> credentials = new ArrayList<String>();
        credentials.add(this.username);
        credentials.add(this.password);
        return credentials;
    }
}
