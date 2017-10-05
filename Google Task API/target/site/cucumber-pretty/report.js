$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Home.feature");
formatter.feature({
  "line": 1,
  "name": "Title of your feature",
  "description": "I want to verify Home Page",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Verify Title of Home Page",
  "description": "",
  "id": "title-of-your-feature;verify-title-of-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@test1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeSteps.i_am_logged_in()"
});
formatter.result({
  "duration": 36540219683,
  "status": "passed"
});
formatter.after({
  "duration": 2504388723,
  "status": "passed"
});
});