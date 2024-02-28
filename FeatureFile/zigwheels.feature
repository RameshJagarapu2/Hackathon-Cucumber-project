Feature: ZigWheels

  Scenario: 1 upComing Bikes
    When user hoveron newBikes
    And click on upcomping bikes
    When click on manufacture
    And select honda
    And click on readmore
    Then get all the deatils of upcoming bikes

  Scenario: 2 popular cars in Chennai
    When user hoveron usedCars
    When click on Chennai
    And get all popular models

  Scenario Outline: 3 Login to Google
    When user click on login/signin
    And click on google
    When user provide "<EmailId>"
    Then click on next and get error message
    And excel is printed

    Examples: 
      | EmailId       |
      | xyz@gmail.com |
