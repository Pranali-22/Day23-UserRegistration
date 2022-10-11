/**
 * 
 */
package com.bridgelabz;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * @author Dell
 * UC13 - Refactor the Code to
 * use Lambda Function
 * to validate User Entry
 */

class UserRegistrationTest {

	@Test
	void check_user_registration_is_valid_or_not() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name");
		String firstName=input.nextLine();
		
		System.out.println("Enter last name");
		String lastName=input.nextLine();		
		
		System.out.println("Enter email address");
		String emailId = input.nextLine();
		
		System.out.println("Enter mobile number");
		String mobileNumber = input.nextLine();
		
		System.out.println("Enter password");
		String password = input.nextLine();
		
		UserRegistration userRegistration = new UserRegistration(firstName, lastName, emailId, mobileNumber, password);	
		
		userRegistration.validateFirstNameWithException(firstName);
		userRegistration.validateLastNameWithException(lastName);
		userRegistration.validateEmailIdWithException(emailId);
		userRegistration.validateMobileNumberWithException(mobileNumber);
		userRegistration.validatePasswordWithException(password);
	}
	
	
}
