# Github-Rest-client

The focus is on the issue tracking feature that’s available for each repository on GitHub. Using
GitHub’s API, we can write Java code to extract issues from our repository and process them.
For example, suppose a client wants an Excel spreadsheet of all the issues logged in GitHub for
their project. To fulfill this request, we can export the extracted issues to any desired format.

So, the overall flow of our project will be:<br>
-> Extract issues from our repository using GitHub API.<br>
->Represent extracted data as a Collection of Issue objects.<br>
->Export the Issue objects to a file in a specified format.<br><br>.
