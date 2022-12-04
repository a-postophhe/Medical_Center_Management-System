import java.time.LocalDate;
import java.util.*;
public class Admin {
    public static Appoint confirmBooking(Student student, Doctor doc, Time time, LocalDate date){
        Appoint uncheck= new Appoint(student,doc,time,date);
        if(AppointmentRecord.checkAppoint(uncheck)) return null;
        else return uncheck;
    }
    public  static Medicine requestMed(Medicine medicine,Student student, boolean payLater){
        MedicalStoreOwner.processPayment(payLater,student,medicine);
        return MedicalStoreOwner.getMeds(medicine);
    }
}
