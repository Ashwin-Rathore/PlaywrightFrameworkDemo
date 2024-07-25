package com.pages.pageObjectRepository;

import com.microsoft.playwright.Page;

/**
 * Create By : Ashwin Rathore on 02/07/24
 *
 * @author : arathore@tracelin.com
 * @date :  02/07/24
 */
public class LoginPageObject {
//    private final Page page;
//    public LoginPageObject(Page page) {
//        this.page = page;
//    }

    public void enterUsername(String username) {
        System.out.println("Please Enter User Name");
    }

    public void enterPassword(String password) {
        System.out.println("Please Enter Password");
    }

    public void clickLoginButton() {
        System.out.println("Please click Login Button");
    }
}
