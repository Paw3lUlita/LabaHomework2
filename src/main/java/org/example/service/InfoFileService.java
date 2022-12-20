package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InfoFileService {

    private static final String FILE_PATH = "infoData.csv";
    private final File lastInfoFile;

    public InfoFileService() {
        this.lastInfoFile = new File(FILE_PATH);
    }

    public void writeToFile(String data) {
        try {
            FileUtils.write(lastInfoFile, data + ",", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readDataFromFile() throws IOException {
        String dataFromFile = FileUtils.readFileToString(lastInfoFile, "UTF-8");
        return Arrays.stream(StringUtils.split(dataFromFile, ',')).toList();
    }

    public void clearDataFile() {
        try {
            FileUtils.delete(lastInfoFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
