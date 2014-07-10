package Database.Validator;

import Database.Entities.Student;
import org.apache.log4j.Logger;

/**
 * Created by Alex on 04.07.14.
 *
 */
public class StudentValidator implements ValidationInterface {

    private static final Logger logger = Logger.getLogger(ValidationInterface.class);

    @Override
    public boolean validate(Object obj) throws IllegalArgumentException {
        logger.debug("Trying to validate student.");
        Student student = (Student) obj;

        if (student.getStart().compareTo(student.getFinish())==-1) {
            logger.debug("Student valid.");
            return true;
        } else {
            logger.warn("Student invalid.");
            throw new IllegalArgumentException();
        }
    }
}
