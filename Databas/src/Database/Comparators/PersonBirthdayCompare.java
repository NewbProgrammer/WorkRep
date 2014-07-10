package Database.Comparators;

import Database.Entities.Person;

import java.util.Comparator;

/**
 * Created by Alex on 03.07.14.
 */
public class PersonBirthdayCompare implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getBirthDay().compareTo(secondPerson.getBirthDay());
    }
}
