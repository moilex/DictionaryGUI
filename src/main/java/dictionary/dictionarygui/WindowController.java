package dictionary.dictionarygui;

import dictionary.examwords.ExamWords;
import dictionary.wordsstorage.WordsStorage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class WindowController {
    WordsStorage wo = new WordsStorage();
    ExamWords ex = new ExamWords(wo);

    @FXML
    private ImageView errorChoice;

    @FXML
    private Button firstOp;

    @FXML
    private Button secondOp;

    @FXML
    private Button thirdOp;

    @FXML
    private Button fourthOp;

    @FXML
    private Text checkWord;

    @FXML
    private Button dictionaryButt;

    @FXML
    private Button checkButt;

    @FXML
    private Button putInWord;

    @FXML
    private AnchorPane dicPanel;

    @FXML
    private AnchorPane exPanel;

    @FXML
    private TextField engWord;

    @FXML
    private TextField rusWord;

    @FXML
    private ListView<String> screenWord;

    @FXML
    void initialize(){
        dicPanel.setVisible(true);
        exPanel.setVisible(false);
        screenWord.getItems().addAll(wo.displayDictionary());
        errorChoice.setVisible(false);
    }

    public void putInDic(){
        wo.addWord(engWord.getText(), rusWord.getText());
        screenWord.getItems().add(engWord.getText() + " - " + rusWord.getText());
        engWord.clear();
        rusWord.clear();
    }


    @FXML
    public void changeToDicPanel(){
        dicPanel.setVisible(true);
        exPanel.setVisible(false);
    }

    @FXML
    public void changeToExPanel(){
        dicPanel.setVisible(false);
        exPanel.setVisible(true);
        wordSet();
    }

    public void wordSet(){
        checkWord.setText(ex.checkWord());
        switch(ex.getNumRandom()){
            case 0:
                firstOp.setText(ex.trueWord());
                secondOp.setText(ex.falseWords());
                thirdOp.setText(ex.falseWords());
                fourthOp.setText(ex.falseWords());
                break;
            case 1:
                firstOp.setText(ex.falseWords());
                secondOp.setText(ex.trueWord());
                thirdOp.setText(ex.falseWords());
                fourthOp.setText(ex.falseWords());
                break;
            case 2:
                firstOp.setText(ex.falseWords());
                secondOp.setText(ex.falseWords());
                thirdOp.setText(ex.trueWord());
                fourthOp.setText(ex.falseWords());
                break;

            case 3:
                firstOp.setText(ex.falseWords());
                secondOp.setText(ex.falseWords());
                thirdOp.setText(ex.falseWords());
                fourthOp.setText(ex.trueWord());
                break;
        }
    }

    public void choiceFirst() throws InterruptedException {
        if(checkWord.getText().equals(wo.getDictionary().get(firstOp.getText()))) {
            wordSet();
        }
        else{
            visiblePic(errorChoice);
        }
    }
    public void choiceSecond() throws InterruptedException {
        if(checkWord.getText().equals(wo.getDictionary().get(secondOp.getText()))) {
            wordSet();
        }else{
            visiblePic(errorChoice);
        }
    }
    public void choiceThird() throws InterruptedException {
        if(checkWord.getText().equals(wo.getDictionary().get(thirdOp.getText()))) {
            wordSet();
        }else{
            visiblePic(errorChoice);
        }
    }
    public void choiceFourth() throws InterruptedException {
        if(checkWord.getText().equals(wo.getDictionary().get(fourthOp.getText()))) {
            wordSet();
        }else{
           visiblePic(errorChoice);
        }
    }
    public void visiblePic(ImageView img){
        img.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    img.setVisible(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}