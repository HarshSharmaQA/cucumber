Feature: Login page Automation saucedemo App

  Scenario: check login is scuccesful with valid creds
    Given User is on login page
    When User enter valid Username and password
    And Click on login Button
    Then User is navigate to Home page
    And close the browser
