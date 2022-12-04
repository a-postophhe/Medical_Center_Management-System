import java.io.*;
import java.util.*;
public class MedicineRecord {
    private static HashSet<Medicine> medRecs;
    public MedicineRecord(HashSet<Medicine> medRecs){
        MedicineRecord.medRecs=medRecs;
    }
    public static void load() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("medicineRecord.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(medRecs);
        objectOutputStream.close();
    }
    public static void unload() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("medicineRecord.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        medRecs=(HashSet<Medicine>)objectInputStream.readObject();
        objectInputStream.close();
    }
    public static HashSet<Medicine> getMedRecs() {
        return medRecs;
    }
    public static boolean checkMedRecs(Medicine medicine){
            return medRecs.contains(medicine);
    }
    public static void addMeds(Medicine medicine){
            MedicineRecord.medRecs.add(medicine);
    }
    public static void removeMeds(Medicine medicine){
            if (medicine.getDefaultQuant() == 0) MedicineRecord.medRecs.remove(medicine);
            else {
                medicine.reduceQuant();
            }
    }
}
