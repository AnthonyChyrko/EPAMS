Feature: deleteNotAllLinks

  Background:
    Given three different shortlink
      | shortlink     | longlink                                                                        |
      | DusterMonster | https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg                                    |
      | PolicePolice  | https://cs540100.userapi.com/c841639/v841639656/940f/Xi6WVJh9038.jpg            |
      | belazSovgaz   | https://content.onliner.by/news/1400x5616/6feb2c38a839d3b3f621f993d9327a71.jpeg |

  Scenario Outline:
    When delete the first link
    Then check <number> of links
    Examples:
      | number |
      | "2"    |