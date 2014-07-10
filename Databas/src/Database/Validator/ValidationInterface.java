package Database.Validator;

import java.util.Objects;

/**
 * Created by Alex on 04.07.14.
 */
public interface ValidationInterface {
    /**
     * Provides interface for creating validators
     * for each entity.
     *
     */

    /**
     * Used for checking object for correct data
     * in object's fields.
     * @param obj object to validate
     * @return true if object valid, or false if object invalid
     */
    public boolean validate(Object obj) throws IllegalArgumentException;
}
