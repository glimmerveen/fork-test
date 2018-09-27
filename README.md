# fork-test

This test project demonstrates an issue between Surefire maven plugin (2.22.0) and Pax Exam (4.12.0) when using the Forked Test Container.

Building this project occasionally gets added an additional 30 seconds of execution time. This matches the timeout used by the Surefire maven plugin in its protocol with the test runners it forks off.

It appears that the issue is caused by the logic of Surefire in the fork and Pax Exam logic the start forked test containers both reading from `System.in` simultaniously. This results in the Pax Exam logic reading (parts of) commands on `System.in` intended for the Surefire logic. As the Surefire logic terminates its `CommandReader` Thread when an invalid message is received, it no longer listens for commands and only the forkedProcessExitTimeoutInSeconds of Surefire is then able to terminate the Surefire fork.

The purpose of this project is to demonstrate the issue reported at PAX Exam: https://ops4j1.jira.com/browse/PAXEXAM-920
