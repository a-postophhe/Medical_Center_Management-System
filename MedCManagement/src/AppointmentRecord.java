import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class AppointmentRecord implements Serializable {
    private  static HashSet<Appoint> appoints;
    public AppointmentRecord(HashSet<Appoint> appoints){
        AppointmentRecord.appoints=appoints;
    }
    public static void load() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("appointmentRecord.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(appoints);
        objectOutputStream.close();
    }
    public static void unload() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream("appointmentRecord.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            appoints=(HashSet<Appoint>)objectInputStream.readObject();
            objectInputStream.close();
    }
    public static void addAppoints(Appoint appoint)  {
        try{
        AppointmentRecord.unload();
        appoints.add(appoint);
        AppointmentRecord.load();
        }catch (Exception e){
            System.out.println("Appointment not possible.");
        }
    }
    public static void removeAppoints(Appoint appoint){
        appoints.remove(appoint);
    }
    public  static boolean checkAppoint(Appoint appoint){
        return appoints.contains(appoint);
    }
    public  static Student displayStudent(Appoint appoint){
        if(appoints.contains(appoint)) return appoint.getStudent();
        else return null;
    }
    public static ArrayList<Appoint>viewAppoint(LocalDate date){
        ArrayList<Appoint> ans= new ArrayList<>();
        for(Appoint appoint:appoints){
            if (appoint.getDate().equals(date))ans.add(appoint);
        }
        return ans;
    }
    public static Appoint checkStudent(Student stud) {
        for(Appoint a: appoints) {
            if(a.getStudent().equals(stud))
                return a;
        }
        return null;
    }


}
