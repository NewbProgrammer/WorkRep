package Database;

import Database.FileIO.FacultyReader;
import Database.FileIO.FacultyWriter;
import Database.Initializing.Init;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Database.Entities.*;
import Database.Tools.DateToString;
import Database.Interface.*;
import Database.Validator.*;
import org.apache.log4j.Logger;

import static Database.Initializing.Init.PROPERTY_FILE_PATH;


public class Test {
    private static final Logger fLog = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        fLog.info("Application started");

        /*ArrayList<Person> persons;
        ArrayList<Student> students;
        ArrayList<Teacher> teachers;
        ArrayList<Major> majors;
        ArrayList<Subject> subjects;
        ArrayList<Group> groups;
        ArrayList<Form> forms;

        Init ini = new Init();

        persons = ini.fillPersonList();
        majors = ini.fillMajorList();
        forms = ini.fillFormList();
        subjects = ini.fillSubjectList(majors);
        groups = ini.fillGroupList(forms,majors);
        teachers = ini.fillTeacherList(persons, subjects);
        students = ini.fillStudentList(persons, groups);

        System.out.println("Persons:");
        for (Object person : persons) {
            System.out.println(person.toString());
        }

        System.out.println("Teachers:");

        for (Object teacher : teachers) {
            System.out.println(teacher.toString());
        }

        System.out.println("Majors:");

        for (Object major : majors) {
            System.out.println(major.toString());
        }

        System.out.println("Forms:");

        for (Object form : forms) {
            System.out.println(form.toString());
        }

        System.out.println("Subjects:");

        for (Object subject : subjects) {
            System.out.println(subject.toString());
        }

        System.out.println("Groups:");

        for (Object group : groups) {
            System.out.println(group.toString());
        }

        System.out.println("Students:");

        for (Object student : students) {
            System.out.println(student.toString());
        }

        System.out.println("Subjects:");

        for (Object subject : subjects) {
            System.out.println(subject.toString());
        }

        Faculty faculty = new Faculty();
        faculty.setForms(forms);
        faculty.setMajors(majors);
        faculty.setSubject(subjects);
        faculty.setGroups(groups);
        faculty.setPersons(persons);
        faculty.setStudents(students);
        faculty.setTeachers(teachers);

        FacultyWriter writer = new FacultyWriter();
        writer.write(faculty);*/

        FacultyReader reader = new FacultyReader();
        Faculty faculty;
        faculty = (Faculty)reader.read();



        /*List<Person> testpers = faculty.getPersons();
        System.out.println("New Persons:");
        for (Object person : testpers) {
            System.out.println(person.toString());
        }*/

        //PersonInterface personInterface = new PersonInterface(faculty.getPersons());
        //personInterface.showMenu();

        StudentInterface studentInterface = new StudentInterface(faculty.getStudents(), faculty.getPersons(), faculty.getGroups());
        studentInterface.showMenu();
        fLog.warn("Application ended");

        /*
        * Read data from file
         * open interface of entities
         * before exiting save data to file
        */
    }
}
