Feature: createShortLinkWhereTheShortLinkIsTheSameAsTheLongLink

  Background:
    Given remove all created links

  Scenario Outline: user can edit short link name
    Given short link with <originalShortlink> and <originalLongLink>
    When open edit pop-up, replace old name on short link <originalShortlink> with <newShortLink>
    Then short link name is changed to <newShortLink> by long link <originalLongLink>

    Examples:
| originalLongLink                                                                  | newLonglink                                                             | originalShortlink | newShortLink  |
| "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg"                                    | "http://zoohall.com.ua/uploads/posts/2011-03/1300657268_panoramas-1.jpg"| "duster"          | "lake"        |
| "https://cs540100.userapi.com/c841639/v841639656/940f/Xi6WVJh9038.jpg"            | "https://commons.wikimedia.org/wiki/Commons:Quality_images/ru"          | "police"          | "meme"        |
| "https://content.onliner.by/news/1400x5616/6feb2c38a839d3b3f621f993d9327a71.jpeg" | "http://www.belaz.by/uploads/photo/full/belaz_75131.jpg"                | "belaz"           | "realmashine" |


  Scenario Outline: user can edit long link name
    Given short link with <originalShortlink> and <originalLongLink>
    When open edit pop-up, replace old name on long link <originalLongLink> with <newLonglink>
    Then long link name is changed and presents <newLonglink>


    Examples:
| originalLongLink                                                                  | newLonglink                                                             | originalShortlink | newShortLink  |
| "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg"                                    | "http://zoohall.com.ua/uploads/posts/2011-03/1300657268_panoramas-1.jpg"| "duster"          | "lake"        |
| "https://cs540100.userapi.com/c841639/v841639656/940f/Xi6WVJh9038.jpg"            | "https://commons.wikimedia.org/wiki/Commons:Quality_images/ru"          | "police"          | "meme"        |
| "https://content.onliner.by/news/1400x5616/6feb2c38a839d3b3f621f993d9327a71.jpeg" | "http://www.belaz.by/uploads/photo/full/belaz_75131.jpg"                | "belaz"           | "realmashine" |

  Scenario Outline: user can edit expiration date
    Given short link with <originalShortlink> and <originalLongLink>
    When open edit pop-up, change expiration date of <originalShortlink>
    Then expiration date of <originalShortlink> is changed


    Examples:
      | originalLongLink                                                                  | newLonglink                                                             | originalShortlink | newShortLink  |
      | "https://img.tyt.by/p/0c/0/aps_808_pylnik.jpg"                                    | "http://zoohall.com.ua/uploads/posts/2011-03/1300657268_panoramas-1.jpg"| "duster"          | "lake"        |
      | "https://cs540100.userapi.com/c841639/v841639656/940f/Xi6WVJh9038.jpg"            | "https://commons.wikimedia.org/wiki/Commons:Quality_images/ru"          | "police"          | "meme"        |
      | "https://content.onliner.by/news/1400x5616/6feb2c38a839d3b3f621f993d9327a71.jpeg" | "http://www.belaz.by/uploads/photo/full/belaz_75131.jpg"                | "belaz"           | "realmashine" |
