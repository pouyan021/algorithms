package com.pouyankhodabakhsh.algorithm.utils;

import com.pouyankhodabakhsh.algorithm.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class FileUtil {

    private FileUtil() {
    }

    public static List<String> readFile(String inputFIle) throws IOException {
        Configuration configuration = Configuration.getInstance();
        String filepath = configuration.getFilepath();
        File file = new File(filepath + inputFIle);
        return FileUtils.readLines(file, StandardCharsets.UTF_8);
    }

}
