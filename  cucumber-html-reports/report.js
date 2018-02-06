$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("yandexMail.feature");
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
formatter.match({
  "location": "YandexMailSteps.navigateToLoginpage()"
});
formatter.result({
  "duration": 12888229126,
  "status": "passed"
});
formatter.match({
  "location": "YandexMailSteps.logInEmail()"
});
formatter.result({
  "duration": 5329845589,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "log in email",
  "description": "",
  "id": "yandex-mail;log-in-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "user should be on the page of his email",
  "keyword": "Then "
});
formatter.match({
  "location": "YandexMailSteps.checkLogin()"
});
formatter.result({
  "duration": 3329203787,
  "status": "passed"
});
formatter.after({
  "duration": 3736816471,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 10,
  "name": "user save a letter as draft",
  "description": "",
  "id": "yandex-mail;user-save-a-letter-as-draft",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "write \"\u003cbody\u003e\" to \"\u003crecepient\u003e\" with subject \"\u003csubject\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "send email in draft folder",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "there must be a letter \"\u003cbody\u003e\" to \"\u003crecepient\u003e\" with subject \"\u003csubject\u003e\" in draft folder",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "yandex-mail;user-save-a-letter-as-draft;",
  "rows": [
    {
      "cells": [
        "body",
        "recepient",
        "subject"
      ],
      "line": 16,
      "id": "yandex-mail;user-save-a-letter-as-draft;;1"
    },
    {
      "cells": [
        "Hello",
        "mikkimous555@gmail.com",
        "Hi"
      ],
      "line": 17,
      "id": "yandex-mail;user-save-a-letter-as-draft;;2"
    },
    {
      "cells": [
        "Hi",
        "mikkimous555@gmail.com",
        "Hello"
      ],
      "line": 18,
      "id": "yandex-mail;user-save-a-letter-as-draft;;3"
    }
  ],
  "keyword": "Examples"
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
formatter.match({
  "location": "YandexMailSteps.navigateToLoginpage()"
});
formatter.result({
  "duration": 1589888316,
  "status": "passed"
});
formatter.match({
  "location": "YandexMailSteps.logInEmail()"
});
formatter.result({
  "duration": 3779467449,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "user save a letter as draft",
  "description": "",
  "id": "yandex-mail;user-save-a-letter-as-draft;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "write \"Hello\" to \"mikkimous555@gmail.com\" with subject \"Hi\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "send email in draft folder",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "there must be a letter \"Hello\" to \"mikkimous555@gmail.com\" with subject \"Hi\" in draft folder",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Hello",
      "offset": 7
    },
    {
      "val": "mikkimous555@gmail.com",
      "offset": 18
    },
    {
      "val": "Hi",
      "offset": 56
    }
  ],
  "location": "YandexMailSteps.createEmail(String,String,String)"
});
formatter.result({
  "duration": 3883135876,
  "status": "passed"
});
formatter.match({
  "location": "YandexMailSteps.createDraft()"
});
formatter.result({
  "duration": 53369770111,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hello",
      "offset": 24
    },
    {
      "val": "mikkimous555@gmail.com",
      "offset": 35
    },
    {
      "val": "Hi",
      "offset": 73
    }
  ],
  "location": "YandexMailSteps.checkDraftFolder(String,String,String)"
});
formatter.result({
  "duration": 857438261,
  "status": "passed"
});
formatter.after({
  "duration": 2755556124,
  "status": "passed"
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
formatter.match({
  "location": "YandexMailSteps.navigateToLoginpage()"
});
formatter.result({
  "duration": 3784097376,
  "status": "passed"
});
formatter.match({
  "location": "YandexMailSteps.logInEmail()"
});
formatter.result({
  "duration": 3798851006,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "user save a letter as draft",
  "description": "",
  "id": "yandex-mail;user-save-a-letter-as-draft;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "write \"Hi\" to \"mikkimous555@gmail.com\" with subject \"Hello\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "send email in draft folder",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "there must be a letter \"Hi\" to \"mikkimous555@gmail.com\" with subject \"Hello\" in draft folder",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Hi",
      "offset": 7
    },
    {
      "val": "mikkimous555@gmail.com",
      "offset": 15
    },
    {
      "val": "Hello",
      "offset": 53
    }
  ],
  "location": "YandexMailSteps.createEmail(String,String,String)"
});
formatter.result({
  "duration": 2378091901,
  "status": "passed"
});
formatter.match({
  "location": "YandexMailSteps.createDraft()"
});
formatter.result({
  "duration": 40021400305,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hi",
      "offset": 24
    },
    {
      "val": "mikkimous555@gmail.com",
      "offset": 32
    },
    {
      "val": "Hello",
      "offset": 70
    }
  ],
  "location": "YandexMailSteps.checkDraftFolder(String,String,String)"
});
formatter.result({
  "duration": 863959641,
  "status": "passed"
});
formatter.after({
  "duration": 3342158810,
  "status": "passed"
});
});