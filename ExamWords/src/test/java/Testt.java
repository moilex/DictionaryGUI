import dictionary.examwords.ExamWords;
import dictionary.wordsstorage.WordsStorage;

public class Testt {
    public static void main(String[] args) {
        WordsStorage woo = new WordsStorage();
        ExamWords ex = new ExamWords(woo);
       /*System.out.println(ex.checkWord());
        System.out.println(ex.falseWords());
        System.out.println(ex.trueWord());
        System.out.println(ex.falseWords());
        System.out.println(ex.falseWords());
        System.out.println(ex.getNumRandom());*/
        System.out.println(ex.checkWord());
        System.out.println(woo.getDictionary().get(ex.trueWord()));
        System.out.println(ex.checkWord().equals(woo.getDictionary().get(ex.trueWord())));

    }
}
