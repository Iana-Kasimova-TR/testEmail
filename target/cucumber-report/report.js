$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/yandexMail.feature");
formatter.feature({
  "line": 1,
  "name": "Yandex mail",
  "description": "",
  "id": "yandex-mail",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "user is logged in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to yandex login mail page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "log in mail yandex",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be on the page of his email",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 8,
  "name": "user save a letter as draft",
  "description": "",
  "id": "yandex-mail;user-save-a-letter-as-draft",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "write \"Hello!\" to \"mikkimous555@gmail.com\" with subject \"Hi\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "send email in draft folder",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "there must be a letter \"Hello!\" to \"mikkimous555@gmail.com\" with subject \"Hi\" in draft folder",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
