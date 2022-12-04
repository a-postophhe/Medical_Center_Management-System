import javax.swing.*;
import java.io.*;
import java.util.*;
import java.time.*;
public class NoticeBoard {
    private static HashSet<Notice> noticeBoard;
    private static HashSet<LocalDate> holidays;

    public static HashSet<LocalDate> getHolidays() {
        return holidays;
    }

    public static HashSet<Notice> getNoticeBoard() {
        return noticeBoard;
    }

    public NoticeBoard(HashSet<Notice>noticeBoard, HashSet<LocalDate>holidays){
        NoticeBoard.noticeBoard=noticeBoard;
        NoticeBoard.holidays=holidays;
    }
    public static void loadNotice() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("notices.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(noticeBoard);
        objectOutputStream.close();
    }
    public static void unloadNotice() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("notices.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        noticeBoard=(HashSet<Notice>)objectInputStream.readObject();
        objectInputStream.close();
    }
    public static void loadHoliday() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("holidays.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(holidays);
        objectOutputStream.close();
    }
    public static void unloadHoliday() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("holidays.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        holidays=(HashSet<LocalDate>) objectInputStream.readObject();
        objectInputStream.close();
    }
    public HashSet<LocalDate> displayHolidays(){
        return NoticeBoard.holidays;
    }
    public Doctor displayDoc(Notice notice){
        if(noticeBoard.contains(notice)) return notice.getDoc();
        else return null;
    }
    public ArrayList<Time> displayTime(Notice notice){
        if(noticeBoard.contains(notice)) return notice.getTimeAvail();
        else return null;
    }
    public String displayConsult(Notice notice){
        if(noticeBoard.contains(notice)) return notice.getConsultType();
        else return null;
    }
    public ArrayList<Day> displayDay(Notice notice){
        if(noticeBoard.contains(notice)) return notice.getDaysAvail();
        else return null;
    }
    public static void update(Notice notice,LocalDate holiday){
        noticeBoard.add(notice);
        holidays.add(holiday);
        System.out.println("Successful!!");
        JFrame f8=new JFrame("Notice Board Update");
        JLabel label11=new JLabel("Update successful.");
        label11.setBounds(10,10,500,50);
        f8.add(label11);
        f8.setSize(300,300);
        f8.setLayout(null);
        f8.setVisible(true);
    }
    public static void update(Notice notice){
        noticeBoard.add(notice);
//        holidays.add(holiday);
    }
    @Override
    public String toString() {
        return "NoticeBoard{" +
                "Notices=" + noticeBoard +
                ", Holidays=" + holidays +
                '}';
    }
}
