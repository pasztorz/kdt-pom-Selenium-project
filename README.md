
## About the Project

This is a Test Automation project to improve my skills and knowledge and experiences on the hybrid use of Keyword Driven Testing approach and Page Object Model implemented in Java and using Selenium for automation as well as in planning and impementing Test projects.

## System Under Test (SUT)

URL: https://playground.qatools.dev/clinic

The above page is a Test Automation practice site developed for training purposes. To navigate to the page, `click` on the above link.

## Scope of the Test project

As I use a practice site for this project and I have no access to either the source code or to the connected database, the test project's goals and scope are limited in some extent, as a consequence.

1. *Security tests:*
    
    Keeping a page's users' account private, security and account access are crucial considarations. As doing so, security test opportunuties was identified but backend password-storage verification is outside the scope of my current black-box test automation setup. In spite of this I did my best to verify some basic password and account security aspects, e.g.: if
    * password is displayed on the page or
    * error messages do not reveal sensitive information
    * password is exposed in URL/query parameters
    * login works with correct password
    * login does not work with incorrect password
    * account details are not available after
      - leaving the page,
      - closing the browser or
      - logout
    * logged-out/not registered user's appointments are not available by opening the page again after booking or any other way

## Jira Project Space

There is a Space set up for this project in Jira as well. Being 
* a Codecool mentor, 
* a Codecool trainee fellow or 
* a future HR / Tech interview participant,

you can come to have a look on it after an access request to the e-mail address: *pasztor.zzz@gmail.com*

**`Note`**: In case of mentors and interview participants, company email address is required.

As a viewer added to the project, please go to:

https://pasztorzzz-1787675593983.atlassian.net/jira/core/projects/KDTPOM
