Feature: Automated End2End Tests
Description: The prupose of this feature is to test End 2 End integration. 

Scenario Outline: User want to contact us for Help
Given user is on home page
When he go to contact us page 
And user enterd Data "<fullname>","<email>","<massege>" 
Then he contacted us Successfuly

Examples:
| fullname | email | massege |
| IslamFares | islamfOxcold7@gmail.com | HellofOx |

