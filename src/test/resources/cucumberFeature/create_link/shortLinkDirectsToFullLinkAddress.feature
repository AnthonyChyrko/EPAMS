Feature: shortLinkDirectsToFullLinkAddress

  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: Checking that a short link leads to the correct page

    When enter longlink with text <longlink>
    When enter shortlink with text <shortlink>
    And press button with text "submit"
    Then a new <shortlink> leads to the correct page <longlink>

    Examples:
      | longlink                                       | shortlink       |
      | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" | "DusterMonster" |