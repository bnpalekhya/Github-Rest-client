import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.maven.githubapiIssues.Issue;
import com.maven.githubapiIssues.IssuesExporter;
import com.maven.githubapiIssues.User;

public class IssueExporterTest {
    @Test
    public void testEquals() {
        Issue issue1 = new Issue();
        Issue issue2 = new Issue();
        Issue issue3 = new Issue();

        User user = new User();

        user.setLogin("alekhya");

        IssuesExporter ie = new IssuesExporter();
        ie.setUsername("bnpalekhya");
        ie.setPwd("123");

        issue1.setUser(user);
        issue1.setAssignee(user);
        issue1.setId(22);
        issue1.setBody(" remove unwanted lines of code");

        issue2.setBody("button not working");
        issue2.setNumber(3);
        issue2.setAssignee(user);

        List<Issue> Issues = new ArrayList<Issue>();
        Issues.add(issue1);
        Issues.add(issue2);
        Issues.add(issue3);

        assertEquals(Issues.size(), 3);
        assertEquals("123", ie.getPwd());
        assertEquals("bnpalekhya", ie.getUsername());

    }
}
