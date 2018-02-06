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




