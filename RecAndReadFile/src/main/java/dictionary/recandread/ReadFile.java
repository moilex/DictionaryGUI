package dictionary.recandread;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class ReadFile {
    private final String pathRead;
    private HashMap<String, String> dic;
    public ReadFile(String pathRead){
        this.pathRead = pathRead;
    }

    public HashMap<String, String> readDic(){
        try(FileInputStream fis = new FileInputStream(pathRead)){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                dic = (HashMap<String, String>) ois.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return dic;
    }
}
