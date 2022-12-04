import java.io.Serializable;
import java.lang.management.MonitorInfo;
import java.util.*;
public class Time implements Serializable {
    private Hour hour;
//    private Min min;
    public Time(Hour h){
        this.hour=h;
//        this.min=m;
    }
    public Hour getHour(){
        return hour;
    }
//    public Min getMin(){
//        return min;
//    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return getHour() == time.getHour();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHour());
    }
}
