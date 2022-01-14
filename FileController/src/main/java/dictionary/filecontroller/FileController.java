package dictionary.filecontroller;

import java.io.File;
import java.io.IOException;

public class FileController {
    private File wordsFile;
    private final String nameUser = System.getProperty("user.name");
    private String pathForCreate;
    private final String OS =System.getProperty("os.name").replaceAll("\\d", "");

    public FileController(){
        this.pathForCreate = createPath();
        this.createFile();
    }

    public void createFile() {
        File directoryFile = new File(pathForCreate);
        directoryFile.mkdirs();
        wordsFile = new File(pathForCreate, "words.bin");
        try {
            wordsFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNameUser() {
        return nameUser;
    }

    public String createPath() {
        if (OS.equals("Windows ")) {
            pathForCreate = "C:\\Users\\" + nameUser + "\\MyDictionary";
        }else{
            pathForCreate = "Users\\" + nameUser + "\\MyDictionary";
        }
        return pathForCreate;
    }

    public String getPathForCreate() {
        return pathForCreate + "\\words.bin";
    }

    public boolean isFileEmpty(){
        return wordsFile.length() == 0;
    }
}
