package Database.FileIO;

import Database.Entities.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alex on 20.06.14.
 * Following class provides couple tools
 * for reading & writing objects Student
 * from(to) file.
 */
public class StudentIO {

    /**
     * Method writes given List of students to file by filePath.
     * @param students - list of students, that needs to be written to file,
     * @param filePath - full path to destination file, if only name-file will
     *                 be created by default
     */
    public static void writeStudent(ArrayList<Student> students, String filePath) {
        try {
            Iterator<Student> iterator = students.iterator();
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
     * Method reads data from file to list of students.
     * @param students - destination list of students, that needs to be written to file,
     * @param filePath - full path to source file
     */
    public static void readStudent(ArrayList<Student> students, String filePath) {
        try {
            ObjectInputStream stream = new ObjectInputStream(
                                           new BufferedInputStream(
                                                new FileInputStream(filePath)));
            Student student;
            try {
                while ( (student=(Student)stream.readObject())!= null ) {
                    students.add(student);
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
