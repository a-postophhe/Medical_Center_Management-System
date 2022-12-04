import java.util.*;
public class AppointNotPossibleException extends NullPointerException {
    String s;
    AppointNotPossibleException(String s){
        this.s=s;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
