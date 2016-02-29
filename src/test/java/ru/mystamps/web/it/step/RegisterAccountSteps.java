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
package ru.mystamps.web.it.step;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import ru.mystamps.web.it.page.RegisterAccountPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegisterAccountSteps {

    private static final int EMAIL_MAX_LENGTH = 255;
    private final RegisterAccountPage page;

    @Autowired
    public RegisterAccountSteps(RegisterAccountPage page) {
        this.page = page;
    }

    @When("^I open registration page$")
    public void openRegistrationPage() {
        page.open();
    }

    @And("^I enter email max length$")
    public void enterEmailMaxLength() {
        page.registerUser(StringUtils.repeat("0", EMAIL_MAX_LENGTH) + "@mail.ru");
    }

    @Then("^I see that field \"([^\"]*)\" has error \"([^\"]*)\" in register user form$")
    public void fieldShouldHaveAnError(String email, String errorMessage) {
        assertThat(page.getErrorByFieldName(email), is(equalTo(errorMessage)));
    }

}
