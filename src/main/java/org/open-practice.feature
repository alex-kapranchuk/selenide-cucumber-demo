Feature: Check home page

  Scenario: Check title of web-page
    Given User is opened home web-page
    Then Title of pages should be "Home | Practice Automation"

  Scenario: Hover mouse
    Given User is opened home web-page
    Given User go to the hover page
    Then Hover mouse on object