Feature: Free CRM login feature
Scenario: Free CRM login testcase


Given user is already on login page
When title of login page is FreeCRM
Then user enters username and password 
Then user click on login button
Then user is on home page