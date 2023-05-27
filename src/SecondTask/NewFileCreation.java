package SecondTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class NewFileCreation {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\alexa\\IdeaProjects\\modul10\\src\\SecondTask\\file.txt");
        Reader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        List<User> users   = new LinkedList<>();
        while(scanner.hasNext()){
            String[] cred = scanner.nextLine().split(" ");
            if(!cred[1].equals("age")){
            User user = new User(cred[0],Integer.parseInt(cred[1]));
            users.add(user);
            }
        }
        scanner.close();
        String jsonText = convertToJson(users);
        OutputStream os = new FileOutputStream("C:\\Users\\alexa\\IdeaProjects\\modul10\\src\\SecondTask\\user.json");
        byte[] buffer = jsonText.getBytes();
        os.write(buffer, 0, buffer.length);
        os.close();
    }

    public static String convertToJson(List <User> users){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
       return json;
    }

}
