Feature: CreateEmptyLongLinkWithoutSpecifiyingShortLinkName
  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: user try create shortlink with empty longlink
    When enter longlink with text <longlink>
    And press button with text "submit"
    Then appears hint with text <hint>

    Examples:
      |hint                    |longlink|
      |"This field is required"|""      |
