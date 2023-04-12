Maven commands to run codes
cross browser implentation for 3
chrome
firefox
edge

Scenario: User opened landing page and validate page title
 mvn clean verify -Dcucumber.filter.tags="@validateLandingPage" -Dbrowser="edge"
--------------------------------------------------------------------------------------------------------------

Scenario: User opened landing page and search for product then product is suggested
 mvn clean verify -Dcucumber.filter.tags="@searchProduct" -Dbrowser="edge"
-------------------------------------------------------------------------------------------------------------


Scenario: user opened landing page and search for product then product description is shown
 mvn clean verify -Dcucumber.filter.tags="@searchProductDesc" -Dbrowser="edge"
-------------------------------------------------------------------------------------------------------------

Scenario: user opened landing page of application and validate about us options

 mvn clean verify -Dcucumber.filter.tags="@footerOptionsCheck" -Dbrowser="edge"		 |
------------------------------------------------------------------------------------------------------------

Scenario Outline: user opened landing page of application and validate social media options

 mvn clean verify -Dcucumber.filter.tags="@socialMediaOptions" -Dbrowser="edge"
