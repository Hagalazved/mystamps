/*
 * Copyright (C) 2009-2016 Slava Semushin <slava.semushin@gmail.com>
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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.RequiredArgsConstructor;

import ru.mystamps.web.Url;

@RequiredArgsConstructor
public class RegisterAccountPage {
    private final WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "email.errors")
    private WebElement errorMessage;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public void open() {
        PageFactory.initElements(driver, this);
        driver.navigate().to(Url.SITE + Url.REGISTRATION_PAGE);
    }

    public void registerUser(String email) {
        emailField.sendKeys(email);
        registerButton.click();
    }

    public String getErrorByFieldName(String fieldEmail) {
        return fieldNameToErrorMessage(fieldEmail).getText();
    }

    private WebElement fieldNameToErrorMessage(String fieldEmail) {
        return fieldNameToElement(fieldEmail, true);
    }

    private WebElement fieldNameToElement(String fieldEmail, boolean toErrorMessage) {
        switch (fieldEmail) {
            case "email":
                return toErrorMessage ? errorMessage : emailField;
            default:
                throw new IllegalStateException("Unknown field email: " + fieldEmail);
        }
    }


}
