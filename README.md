# CSSE374-HW1
Submission for HW1

Link to engineering notebook: https://docs.google.com/document/d/1T7PnkhHKpTOwM0nOaxvjq9N0nmof4iSqMYrIJa7QdjI/edit?usp=sharing

A note about testing:

Each time the test suite is run, it is preferable that the DB.csv file is updated each time to its original state.
This could have been done in the test cases, but since it would require a decent amount of extra time and clutter up the test files,
I have decided to include the original state in the DBFinalCopy.csv file. It can simply be copy/pasted into the DB.csv file, overwriting anything that
currently exists in that file. If this is the first time the tests are run, then the content does not need to be pasted. 
If the tests are run more than once without the original data being pasted in, then two tests from the TestAPI will fail. 