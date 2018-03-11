package com.epam.project;

import com.epam.project.Utils.BaseTest;

import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class EmailTest extends BaseTest{


    @Test
    public void testLogIn(){
        emailAssert.checkSuccessfullLogIn(email);
    }


    @Test
    public void draftTest(){
        email.createDraft();
        emailAssert.checkExistanceDraft(email);
        email.deleteEmail();

    }


    @Test
    public void sentTest(){
        email.createDraft();
        email.sentDraft();
        emailAssert.checkNonExistenceDraft(email);
        emailAssert.checkExistenceSentEmail(email);
        email.deleteSentEmail();
    }

}
