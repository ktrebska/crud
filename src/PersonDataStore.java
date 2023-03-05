import java.util.ArrayList;
import java.util.List;

public class PersonDataStore {
    private List<Person> persons = new ArrayList<>();
    private int nextId = 1;

    public void addPerson(Person person) {
        person.setId(nextId++);
        persons.add(person);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void updatePerson(int id, String name) {
        Person existingPerson = getPersonById(id);
        if (existingPerson != null) {
            existingPerson.setName(name);
        }
    }


    public void deletePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
