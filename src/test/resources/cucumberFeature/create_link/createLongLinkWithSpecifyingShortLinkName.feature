Feature: createLongLinkWithSpecifyingShortLinkName

  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: user create shortlink with specifying name

    When enter longlink with text <longlink>
    When enter shortlink with text <shortlink>
    And press button with text "submit"
    Then a new <shortlink> is matches <longlink>

    Examples:
      | longlink                                       | shortlink       |
      | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" | "DusterMonster" |