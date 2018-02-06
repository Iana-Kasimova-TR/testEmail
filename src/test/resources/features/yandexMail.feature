Feature: Yandex mail

Background: user is logged in
  Given user navigates to yandex login mail page
  When  log in mail yandex

  Scenario: log in email
    Then  user should be on the page of his email

  Scenario Outline: user save a letter as draft
    When write "<body>" to "<recepient>" with subject "<subject>"
    When send email in draft folder
    Then there must be a letter "<body>" to "<recepient>" with subject "<subject>" in draft folder

    Examples:
      | body | recepient | subject |
      |  Hello   |  mikkimous555@gmail.com  |  Hi   |
      |  Hi   |  mikkimous555@gmail.com  |  Hello  |

  Scenario: user send draft to recepient
    When write "Hello!" to "mikkimous555@gmail.com" with subject "Hi"
    When send email in draft folder
    When send draft to recepient
    Then there should be no letters in the draft folder
    And there must be a letter to "mikkimous555@gmail.com" in sent folder


