import java.io.*;
import java.util.*;
public class StudentRecord {
    private static HashSet<Student> studentSet;
    public static void load() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("studentRecord.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentSet);
        objectOutputStream.close();
    }
    public static void unload() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("studentRecord.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        studentSet=(HashSet<Student>)objectInputStream.readObject();
        objectInputStream.close();
    }
     public StudentRecord(HashSet<Student> studentSet){
         StudentRecord.studentSet=studentSet;
     }
    public static void studentBooking(Student student){
        StudentRecord.studentSet.add(student);
    }
    public static boolean verifyStudent(Student student){
        return StudentRecord.studentSet.contains(student);
    }

}
