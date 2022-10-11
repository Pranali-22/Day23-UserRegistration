/**
 * 
 */
package com.bridgelabz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dell
 * UC13 - Refactor the Code to
 * use Lambda Function
 * to validate User Entry
 */
interface IValidate {
	public boolean validateFields(String fieldValue, String regexForField);
}

public class UserRegistration{
	
	String firstName, lastName, emailId, mobileNumber, password;
	
	public UserRegistration() {
		
	}
		
	//Parameterized constructor
	public UserRegistration(String firstName, String lastName, String emailId, String mobileNumber, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
	IValidate validateObj = (fieldValue, regexForField) -> {
		Pattern patternObj = Pattern.compile(regexForField);			 
		Matcher matcherObj = patternObj.matcher(fieldValue);
		return matcherObj.matches();
	};
	
	
	//Validate first name
	public boolean validateFirstName(String firstName) throws InvalidInputException{
	
		String newRegex =  "[A-Z]{1}[a-z]{2,}$";
		boolean isValidFirstName = validateObj.validateFields(firstName, newRegex);
		//System.out.println(validateObj.validateFields(firstName, newRegex));
		
		if(isValidFirstName == false) {
			throw new InvalidInputException("Invalid First Name");
		}
		return isValidFirstName;
		
	}
	
					
	//Validate last name
	public boolean validateLastName(String lastName) throws InvalidInputException{
		String newRegex =  "[A-Z]{1}[a-z]{2,}$";
		boolean isValidLastName = validateObj.validateFields(lastName, newRegex);
		
		if(isValidLastName == false) {
			throw new InvalidInputException("Invalid Last Name");
		}
		return isValidLastName;
	}
		
	//Validate email address
	public boolean validateEmailAddress(String emailId) throws InvalidInputException{
		String newRegex = "^[a-zA-Z]+[a-zA-Z0-9]*[- . + _]?[a-zA-Z0-9]+[@]{1}[a-z0-9]+[.]{1}[a-z]+[.]?[a-z]+$";
		
		boolean isValidEmailId = validateObj.validateFields(emailId, newRegex);
		
		if(isValidEmailId == false) {
			throw new InvalidInputException("Invalid Email Id");
		}
		return isValidEmailId;
	}

		
	//Validate mobile number
	public boolean validateMobileNumber(String mobileNumber) throws InvalidInputException{
		String newRegex = "[0-9]{2} [0-9]{10}$";
		
		boolean isValidMobileNumber = validateObj.validateFields(mobileNumber, newRegex);
		
		if(isValidMobileNumber == false) {
			throw new InvalidInputException("Invalid mobile number");
		}
		return isValidMobileNumber;
	}
		
	//Validate password to have exact 1 special character
	public boolean validatePassword(String password) throws InvalidInputException{
		String newRegex = "[A-Z]{1,}[a-zA-Z0-9]{5,}[!@#$&*]{1,}[0-9]{1,}$";
		
		boolean isValidPassword = validateObj.validateFields(password, newRegex);
		
		if(isValidPassword == false) {
			throw new InvalidInputException("Invalid mobile number");
		}
		return isValidPassword;
	}
		
		
	//validate fields using exceptions
	
	public void validateFirstNameWithException(String firstName) {
		try {
			validateFirstName(firstName);			
		}
		catch(InvalidInputException e){
			System.out.println(e.exceptionMessage);
		}
	}
	
	public void validateLastNameWithException(String lastName) {
		try {
			validateLastName(lastName);
		}
		catch(InvalidInputException e){
			System.out.println(e.exceptionMessage);
		}
	}
	
	public void validateEmailIdWithException(String emailId) {
		try {
			validateEmailAddress(emailId);
		}
		catch(InvalidInputException e){
			System.out.println(e.exceptionMessage);
		}
	}
	
	public void validateMobileNumberWithException(String mobileNumber) {
		try {
			validateMobileNumber(mobileNumber);
		}
		catch(InvalidInputException e){
			System.out.println(e.exceptionMessage);
		}
	}
	
	public void validatePasswordWithException(String password) {
		try {
			validatePassword(password);
		}
		catch(InvalidInputException e){
			System.out.println(e.exceptionMessage);
		}
	}

	
	
}
