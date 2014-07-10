package Database.Comparators;

import Database.Entities.Person;

import java.util.Comparator;

/**
 * Created by Alex on 04.07.14.
 */
public class PersonPassportCompare implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getPassport().compareTo(secondPerson.getPassport());
    }
}

