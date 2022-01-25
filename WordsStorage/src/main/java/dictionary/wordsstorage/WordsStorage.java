package dictionary.wordsstorage;
import dictionary.filecontroller.FileController;
import dictionary.recandread.*;

import java.util.HashMap;
import java.util.Map;


public class WordsStorage{
    private final FileController wordsFile = new FileController();
    private final RecFile recFile = new RecFile(wordsFile.getPathForCreate());
    private final ReadFile readDic = new ReadFile(wordsFile.getPathForCreate());
    private HashMap<String, String> dictionary;


    public WordsStorage(){
        checkDic();
    }

    public void addWord(String engW, String rusW){
        this.dictionary.put(engW,rusW);
        recFile.recDictionary(dictionary);
    }
    public String[] displayDictionary(){
        dictionary = readDic.readDic();
        String[] allWords = new String[dictionary.size()];
        int i = 0;
        for(Map.Entry<String, String> words : dictionary.entrySet()){
            allWords[i] = words.getKey() + " - " + words.getValue();
            i++;
        }
        return allWords;
    }

    public void checkDic(){
        if(wordsFile.isFileEmpty()){
            dictionary = new HashMap<>();
            recFile.recDictionary(dictionary);
        }else{
            dictionary = readDic.readDic();
        }
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }


}
