import dictionary.wordsstorage.WordsStorage;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        WordsStorage wo = new WordsStorage();
        HashMap<String, String> dictionary = wo.getDictionary();
        System.out.println(dictionary.get(1));
    }
}
