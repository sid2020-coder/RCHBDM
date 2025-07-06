Feature: search and place order for products
@offersPage
Scenario Outline: search experience of products in home and offers page

Given user is on GreenCart landing page
When user searched with shortname <Name> and found actual name of product
Then user searched with <Name> shortname in offers page
And validate product name if offes page matched with landing page

Examples:
|Name|
|Tom |
|Beet|