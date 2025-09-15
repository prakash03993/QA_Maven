package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.reusableMethods.BaseClass;

public class LoginPage extends BaseClass implements LoginPageInterfaceElements{

	@FindBy(xpath = userName_xpath)
	private WebElement userName;

	@FindBy(xpath = password_xpath)
	private WebElement password;

	@FindBy(xpath = login_xpath)
	private WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validLogin() {

		//elementClick(Signin);
		valuePassing(userName, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("userName"));
		valuePassing(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		elementClick(login);

	}

	
}
