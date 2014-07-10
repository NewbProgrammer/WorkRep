package Database.FileIO;

import Database.Entities.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alex on 20.06.14.
 * Following class provides couple tools
 * for reading & writing objects Person
 * from(to) file.
 */
public class PersonIO {
    /**
     * Method writes given List of persons to file by filePath.
     * @param persons - list of persons, that needs to be written to file,
     * @param filePath - full path to destination file, if only name-file will
     *                 be created by default
     */
    public static void writePerson(ArrayList<Person> persons, String filePath) {
        try {
            Iterator<Person> iterator = persons.iterator();
            ObjectOutputStream stream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));
            while (iterator.hasNext()) {
                stream.writeObject(iterator.next());
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method reads data from file to list of persons.
     * @param persons - destination list of persons, that needs to be written to file,
     * @param filePath - full path to source file
     */
    public static void readPerson(ArrayList<Person> persons, String filePath) {
        try {
            ObjectInputStream stream = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));
            Person person;
            try {
                while ( (person=(Person)stream.readObject())!= null ) {
                    persons.add(person);
                }
            }
            /*
            * Empty catch block 'cause EOF is nominal in this context
            */
            catch (EOFException e) {}
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
