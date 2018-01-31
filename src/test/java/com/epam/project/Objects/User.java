package com.epam.project.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public interface User {

    String getUsername();
    String getPassword();
    List<String> toListOfCred();

}
