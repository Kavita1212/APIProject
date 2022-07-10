Feature: Location search

Scenario: Searching the location with the GET API

When users calls the "LocationSearchAPI" with "GET" https request 
Then the API call success with status code 403 
Then "message" must be "You are not subscribed to this API." 


