package helper.json;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void write(String json) {
        try {
            FileWriter myWriter = new FileWriter("result.json");
            myWriter.write(json);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
