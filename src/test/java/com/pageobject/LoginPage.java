package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.Base;

public class LoginPage extends Base{

    /*
     * EJEMPLOS:
     * 
     * @FindBy(id = "foobar") By foobar;
     * @FindBy(className = "foobar") By foobar;
     * @FindBy(css = "foobar") By foobar;
     * @FindBy(linkText = "foobar") By foobar;
     * @FindBy(name = "foobar") By foobar;
     * @FindBy(partialLinkText = "foobar") By foobar;
     * @FindBy(tagName = "foobar") By foobar;
     * @FindBy(using = "foobar") By foobar;
     * @FindBy(xpath = "foobar") By foobar;
     * 
     */

     By Username = By.id("Username");
     By btnSubmit = By.id("btnSubmit");
     By pwd = By.id("pwd");
     By login = By.id("login");
     By loginErrorMessage = By.className("validation-summary-errors");
     By btnBack = By.xpath("/html/body/div[2]/div/div/div[2]/div/form/div[3]/div[1]/button");

    //@FindBy(id = "Username") By Username;
    //@FindBy(id = "btnSubmit") By btnSubmit;
    //@FindBy(id = "pwd") By pwd;
    //@FindBy(id = "login") By login;


    final String USER = "pmartinez@miempresa.work";
    final String PASS = "WbtD3mo2021&";


    public LoginPage(WebDriver driver){
        super(driver);
    }


    public void loginUser(){
        type(USER, Username);
        click(btnSubmit);
        type(PASS, pwd);
        click(login);
    }

    public Boolean loginEmptyUsername(){
        type("", Username);
        return isEnabled(btnSubmit);
    }

    public String loginIncorrectUsername(){
        type("incorrectusername", Username);
        click(btnSubmit);
        type(PASS, pwd);
        click(login);
        return getText(loginErrorMessage);
    }

    public String loginIncorrectPassword(){
        type(USER, Username);
        click(btnSubmit);
        type("incorrectpass", pwd);
        click(login);
        return getText(loginErrorMessage);
    }

    public Boolean loginBackButton(){
        type(USER, Username);
        click(btnSubmit);
        click(btnBack);
        if(isEnabled(btnSubmit) == false && isDisplayed(btnBack) == false){
            return false;
        }else{
            return true;
        }
        
    }

    public String getTitle(){
        return getTitlePage();
    }
}