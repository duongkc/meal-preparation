package com.example.ikm;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class to
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class FileReader {
    String filePath;
    String fileText;


    public static String getJsonAsString(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try
        {
            Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public void readJson()
    {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(filePath));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
