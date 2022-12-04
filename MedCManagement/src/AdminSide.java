import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class AdminSide implements Runnable {
    //Password is i@mAdmin.

    @Override
    public void run() {
        try {
            AdminSide.Authentication();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Authentication() throws IOException {
        HashSet<Appoint> init = new HashSet<>();
        AppointmentRecord objar = new AppointmentRecord(init);
        HashSet<Student> inits = new HashSet<>();
        StudentRecord objsr = new StudentRecord(inits);
        HashSet<Notice> initn = new HashSet<>();
        HashSet<LocalDate> inith = new HashSet<>();
        NoticeBoard objnb = new NoticeBoard(initn, inith);
        HashSet<Medicine> objm = new HashSet<>();
        MedicineRecord objmr = new MedicineRecord(objm);
        HashSet<Order> objOrd = new HashSet<>();
        MedicalStoreOwner objMSO = new MedicalStoreOwner(objOrd);
        NoticeBoard.loadHoliday();
        NoticeBoard.loadNotice();
        JFrame f = new JFrame("Admin Login Portal");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JPasswordField value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 75, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 120, 80, 30);
        final JTextField text = new JTextField();
        text.setBounds(100, 20, 100, 30);
        f.add(value);
        f.add(l1);
        f.add(l2);
        f.add(b);
        f.add(text);
        f.add(label);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(value.getPassword());
                if (password.equals("i@mAdmin")) {
                    label.setText("Login successful");
                    AdminSide.RadioButtonChoices();
                } else label.setText("Incorrect login credentials");
            }
        });
    }

    public static void RadioButtonChoices() {
        JRadioButton rb1, rb2, rb3;
        JButton b;
        JFrame f = new JFrame("Admin Portal");
        rb1 = new JRadioButton("See appointments for a particular date.");
        rb1.setBounds(100, 50, 500, 80);
        rb2 = new JRadioButton("Add notice to notice board");
        rb2.setBounds(100, 100, 500, 80);
        rb3 = new JRadioButton("View Medical Store Owner's Order List.");
        rb3.setBounds(100, 150, 500, 80);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        b = new JButton("Ok");
        b.setBounds(100, 300, 100, 40);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (rb1.isSelected()) {
//                    AdminSide.enterDataAV();
                    JFrame f = new JFrame("Admin Portal");
                    JLabel label13 = new JLabel("Select date(enter numeric values)");
                    label13.setBounds(100, 10, 500, 50);
                    JTextField tf = new JTextField("1");
                    tf.setBounds(100, 50, 150, 80);
                    JLabel label14 = new JLabel("Enter day of month");
                    label14.setBounds(100, 150, 500, 50);
                    JTextField tf1 = new JTextField("1");
                    tf1.setBounds(100, 250, 150, 80);
                    JLabel label15 = new JLabel("Enter month");
                    label15.setBounds(100, 350, 500, 50);
                    JTextField tf2 = new JTextField("1");
                    tf2.setBounds(100, 450, 150, 80);
                    JLabel label16 = new JLabel("Enter year");
                    label16.setBounds(100, 550, 500, 50);
//                    int day = Integer.parseInt(tf.getText());
//                    int month = Integer.parseInt(tf1.getText());
//                    int year = Integer.parseInt(tf2.getText());
//                    LocalDate date = LocalDate.of(year, month, day);
                    JButton b = new JButton("Ok");
                    b.setBounds(100, 650, 150, 50);
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            int day = Integer.parseInt(tf.getText());
                            int month = Integer.parseInt(tf1.getText());
                            int year = Integer.parseInt(tf2.getText());
                            LocalDate date = LocalDate.of(year, month, day);
                            try {
                                AppointmentRecord.unload();
                                ArrayList<Appoint> appointSet = AppointmentRecord.viewAppoint(date);
                                for (Appoint appoint : appointSet) {
                                    System.out.println(appoint);
                                }
                                if (appointSet.isEmpty()) System.out.println("No appointment for this date.");
                                AppointmentRecord.load();
                            } catch (Exception e) {
                                System.out.println("No appointment for this date.");
                            }

                        }
                    });
                    f.add(label13);
                    f.add(tf);
                    f.add(label14);
                    f.add(tf1);
                    f.add(label15);
                    f.add(tf2);
                    f.add(label16);
                    f.add(b);
                    f.setSize(500, 500);
                    f.setLayout(null);
                    f.setVisible(true);
                }
                if (rb2.isSelected()) {
                    Doctor burnwal = new Doctor(1, "Burnwal");
                    Doctor rajesh = new Doctor(2, "Rajesh");
                    Doctor bhatia = new Doctor(3, "Bhatia");
                    Doctor km = new Doctor(4, "Krishnamurthy");
                    JRadioButton rb1, rb2, rb3, rb4;
                    JButton b;
                    JFrame f8 = new JFrame("Update notice. ");
                    JLabel label11 = new JLabel("Select a doctor");
                    label11.setBounds(10, 10, 500, 50);
                    rb1 = new JRadioButton("1)Dr.Burnwal");
                    rb1.setBounds(10, 50, 250, 80);
                    rb2 = new JRadioButton("2)Dr.Rajesh");
                    rb2.setBounds(10, 100, 250, 80);
                    rb3 = new JRadioButton("3)Dr.Bhatia");
                    rb3.setBounds(10, 150, 250, 80);
                    rb4 = new JRadioButton("4)Dr.Krishanmurthy");
                    rb4.setBounds(10, 200, 250, 80);
                    ButtonGroup bg = new ButtonGroup();
                    bg.add(rb1);
                    bg.add(rb2);
                    bg.add(rb3);
                    bg.add(rb4);
                    JTextField tf = new JTextField("Enter consult type");
                    tf.setBounds(10, 400, 100, 50);
                    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, rbh1, rbh2, rbh3, rbh4, rbh5, rbh6, rbh7, rbh8;
                    cb1 = new JCheckBox("Monday");
                    cb1.setBounds(400, 50, 250, 80);
                    cb2 = new JCheckBox("Tuesday");
                    cb2.setBounds(400, 100, 250, 80);
                    cb3 = new JCheckBox("Wednesday");
                    cb3.setBounds(400, 150, 250, 80);
                    cb4 = new JCheckBox("Thursday");
                    cb4.setBounds(400, 200, 250, 80);
                    cb5 = new JCheckBox("Friday");
                    cb5.setBounds(400, 250, 250, 80);
                    cb6 = new JCheckBox("Saturday");
                    cb6.setBounds(400, 300, 250, 80);
                    cb7 = new JCheckBox("Sunday");
                    cb7.setBounds(400, 350, 250, 80);
                    rbh1 = new JCheckBox("9am slot");
                    rbh1.setBounds(700, 50, 250, 80);
                    rbh2 = new JCheckBox("10am slot");
                    rbh2.setBounds(700, 100, 250, 80);
                    rbh3 = new JCheckBox("11am slot");
                    rbh3.setBounds(700, 150, 250, 80);
                    rbh4 = new JCheckBox("12 noon slot");
                    rbh4.setBounds(700, 200, 250, 80);
                    rbh5 = new JCheckBox("2pm slot");
                    rbh5.setBounds(700, 250, 250, 80);
                    rbh6 = new JCheckBox("3pm slot");
                    rbh6.setBounds(700, 300, 250, 80);
                    rbh7 = new JCheckBox("4pm slot");
                    rbh7.setBounds(700, 350, 250, 80);
                    rbh8 = new JCheckBox("5pm slot");
                    rbh8.setBounds(700, 400, 250, 80);
                    JLabel label13 = new JLabel("Enter holiday(enter numeric values)");
                    label13.setBounds(1000, 10, 500, 50);
                    JTextField tf3 = new JTextField("1");
                    tf3.setBounds(1000, 50, 150, 80);
                    JLabel label14 = new JLabel("Enter day of month");
                    label14.setBounds(1000, 150, 500, 50);
                    JTextField tf1 = new JTextField("1");
                    tf1.setBounds(1000, 250, 150, 80);
                    JLabel label15 = new JLabel("Enter month");
                    label15.setBounds(1000, 350, 500, 50);
                    JTextField tf2 = new JTextField("1");
                    tf2.setBounds(1000, 450, 150, 80);
                    JLabel label16 = new JLabel("Enter year");
                    label16.setBounds(1000, 550, 500, 50);
//                    int day = Integer.parseInt(tf3.getText());
//                    int month = Integer.parseInt(tf1.getText());
//                    int year = Integer.parseInt(tf2.getText());
//                    LocalDate date = LocalDate.of(year, month, day);
                    b = new JButton("Ok");
                    b.setBounds(100, 500, 100, 40);
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
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            int day = Integer.parseInt(tf3.getText());
                            int month = Integer.parseInt(tf1.getText());
                            int year = Integer.parseInt(tf2.getText());
                            LocalDate date = LocalDate.of(year, month, day);
                            ArrayList<Time> timeArrayList = new ArrayList<>();
                            ArrayList<Day> dayArrayList = new ArrayList<>();
                            String ct = tf.getText();
                            if (cb1.isSelected()) {
                                dayArrayList.add(Day.MONDAY);
                            }
                            if (cb2.isSelected()) {
                                dayArrayList.add(Day.TUESDAY);
                            }
                            if (cb3.isSelected()) {
                                dayArrayList.add(Day.WEDNESDAY);
                            }
                            if (cb4.isSelected()) {
                                dayArrayList.add(Day.THURSDAY);
                            }
                            if (cb5.isSelected()) {
                                dayArrayList.add(Day.FRIDAY);
                            }
                            if (cb6.isSelected()) {
                                dayArrayList.add(Day.SATURDAY);
                            }
                            if (cb7.isSelected()) {
                                dayArrayList.add(Day.SUNDAY);
                            }
                            if (rbh1.isSelected()) {
                                timeArrayList.add(new Time(Hour.NINE));
                            }
                            if (rbh2.isSelected()) {
                                timeArrayList.add(new Time(Hour.TEN));
                            }
                            if (rbh3.isSelected()) {
                                timeArrayList.add(new Time(Hour.ELEVEN));
                            }
                            if (rbh4.isSelected()) {
                                timeArrayList.add(new Time(Hour.TWELVE));
                            }
                            if (rbh5.isSelected()) {
                                timeArrayList.add(new Time(Hour.TWO));
                            }
                            if (rbh6.isSelected()) {
                                timeArrayList.add(new Time(Hour.THREE));
                            }
                            if (rbh7.isSelected()) {
                                timeArrayList.add(new Time(Hour.FOUR));
                            }
                            if (rbh8.isSelected()) {
                                timeArrayList.add(new Time(Hour.FIVE));
                            }
                            if (rb1.isSelected()) {
                                Notice notice = new Notice(burnwal, ct, dayArrayList, timeArrayList);
                                NoticeBoard.update(notice, date);
                                try {
                                    NoticeBoard.loadNotice();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    NoticeBoard.loadHoliday();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (rb2.isSelected()) {
                                Notice notice = new Notice(rajesh, ct, dayArrayList, timeArrayList);
                                NoticeBoard.update(notice, date);
                                try {
                                    NoticeBoard.loadNotice();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    NoticeBoard.loadHoliday();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (rb3.isSelected()) {
                                Notice notice = new Notice(bhatia, ct, dayArrayList, timeArrayList);
                                NoticeBoard.update(notice, date);
                                try {
                                    NoticeBoard.loadNotice();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    NoticeBoard.loadHoliday();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (rb4.isSelected()) {
                                Notice notice = new Notice(km, ct, dayArrayList, timeArrayList);
                                NoticeBoard.update(notice, date);
                                try {
                                    NoticeBoard.loadNotice();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    NoticeBoard.loadHoliday();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    });
                    f8.add(rb1);
                    f8.add(rb2);
                    f8.add(rb3);
                    f8.add(rb4);
                    f8.add(b);
                    f8.add(rbh1);
                    f8.add(rbh2);
                    f8.add(rbh3);
                    f8.add(rbh4);
                    f8.add(rbh5);
                    f8.add(rbh6);
                    f8.add(rbh7);
                    f8.add(rbh8);
                    f8.add(cb1);
                    f8.add(cb2);
                    f8.add(cb3);
                    f8.add(cb4);
                    f8.add(cb5);
                    f8.add(cb6);
                    f8.add(cb7);
                    f8.add(tf);
                    f8.add(tf1);
                    f8.add(tf2);
                    f8.add(tf3);
                    f8.add(label13);
                    f8.add(label11);
                    f8.add(label14);
                    f8.add(label15);
                    f8.add(label16);
                    f8.setSize(500, 500);
                    f8.setLayout(null);
                    f8.setVisible(true);
                }
                if (rb3.isSelected()) {
                    try {
                        MedicalStoreOwner.unload();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(MedicalStoreOwner.getOrderList());
                }
            }
        });
        f.add(rb1);
        f.add(rb2);
        f.add(b);
        f.add(rb3);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}