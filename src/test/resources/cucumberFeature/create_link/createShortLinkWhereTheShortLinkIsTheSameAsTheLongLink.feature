Feature: createShortLinkWhereTheShortLinkIsTheSameAsTheLongLink

  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: user try create short link the same as the longlink

    When enter longlink with text <longlink>
    When enter shortlink with text <shortlink>
    And press button with text "submit"
    Then appears hint with text <hint>

    Examples:
      | hint                                                                 | longlink                                       | shortlink                                      |
      | "Invalid short link (only English letters, digits, and '-' allowed)" | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" |