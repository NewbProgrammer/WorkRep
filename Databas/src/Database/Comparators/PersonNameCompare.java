package Database.Comparators;

import Database.Entities.Person;

import java.util.Comparator;

/**
 * Created by Alex on 02.07.14.
 */
public class PersonNameCompare implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getName().compareTo(secondPerson.getName());
    }
}
