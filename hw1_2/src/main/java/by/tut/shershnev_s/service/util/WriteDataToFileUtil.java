package by.tut.shershnev_s.service.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToFileUtil {

    private static final Logger logger = LogManager.getLogger();

    public static void writeDataToFileUtil(File file, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal("File can't be written: " + e.getMessage());
        }
    }
}
