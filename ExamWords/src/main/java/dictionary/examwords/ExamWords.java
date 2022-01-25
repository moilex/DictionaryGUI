package dictionary.examwords;

import dictionary.wordsstorage.WordsStorage;
import java.util.*;

public class ExamWords {
    private String[] engWords;
    private String[] rusWords;
    private HashMap<String, String> dictionary;
    private int randomNum;


    public ExamWords(WordsStorage wo){
        this.dictionary = wo.getDictionary();
        putWords();
    }

    public void putWords(){
        int i = 0;
        engWords = new String[dictionary.size()];
        rusWords = new String[dictionary.size()];
        for(Map.Entry<String, String> words : dictionary.entrySet()){
            engWords[i] = words.getKey();
            rusWords[i] = words.getValue();
            i++;
        }
    }

    public String checkWord(){
        randomNum = (int)(Math.random() * (engWords.length - 1));
        return rusWords[randomNum];
    }
    public String trueWord(){
        return engWords[randomNum];
    }

    public String falseWords(){
        int newRandomNum = (int)(Math.random() * (engWords.length - 1));
        if(newRandomNum == randomNum){
            newRandomNum = (int)(Math.random() * (engWords.length - 1));
        }
        return engWords[newRandomNum];
    }

    public int getNumRandom(){
        return (int)(Math.random() * 4);
    }

}
