package Database.Entities;

import java.io.Serializable;
import java.util.*;
import Database.Tools.*;
/**
 * class Person represents object Person, which has name, birthday, passport num and is student and(or) teacher
 */
public class Person  implements Serializable{

    /** Name of person*/
	private String name;

    /**Date of birth of person*/
	private GregorianCalendar birthDay;

    /**Passport number*/
	private String passport;

    /**List of all groups that have person as Student*/
    private List<Student> students;

    /**List of objects Techer, if person is teacher*/
    private List<Teacher> teachers;

    public Person() {
        name = "NoName";
        birthDay = new GregorianCalendar();
        passport = "NoPassport";
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
    }

    public Person(String name, GregorianCalendar birthDay, String passport){
        this();
		this.name=name;
		this.birthDay=birthDay;
		this.passport=passport;
	}

    public Person (String name, GregorianCalendar birthDay, String passport, Student student) {
        this(name, birthDay, passport);
        students.add(student);
        student.setPerson(this);
    }

    public Person (String name, GregorianCalendar birthDay, String passport, Student student, Teacher teacher) {
        this(name, birthDay, passport,student);
        teachers.add(teacher);
        teacher.setPerson(this);
    }
	
	@Override 
	public String toString() {
        DateToString dateToString = new DateToString();
		return /*"Person info:\n"+*/"Name - "+name+" BirthDay - "+dateToString.dateToString(birthDay)+" Passport - "+passport+"\n";
	}

    /**Method adds student in the end of the List*/
    public void addStudent(Student student) {
        students.add(student);
    }

    /**Method removes last student in List*/
    public void removeStudent() {
        students.remove(students.size()-1);
    }

    /**Method adds teacher in the end of the List*/
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    /**Method removes last student in List*/
    public void removeTeacher() {
        teachers.remove(teachers.size()-1);
    }

    /*
     *  Self-explanatory getters & setters
     */

	public void setName(String name) {
		this.name=name;
	}
	
	public void setBirthDay(GregorianCalendar birthDay) {
		this.birthDay=birthDay;
	}
	
	public void setPassport(String passport) {
		this.passport=passport;
	}

    public String getName() {
        return name;
    }


    /*public String toStringMini() {
        return toString()+getAllNames();
    }*/
    /*private String getAllNames() {
        String studentNames = "Student in group(s): ";
        String teacherNames = "Teacher of subject(s): ";

        for (Student s:students) {
            studentNames += s.getGroup().getName() + " ";
        }

        for (Teacher t:teachers) {
            teacherNames += t.getSubject() + " ";
        }

        return "\n"+studentNames+"\n"+teacherNames+"\n";
    }*/

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public GregorianCalendar getBirthDay() {
        return birthDay;
    }

    public String getPassport() {
        return passport;
    }
}
