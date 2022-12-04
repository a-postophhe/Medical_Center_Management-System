import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        HashSet<Appoint> init=new HashSet<>();
        AppointmentRecord objar=new AppointmentRecord(init);
        HashSet<Student> inits=new HashSet<>();
        StudentRecord objsr=new StudentRecord(inits);
        HashSet<Notice> initn=new HashSet<>();
        HashSet<LocalDate> inith=new HashSet<>();
        NoticeBoard objnb=new NoticeBoard(initn,inith);
        Scanner sc =new Scanner(System.in);
        JFrame f= new JFrame("MEDC Management System");
        JLabel label=new JLabel("Enter 1)Student mode 2)Admin mode");
        label.setBounds(10,15,500,50);
        f.add(label);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        int n=sc.nextInt();
        sc.nextLine();
        switch(n){
            case 1:
                StudentSide studentSide=new StudentSide();
                Thread thread=new Thread(studentSide);
                thread.start();
                thread.join();
                break;
            case 2:
                AdminSide adminSide=new AdminSide();
                Thread thread1=new Thread(adminSide);
                thread1.start();
                thread1.join();
                break;
            default:
//                System.out.println("Invalid choice.");
                JFrame f1= new JFrame("MEDC Management System");
                JLabel label1=new JLabel("Invalid choice!!");
                label1.setBounds(10,15,500,50);
                f1.add(label1);
                f1.setSize(300,300);
                f1.setLayout(null);
                f1.setVisible(true);

        }

    }
}