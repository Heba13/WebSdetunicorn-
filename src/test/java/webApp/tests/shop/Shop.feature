Feature: Shop

#  Scenario Outline: User can sign up new user account
#    When  click on profile icon in header
#    And   click on register button in header
#    And   enter username "<userName>" in register page
#    And   enter password for new user "<password>" in register page
#    And   enter email "<email>" for new user in register page
#    And   select gender for new user "<gender>" in register page
#    And   enter first address "<address>" for new user in register page
#    And   enter second address "<address>" for new user in register page
#    And   enter contact "<contact>" for new user in register page
#    And   click on register button in register page
#    Then  user should be redirected to products page with title "<products>"
#    And   message should be displayed "<successMessage>" in products page
#    And   click on profile icon in header
#    And   click on logout button icon in header
#
#    Examples:
#      | userName | password  | email                  | gender | address | contact    | products | successMessage                                |
#      | Admin    | Admin1234 | digital.testing88@gmail.com | female | Giza    | 0101182335 | SHOP     | Congratulations Your account has been created |
#
#  Scenario Outline: Verify that two products are purchased successfully
#    When  click on profile icon in header
#    And   click on login button in header
#    And   enter email "<email>" in login page
#    And   enter password for new user "<password>" in login page
#    And   click on login button in login page
#    And   click on profile icon in header
#    Then  logout button should be displayed in header
#    And   click on products tab in header
#    When  click on product type "<keyboard>" on check list in products page
#    And   click on apply button in products page
#    Then  "<keyboardModel>" products should be displayed in products page
#    And   laptop product should be disappeared from products page
#    When  click on product "<keyboardModel>" in products page
#    Then  product name "<keyboardModel>"should be displayed in products page
#    And   product price "<kPrice>" should be displayed in products page
#    And   cart count should be zero in header
#    When  click on add to cart in products page
#    Then  cart count should be one in header
#    And   message should be displayed "<message>" in products page
#    And   click on products tab in header
#    And   click on product type "<laptop>" on check list in products page
#    And   click on apply button in products page
#    And   click on product "<laptop model>" in products page
#    And   click on add to cart in products page
#    Then  cart count should be two in header
#    And   click on cart button in header
#    And   click on view button in header
#    Then  product name "<keyboardModel>"should be displayed in products page in cart page
#    And   product price "<kPrice>" should be displayed in cart page
#    And   product name "<laptop model>"should be displayed in products page in cart page
#    And   product price "<lPrice>" should be displayed in cart page
#    And   total price "<total>" should be displayed in cart page
#    And   click on checkout button in cart page
#    And   enter the shipping address "<address>" in cart page
#    And   select country "<country>" in cart page
#    And   select region "<region>" in cart page
#    And   enter phone number "<phone>" and postal code "<code>" in cart page
#    And   click on cash on delivery check box in cart page
#    And   click on confirm button in cart page
#    And   click on order in order page
#    Then  shipping address "<address>" and total price  should be displayed correctly in order page
#    And   total price "<total>" should be displayed correctly in order page
#    Examples:
#      | email                          | password  | keyboard | laptop | keyboardModel     | laptop model | kPrice | lPrice | total | message       | address | country | region | phone    | code |
#      | regression.testing08@gmail.com | Heb@@2022 | keyboard | laptop | Wireless Keyboard | Chromebook   | 33     | 700    | 733   | Added To Cart | Giza    | Algeria | Adrar  | 78965223 | 02   |

  Scenario Outline:  Verify that order id returns as expected successfully
    When  click on profile icon in header
    And   click on login button in header
    And   enter email "<email>" in login page
    And   enter password for new user "<password>" in login page
    And   click on login button in login page
    And   click on profile icon in header
    Then  logout button should be displayed in header
    And   click on products tab in header
    When  click on product type "<keyboard>" on check list in products page
    And   click on apply button in products page
    Then  "<keyboardModel>" products should be displayed in products page
    And   laptop product should be disappeared from products page
    When  click on product "<keyboardModel>" in products page
    When  click on add to cart in products page
    Then  cart count should be one in header
    And   message should be displayed "<message>" in products page
    When   click on cart button in header
    And   click on view button in header
    And   click on checkout button in cart page
    And   enter the shipping address "<address>" in cart page
    And   select country "<country>" in cart page
    And   select region "<region>" in cart page
    And   enter phone number "<phone>" and postal code "<code>" in cart page
    And   click on cash on delivery check box in cart page
    And   click on confirm button in cart page
    And   click on order in order page
    And   get orders from api
    Then  order id should be displayed in order page
    Examples:
      | email                          | password  | keyboard | keyboardModel     | message       | address | country | region | phone    | code |
      | regression.testing08@gmail.com | Heb@@2022 | keyboard | Wireless Keyboard | Added To Cart | Giza    | Algeria | Adrar  | 78965223 | 02   |
