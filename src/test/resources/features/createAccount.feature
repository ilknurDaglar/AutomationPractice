Feature: Users should be able to create account

  Background:
    Given the user is on the home page


  Scenario: the user wants to signup
    When the user click the signin button
    Then Authentication page should be display


  Scenario Outline:the user enters with valid mail address
    When the user click the signin button
    And the user enters valid "<email address>"
    And  click the Create an account button
    Then Create an account page should be display
    Examples:
      | email address        |
      | azihaskkbaku@gmail.com |

#BUG 1
  Scenario Outline:the user enters with invalid mail address
    When the user click the signin button
    And the user enters invalid "<invalidEmail address>"
    And  click the Create an account button
    Then "Invalid email address" pop should be display
    Examples:
      | invalidEmail address |
      | !~~~~@x.com              |
      | !****@z.com              |

#it also accepts  0@a.com, $@b.com, -@c.com,  #@d.com, !@e.com

  Scenario Outline: the user enters valid credentials
    When the user click the signin button
    And the user enters mail address
    And  click the Create an account button
    And the user enters the valid "<firstname>","<lastname>","<password>,"<address>","<city>","<zipcode>", "<phone>",
    And the user choose the state
    And the user click the register button
    Then My Account page should display;
    Examples:
      | firstname | lastname | password | address       | city     | zipcode | phone      |
      | Bety      | White    | 12345    | BernStraat 11 | Roermond | 12345   | 0654725552 |


#BUG2, BUG3, BUG4, BUG5, BUG6, BUG7, BUG8

  Scenario Outline: the user enters invalid credentials
    When the user click the signin button
    And the user enters with new mail address
    And  click the Create an account button
    And the user enters the invalid "<firstname>","<lastname>","<password>","<address>","<city>","<zipcode>", "<phone>",
    And the user choose the state
    And the user click the register button
    Then My Account page should not display;
    Examples:
      | firstname | lastname  | password | address | city    | zipcode | phone            |
      | n^&~\`/*  | q^*&~/`/* | 00000    | 3204724 | 5397593 | 00000   | 0000000000000000 |

    #Password also excepted    @@@@@, $$$$$, #####, .....

    #There are also BUGS on "-Home phone, -Addres line2,-Company, -Assign an adress" boxes
