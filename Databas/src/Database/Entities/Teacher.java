package Database.Entities;

import Database.Tools.DateToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Teacher implements Serializable{
  //private Subject subject;
	private GregorianCalendar start;
	private GregorianCalendar finish;
    private Person person;
    private ArrayList<Subject> subjects;

    public Teacher() {
        start = new GregorianCalendar();
        finish = new GregorianCalendar();
        person = new Person();
        //person = null;
        subjects = new ArrayList<Subject>(10);
    }

    public Teacher(GregorianCalendar start, GregorianCalendar finish) {
        this();
		this.start = start;
		this.finish = finish;
	}

    public Teacher(GregorianCalendar start, GregorianCalendar finish, Person person) {
        this(start, finish);
        this.person = person;
        person.addTeacher(this);
    }
    
    public Teacher(GregorianCalendar start, GregorianCalendar finish, Person person, Subject subject) {
        this(start, finish,person);
        subjects.add(subject);
        subject.addTeacher(this);
    }
	
	@Override
	public String toString() {
        DateToString dateToString = new DateToString();
		return "Person Name - "+person.getName()+" Start - "+ dateToString.dateToString(start)+" Finish - "+dateToString.dateToString(finish);
	}

	public void setPerson(Person person) {
		this.person=person;
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

	public void addSubject(Subject subject) {
		subjects.add(subject);
        subject.addTeacher(this);
	}
	
    /*public Subject getSubject() {
        return subject;
    }*/
}
