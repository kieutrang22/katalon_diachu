Feature: Company
  
  Background:
    Given Home page displays the Contacts button
    When Tap Contacts button
    And Tap Company lnk


  @TC_01
  Scenario: Verify Company page
    Then displays: name,address,phone number,image

  @TC_02
  Scenario Outline: Verify Company name
    Then Comany page: shows the company <name>
    Examples:
      | name                                             |
      | Công ty CP Đầu tư và Xây dựng Xuân Mai           |
      | Công ty TNHH TM - DV - ĐT Bất động sản Phú Thành |
      | Tập đoàn Vingroup                                |

  @TC_03
  Scenario Outline: Verify Company info
    And Tap company <name>
    Then displays <name>,<address>,<email>,<website>,<phone number>,introduce,call button
    Examples:
      | name                                  | address                                                        | email         | website                   | phone number |
      | Công ty CP Kinh doanh và Xây dựng Nhà | Số 25-27 Hai Bà Trưng, Quận Hoàn Kiếm, Hà Nội                  | Đang cập nhật | Đang cập nhật             | 0437162515   |
      | Tổng Công ty Xây dựng Hà Nội          | Số 57 Quang Trung, Phường Nguyễn Du, Quận Hai Bà Trưng, Hà Nội | Đang cập nhật | http://www.hancorp.com.vn | 0439439063   |

  @TC_04
  Scenario Outline: Verify search Company by name
    And input <text> to search bar
    Then Comany page: shows the company <name>
    Examples:
      | text        | name                             |
      | VinaCapital | Tập đoàn VinaCapital Real Estate |
      | NQH         | Công ty TNHH Kiến trúc NQH       |