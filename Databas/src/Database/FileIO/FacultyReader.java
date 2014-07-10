package Database.FileIO;

import org.apache.log4j.Logger;

import static Database.Initializing.Init.PROPERTY_FILE_PATH;

import java.io.*;
import java.util.Properties;

/**
 * Created by Alex on 02.07.14.
 *
 */
public class FacultyReader {
    /**
     * Main purpose is to read object Faculty from the file.
     */

    /**
     * Reads serializable instance from file.
     * First getting file path from property file, if fails
     * set file path by default.
     * @return object of type Serializable
     */
    public Serializable read() {

        Logger logger = Logger.getLogger(FacultyWriter.class);

        boolean isFilePathCorrect = true;

        Properties properties = new Properties();

        String filePath = null;

        Serializable object = null;

        try {
            logger.debug("Trying to read data by property file path. File path: " + filePath);
            properties.load(new FileReader(PROPERTY_FILE_PATH));
            filePath =properties.getProperty("file_path");
            ObjectInputStream stream = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));
            object = (Serializable)stream.readObject();
            logger.info("Data successfully read from file by property file path. File path: " + filePath);
            stream.close();
            logger.trace("Stream closed.");
        } catch (ClassNotFoundException | IOException  e) {
            if (e instanceof FileNotFoundException) {
                logger.error("File not found. File path: "+filePath);
            } else if (e instanceof IOException) {
                logger.error("Error reading file. File path " + filePath);
            } else if (e instanceof ClassNotFoundException) {
                logger.error("Class not found exception!");
            }
            isFilePathCorrect = false;
            filePath = "default.txt";
        }

        if (!isFilePathCorrect) {
            try {
                logger.debug("Trying to read data by default file path. File path: " + filePath);
                ObjectInputStream stream = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filePath)));
                object = (Serializable)stream.readObject();
                logger.info("Data successfully read from file by property file path. File path: " + filePath);
                stream.close();
                logger.trace("Stream closed.");
            } catch (ClassNotFoundException | IOException  e) {
                if (e instanceof FileNotFoundException) {
                    logger.error("File not found. File path: "+filePath);
                } else if (e instanceof IOException) {
                    logger.error("Error reading file. File path " + filePath);
                } else if (e instanceof ClassNotFoundException) {
                    logger.error("Class not found exception!");
                }
            }
        }
        return object;
    }

}
