package Database.Comparators;

import Database.Entities.Student;

import java.util.Comparator;

/**
 * Created by Alex on 04.07.14.
 */
public class StudentStartCompare implements Comparator<Student> {

    @Override
    public int compare(Student firstPerson, Student secondPerson) {
        return firstPerson.getStart().compareTo(secondPerson.getStart());
    }
}
