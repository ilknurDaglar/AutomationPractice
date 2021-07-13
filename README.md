## How to run the tests locally
* Locally I use Cucumber and Selenium tools. Page Object Model structure in order to keep my code organized and clean. So, I basically created a separate Java class for each page
of my application. I have separate classes where I keep my implemented step definitions. Also, for each scenario (positive or negative) I created Cucumber feature files where
I used GHERKIN language in order to describe my test scenarios, by doing that I'm making sure that my test cases are understandable for each member of my team, even for those
who aren't technically strong. I created another separate package for my utilities where I would store all my drivers, page files or utilities that I could possibly run. 
Webelements and their locations are kept in page classes. In Hook class there are before and after methods for each run and my Cucumber fancy report's method. Configuration 
properties keeps my url, and credentials. CukesRunner class runs my test scnerios and whenever my scenerio failed, it takes screenshot.*

## How to run the test in a CI/CD pipeline
* For CI/CD pipeline I use Jenkins. Source control managent tool is Git. I copied and pasted the address of this repository, and I choose Cucumber Report. I click the Build Now,
for running. For check to running I click the Console Output. After running my Cucumber Reports shows up. *

## What you used to select the scenarios, what was your approach?
* First of all I chose create account scenarios because when I checked the application. I saw that in the last step. customers are asked to create an account.*

* Secondly, I chose the search scenarios, because the application is an ecommerce application, customers should be able to find whatever they want easily and for this search box
 should work properly. If the customer wants to search for "Price: Lowest first", the price should go down, if she/he wants to search with an "Price: Highest first",it should go up.*
 
* Third, I chose the cart scenarios. Customer should be able to put as many items in the cart as he/she wants, the items he/she chooses and the items in the cart must be the same. 
 The prices of the pieces she/he chooses should not change in the basket. At the purchasing stage, the sum of the prices of the items in the cart plus Shipping, should be equal to
 the total price.*
 
* Finally, I chose payment scenarios because the main purpose of the application is to sell items to customers. I tested "Proceed to checkout" steps.*

## What could be the next steps to your project
* I would test if the customer encounters any problems while paying the money.*
