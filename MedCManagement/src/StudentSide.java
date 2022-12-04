import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
public class StudentSide implements Runnable {
    @Override
    public void run() {
        HashSet<Appoint> init=new HashSet<>();
        AppointmentRecord objar=new AppointmentRecord(init);
        HashSet<Student> inits=new HashSet<>();
        StudentRecord objsr=new StudentRecord(inits);
        HashSet<Notice> initn=new HashSet<>();
        HashSet<LocalDate> inith=new HashSet<>();
        NoticeBoard objnb=new NoticeBoard(initn,inith);
        HashSet<Medicine> objm=new HashSet<>();
        MedicineRecord objmr=new MedicineRecord(objm);
        HashSet<Order> objOrd=new HashSet<>();
        MedicalStoreOwner objMSO=new MedicalStoreOwner(objOrd);
        Scanner sc=new Scanner(System.in);
//        System.out.println("Welcome to the Student portal");
//        System.out.println("Press 1 for student registration");
//        System.out.println("Press 2 for student login");
        JFrame f= new JFrame("Student portal");
        JLabel label=new JLabel("Enter 1)Student registration 2)Student login");
        label.setBounds(10,15,500,50);
        f.add(label);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        int n1=sc.nextInt();
        sc.nextLine();
        switch(n1){
            case 1:
//                System.out.println("Enter student name");
                JFrame f1= new JFrame("Student Registration");
                JLabel label1=new JLabel("Enter Student name");
                label1.setBounds(10,15,500,50);
                f1.add(label1);
                f1.setSize(300,300);
                f1.setLayout(null);
                f1.setVisible(true);
                String name=sc.nextLine();
//                System.out.println("Enter BITS ID");
                JFrame f2= new JFrame("Student Registration");
                JLabel label2=new JLabel("Enter BITS ID.");
                label2.setBounds(10,15,500,50);
                f2.add(label2);
                f2.setSize(300,300);
                f2.setLayout(null);
                f2.setVisible(true);
                String bitsId=sc.nextLine();
//                System.out.println("Enter BITS Email");
                JFrame f3= new JFrame("Student Registration");
                JLabel label3=new JLabel("Enter BITS Email.");
                label3.setBounds(10,15,500,50);
                f3.add(label3);
                f3.setSize(300,300);
                f3.setLayout(null);
                f3.setVisible(true);
                String bitsEmail=sc.nextLine();
                if(!bitsEmail.endsWith("@pilani.bits-pilani.ac.in")){
//                    System.out.println("Invalid email Id.Kindly enter BITS Email ID only");
                    JFrame f4= new JFrame("Student Registration");
                    JLabel label4=new JLabel("Invalid email Id.Kindly enter BITS Email ID only");
                    label4.setBounds(10,15,500,50);
                    f4.add(label4);
                    f4.setSize(300,300);
                    f4.setLayout(null);
                    f4.setVisible(true);
                    break;
                }
//                System.out.println("Enter mobile number");
                JFrame f5= new JFrame("Student Registration");
                JLabel label5=new JLabel("Enter mobile number");
                label5.setBounds(10,15,500,50);
                f5.add(label5);
                f5.setSize(300,300);
                f5.setLayout(null);
                f5.setVisible(true);
                String mobNo=sc.nextLine();
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                if((mobNo==null)||! pattern.matcher(mobNo).matches()){
//                    System.out.println("Invalid mobile number.");
                    JFrame f6= new JFrame("Student Registration");
                    JLabel label6=new JLabel("Invalid mobile number.");
                    label6.setBounds(10,15,500,50);
                    f6.add(label6);
                    f6.setSize(300,300);
                    f6.setLayout(null);
                    f6.setVisible(true);
                    break;
                }
                Student student =new Student(name,bitsId,bitsEmail,mobNo,10000);
                try {
                    StudentRecord.unload();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                StudentRecord.studentBooking(student);
                try {
                    StudentRecord.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JFrame f7= new JFrame("Student Registration");
                JLabel label7=new JLabel("Your pay later balance has been initialized with 10,000 INR");
                label7.setBounds(10,15,500,50);
                JLabel label8=new JLabel("Your account will continually be updated to maintain this amt whenever it becomes too low");
                label8.setBounds(10,35,700,50);
                JLabel label9=new JLabel("This money will be deducted from your SWD account.");
                label9.setBounds(10,55,500,50);
                JLabel label10=new JLabel("Registration successful.");
                label10.setBounds(10,75,500,50);
                f7.add(label7);f7.add(label8);f7.add(label9);f7.add(label10);
                f7.setSize(300,300);
                f7.setLayout(null);
                f7.setVisible(true);
                break;
            case 2:
                System.out.println("Enter student name");
                String name1=sc.nextLine();
                System.out.println("Enter BITS ID");
                String bitsId1=sc.nextLine();
                System.out.println("Enter BITS Email");
                String bitsEmail1=sc.nextLine();
                if(!bitsEmail1.endsWith("@pilani.bits-pilani.ac.in")){
                    System.out.println("Invalid email Id.Kindly enter BITS Email ID only");
                    break;
                }
                System.out.println("Enter mobile number");
                String mobNo1=sc.nextLine();
                Pattern pattern1 = Pattern.compile("-?\\d+(\\.\\d+)?");
                if((mobNo1==null)||! pattern1.matcher(mobNo1).matches()){
                    System.out.println("Invalid mobile number.");
                    break;
                }
                Student obj=new Student(name1,bitsId1,bitsEmail1,mobNo1,10000);
                try {
                    StudentRecord.unload();
                } catch (IOException e) {
                    System.out.println("Kindly enter a valid input");
                } catch (ClassNotFoundException e) {
                    System.out.println("Please enter a valid input");
                }
                if(!StudentRecord.verifyStudent(obj)){
                    System.out.println("Student with the entered details does not exist,");
                    break;
                }
                System.out.println("Choose an action to perform");
                System.out.println("1)View Notice Board");
                System.out.println("2)Book appointment with a Doctor");
                System.out.println("3)Purchase medicines.");
                int k= sc.nextInt();
                sc.nextLine();
                switch(k){
                    case 1:
                        try {
                            NoticeBoard.unloadNotice();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            NoticeBoard.unloadHoliday();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        obj.viewNotice();
                        break;
                    case 2:
                        Doctor burnwal=new Doctor(1,"Burnwal");
                        Doctor rajesh=new Doctor(2,"Rajesh");
                        Doctor bhatia=new Doctor(3,"Bhatia");
                        Doctor km=new Doctor(4,"Krishnamurthy");
                        JRadioButton rb1,rb2,rb3,rb4,rbh1,rbh2,rbh3,rbh4,rbh5,rbh6,rbh7,rbh8;
                        JButton b;
                        JFrame f8=new JFrame("Book Appointment");
                        JLabel label11=new JLabel("Select a doctor");
                        label11.setBounds(10,10,500,50);
                        rb1=new JRadioButton("1)Dr.Burnwal");
                        rb1.setBounds(10,50,250,80);
                        rb2=new JRadioButton("2)Dr.Rajesh");
                        rb2.setBounds(10,100,250,80);
                        rb3=new JRadioButton("3)Dr.Bhatia");
                        rb3.setBounds(10,150,250,80);
                        rb4=new JRadioButton("4)Dr.Krishanmurthy");
                        rb4.setBounds(10,200,250,80);
                        ButtonGroup bg=new ButtonGroup();
                        bg.add(rb1);bg.add(rb2);bg.add(rb3);bg.add(rb4);
                        JLabel label12=new JLabel("Select Hourly booking slot");
                        label12.setBounds(300,10,500,50);
                        rbh1=new JRadioButton("9am slot");
                        rbh1.setBounds(300,50,250,80);
                        rbh2=new JRadioButton("10am slot");
                        rbh2.setBounds(300,100,250,80);
                        rbh3=new JRadioButton("11am slot");
                        rbh3.setBounds(300,150,250,80);
                        rbh4=new JRadioButton("12 noon slot");
                        rbh4.setBounds(300,200,250,80);
                        rbh5=new JRadioButton("2pm slot");
                        rbh5.setBounds(300,250,250,80);
                        rbh6=new JRadioButton("3pm slot");
                        rbh6.setBounds(300,300,250,80);
                        rbh7=new JRadioButton("4pm slot");
                        rbh7.setBounds(300,350,250,80);
                        rbh8=new JRadioButton("5pm slot");
                        rbh8.setBounds(300,400,250,80);
                        JLabel label13=new JLabel("Select date(enter numeric values)");
                        label13.setBounds(900,10,500,50);
                        JTextField tf=new JTextField("1");
                        tf.setBounds(900,50,150,80);
                        JLabel label14=new JLabel("Enter day of month");
                        label14.setBounds(700,50,500,50);
                        JTextField tf1=new JTextField("1");
                        tf1.setBounds(900,150,150,80);
                        JLabel label15=new JLabel("Enter month");
                        label15.setBounds(700,150,500,50);
                        JTextField tf2=new JTextField("1");
                        tf2.setBounds(900,250,150,80);
                        JLabel label16=new JLabel("Enter year");
                        label16.setBounds(700,250,500,50);
//                        int day = Integer.parseInt(tf.getText());
//                        int month = Integer.parseInt(tf1.getText());
//                        int year = Integer.parseInt(tf2.getText());
//                        LocalDate date = LocalDate.of(year, month, day);
                        ButtonGroup bg1=new ButtonGroup();
                        bg1.add(rbh1);bg1.add(rbh2);bg1.add(rbh3);bg1.add(rbh4);bg1.add(rbh5);bg1.add(rbh6);
                        bg1.add(rbh7);bg1.add(rbh8);
                        b=new JButton("Ok");
                        b.setBounds(100,500,100,40);
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                int day = Integer.parseInt(tf.getText());
                                int month = Integer.parseInt(tf1.getText());
                                int year = Integer.parseInt(tf2.getText());
                                LocalDate date = LocalDate.of(year, month, day);
                                if(rb1.isSelected()&&rbh1.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.NINE),date);
                                }
                                if(rb1.isSelected()&&rbh2.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.TEN),date);
                                }
                                if(rb1.isSelected()&&rbh3.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.ELEVEN),date);
                                }
                                if(rb1.isSelected()&&rbh4.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.TWELVE),date);
                                }
                                if(rb1.isSelected()&&rbh5.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.TWO),date);
                                }
                                if(rb1.isSelected()&&rbh6.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.THREE),date);
                                }
                                if(rb1.isSelected()&&rbh7.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.FOUR),date);
                                }
                                if(rb1.isSelected()&&rbh8.isSelected()){
                                    obj.placeBooking(burnwal,new Time(Hour.FIVE),date);
                                }
                                if(rb2.isSelected()&&rbh1.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.NINE),date);
                                }
                                if(rb2.isSelected()&&rbh2.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.TEN),date);
                                }
                                if(rb2.isSelected()&&rbh3.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.ELEVEN),date);
                                }
                                if(rb2.isSelected()&&rbh4.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.TWELVE),date);
                                }
                                if(rb2.isSelected()&&rbh5.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.TWO),date);
                                }
                                if(rb2.isSelected()&&rbh6.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.THREE),date);
                                }
                                if(rb2.isSelected()&&rbh7.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.FOUR),date);
                                }
                                if(rb2.isSelected()&&rbh8.isSelected()){
                                    obj.placeBooking(rajesh,new Time(Hour.FIVE),date);
                                }
                                if(rb3.isSelected()&&rbh1.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.NINE),date);
                                }
                                if(rb3.isSelected()&&rbh2.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.TEN),date);
                                }
                                if(rb3.isSelected()&&rbh3.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.ELEVEN),date);
                                }
                                if(rb3.isSelected()&&rbh4.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.TWELVE),date);
                                }
                                if(rb3.isSelected()&&rbh5.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.TWO),date);
                                }
                                if(rb3.isSelected()&&rbh6.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.THREE),date);
                                }
                                if(rb3.isSelected()&&rbh7.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.FOUR),date);
                                }
                                if(rb3.isSelected()&&rbh8.isSelected()){
                                    obj.placeBooking(bhatia,new Time(Hour.FIVE),date);
                                }
                                if(rb4.isSelected()&&rbh1.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.NINE),date);
                                }
                                if(rb4.isSelected()&&rbh2.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.TEN),date);
                                }
                                if(rb4.isSelected()&&rbh3.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.ELEVEN),date);
                                }
                                if(rb4.isSelected()&&rbh4.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.TWELVE),date);
                                }
                                if(rb4.isSelected()&&rbh5.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.TWO),date);
                                }
                                if(rb4.isSelected()&&rbh6.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.THREE),date);
                                }
                                if(rb4.isSelected()&&rbh7.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.FOUR),date);
                                }
                                if(rb4.isSelected()&&rbh8.isSelected()){
                                    obj.placeBooking(km,new Time(Hour.FIVE),date);
                                }
                            }
                        });
                        f8.add(rb1);f8.add(rb2);f8.add(rb3);f8.add(rb4);f8.add(b);f8.add(label11);
                        f8.add(rbh1);f8.add(rbh2);f8.add(rbh3);f8.add(rbh4);f8.add(rbh5);f8.add(label12);
                        f8.add(rbh6);f8.add(rbh7);f8.add(rbh8);f8.add(label13);
                        f8.add(tf);f8.add(tf1);f8.add(tf2);
                        f8.add(label14);f8.add(label15);f8.add(label16);
                        f8.setSize(500,500);
                        f8.setLayout(null);
                        f8.setVisible(true);
                        break;
                    case 3:
                        Medicine ibuprofen=new Medicine(1,"Ibuprofen",50,1000);
                        Medicine dolo=new Medicine(2,"Dolo",30,1000);
                        Medicine grillinctus=new Medicine(3,"Grillinctus",40,1000);
                        Medicine tusq=new Medicine(4,"TusQ",35,1000);
                        Medicine amp=new Medicine(5,"Acetaminophen",60,1000);
                        Medicine hc=new Medicine(6,"Hydrocortisone",20,1000);
                        Medicine pd=new Medicine(7,"Pantop-D",25,1000);
                        MedicineRecord.addMeds(ibuprofen);
                        MedicineRecord.addMeds(dolo);
                        MedicineRecord.addMeds(grillinctus);
                        MedicineRecord.addMeds(tusq);
                        MedicineRecord.addMeds(amp);
                        MedicineRecord.addMeds(hc);
                        MedicineRecord.addMeds(pd);
//                        try {
//                            MedicineRecord.load();
//                        } catch (IOException e) {
//                            System.out.println("Order cannot be placed.");;
//                        }
                        JRadioButton rbm1,rbm2,rbm3,rbm4,rbm5,rbm6,rbm7,rb1p,rb2p;
                        JButton bm;
                        JFrame fm=new JFrame("Medicine Purchase Portal");
                        rb1p=new JRadioButton("Pay with Cash");
                        rb1p.setBounds(100,50,250,80);
                        rb2p=new JRadioButton("Pay Later.");
                        rb2p.setBounds(100,100,250,80);
                        ButtonGroup bgm=new ButtonGroup();
                        bgm.add(rb1p);bgm.add(rb2p);
                        rbm1=new JRadioButton("Ibuprofen");
                        rbm1.setBounds(300,50,250,80);
                        rbm2=new JRadioButton("Dolo");
                        rbm2.setBounds(300,100,250,80);
                        rbm3=new JRadioButton("Grillinctus");
                        rbm3.setBounds(300,150,250,80);
                        rbm4=new JRadioButton("TusQ");
                        rbm4.setBounds(300,200,250,80);
                        rbm5=new JRadioButton("Acetaminophen");
                        rbm5.setBounds(300,250,250,80);
                        rbm6=new JRadioButton("Hydrocortisone");
                        rbm6.setBounds(300,300,250,80);
                        rbm7=new JRadioButton("Pantop-D");
                        rbm7.setBounds(300,350,250,80);
                        ButtonGroup bgm1=new ButtonGroup();
                        bgm1.add(rbm1);bgm1.add(rbm2);bgm1.add(rbm3);bgm1.add(rbm4);
                        bgm1.add(rbm5);bgm1.add(rbm6);bgm1.add(rbm7);
                        b=new JButton("Ok");
                        b.setBounds(100,500,100,40);
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                try {
                                    if (rbm1.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(ibuprofen, false, obj);
                                    }
                                    if (rbm1.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(ibuprofen, true, obj);
                                    }
                                    if (rbm2.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(dolo, false, obj);
                                    }
                                    if (rbm2.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(dolo, true, obj);
                                    }
                                    if (rbm3.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(grillinctus, false, obj);
                                    }
                                    if (rbm3.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(grillinctus, true, obj);
                                    }
                                    if (rbm4.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(tusq, false, obj);
                                    }
                                    if (rbm4.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(tusq, true, obj);
                                    }
                                    if (rbm5.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(amp, false, obj);
                                    }
                                    if (rbm5.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(amp, true, obj);
                                    }
                                    if (rbm6.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(hc, false, obj);
                                    }
                                    if (rbm6.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(hc, true, obj);
                                    }
                                    if (rbm7.isSelected() && rb1p.isSelected()) {
                                        obj.placeMedOrder(pd, false, obj);
                                    }
                                    if (rbm7.isSelected() && rb2p.isSelected()) {
                                        obj.placeMedOrder(pd, true, obj);
                                    }
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                            }
                        });
                        fm.add(rbm1);fm.add(rbm2);fm.add(b);
                        fm.add(rbm3);fm.add(rbm4);fm.add(rbm5);fm.add(rbm6);fm.add(rbm7);
                        fm.add(rb1p);fm.add(rb2p);
                        fm.setSize(500,500);
                        fm.setLayout(null);
                        fm.setVisible(true);
                        break;
                    default:
//                        System.out.println("Invalid choice!!");
                        JFrame fdef=new JFrame("Invalid Choice");
                        JLabel labeldef=new JLabel("Invalid Choice.");
                        labeldef.setBounds(10,10,500,50);
                        fdef.add(labeldef);
                        fdef.setSize(300,300);
                        fdef.setLayout(null);
                        fdef.setVisible(true);
                        break;
                }


        }
    }
}
