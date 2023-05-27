package FirstTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneReaderTest {
    public static void main(String[] args) throws IOException {
        List<String > phones = new ArrayList<String>();
        File file = new File("C:\\Users\\alexa\\IdeaProjects\\modul10\\src\\FirstTask\\file.txt");

        InputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            phones.add(scanner.nextLine());
        }
        PhoneValidity.phoneValidity(phones);
        fis.close();
    }
}