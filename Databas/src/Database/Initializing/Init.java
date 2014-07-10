package Database.Initializing;

import Database.Entities.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Alex on 30.06.14.
 * ALL RIGHTS RESERVED ®©
 */
public class Init {
    /**
     * Performs initialization of database Faculty
     * with testing data.
     */

    public static final String PROPERTY_FILE_PATH = "application.properties";

    /**
     * Fills list of persons.
     * @return List<Person> filled list of persons
     */
    public ArrayList<Person> fillPersonList() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Jessy", new GregorianCalendar(1985,4,13),"AA796423"));
        persons.add(new Person("Jessica", new GregorianCalendar(1978,7,78),"AK845261"));
        persons.add(new Person("Marla", new GregorianCalendar(1990,2,11),"EH784521"));
        persons.add(new Person("Brenon", new GregorianCalendar(1986,5,6),"GG112233"));
        persons.add(new Person("Clark", new GregorianCalendar(1988,8,30),"AS559461"));
        persons.add(new Person("Mark", new GregorianCalendar(1983,0,15),"AA023125"));
        persons.add(new Person("Clyde", new GregorianCalendar(1980,9,5),"AA201597"));
        persons.add(new Person("Daniel", new GregorianCalendar(1991,3,26),"UK159462"));
        persons.add(new Person("Max", new GregorianCalendar(1987,11,25),"EF136497"));
        persons.add(new Person("Dean", new GregorianCalendar(1987,11,25),"UA996133"));
        persons.add(new Person("John", new GregorianCalendar(1992,10,11),"EH596661"));
        persons.add(new Person("Michael", new GregorianCalendar(1989,1,19),"AA294016"));
        persons.add(new Person("Patrick", new GregorianCalendar(1985,7,7),"EH846122"));
        persons.add(new Person("Shawn", new GregorianCalendar(1981,11,13),"EH845510"));
        persons.add(new Person("Alex", new GregorianCalendar(1985,8,9),"EH846146"));
        persons.add(new Person("Adam", new GregorianCalendar(1991,0,5),"EH846121"));
        persons.add(new Person("Will", new GregorianCalendar(1988,1,17),"AK130699"));
        persons.add(new Person("Tyler", new GregorianCalendar(1992,7,29),"EF940220"));
        persons.add(new Person("Mindy", new GregorianCalendar(1991,8,1),"MM503278"));
        persons.add(new Person("Dave", new GregorianCalendar(1993,2,23),"EE913652"));
        persons.add(new Person("Veronica", new GregorianCalendar(1989,10,16),"EH596600"));
        persons.add(new Person("Kate", new GregorianCalendar(1991,9,15),"EH511103"));
        persons.add(new Person("Maggie", new GregorianCalendar(1990,12,30),"AA946132"));
        persons.add(new Person("Toby", new GregorianCalendar(1990,4,27),"EH774561"));
        persons.add(new Person("Travis", new GregorianCalendar(1991,3,26),"GG100023"));

        return persons;
    }

    /**
     * Fills list of majors.
     * @return List<Major>
     */
    public ArrayList<Major> fillMajorList() {

        ArrayList<Major> majors = new ArrayList<Major>();

        majors.add(new Major("Develop"));
        majors.add(new Major("Admin"));
        majors.add(new Major("Design"));

        return majors;
    }

    public ArrayList<Form> fillFormList() {
        ArrayList<Form> forms = new ArrayList<Form>(2);

        forms.add(new Form("Stacionar"));
        forms.add(new Form("Semi-stacionar"));

        return forms;
    }

    public ArrayList<Subject> fillSubjectList(List<Major> majors) {
        ArrayList<Subject> subjects = new ArrayList<Subject>();

        subjects.add(new Subject("Java", majors.get(0)));
        subjects.add(new Subject("CPP", majors.get(0)));
        subjects.add(new Subject("JavaScript", majors.get(0)));
        subjects.add(new Subject("HTML", majors.get(2)));
        subjects.add(new Subject("MySQL", majors.get(0)));
        subjects.add(new Subject("Hardware", majors.get(1)));
        subjects.add(new Subject("Linux", majors.get(1)));
        subjects.add(new Subject("LAN", majors.get(1)));
        subjects.add(new Subject("CorelDraw", majors.get(2)));
        subjects.add(new Subject("Photoshop", majors.get(2)));
        subjects.add(new Subject("MSPaint", majors.get(2)));

        return subjects;
    }

    public ArrayList<Group> fillGroupList(List<Form> forms, List<Major> majors) {
        ArrayList<Group> groups = new ArrayList<Group>();

        groups.add(new Group("PPJ-13-1", forms.get(1), majors.get(0)));
        groups.add(new Group("PPP-12-1", forms.get(1), majors.get(0)));
        groups.add(new Group("PDD-12-1", forms.get(0), majors.get(2)));
        groups.add(new Group("PPA-10-1", forms.get(1), majors.get(1)));
        groups.add(new Group("PPC-11-1", forms.get(0), majors.get(0)));

        return groups;
    }


    public ArrayList<Student> fillStudentList(List<Person> persons, List<Group> groups) {

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(new GregorianCalendar(2010,8,1), new GregorianCalendar(2013,0,15), persons.get(0), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2009,3,12), new GregorianCalendar(2014,2,12), persons.get(1), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2005,1,10), new GregorianCalendar(2010,5,11), persons.get(2), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2011,11,11), new GregorianCalendar(2014,8,10), persons.get(4), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2012,4,23), new GregorianCalendar(2014,8,10), persons.get(4), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2005,3,22), new GregorianCalendar(2007,9,12), persons.get(5), groups.get(1)));
        students.add(new Student(new GregorianCalendar(2010,9,10), new GregorianCalendar(2015,11,10), persons.get(6), groups.get(1)));
        students.add(new Student(new GregorianCalendar(2012,5,12), new GregorianCalendar(2014,8,1), persons.get(6), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2008,7,10), new GregorianCalendar(2011,10,13), persons.get(7), groups.get(1)));
        students.add(new Student(new GregorianCalendar(2011,10,29), new GregorianCalendar(2014,5,26), persons.get(7), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2009,0,12), new GregorianCalendar(2014,7,22), persons.get(8), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2007,8,10), new GregorianCalendar(2010,2,10), persons.get(9), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2011,9,22), new GregorianCalendar(2015,1,2), persons.get(10), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2013,2,13), new GregorianCalendar(2016,3,15), persons.get(11), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2014,11,12), new GregorianCalendar(2017,4,10), persons.get(11), groups.get(4)));
        students.add(new Student(new GregorianCalendar(2013,1,14), new GregorianCalendar(2016,4,15), persons.get(13), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2011,8,9), new GregorianCalendar(2014,5,8), persons.get(14), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2012,6,7), new GregorianCalendar(2015,6,7), persons.get(15), groups.get(4)));
        students.add(new Student(new GregorianCalendar(2011,8,1), new GregorianCalendar(2015,4,30), persons.get(16), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2009,8,20), new GregorianCalendar(2013,9,13), persons.get(17), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2012,11,21), new GregorianCalendar(2014,0,30), persons.get(17), groups.get(4)));
        students.add(new Student(new GregorianCalendar(2011,3,3), new GregorianCalendar(2013,11,3), persons.get(18), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2013,7,27), new GregorianCalendar(2015,11,25), persons.get(19), groups.get(0)));
        students.add(new Student(new GregorianCalendar(2014,8,23), new GregorianCalendar(2016,11,8), persons.get(19), groups.get(4)));
        students.add(new Student(new GregorianCalendar(2014,9,14), new GregorianCalendar(2018,9,14), persons.get(20), groups.get(2)));
        students.add(new Student(new GregorianCalendar(2011,7,30), new GregorianCalendar(2015,0,1), persons.get(21), groups.get(1)));
        students.add(new Student(new GregorianCalendar(2010,1,17), new GregorianCalendar(2013,2,16), persons.get(21), groups.get(3)));
        students.add(new Student(new GregorianCalendar(2014,3,20), new GregorianCalendar(2016,4,25), persons.get(22), groups.get(4)));
        students.add(new Student(new GregorianCalendar(2008,3,12), new GregorianCalendar(2013,11,5), persons.get(23), groups.get(1)));

        return students;
    }

    public ArrayList<Teacher> fillTeacherList(List<Person> persons, List<Subject> subjects) {

        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        teachers.add(new Teacher(new GregorianCalendar(2012,5,1), new GregorianCalendar(2015,7,10), persons.get(0)));
        teachers.add(new Teacher(new GregorianCalendar(2008,0,10), new GregorianCalendar(2016,11,22), persons.get(3)));
        teachers.add(new Teacher(new GregorianCalendar(2013,0,22), new GregorianCalendar(2015,10,9), persons.get(6)));
        teachers.add(new Teacher(new GregorianCalendar(2011,11,29), new GregorianCalendar(2017,4,17), persons.get(7)));
        teachers.add(new Teacher(new GregorianCalendar(2005,7,17), new GregorianCalendar(2017,9,19), persons.get(12)));
        teachers.add(new Teacher(new GregorianCalendar(2012,1,10), new GregorianCalendar(2018,11,30), persons.get(14)));
        teachers.add(new Teacher(new GregorianCalendar(2010,2,26), new GregorianCalendar(2016,10,16), persons.get(19)));
        teachers.add(new Teacher(new GregorianCalendar(2003,4,9), new GregorianCalendar(2015,11,13), persons.get(24)));

        teachers.get(0).addSubject(subjects.get(0));
        teachers.get(0).addSubject(subjects.get(1));
        teachers.get(0).addSubject(subjects.get(2));
        teachers.get(0).addSubject(subjects.get(3));
        teachers.get(0).addSubject(subjects.get(4));
        
        teachers.get(1).addSubject(subjects.get(5));
        teachers.get(1).addSubject(subjects.get(6));
        teachers.get(1).addSubject(subjects.get(7));
        teachers.get(1).addSubject(subjects.get(1));
        teachers.get(1).addSubject(subjects.get(4));
        
        teachers.get(2).addSubject(subjects.get(8));
        teachers.get(2).addSubject(subjects.get(9));
        teachers.get(2).addSubject(subjects.get(10));
        
        teachers.get(3).addSubject(subjects.get(8));
        teachers.get(3).addSubject(subjects.get(9));
        teachers.get(3).addSubject(subjects.get(10));
        
        teachers.get(4).addSubject(subjects.get(3));
        teachers.get(4).addSubject(subjects.get(2));
        teachers.get(4).addSubject(subjects.get(4));
        
        teachers.get(5).addSubject(subjects.get(0));
        teachers.get(5).addSubject(subjects.get(1));
        teachers.get(5).addSubject(subjects.get(4));
        teachers.get(5).addSubject(subjects.get(6));
        
        teachers.get(6).addSubject(subjects.get(8));
        teachers.get(6).addSubject(subjects.get(9));
        teachers.get(6).addSubject(subjects.get(2));
        teachers.get(6).addSubject(subjects.get(3));
        
        teachers.get(7).addSubject(subjects.get(7));
        teachers.get(7).addSubject(subjects.get(10));
        teachers.get(7).addSubject(subjects.get(0));
        teachers.get(7).addSubject(subjects.get(4));
        
        return teachers;
    }

    
}
