
//import org.junit.jupiter.api.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.maven.githubapiIssues.Issue;
import com.maven.githubapiIssues.User;

public class IssueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEquals() throws ParseException {
        Issue issue1 = new Issue();
        Issue issue2 = new Issue();
        Issue issue3 = new Issue();

        User user = new User();
        user.setId(10);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Date yesterday = dateFormat.parse("2018/03/11");
        Date today = dateFormat.parse("2018/03/21");

        String s = dateFormat.format(date);

        assertTrue(user.equals(user));
        issue1.setId(32);
        issue2.setNumber(2);
        issue3.setId(32);
        issue1.setTitle("Button not working");
        issue1.setState(true);
        issue1.setBody("please fix this");
        issue2.setUser(user);
        issue2.setAssignee(user);
        issue1.setCreatedAt(yesterday);
        issue2.setClosedAt(today);

        assertFalse(issue1.equals(issue2));
        // assertEquals(10, user.getId());

        assertNotEquals(issue1.hashCode(), issue2.hashCode());
        // assertEquals(issue1.hashCode(), issue3.hashCode());
        Assert.assertFalse(issue1.equals(issue2) && issue2.equals(issue1));
        Assert.assertTrue(issue1.equals(issue3) && issue3.equals(issue1));
        Assert.assertEquals("please fix this", issue1.getBody());
        Assert.assertEquals("Button not working", issue1.getTitle());
        Assert.assertTrue(issue1.isState());
        Assert.assertEquals(2, issue2.getNumber());
        Assert.assertEquals(32, issue1.getId());
        Assert.assertEquals(yesterday, issue1.getCreatedAt());
        // Assert.assertEquals(today, issue2.getClosedAt());

    }

    @Test
    public void testToString() {
        Issue issue = new Issue();
        issue.setBody("button not working");
        String result = "Issue [number=0, id=0, state=false, title=null, body=button not working, createdAt=null, closedAt=null, user=null, assignee=null]";
        Assert.assertEquals(result, issue.toString());
    }

    @Test
    public void compareToTest() {
        Issue issue = new Issue();
        issue.setId(6);
        // issue.setId(6);
        Assert.assertNotNull(issue.compareTo(issue));

    }

    @Test(expected = NullPointerException.class)
    public void compareToNull() {
        Issue is = new Issue();
        is.compareTo(null);

    }

    @Test
    public void compareToLessThan() {
        Issue is = new Issue();
        Issue is2 = new Issue();
        is.setId(20);
        is2.setId(22);

        Assert.assertEquals(-1, is.compareTo(is2));

        Assert.assertNotNull(null, is.toString());
    }

    @Test
    public void compareToGreaterThan() {
        Issue is = new Issue();
        Issue is2 = new Issue();
        is.setId(24);
        is2.setId(22);

        Assert.assertEquals(1, is.compareTo(is2));
    }

    @Test
    public void compareToEquals() {
        Issue is = new Issue();
        Issue is2 = new Issue();
        is.setId(24);
        is2.setId(24);
        Assert.assertEquals(0, is.compareTo(is2));
    }

}
