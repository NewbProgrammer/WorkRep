package Database.Interface;

import Database.Comparators.PersonBirthdayCompare;
import Database.Comparators.PersonNameCompare;
import Database.Comparators.PersonPassportCompare;
import Database.Entities.Person;
import Database.Entities.Student;
import Database.Entities.Teacher;
import Database.FileIO.*;
import Database.Validator.Validator;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Alex on 20.06.14.
 *
 * Following class provides console interface
 * for dealing with Person's instances.
 * PersonInterface includes next options:
 *  - creating of list of Person type;
 *  - adding element at the end of the existing list;
 *  - removing last element from the list;
 *  - reading data from specified file to list;
 *  - writing current list to specified file;
 *  - printing all persons from the list to console.\
 *
 *  Though, this class needs to be modified in part
 *  of adding students & teachers to object Person.
 *
 */
public class PersonInterface {

    private static final Logger logger = Logger.getLogger(PersonInterface.class);

    private ArrayList<Person> persons;

    public PersonInterface(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void showMenu() {
       // PersonInterface personInterface = new PersonInterface(persons);

        boolean end=false;

        Scanner scan = new Scanner(System.in);

        /**Work list of persons*/
        //ArrayList<Person> persons = new ArrayList<Person>(10);

        do {
            logger.debug("Entered in person interface.");
            System.out.println("Choose option:");
            //System.out.println("1 - Create list of persons");
            System.out.println("2 - Add person");
            System.out.println("3 - Remove last person from the list");
            //System.out.println("4 - Read list of persons from file");
            //System.out.println("5 - Write list of persons to file");
            System.out.println("6 - Print list of persons");
            System.out.println("7 - Sort by name");
            System.out.println("8 - Sort by birthday");
            System.out.println("9 - Sort by passport");
            System.out.println("0 - Exit");

            switch (scan.nextInt()) {

                case 2: {
                    logger.debug("Option \"2 - Add person\" chosen");
                    addPerson();
                }
                break;

                case 3: {
                    logger.debug("Option \"3 - Remove last person from the list\" chosen");
                    persons.remove(persons.size()-1);
                }
                break;

                /*case 4: {
                    System.out.println("Enter file path/name:");
                    scan.skip("\n");
                    String fileName = scan.nextLine();
                    PersonIO.readPerson(persons, fileName);
                }
                break;

                case 5: {
                    System.out.println("Enter file path/name:");
                    scan.skip("\n");
                    String fileName = scan.nextLine();
                    PersonIO.writePerson(persons, fileName);
                }
                break;*/

                case 6: {
                    logger.debug("Option \"6 - Print list of persons\" chosen");
                    System.out.println(persons);
                }
                break;

                case 7: {
                    logger.debug("Option \"7 - Sort by name\" chosen");
                    logger.debug("Start sorting by Name.");
                    persons.sort(new PersonNameCompare());
                    logger.info("List of persons sorted by Name.");
                }
                break;

                case 8: {
                    logger.debug("Option \"8 - Sort by birthday\" chosen");
                    logger.debug("Start sorting by Birthday.");
                    persons.sort(new PersonBirthdayCompare());
                    logger.info("List of persons sorted by Birthday.");
                }
                break;

                case 9: {
                    logger.debug("Option \"9 - Sort by passport\" chosen");
                    logger.debug("Start sorting by Passport.");
                    persons.sort(new PersonPassportCompare());
                    logger.info("List of persons sorted by Passport.");
                }

                case 0: {
                    logger.debug("Option \"0 - Exit\" chosen");
                    end=true;
                }
                break;

                default: {
                    logger.warn("Incorrect option chosen!");
                }
            }
        } while (!end);
    }

    private void addPerson() {
        logger.debug("Trying to add new Person.");
        Scanner scan = new Scanner(System.in);

        String name = null;
        int year = 0;
        int month = 0;
        int day = 0;
        String passport = null;

        try {
            Validator validator = new Validator();
            logger.trace("Getting data from user.");
            System.out.println("Enter name:");
            name = scan.nextLine();
            validator.validateText(name);
            System.out.println("Enter birthday (dd mm yy):");
            day = scan.nextInt();
            month = scan.nextInt();
            year = scan.nextInt();
            validator.validateDate(""+day+month+year);
            System.out.println("Enter passport number:");
            passport = scan.nextLine();
            validator.validatePassport(passport);
            logger.debug("All data valid. Proceed to creating Person.");
            Person person = new Person(name, new GregorianCalendar(year, month, day), passport);
            persons.add(person);
            logger.info("Person successfully added.");
        } catch (IllegalArgumentException e) {
            logger.warn("Incorrect data! Name: " + name + " Birthday: " +
                    day + "." + month + "." + year + " Passport: " + passport);
        }



        /*do {
            System.out.println("1 - Add student");
            System.out.println("2 - Add teacher");
            System.out.println("0 - Exit");
            int switcher = scan.nextInt();
            switch (switcher) {

                case 1: {
                    addStudent();
                }
                break;

                case 2: {
                    addTeacher();
                }
                break;

                case 0:
                break;

                default: {
                    System.out.println("Incorrect data!");
                }
            }
        } while (true);*/
    }



    /*private void addStudent() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose student to add");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i+students.get(i).getPerson().getName());
        }
    }*/

    /*private void addTeacher() {

    }*/
}
