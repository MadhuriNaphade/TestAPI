Feature: Weather
 
Scenario: Weather checking for the provided city 
 Given User is on Home Page
 When the status code is 200
 Then Get the Weather Details
 
Scenario: Successful Quit
 When Got the weather details
 Then quit successfully