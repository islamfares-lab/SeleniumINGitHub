Feature: User Registration
I want to check that the User can Register in our e-Commerce website.

Scenario Outline: User Registration
Given  the user in the home page
When i click on register link
And  i entered the "<firstname>","<lastname>","<email>","<password>"
Then The registration page displayed successfully

Examples:
| firstname | lastname | email | password |
| Islam | Fares | islamfOxcol0288@gmail.com | 12345678 |
| fOx | Magnito | usertjaemozh7044575sa817@yahoo.com| 12345678 |