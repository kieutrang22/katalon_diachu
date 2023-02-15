Feature: Brokerage Firm

  Background: 
    Given Home page displays the Contacts button
    When Tap Contacts button
    And Tap BrokerageFirm lnk

  @TC_09
  Scenario: Verify Brokerage Firm page
  Then displays: name,address,phone number,image
  
  @TC_10
  Scenario Outline: Verify Brokerage Firm name
  Then Brokerage Firm: shows the Brokerage Firm <name>
  
  Examples:
  | name                            |
  | NEWS LAND                       |
  | Siêu thị dự án STDA             |
  | CÔNG TY CỔ PHẦN ĐỊA ỐC LUXOHOME |
  @TC_11
  Scenario Outline: Verify Brokerage Firm info
    And Tap Brokerage Firm <name>
    Then displays <address>,<name>,<email>,<website>,<phone number>,introduce,call button

    Examples: 
      | name                                                 | address                                           | email                        | website                     | phone number |
      | CÔNG TY CỔ PHẦN ĐỊA ỐC LUXOHOME                      | Mac Plaza, 10 Trần Phú, Hà Đông, Hà Nội, Việt Nam | cskh.luxohome@gmail.com      | http://luxohome.vn/         |   0942688245 |
      | Công ty CP đầu tư kiến trúc xây dựng Toàn Thịnh Phát | Quyết Thắng, Biên Hòa, Đồng Nai, Việt Nam         | luongct@toanthinhphat.com.vn | http://toanthinhphat.com.vn |   0918734300 |
  @TC_12
  Scenario Outline: Verify search Brokerage Firm by name
    And input <text> to Brokerage Firm search bar
    Then Brokerage Firm: shows the Brokerage Firm <name>

    Examples: 
      | text | name                |
      | STDA | Siêu thị dự án STDA |
      | NEWS | NEWS LAND           |
