package friendship;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonGraph {

    private List<Person> persons;

    public PersonGraph() {
        this.persons = new ArrayList<Person>();
    }

    public void addPersonsToGraph(List<Person> persons) {
        this.persons.addAll(persons);
    }

    public void makeFriends(Person a, Person b) {
        a.getFriends().add(b);
        b.getFriends().add(a);
    }

    public void removeFriends(Person a, Person b) {
        a.getFriends().remove(b);
        b.getFriends().remove(a);
    }

    public List<Person> getDirectFriends(Person a) {
        return a.getFriends();
    }

    public List<Person> getIndirectFriends(Person a) {

        List<Person> indirectFriends = new LinkedList<Person>();

        for (Person directFriends : a.getFriends()) {
            for (Person indirectFriend : directFriends.getFriends()) {
                if (!indirectFriend.equals(a)) {
                    indirectFriends.add(indirectFriend);
                }
            }
        }

        return indirectFriends;
    }
}
