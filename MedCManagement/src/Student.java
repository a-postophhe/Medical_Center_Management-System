import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Student implements Serializable {
    private static final long serialVersionUID= 4336800820181227849L;
    private final String name;
    private final String bitsID;
    private final String bitsEmail;
    private final String mobileNo;
    private  int payLaterBalance;
    public Student(String name,String bitsID,String bitsEmail,String mobileNo,int payLaterBalance){
        this.name=name;
        this.bitsID=bitsID;
        this.bitsEmail=bitsEmail;
        this.mobileNo=mobileNo;
        this.payLaterBalance=payLaterBalance;
    }
    public  void reduceBalance(int amt){
        this.payLaterBalance-=amt;
    }
    public  int getPayLaterBalance(){
        return payLaterBalance;
    }
    public  void viewBalance(){
        System.out.println("Your current pay later balance is: "+payLaterBalance);
    }
    public  void viewNotice(){
        try {
            NoticeBoard.unloadNotice();
            NoticeBoard.unloadHoliday();
        }catch(Exception e){
            System.out.println("No notices to display.");
        }
        System.out.println("Notices:");
        System.out.println(NoticeBoard.getNoticeBoard());
        System.out.println("Holidays:");
        System.out.println(NoticeBoard.getHolidays());
    }
    public  void placeBooking(Doctor doc, Time time, LocalDate date){
        if(Admin.confirmBooking(this,doc,time, date )==null)throw new AppointNotPossibleException("Appointment is not possible");
        else{
            AppointmentRecord.addAppoints(Admin.confirmBooking(this,doc,time,date));
//            System.out.println("Booking for "+this+"placed at "+Admin.confirmBooking(this,doc,time,date)+" is successful.");
            System.out.println("Booking for "+this+"is successful.");
            JFrame f8=new JFrame("Appointment Booking");
            JLabel label11=new JLabel("Booking confirmed.");
            label11.setBounds(10,10,500,50);
            f8.add(label11);
            f8.setSize(300,300);
            f8.setLayout(null);
            f8.setVisible(true);
        }
    }
    public  void updateBooking(Time time, LocalDate date) {
        //student not registered
        if(AppointmentRecord.checkStudent(this) == null) {
            try {
                throw new AppointNotPossibleException("Student not registered.");
            }
            catch(AppointNotPossibleException a){
                System.out.println("Enter 1 to place a booking.2 to view student details.");
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("Enter the doctor name: ");
                        String name=sc.nextLine();
                        System.out.println("Enter the doctor ID: ");
                        int id=sc.nextInt();
                        Doctor doc=new Doctor(id,name); // input
                        this.placeBooking(doc, time, date);
                        break;

                    case 2:
                    System.out.println("Student with the following details "+this+"does not have an appointment.");



                    default:
                        System.out.println("Invalid input");
                }
            }
        }
        else{
            Appoint a = AppointmentRecord.checkStudent(this);

            //time not available
            if(Admin.confirmBooking(this,a.getDoc(),time, date )==null)throw new AppointNotPossibleException("Time not available");
            else{
                AppointmentRecord.addAppoints(Admin.confirmBooking(this,a.getDoc(),time,date));
                System.out.println("Update for "+this+"placed at "+Admin.confirmBooking(this,a.getDoc(),time,date)+" is successful.");

            }
        }
    }
    public  void placeMedOrder(Medicine medicine,boolean payLater,Student student) throws IOException {
        if(Admin.requestMed(medicine,this,payLater)==null)throw new MedicineUnavailableException();
        else{
            Admin.requestMed(medicine,this,payLater);
            Order obj=new Order(medicine,this,payLater);
            MedicalStoreOwner.addOrder(obj);
            MedicalStoreOwner.load();
            System.out.println("Order for "+ medicine+"placed successfully.");
            JFrame f8=new JFrame("Medicine Purchase");
            JLabel label11=new JLabel("Purchase successful.");
            label11.setBounds(10,10,500,50);
            f8.add(label11);
            f8.setSize(300,300);
            f8.setLayout(null);
            f8.setVisible(true);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(mobileNo,student.mobileNo) && Objects.equals(name, student.name) && Objects.equals(bitsID, student.bitsID) && Objects.equals(bitsEmail, student.bitsEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bitsID, bitsEmail, mobileNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", bitsID='" + bitsID + '\'' +
                ", bitsEmail='" + bitsEmail + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
