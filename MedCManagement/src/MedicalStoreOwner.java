import java.io.*;
import java.util.*;
public class MedicalStoreOwner {
    private static HashSet<Order> orderList;
    public MedicalStoreOwner(HashSet<Order> orderList){
        MedicalStoreOwner.orderList=orderList;
    }
    public static void addOrder(Order o){MedicalStoreOwner.orderList.add(o);}
    public static HashSet<Order> getOrderList(){return orderList;}
    public static void load() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("orderList.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(orderList);
        objectOutputStream.close();
    }
    public static void unload() throws IOException, ClassNotFoundException {
//        boolean check=true;
//        while (check) {
//            try{
                FileInputStream fileInputStream = new FileInputStream("orderList.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                orderList=(HashSet<Order>) objectInputStream.readObject();
                objectInputStream.close();
//            } catch(EOFException ex){
//                check=false;
//            }
//        }

    }
    public static Medicine getMeds(Medicine medicine){
        if(MedicalStoreOwner.checkAvail(medicine)){
            MedicineRecord.removeMeds(medicine);
            return medicine;
        }
        else return null;
    }
    private static boolean checkAvail(Medicine medicine){
        return MedicineRecord.checkMedRecs(medicine);
    }
    public static void processPayment(boolean payLater,Student student,Medicine medicine){
        if(payLater && MedicalStoreOwner.checkAvail(medicine)){
            if(student.getPayLaterBalance()>= medicine.getPrice()){
                student.reduceBalance(medicine.getPrice());
                MedicineRecord.removeMeds(medicine);
            }
            else if(student.getPayLaterBalance()<medicine.getPrice())throw new BalanceInsufficientException();
        }
        else if(payLater && !MedicalStoreOwner.checkAvail(medicine))throw new MedicineUnavailableException();
        else if(!payLater && MedicalStoreOwner.checkAvail(medicine))System.out.println("Pay in cash at the counter.");
        else if(!payLater && !MedicalStoreOwner.checkAvail(medicine))throw new MedicineUnavailableException();
    }
}
