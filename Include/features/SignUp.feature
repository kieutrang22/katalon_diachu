Feature: Sign Up

  Background: 
    Given Navigate to the Sign Up Page

  @DiaChu_TC_01
  Scenario: Verify Sign Up Screen
    Then The Sign Up screen displayed: Ten Dang Nhap, Email, Mat Khau, Nhap Lai Mat Khau, Dang Ky btn

  @DiaChu_TC_02
  Scenario Outline: Create Account
    When Input: <Username>, <Email>, <Password>,<Password2>
    And Click Dang Ky btn <enable>
    Then Displayes <messages> <enable> <Username> <Password> <status>

    Examples: 
      | Username | Email                   | Password | Password2 | enable | messages                                                                                | status     |
      | test1    | test1@gmail.com         |   123456 |    123456 | true   | Đăng ký tài khoản thành công. Vui lòng vào email bạn đã đăng ký để kích hoạt tài khoản. | successful |
      | test425  | vukimloan1968@gmail.com |   123456 |    123456 | true   | Email đã được sử dụng!                                                                  |            |
      | ktrang22 | test3gh5@gmail.com      |   123456 |    123456 | true   | Tên đăng nhập đã được sử dụng!                                                          |            |
      | test18   | test18                  |   123456 |    123456 | false  | Không đúng định dạng email                                                              |            |
      | test4    |                         |          |           | false  |                                                                                         |            |
      |          | test5@gmail.com         |          |           | false  |                                                                                         |            |
      |          |                         |   123456 |           | false  |                                                                                         |            |
      |          |                         |          |    123456 | false  |                                                                                         |            |
      |          | test8@gmail.com         |   123456 |    123456 | false  |                                                                                         |            |
      | test9    |                         |   123456 |    123456 | false  |                                                                                         |            |
      | test10   | test10@gmail.com        |          |    123456 | false  |                                                                                         |            |
      | test11   | test11@gmail.com        |   123456 |           | false  |                                                                                         |            |
      | test12   | test12@gmail.com        |          |           | false  |                                                                                         |            |
      | test13   |                         |   123456 |           | false  |                                                                                         |            |
      | test14   |                         |          |    123456 | false  |                                                                                         |            |
      |          |                         |   123456 |    123456 | false  |                                                                                         |            |
      |          | test16@gmail.com        |   123456 |           | false  |                                                                                         |            |
      |          | test17@gmail.com        |          |    123456 | false  |                                                                                         |            |
      | test19   | test19@gmail.com        |   123456 |    654321 | false  |                                                                                         |            |
