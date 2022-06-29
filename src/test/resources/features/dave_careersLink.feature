@wip
Feature: Dave Careers Link verification

  Background:
    Given user is on Dave homepage

    Scenario: Dave Careers page job opening verification
      When user navigates to Careers page by clicking on the Careers link
      And user should see Senior QA Engineer job opening
      Then user should see Read More link exists