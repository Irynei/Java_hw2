package marital_status;

import java.util.ArrayList;
import java.util.List;


public class PersonReader implements Reader<Person> {

    private List<Person> persons;

    public PersonReader() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void read(Person person) {
        if(!persons.isEmpty() && persons.get(persons.size() - 1).equals(person)) {
            System.out.println(String.format("You again?? (%s)", person));
        } else {
            System.out.println(person);
        }
        persons.add(person);
    }
}
