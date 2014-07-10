package Database.Interface;

import Database.Comparators.StudentStartCompare;
import Database.Entities.Group;
import Database.Entities.Person;
import Database.Entities.Student;
import Database.FileIO.*;
import Database.Validator.StudentValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Alex on 20.06.14.
 *
 * Following class provides console interface
 * for dealing with Student's instances.
 * StudentInterface includes next options:
 *  - creating of list of Student type;
 *  - adding element at the end of the existing list;
 *  - removing last element from the list;
 *  - reading data from specified file to list;
 *  - writing current list to specified file;
 *  - printing all students from the list to console
 */
public class StudentInterface {

    private ArrayList<Student> students;
    private ArrayList<Person> persons;
    private ArrayList<Group> groups;

    private static final Logger logger = Logger.getLogger(PersonInterface.class);

    public StudentInterface(ArrayList<Student> students, ArrayList<Person> persons, ArrayList<Group> groups) {
        this.students = students;
        this.persons = persons;
        this.groups = groups;
    }

    public void showMenu() {

        /** Flag for endless loop of menu */
        boolean end=false;

        /**scanner for input data from keyboard*/
        Scanner scan = new Scanner(System.in);

        /**work array of students*/
        //ArrayList<Student> students = new ArrayList<Student>(10);


        do {
            logger.debug("Entered in student interface.");
            System.out.println("Choose option:");
            //System.out.println("1 - Create list of students");
            System.out.println("2 - Add student");
            System.out.println("3 - Remove last student from the list");
            //System.out.println("4 - Read list of students from file");
            //System.out.println("5 - Write list of students to file");
            System.out.println("6 - Print list of students");
            System.out.println("7 - Sort by start date");
            System.out.println("0 - Exit");

            switch (scan.nextInt()) {
                case 1: {

                }
                break;

                case 2: {
                    addStudent();
                }
                break;

                case 3: {
                    students.remove(students.size()-1);
                }
                break;

                /*case 4: {
                    System.out.println("Enter file path/name:");
                    scan.skip("\n");
                    String fileName = scan.nextLine();
                    StudentIO.readStudent(students, fileName);
                }
                break;

                case 5: {
                    System.out.println("Enter file path/name:");
                    scan.skip("\n");
                    String fileName = scan.nextLine();
                    StudentIO.writeStudent(students, fileName);
                }
                break;*/

                case 6: {
                    System.out.println(students);
                }
                break;

                case 7: {
                    logger.debug("Option \"8 - Sort by start\" chosen");
                    logger.debug("Start sorting by Start date.");
                    students.sort(new StudentStartCompare());
                    logger.info("List of persons sorted by Start date.");
                }
                break;

                case 0: {
                    end=true;
                }
                break;

                default: {
                    logger.warn("Incorrect option chosen.");
                }
                break;
            }
        } while (!end);
    }

    private void addStudent() {
        Scanner scan = new Scanner(System.in);
        StudentValidator validator = new StudentValidator();
        Student student = null;
        int year;
        int month;
        int day;
        try {
            System.out.println("Enter start date:");
            day = scan.nextInt();
            month = scan.nextInt();
            year = scan.nextInt();
            GregorianCalendar start = new GregorianCalendar(year, month, day);
            System.out.println("Enter finish date:");
            day = scan.nextInt();
            month = scan.nextInt();
            year = scan.nextInt();
            student = new Student(start, new GregorianCalendar(year, month, day));
            logger.info("Validating new student.");
            validator.validate(student);
        } catch (IllegalArgumentException e) {
            logger.error("Illegal Argument. Student invalid.");
            System.out.println("You've entered incorrect data!");
            return;
        }

        boolean end = false;
        do {
            System.out.println("You may want to add person and group to student:");
            System.out.println("1 - Person");
            System.out.println("2 - Group");
            System.out.println("0 - Exit");
            switch (scan.nextInt()) {

                case 1:{
                    addPerson(student);
                }
                break;

                case 2: {
                    addGroup(student);
                }
                break;

                case 0: {
                    end = true;
                }
                break;

                default: {
                    logger.warn("Incorrect option chosen.");
                }
            }
        } while (!end);

        students.add(student);
    }

    private void addPerson(Student student) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose person to add:");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(i+" - "+persons.get(i).getName());
        }
        student.setPerson(persons.get(scan.nextInt()));

    }

    private void addGroup(Student student) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose group to add:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i+1)+" - "+groups.get(i).getName());
        }
        student.setGroup(groups.get(scan.nextInt() - 1));

    }
}
