Feature:  register to website
  Scenario Outline: register to website
    Given setting email and click to register page
    When fill up <password>, <name>, <surname>, <city>, <street>
    Then account should be registered
    Examples:
      | password | name 	| surname 	| city 		| street 	|
      | "password" | "Jan"| "Kowalksi"	| "Gdynia" | "Brzegi"|
      | "password" | "Tomasz"| "Nowak"| "Gdansk" | "Kowalska"|