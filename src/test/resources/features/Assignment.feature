@assignment

Feature: E-commerce application requirement test assignment
Background: Navigation to Application BASE URL
Given user navigate to landing page
@validateLandingPage
Scenario: User opened landing page and validate page title
Given user validate page title

@searchProduct
Scenario: User opened landing page and search for product then product is suggested
Given user enter product name
Then search result is validated

@searchProductDesc
Scenario: user opened landing page and search for product then product description is shown
Given user input product name
When user click on product link
Then product descrption is opened
When product size is selected
Then price update is validated