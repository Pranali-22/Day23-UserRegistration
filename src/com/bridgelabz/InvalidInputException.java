/**
 * 
 */
package com.bridgelabz;

/**
 * @author Dell
 * UC13 - Refactor the Code to
 * use Lambda Function
 * to validate User Entry
 */

public class InvalidInputException extends Exception{
	String exceptionMessage;

	public InvalidInputException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
