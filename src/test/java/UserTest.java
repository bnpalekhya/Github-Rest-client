import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;

import com.maven.githubapiIssues.User;

public class UserTest {

    @Test
    public void testEquals() {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user.setId(20);
        user.setLogin("alu");
        user2.setId(21);
        user2.setLogin("sam");
        user3.setId(20);
        user3.setLogin("alu");

        assertEquals("alu", user.getLogin());
        assertEquals(21, user2.getId());

        assertNotEquals(user.hashCode(), user2.hashCode());
        assertEquals(user.hashCode(), user3.hashCode());
        Assert.assertEquals("sam", user2.getLogin());
        Assert.assertFalse(user.equals(user2) && user2.equals(user));

    }

    @Test
    public void testToString() {
        User user1 = new User();

        user1.setLogin("alu");
        user1.setId(10);
        String result = "User [login=alu, id=10]";
        Assert.assertEquals(result, user1.toString());

    }
}
