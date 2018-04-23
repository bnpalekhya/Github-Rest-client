package com.maven.githubapiIssues;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {
    String username, pwd;

    public IssuesExporter() {
        // no argument constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String jsonOpen = "";
        String jsonClosed = "";
        Scanner sc = new Scanner(System.in);

        PrintWriter myconsole;
        User u1 = new User();
        u1.setId(1234);

        IssuesExporter ie = new IssuesExporter();
        GitHubRestClient rest = new GitHubRestClient();
        try {

            myconsole = new PrintWriter(new FileWriter("./out.txt"));

            System.out.println("Enter username\n");
            String uname = sc.next();
            ie.setUsername(uname);
            System.out.println("Enter password\n");
            String pass = sc.next();
            ie.setPwd(pass);

            jsonOpen = rest.requestIssues(uname, pass, "open");
            jsonClosed = rest.requestIssues(uname, pass, "closed");

            IssueParser ip = new IssueParser();
            List<Issue> openIssues = ip.parseIssues(jsonOpen);

            List<Issue> closedIssues = ip.parseIssues(jsonClosed);

            openIssues.addAll(closedIssues);

            Collections.sort(openIssues);

            for (Issue issue : openIssues) {
                myconsole.println(issue);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sc.close();

        }
    }

}
