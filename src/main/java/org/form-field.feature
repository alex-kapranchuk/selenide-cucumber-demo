Feature: Fill out a form

  Scenario: Fill out a form with name, favorite drink, favorite color, and siblings
    Given User is opened home web-page
    Given User go to the form page
    When User enters "John Doe" in the name field
    And User click "Milk" as favorite drink
    And User click "Yellow" as favorite color
    And User have any siblings, "yes"
    And User enters "example@example.com" in the email field
    And User type in message "Example of message"
    Then User submits the form successfully
