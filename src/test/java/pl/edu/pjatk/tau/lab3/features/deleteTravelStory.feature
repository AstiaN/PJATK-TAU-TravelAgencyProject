Feature: Proof that delete works.

Narrative: As a user
I want to delete record from database

Scenario: Delete travel record
Given I have data and 3 records on the list
When I gonna delete one of them.
Then  As a result theres should be 2 records