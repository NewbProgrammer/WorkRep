package Database.Entities;

import Database.Tools.*;

import java.io.Serializable;
import java.util.*;
/**
 * @author Alex
 *
 *Class Student describes object student.
 */
public class Student implements Serializable {

	/**Start date of education.*/
	private GregorianCalendar start;
	
	/**Finish date of education*/
	private GregorianCalendar finish;

    /**group contains information about Student's group - name, form, major.*/
    private Group group;

    /**person contains information about Student such as name, birthDay and passport number.*/
    private Person person;
	
    public Student() {
        start = new GregorianCalendar();
        finish = new GregorianCalendar();
        group = new Group();
        person = new Person();
    }

    public Student(GregorianCalendar start, GregorianCalendar finish) {
        this();
        this.start = start;
        this.finish = finish;
    }

    public Student(GregorianCalendar start, GregorianCalendar finish, Person person) {
        this(start, finish);
        this.person = person;
        person.addStudent(this);
    }

    public Student(GregorianCalendar start, GregorianCalendar finish, Person person, Group group) {
        this(start, finish, person);
        this.group = group;
        group.addStudent(this);
    }

	/**Overrided function toString return String representation of object from class.
	 * @return - returns text, wich provides complete information about object Student
	 */
	@Override 
	public String toString() {
        DateToString dateToString = new DateToString();
		return "Name - " + person.getName() + " StartDate - " + dateToString.dateToString(start)+" FinishDate - " +
                dateToString.dateToString(finish) + " Group - " + group.getName() + "\n";
	}

	public void setGroup(Group groupData) {
		this.group=groupData;
	}
	
	public void setPerson(Person personData) {
		this.person =personData;
	}
	
	public void setStart(GregorianCalendar start) {
		this.start=start;
	}
	
	public void setFinish(GregorianCalendar finish) {
		this.finish=finish;
	}

	public Person getPerson() {
		return person;
	}
	
	public GregorianCalendar getStart() {
		return start;
	}
	
	public GregorianCalendar getFinish() {
		return finish;
	}

    public Group getGroup() {
        return group;
    }

}
