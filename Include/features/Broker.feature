Feature: Broker

  Background: 
    Given Home page displays the Contacts button
    When Tap Contacts button
    And Tap Brokerlnk

  @TC_05
  Scenario: Verify Broker page
    Then displays: name,address,phone number,image

  @TC_06
  Scenario Outline: Verify Broker name
    Then Broker page: shows the broker <name>

    Examples: 
      | name       |
      | Mai Xuan   |
      | David Luân |

  @TC_07
  Scenario Outline: Verify Broker info
    And Tap Broker <name>
    Then displays <name>,<email>,<phone number>,rating,call button

    Examples: 
      | name         | email         | phone number |
      | Hoàng Nguyễn | Đang cập nhật |   0968175177 |
      | Mai Xuan     | Đang cập nhật |   0589095302 |

  @TC_08
  Scenario Outline: Verify search Broker by name
    And input <text> to broker search bar
    Then Broker page: shows the broker <name>

    Examples: 
      | text       | name                  |
      | Kiều Trang | Nguyễn Thị Kiều Trang |
      | Bích Huyền | Hồ Thị Bích Huyền     |
