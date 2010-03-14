package ru.mystamps.site.beans;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

public class RegisterBean {
	
	private UIInput loginInput;
	private UIInput passwordInput;
	
	private Logger log = null;
	
	public RegisterBean() {
		log = Logger.getRootLogger();
	}
	
	public void setPasswordInput(UIInput passwordInput) {
		this.passwordInput = passwordInput;
	}
	
	public UIInput getPasswordInput() {
		return passwordInput;
	}
	
	public void setLoginInput(UIInput loginInput) {
		this.loginInput = loginInput;
	}
	
	public UIInput getLoginInput() {
		return loginInput;
	}
	
	/**
	 * Get message translation from application bundle for current locale.
	 *
	 * @param FacesContext context
	 * @param String message
	 **/
	private String getMessageTranslation(FacesContext context, String message) {
		
		String bundleName = context.getApplication().getMessageBundle();
		Locale locale = context.getViewRoot().getLocale();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		final String translatedMessage =
			ResourceBundle.getBundle(bundleName, locale, loader).getString(message);
		
		return translatedMessage;
	}
	
	/**
	 * Check that login and password mismath.
	 *
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @throws ValidatorException
	 **/
	public void validatePasswordLoginMismatch(FacesContext context,
			UIComponent component, Object value) {
		
		// don't continue if login field not set or not valid
		if (! loginInput.isValid()) {
			return;
		}
		
		final String login = (String)loginInput.getLocalValue();
		final String password = (String)value;
		
		if (login == null) {
			log.warn("validatePasswordLoginMismatch(): value of login field is null!");
		}
		
		if (password == null) {
			log.warn("validatePasswordLoginMismatch(): value of password field is null!");
		}
		
		try {
			if (login.equals(password)) {
				String msg = getMessageTranslation(context, "tv_password_login_match");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				throw new ValidatorException(message);
			}
		} catch (NullPointerException ex) {
			log.error("validatePasswordLoginMismatch() exception: " + ex.getMessage());
		}
	}
	
	/**
	 * Check that password and password confirmation are similar.
	 *
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @throws ValidatorException
	 **/
	public void validatePasswordConfirm(FacesContext context,
			UIComponent component, Object value) {
		
		// don't continue if password field not set or not valid
		if (! passwordInput.isValid()) {
			return;
		}
		
		final String password = (String)passwordInput.getLocalValue();
		final String passwordConfirm = (String)value;
		
		if (password == null) {
			log.warn("validatePasswordConfirm(): value of password field is null!");
		}
		
		if (passwordConfirm == null) {
			log.warn("validatePasswordConfirm(): value of passwordConfirm field is null!");
		}
		
		try {
			if (! password.equals(passwordConfirm)) {
				String msg = getMessageTranslation(context, "tv_password_mismatch");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				throw new ValidatorException(message);
			}
		} catch (NullPointerException ex) {
			log.error("validatePasswordConfirm() exception: " + ex.getMessage());
		}
	}
	
}

