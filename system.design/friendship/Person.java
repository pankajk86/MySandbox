package friendship;

import java.util.LinkedList;
import java.util.List;

public class Person {

    private long personId;
    private String firstName;
    private String lastName;
    private List<Person> friends;

    public Person(long personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friends = new LinkedList<Person>();
    }

    public long getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriends(List<Person> friends) {
        this.friends.addAll(friends);
    }

    public void addFriend(Person friend) {
        this.friends.add(friend);
    }
}
