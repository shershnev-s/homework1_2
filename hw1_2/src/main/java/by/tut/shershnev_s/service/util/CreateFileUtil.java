package by.tut.shershnev_s.service.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateFileUtil {

    private static final Logger logger = LogManager.getLogger();

    public static void createFile(File file) {
        try {
            if (!file.exists()) {
                boolean isFileCreated = file.createNewFile();
                if (!isFileCreated) {
                    throw new FileNotFoundException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal("File can't be created: " + e.getMessage());
        }
    }
}
