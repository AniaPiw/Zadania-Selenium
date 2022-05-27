Feature: Registration form
Background: User is logged in

  Scenario Outline: New user registration
    Given user is logged in and is on address form page
    And a keyword <phone> is entered in phone field
    And a keyword <alias> is entered in alias field
    And a keyword <address> is entered in address field
    And a keyword <zip/postal code> is entered in zip code field
    And a keyword <city> is entered in city field
    When a country is chosen from country field
    And confirm by save button
    Then check if data is correct
    Examples:
     | phone | alias | address | zip/postal code | city |
     | 666777888 | Ania  | Diagonal | 08-013          | Barcelona |
