Feature: test login to website
  Scenario Outline: login to website
    Given there is url to webservice
    When i use login <name> and password <password> in form
    Then we should login to page
    Examples:
      | name | password |
      |"jakisemail@wp.pl"  | "password123" |