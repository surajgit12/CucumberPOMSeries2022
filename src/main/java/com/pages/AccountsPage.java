package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	
	private WebDriver driver;
	
	// 1. By Locators: OR
	private By AccountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver =driver;
	}
	
	
	public String getaccountPageTitle() {
		return driver.getTitle();
	}
	public int getAccountsSectionCount() {
		return driver.findElements(AccountSections).size()-1;
	}
	
	public List<String> getAccountsSectionList() {
		
		List<String> AccountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList =driver.findElements(AccountSections);
		
		for(WebElement e :accountsHeaderList) {
			String text =e.getText();
			System.out.println(text);
			AccountsList.add(text);
		}
		return AccountsList;
	}
	
	
	
	
}
