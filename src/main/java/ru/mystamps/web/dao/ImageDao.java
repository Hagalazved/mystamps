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
package ru.mystamps.web.dao;

import org.springframework.data.repository.CrudRepository;

<<<<<<< 52a5f5acc11f3a09ea0051b87bcbff2e8f915144:src/main/java/ru/mystamps/web/dao/ImageDao.java
import ru.mystamps.web.entity.Image;

public interface ImageDao extends CrudRepository<Image, Integer> {
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.mystamps.web.it.page.AuthAccountPage;
import ru.mystamps.web.tests.WebDriverFactory;

public class CommonSteps {
	
	private final AuthAccountPage page;
	
	public CommonSteps() {
		WebDriver driver = WebDriverFactory.getDriver();
		page = PageFactory.initElements(driver, AuthAccountPage.class);
	}
	@Given("^As anonymous user$")
	public void becomeAnonymousUser() {
		// TODO: do logout if we're already authenticated
	}
	
	@Given("^As authenticated user$")
	public void becomeAuthenticatedUser() {
		page.open();
		// TODO: check message and do nothing if we're already authenticated
		// TODO: get login/password from spring context
		page.loginAs("coder", "test");
	}
	
>>>>>>> WhenUserAtIndexPage: port to Cucumber.:src/test/java/ru/mystamps/web/it/step/CommonSteps.java
}
