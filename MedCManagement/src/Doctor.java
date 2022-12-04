import java.io.Serializable;
import java.util.*;
public class Doctor implements Serializable {
    private int docID;
    private String docName;
    public Doctor(int docID, String docName){
        this.docID=docID;
        this.docName=docName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Doctor ID=" + docID +
                ", Doctor Name='" + docName + '\'' +
                '}';
    }
}
