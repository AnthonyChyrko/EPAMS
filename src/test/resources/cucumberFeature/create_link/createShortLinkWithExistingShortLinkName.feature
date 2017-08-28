Feature: createShortLinkWithExistingShortLinkName

  Background:
    Given an open browser with https://epa.ms/

  Scenario Outline: user try create shortlink with existing shortlink name

    When create shortlink with text <longlink> and <shortlink>
    And repeat
    When create shortlink with text <longlink> and <shortlink>
    Then server return error

    Examples:
      | longlink                                       | shortlink       |
      | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg" | "DusterMonster" |