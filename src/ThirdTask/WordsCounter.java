package ThirdTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class WordsCounter {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\alexa\\IdeaProjects\\modul10\\src\\ThirdTask\\word.txt");
        InputStream inputStream = new FileInputStream(file);
        StringJoiner text = new StringJoiner(" ");
        try(Scanner scanner = new Scanner(inputStream)){
           while (scanner.hasNext()){
               text.add(scanner.nextLine());
           }
            wordsCounter(String.valueOf(text));

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void wordsCounter(String text){
        Set<String> uniqueItems = new LinkedHashSet<>();
        Set<Integer> amountOfRepeats = new LinkedHashSet<>();
        String [] words =text.split(" ");
        for (String word: words){
            uniqueItems.add(word);
        }
        int counter = 0;
        for (String item : uniqueItems) {
            for(int i = 0; i<words.length; i++){
                if(item.equals(words[i])){
                    counter++;
                }
            }
            amountOfRepeats.add(counter);
            counter=0;
        }
        sortedData(amountOfRepeats,uniqueItems);
    }

    public static void sortedData(Set<Integer> amountOfRepeats, Set<String> uniqueItems ){
        List<Integer> amount = new LinkedList<>(amountOfRepeats);
        List<String> unItems = new LinkedList<String>(uniqueItems);

        TreeMap<Integer, String> sorted = new TreeMap<>();
        for (int i = 0; i < amountOfRepeats.size(); i++) {
            sorted.put(amount.get(i),unItems.get(i));
        }
        System.out.println("sorted.descendingMap() = " + sorted.descendingMap());
    }
}
