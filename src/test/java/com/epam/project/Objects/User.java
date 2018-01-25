package com.epam.project.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class User {
    public String username;
    public String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public List<String> toListOfCred(){
        List<String> credentials = new ArrayList<String>();
        credentials.add(this.username);
        credentials.add(this.password);
        return credentials;
    }
}
