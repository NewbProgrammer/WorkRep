package Database.Validator;

import Database.Entities.Person;

/**
 * Created by Alex on 04.07.14.
 */
public class PersonValidator implements ValidationInterface{

    @Override
    public boolean validate(Object obj) throws IllegalArgumentException{
        Person person = (Person) obj;
        Validator validator = new Validator();

        validator.validateText(person.getName());
        validator.validatePassport(person.getPassport());
        /*No need to validate Birthday, 'cause GregorianCalendar always convert in correct format*/

        return true;
    }
}
