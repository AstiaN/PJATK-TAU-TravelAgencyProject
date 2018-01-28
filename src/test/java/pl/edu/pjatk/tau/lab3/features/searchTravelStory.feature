Feature: Proof that searching works.
Narrative: As a user
I want to find one record from database

Scenario: Search for travel record
Given I have data and 3 records on the list
When I want find one of them.
Then I should find one of them.