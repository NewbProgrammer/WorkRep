package Database.Validator;

import org.apache.log4j.Logger;

/**
 * Created by Alex on 29.06.14.
 *
 */
public class Validator {
    /**
     * Designed for validating data such as
     * names, dates etc.
     *
     * Might be useful to develop method for
     * validation of hole object...
     */

    /**
     * Logger used for logging information from this class.
     */
    private static final Logger logger = Logger.getLogger(Validator.class);

    public Validator() {}

    /**
     * Used for validation data
     * which represents simple string
     * which starts from capital letter followed
     * by as many characters as you need
     * @param text string which represents name, major, subject or
     *             etc. - simple string.
     * @throws IllegalArgumentException
     */
    public  boolean validateText (String text) throws IllegalArgumentException {
        logger.debug("Validating text: " + text);
        String test = "[A-Z][a-z]+";
        if (!text.matches(test)) {
            logger.warn("Validation of text failed: " + text);
            throw new IllegalArgumentException();
        }
        logger.info("Validation of text succeed: " + text);
        return true;
    }

    /**
     * Used for validation of date in format
     * DD-MM-YYYY.
     * @param date string representation of date in format DD-MM-YYYY
     * @throws IllegalArgumentException
     */
    public  boolean validateDate(String date) throws IllegalArgumentException {
        logger.debug("Validating date: " + date);
        String test = "((0?\\d)|([1-2]\\d)|(3[0-1]))((0?[1-9])|(1[0-2]))\\d{4}";
        if (!date.matches(test)) {
            logger.warn("Validation of date failed: " + date);
            throw new IllegalArgumentException();
        }
        logger.info("Validation of date succeed: " + date);
        return true;
    }

    /**
     * Used for validation of passport number
     * which consists from two capital letters
     * and four digits
     * @param passport - passport number - 2 letters and 4 digits
     * @throws IllegalArgumentException
     */
    public boolean validatePassport (String passport) throws IllegalArgumentException {
        logger.debug("Validating passport: " + passport);
        String test = "[A-Z]{2}\\d{4}";
        if (!passport.matches(test)) {
            logger.warn("Validation of passport failed: " + passport);
            throw new IllegalArgumentException();
        }
        logger.info("Validation of passport succeed: " + passport);
        return true;
    }

    public boolean validateStringDate(String date) throws IllegalArgumentException {
        logger.debug("Validating date: " + date);
        String test = "((0?\\d)|([1-2]\\d)|(3[0-1])).((0?[1-9])|(1[0-2])).\\d{4}";
        if (!date.matches(test)) {
            logger.warn("Validation of date failed: " + date);
            throw new IllegalArgumentException();
        }
        logger.info("Validation of date succeed: " + date);
        return true;
    }
}
