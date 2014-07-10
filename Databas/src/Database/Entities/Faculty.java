package Database.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 01.07.14.
 * ALL RIGHTS RESERVED ®©
 */
public class Faculty implements Serializable{
    /**
     * Main work storage of all tables with entities.
     */

    private ArrayList<Person> persons;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Form> forms;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    private ArrayList<Major> majors;

    public Faculty() {
        persons = null;
        students = null;
        teachers = null;
        groups = null;
        subjects = null;
        majors = null;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Form> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Subject> getSubject() {
        return subjects;
    }

    public void setSubject(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }
}
