package friendship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonGraphTest {

    private PersonGraph graph;
    private Person p1, p2, p3, p4, p5, p6, p7;

    @Before
    public void setUp() {
        graph = new PersonGraph();

        p1 = new Person(1L, "fname1", "lname1");
        p2 = new Person(2L, "fname2", "lname2");
        p3 = new Person(3L, "fname3", "lname3");
        p4 = new Person(4L, "fname4", "lname4");
        p5 = new Person(5L, "fname5", "lname5");
        p6 = new Person(6L, "fname6", "lname6");
        p7 = new Person(7L, "fname7", "lname7");
    }

    @Test
    public void testMakeFriends() {

        graph.makeFriends(p1, p2);
        graph.makeFriends(p1, p3);
        graph.makeFriends(p1, p5);
        graph.makeFriends(p3, p4);
        graph.makeFriends(p4, p6);
        graph.makeFriends(p4, p7);
        graph.makeFriends(p7, p6);

        assertEquals(3, p1.getFriends().size());
        assertEquals(1, p2.getFriends().size());
        assertEquals(2, p3.getFriends().size());
        assertEquals(3, p4.getFriends().size());
        assertEquals(1, p5.getFriends().size());
        assertEquals(2, p6.getFriends().size());
        assertEquals(2, p7.getFriends().size());
    }

    @Test
    public void testRemoveFriends() {
        graph.makeFriends(p1, p2);
        graph.makeFriends(p2, p3);
        graph.makeFriends(p3, p5);
        graph.makeFriends(p3, p4);
        graph.makeFriends(p4, p5);

        graph.removeFriends(p2, p3);
        graph.removeFriends(p4, p5);

        assertEquals(1, p2.getFriends().size());
        assertEquals(2, p3.getFriends().size());
        assertEquals(1, p4.getFriends().size());
        assertEquals(1, p5.getFriends().size());
    }

    @Test
    public void testDirectFriends() {
        graph.makeFriends(p1, p2);
        graph.makeFriends(p1, p3);
        graph.makeFriends(p1, p5);
        graph.makeFriends(p3, p4);
        graph.makeFriends(p4, p6);
        graph.makeFriends(p4, p7);
        graph.makeFriends(p7, p6);

        List<Person> directFriendsOfp1 = graph.getDirectFriends(p1);
        List<Person> directFriendsOfp3 = graph.getDirectFriends(p3);

        assertTrue(directFriendsOfp1.containsAll(Arrays.asList(p2, p3, p5)));
        assertTrue(directFriendsOfp3.containsAll(Arrays.asList(p1, p4)));
    }

    @Test
    public void testIndirectFriends() {
        graph.makeFriends(p1, p2);
        graph.makeFriends(p1, p3);
        graph.makeFriends(p1, p5);
        graph.makeFriends(p3, p4);
        graph.makeFriends(p4, p6);
        graph.makeFriends(p4, p7);
        graph.makeFriends(p7, p6);

        List<Person> indirectFriendsOfp1 = graph.getIndirectFriends(p1);
        List<Person> indirectFriendsOfp5 = graph.getIndirectFriends(p5);

        assertTrue(indirectFriendsOfp1.contains(p4));
        assertTrue(indirectFriendsOfp5.containsAll(Arrays.asList(p2, p3)));
    }
}
