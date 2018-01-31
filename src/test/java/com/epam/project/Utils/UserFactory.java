package com.epam.project.Utils;

import com.epam.project.Objects.PrivilegedUser;
import com.epam.project.Objects.SimpleUser;
import com.epam.project.Objects.User;

/**
 * Created by Iana_Kasimova on 31-Jan-18.
 */
public class UserFactory {

    public User createUser(String typeofUser){
        User user = null;
        if(typeofUser.equals("VIP")){
            user = new PrivilegedUser("Iana", "1234");
        } else if(typeofUser.equals("simple")){
            user = new SimpleUser("janekasimova", "Qwerty123456");
        }
        return user;
    }
}
