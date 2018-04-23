import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.maven.githubapiIssues.Issue;
import com.maven.githubapiIssues.IssueParser;

public class IssueParserTest {
    private String contents;

    @Before
    public void readJSON() throws IOException {
        contents = new String(
                Files.readAllBytes(Paths.get("./sample-output.txt")));
        // System.out.println("Contents : " + contents);

    }

    @Test
    public void testEquals() throws Exception {

        IssueParser ip = new IssueParser();

        List<Issue> issues = ip.parseIssues(contents);
        assertNotNull(issues);
        assertEquals(1, issues.size());
        Issue issue1 = issues.get(0);
        assertEquals(294120343, issue1.getId());
        // issues.

    }
}
