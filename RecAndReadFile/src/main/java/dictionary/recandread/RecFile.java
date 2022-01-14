package dictionary.recandread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class RecFile {
    private String pathRec;
    public RecFile(String pathRec){
        this.pathRec = pathRec;
    }

    public void recDictionary(HashMap<String, String> dict){
        try(FileOutputStream fos = new FileOutputStream(pathRec)){
            try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
                obj.writeObject(dict);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
