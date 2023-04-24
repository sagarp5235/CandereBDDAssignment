@assignment

Feature: E-commerce application requirement test assignment
Background: Navigation to Application BASE URL
Given user navigate to landing page
@validateLandingPage
Scenario: User opened landing page and validate page title
Given user navigate to landing page
And user validate page title "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

@searchProduct
Scenario: User opened landing page and search for product then product is suggested
Given user enter product name "majestic solitaire diamond ring"
Then search result is validated "majestic solitaire diamond Ring"

@searchProductDesc
Scenario: user opened landing page and search for product then product description is shown
Given user input product name "majestic solitaire diamond ring"
When user click on product link
Then product descrption is opened for "Majestic Solitaire Diamond Ring"
When product size is selected "15"
Then price update is validated "Price updated"

@footerOptionsCheck
Scenario: user opened landing page of application and validate about us options
Given user scroll to bottom of landing page
When user is able to see "ABOUT US" section
Then under About Us section below options are visible
| About Our Company    |
| Terms and Conditions |
| Privacy Policy			 |
| FAQ									 |
| Offers T&Cs					 |
| Customer Reviews		 |

@socialMediaOptions
Scenario Outline: user opened landing page og application and validate social media options
Given user scroll down to bottom of landing page
And user is able to see follow us section
When user click for "<social_media_link>"
Then url should contain "<social_media_handle>" 
And social media page contain "<social_media_link>" "<social_media_text>"
 		Examples:
	|social_media_link| social_media_handle|social_media_text						|
	|facebook					|canderejewellery		 |Candere by Kalyan Jewellers |
  |twitter					|canderebyKalyan		 |Candere By Kalyan Jewellers	|
	|instagram				|canderejewellery		 |canderejewellery						|