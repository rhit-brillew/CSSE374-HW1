# CSSE374-HW1
Submission for HW1

Link to engineering notebook: https://docs.google.com/document/d/1T7PnkhHKpTOwM0nOaxvjq9N0nmof4iSqMYrIJa7QdjI/edit?usp=sharing

A note about testing:

Each time the test suite is run, it is preferable that the DB.csv file is updated each time to its original state.
This could have been done in the test cases, but since it would require a decent amount of extra time and clutter up the test files,
I have decided to include the original state below. It can simply be copy/pasted into the DB.csv file, overwriting anything that
currently exists in that file. This same code is shown in the DBFinalCopy.csv file. If this is the first time the tests are run,
then the content does not need to be pasted. If the tests are run more than once without the original data being pasted in, then
two tests from the TestAPI will fail. 

1,27:39:32,1:1:1,100:100:100,3.99:4.00:5.99,CODE1:CODE2:CODE3,.05:.05:.05,2/22:3/22:4/22,Indiana
2,88:14:15,2:2:2,50:50:50,7.22:3.30:8.00,CODE1:CODE2,.1:.05:.1,2/22:3/22:4/22,Kentucky
3,72:33:41,5:4:5,100:50:100,15.99:2.99:3.00,,,,Ohio
4,,,,,,,,Ohio
5,,,,,,,,Texas
6,,,,,,,,Wyoming