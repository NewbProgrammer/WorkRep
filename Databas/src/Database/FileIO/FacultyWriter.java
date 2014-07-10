package Database.FileIO;

import Database.Entities.Faculty;
import Database.Entities.Person;
import org.apache.log4j.Logger;

import static Database.Initializing.Init.PROPERTY_FILE_PATH;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Alex on 02.07.14.
 *
 */
public class FacultyWriter implements Writer {
    /**
     *  Designed for write Faculty object to file.
     */

    /**
     * Writes serializable instance to file.
     * First trying to get file path from property file of
     * application, if failed set default file path.
     * @param object that needs to be written to file
     */
    public void write(Serializable object) {

        Logger logger = Logger.getLogger(FacultyWriter.class);

        boolean isFilePathCorrect = true;

        Properties properties = new Properties();


        String filePath = null;

        try {
            logger.debug("Trying to write file by property file path.");
            properties.load(new FileReader(PROPERTY_FILE_PATH));
            filePath =properties.getProperty("file_path");
            ObjectOutputStream stream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));

            stream.writeObject(object);
            logger.info("File by property file path successfully written. File path: " + filePath);
            stream.close();
            logger.trace("Stream closed.");
        } catch (IOException e) {
            logger.error("Error in writing file. File path: " + filePath);
            isFilePathCorrect = false;
            filePath = "default.txt";
        }

        if (!isFilePathCorrect) {
            try {
                logger.debug("Trying to write file by default file path.");
                ObjectOutputStream stream = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filePath)));

                stream.writeObject(object);
                logger.info("File by default file path successfully written.File path: " + filePath);
                stream.close();
                logger.trace("Stream closed.");
            } catch (IOException e) {
                logger.error("Error in writing file.File path: " + filePath);
            }
        }
    }
}
