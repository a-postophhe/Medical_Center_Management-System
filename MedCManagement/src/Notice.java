import java.io.Serializable;
import java.util.*;
public class Notice implements Serializable {
    private final Doctor doc;
    private final String consultType;
    private final ArrayList<Day> daysAvail;
    private final ArrayList<Time> timeAvail;
    public Notice(Doctor doc, String consultType,ArrayList<Day> daysAvail, ArrayList<Time> timeAvail){
        this.doc=doc;
        this.consultType=consultType;
        this.daysAvail=daysAvail;
        this.timeAvail=timeAvail;
    }
    public Doctor getDoc(){
        return this.doc;
    }
    public String getConsultType(){
        return this.consultType;
    }
    public ArrayList<Day> getDaysAvail(){
        return this.daysAvail;
    }
    public ArrayList<Time> getTimeAvail(){
        return this.timeAvail;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "doc=" + doc +
                ", consultType='" + consultType + '\'' +
                ", daysAvail=" + daysAvail +
                ", timeAvail=" + timeAvail +
                '}';
    }
}
