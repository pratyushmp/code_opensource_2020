package com.hacktober.open;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
	
	private static final String EMAIL_REGEX =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void main(String[] args) {
		
		String eMail = "hacktoberMail@mail.com";
		
		if(validEmail(eMail)) {
			System.out.println("Email is valid");
		}else {
			System.out.println("Please enter a valid Email address");
		}
	}


	public static boolean validEmail(String email){
		Pattern pattern =Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
