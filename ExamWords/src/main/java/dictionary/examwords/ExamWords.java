package dictionary.examwords;

import dictionary.wordsstorage.WordsStorage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExamWords {
    private String[] engWords;
    private String[] rusWords;
    private WordsStorage wo;
    private Random random = new Random();
    private HashMap<String, String> dictionary;
    private int randomNum;
    private int newRandomNum;
    private int secNum;



    public ExamWords(WordsStorage wo){
        this.wo = wo;
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
        randomNum = random.nextInt(engWords.length - 1);
        return rusWords[randomNum];
    }
    public String trueWord(){
        return engWords[randomNum];
    }

    public String falseWords(){
        newRandomNum = random.nextInt(engWords.length - 1);
        if(newRandomNum == randomNum){
            newRandomNum = random.nextInt(engWords.length - 1);
        }
        return engWords[newRandomNum];
    }

    public int getNumRandom(){
        int i = random.nextInt(4);
        return i;
    }

}
