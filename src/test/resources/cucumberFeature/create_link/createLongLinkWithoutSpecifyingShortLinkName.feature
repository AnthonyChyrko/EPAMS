Feature: createLongLinkWithoutSpecifyingShortLinkName

  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: user try create longlink without shortlink name

    When enter longlink with text <longlink>
    When enter shortlink with text <shortlink>
    And press button with text "submit"
    Then a new <longlink> appears in the general list of links


    Examples:
      | longlink                                       | shortlink |
      | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" | ""        |