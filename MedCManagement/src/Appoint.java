import java.io.Serializable;
import java.time.*;
import java.util.*;
public class Appoint implements Serializable {
    private static final long serialVersionUID=898470106220380823L;//This solves the InvalidClassException
    //This Id is compiler specific and may have to be changed so as to suit other compilers.
    private  final Student student;
    private  final Doctor doc;
    private  final Time time;
    private final LocalDate date;
    public Appoint(Student student,Doctor doc, Time time,LocalDate date){
        this.student=student;
        this.doc=doc;
        this.time=time;
        this.date=date;
    }
    public Student getStudent() {
        return student;
    }

    public Doctor getDoc() {
        return doc;
    }

    public LocalDate getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appoint appoint = (Appoint) o;
        return Objects.equals(getDoc(), appoint.getDoc()) && Objects.equals(getTime(), appoint.getTime()) && Objects.equals(getDate(), appoint.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoc(), getTime(), getDate());
    }

    @Override
    public String toString() {
        return "Appoint{" +
                "student=" + student +
                ", doc=" + doc +
                ", time=" + time +
                ", date=" + date +
                '}';
    }
}

