package com.epam.project.Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iana_Kasimova on 31-Jan-18.
 */
public class PrivilegedUser implements User{
    @Getter @Setter private String username;
    @Getter @Setter private String password;

    public PrivilegedUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    //добавила system out чтобы сделать различия для привилегированных пользователей, в реальной жизни просто может быть будет еще второй пароль к примеру иил еще что то
    @Override
    public List<String> toListOfCred(){
        List<String> credentials = new ArrayList<String>();
        credentials.add(this.username);
        credentials.add(this.password);
        System.out.println(credentials.get(0) + " this is username " + credentials.get(1) + " this is password");
        return credentials;
    }
}
