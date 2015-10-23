/*
<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333
 * Copyright (C) 2009-2016 Slava Semushin <slava.semushin@gmail.com>
=======
 * Copyright (C) 2009-2015 Slava Semushin <slava.semushin@gmail.com>
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
 * Copyright (C) 2009-2015 Slava Semushin <slava.semushin@gmail.com>
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.it.page;

import org.apache.commons.lang3.Validate;

<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
>>>>>>> WhenUserAtIndexPage: port to Cucumber.

import lombok.RequiredArgsConstructor;

import ru.mystamps.web.Url;

@RequiredArgsConstructor
public class AuthAccountPage {
	
	private final WebDriver driver;
	
<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333
	@FindBy(id = "sign-out-btn")
	private WebElement signOutButton;
	
=======
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
	@FindBy(id = "login")
	private WebElement loginField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;
	
<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333
	@FindBy(id = "info-msg")
	private WebElement infoMessage;
	
	public void open() {
		PageFactory.initElements(driver, this);
=======
	public void open() {
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
	public void open() {
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
		driver.navigate().to(Url.SITE + Url.AUTHENTICATION_PAGE);
	}
	
	public void loginAs(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		signInButton.submit();

		ensureCurrentPageUrl(Url.SITE + Url.INDEX_PAGE);
	}
	
<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144
<<<<<<< 5a3f7f18c4f46b20c6341c1fd131c5710bfda333
	public void logout() {
		signOutButton.submit();
	}
	
	public boolean hasInfoMessage() {
		try {
			return !"".equals(infoMessage.getText());
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
=======
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
=======
>>>>>>> WhenUserAtIndexPage: port to Cucumber.
	private void ensureCurrentPageUrl(String expectedUrl) {
		String currentUrl = driver.getCurrentUrl();
		Validate.validState(
			expectedUrl.equals(currentUrl),
			"Current URL should be %s but it's %s",
			expectedUrl,
			currentUrl
		);
	}
	
}
