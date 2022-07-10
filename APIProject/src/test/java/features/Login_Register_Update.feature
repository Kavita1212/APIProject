Feature: Register,Login and Update 

@Login
Scenario Outline: Login with emailaddress and password 

	Given Login with "<email>" and "<password>" 
	When users calls "LoginAPI" with "POST" https request 
	Then the API call is success with status code 200 
	
	Examples: 
		|email			   |password  |
		|eve.holt@reqres.in|cityslicka|
	
@Login
Scenario Outline: Verify the error message when login without password

	Given Login with "<email>" and "<password>" 
	When users calls "LoginAPI" with "POST" https request 
	Then the API call is success with status code 400 
	Then "error" should be "Missing password" 
	
	Examples: 
		|email			   |password  |
		|eve.holt@reqres.in|          |
		
@Register		
Scenario Outline: user registration 

	Given Login with "<email>" and "<password>" 
	When users calls "RegisterAPI" with "POST" https request 
	Then the API call is success with status code 200 
	
	Examples: 
		|email			   |password  |
		|eve.holt@reqres.in|pistol    |
		
@Register	
Scenario Outline: user registration without password 

	Given Login with "<email>" and "<password>" 
	When users calls "RegisterAPI" with "POST" https request 
	Then the API call is success with status code 400 
	Then "error" should be "Missing password" 
	
	Examples: 
		|email			   |password  |
		|sydney@fife       |    	  |
		
				
@Update		
Scenario Outline: Update the user 

	Given update the user "<name>" and "<job>" 
	When users calls "UpdateAPI" with "PUT" https request 
	Then the API call is success with status code 200 
	Then "name" should be "<name>" 
	Then "job" should be "<job>" 
	
	
	Examples: 
		|name    |job          |
		|morpheus|zion resident|
		
		
		
		
		
