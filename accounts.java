
import college.connection.ConnectionProvider;
import java.sql.Connection;
import java.io.File;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JFileChooser;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author rohan
 */
public class accounts extends javax.swing.JFrame {

    String rock, filename, filename1;
    String[][] timetable = new String[6][7];
    int i, j;
    int counter = 1, counter1 = 1;

    public void tableDetaile() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser7.getDate());

        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select bi,amt from credit where dat='" + date + "' order by amt ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void tableDetaile1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser7.getDate());

        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select tu,amt from debit where dat='" + date + "' order by amt ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void tableDetailes() {

        DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select i.phone,i.name,p.dept from passmanager p,infom i where p.des='lecture' and p.status='alive' and p.un=i.un order by ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void createmonth(int m, int d, int y) {
        try {
            Connection con = ConnectionProvider.getcon();
            PreparedStatement ps = con.prepareStatement("create table a+'" + m + "'+'" + y + "'(date varchar(10),id varchar(11),attendence varchar(75))");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void rst() {
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
    }

    public void total(String date) {
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select sum(amt) from credit where dat='" + date + "'");
            while (rs.next()) {
                jTextField27.setText(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void total1(String date) {
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select sum(amt) from debit where dat='" + date + "'");
            while (rs.next()) {
                jTextField29.setText(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public accounts() {
        initComponents();
        jLabel45.setVisible(false);
        jLabel46.setVisible(false);
        jLabel47.setVisible(false);
        jLabel49.setVisible(false);
        jLabel51.setVisible(false);
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jTextField23.setVisible(false);
        jTextField24.setVisible(false);
        jTextField22.setVisible(false);
        jTextField25.setVisible(false);
        jComboBox13.setVisible(false);
        jComboBox15.setVisible(false);
        jLabel55.setVisible(false);
        jLabel56.setVisible(false);
    }

    public accounts(String name, String Id) {
        initComponents();
        jLabel2.setText(name);
        jLabel4.setText(Id);
        jLabel45.setVisible(false);
        jLabel46.setVisible(false);
        jLabel47.setVisible(false);
        jLabel49.setVisible(false);
        jLabel51.setVisible(false);
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jTextField23.setVisible(false);
        jTextField24.setVisible(false);
        jTextField22.setVisible(false);
        jTextField25.setVisible(false);
        jLabel56.setVisible(false);

    }

    public void checkid(String x, String month, String year, int count) {

        Connection con = ConnectionProvider.getcon();
        try {
            Statement st = con.createStatement();
            for (int c = 0; c < count; c++) {

                ResultSet rs = st.executeQuery("select id from lattendence where m='" + month + "' and y='" + year + "'");
               if (rs.next()) {
                    String a[] = new String[count + 1];
                    a[c] = rs.getString(1);
                    JOptionPane.showMessageDialog(null, a[0]);
                 }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jTextField18 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jTextField22 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jTextField23 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jButton15 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jComboBox22 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        jComboBox21 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel38.setText("Age");

        jLabel39.setText("Name");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transport", "Cleaning", "Managing", "Canteen", "Others" }));

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel40.setText("Phone");

        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel41.setText("Date");

        jLabel42.setText("Address");

        jLabel43.setText("Gender");

        jCheckBox3.setText("Male");

        jCheckBox4.setText("Female");

        jLabel44.setText("Department");

        jButton17.setText("jButton17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        jLabel1.setText("Welcome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, 80, -1));

        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 35, 85, -1));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, 80, -1));

        jLabel4.setText(" ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 63, 85, -1));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Science", "Commerce" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 59, 197, -1));

        jLabel7.setText("Stream");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 62, 57, -1));

        jLabel8.setText("Combination");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 90, 85, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));
        jPanel3.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 87, 197, -1));

        jLabel9.setText("Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 162, 83, -1));
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 159, 199, -1));

        jLabel10.setText("Age");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 190, 43, -1));
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 187, 199, -1));

        jLabel11.setText("Father Name");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 218, 83, -1));

        jLabel12.setText("Phone Number");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 246, 83, -1));

        jLabel13.setText("Address");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 274, 83, -1));

        jLabel14.setText("Previous Year %");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 302, -1, -1));

        jLabel15.setText("classroom");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 330, 83, -1));
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 215, 199, -1));
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 243, 199, -1));
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 271, 199, -1));
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 299, 199, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Class A", "class B", "class C" }));
        jPanel3.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 327, 199, -1));

        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 361, -1, -1));

        jButton2.setText("Click to get addmission number");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 390, 199, -1));

        jLabel17.setText("Grade");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 118, 43, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I PUC", "II PUC" }));
        jPanel3.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 115, 197, -1));

        jLabel29.setText("Date");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 37, 43, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 31, 197, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 500));

        jTabbedPane1.addTab("+Students", jPanel3);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Stream");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 29, 43, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Science", "Commerce" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 26, 197, -1));

        jLabel18.setText("Combination");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 57, 85, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-" }));
        jPanel6.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 54, 197, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I PUC", "II PUC" }));
        jPanel6.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 145, 197, -1));

        jLabel19.setText("Grade");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 148, 43, -1));

        jLabel20.setText("Name");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 176, 83, -1));
        jPanel6.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 173, 199, -1));
        jPanel6.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 201, 199, -1));

        jLabel21.setText("Age");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 204, 43, -1));

        jLabel22.setText("Father Name");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 232, 83, -1));
        jPanel6.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 229, 199, -1));
        jPanel6.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 257, 199, -1));

        jLabel23.setText("Phone Number");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 260, 83, -1));

        jLabel24.setText("Address");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 288, 83, -1));
        jPanel6.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 285, 199, -1));
        jPanel6.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 313, 199, -1));

        jLabel25.setText("Previous Year %");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 316, -1, -1));

        jLabel26.setText("classroom");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 344, 83, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Class A", "class B", "class C" }));
        jPanel6.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 341, 199, -1));

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 400, -1, -1));

        jLabel27.setText("Admn.no");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 85, 65, -1));
        jPanel6.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 82, 197, -1));

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 197, -1));

        jLabel28.setText("Status");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 372, 49, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Studiying", "Completed" }));
        jPanel6.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 369, 199, -1));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 500));

        jTabbedPane1.addTab("Update Students", jPanel6);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setText("Name");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 122, 43, -1));
        jPanel5.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 119, 281, -1));

        jLabel31.setText("Phone");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 150, 43, -1));
        jPanel5.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 147, 281, -1));

        jLabel32.setText("Address");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 178, 43, -1));
        jPanel5.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 175, 281, -1));
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 205, 43, -1));

        jLabel34.setText("Age");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 206, 43, -1));
        jPanel5.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 203, 281, -1));

        jLabel35.setText("Gender");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 233, 43, -1));

        jCheckBox1.setText("Male");
        jPanel5.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 231, 85, -1));

        jCheckBox2.setText("Female");
        jPanel5.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 231, 85, -1));

        jLabel36.setText("Department");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 260, -1, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transport", "Cleaning", "Managing", "Canteen", "Others" }));
        jPanel5.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 257, 281, -1));

        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 291, 95, -1));

        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 291, 99, -1));

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jPanel5.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 91, 281, -1));

        jLabel37.setText("Date");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 97, 43, -1));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 0, 9, 505));

        jLabel45.setText("Age");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 190, 43, -1));

        jLabel46.setText("Name");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 128, 43, -1));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transport", "Cleaning", "Managing", "Canteen", "Others" }));
        jPanel5.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 215, 281, -1));
        jPanel5.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 125, 281, -1));

        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 283, 95, -1));

        jLabel47.setText("Phone");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 93, 43, -1));

        jButton13.setText("Reset");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 283, 99, -1));
        jPanel5.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 90, 172, -1));

        jLabel49.setText("Address");
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 162, 43, -1));
        jPanel5.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 159, 281, -1));
        jPanel5.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 187, 281, -1));

        jLabel51.setText("Department");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 218, -1, -1));

        jButton14.setText("Search");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 90, -1, -1));

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel54.setText("Addmission");
        jPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 35, 238, 29));

        jButton16.setText("Press to Update");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 468, -1, -1));

        jLabel55.setText("Status");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 246, 43, -1));

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Working", "Left Job" }));
        jPanel5.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 243, 281, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel56.setText("Updation");
        jPanel5.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 34, 238, 38));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 500));

        jTabbedPane1.addTab("+workers", jPanel5);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setText("Date");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 38, 43, -1));

        jDateChooser5.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 32, 169, -1));

        jLabel50.setText("Credits");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 129, 67, -1));

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 126, 170, -1));

        jLabel52.setText("Source");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 157, 43, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Addmission", "Government", "Fine", "Other Fee" }));
        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 154, 170, -1));

        jButton15.setText("Add");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 239, -1, -1));

        jLabel53.setText("Total");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 272, 43, -1));
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 269, 170, -1));

        jLabel57.setText("Debits");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 129, 43, -1));
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 126, 150, -1));

        jLabel58.setText("To");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 157, 43, -1));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salary to Lectures", "Salary to Workers", "Food", "Accessories", "Others" }));
        jComboBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox16ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 154, 150, -1));

        jButton18.setText("Choose File");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 182, 170, -1));

        jButton19.setText("Choose File");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 182, 150, -1));

        jButton20.setText("Add");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 240, -1, -1));

        jLabel59.setText("Total");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 272, 43, -1));
        jPanel4.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 269, 150, -1));
        jPanel4.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 212, 167, -1));
        jPanel4.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 212, 150, -1));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 510));

        jTabbedPane1.addTab("Transactions", jPanel4);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setText("Department");
        jPanel7.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 20, 86, -1));

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Transport", "Cleaning", "Managing", "Canteen", "Others" }));
        jComboBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox22ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 17, 120, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Phone", "age", "Address", "Department"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 57, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel7.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 1050, 510));

        jTabbedPane2.addTab("View Workers", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setText("Date");
        jPanel8.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 31, 43, -1));

        jDateChooser7.setDateFormatString("yyyy-MM-dd");
        jPanel8.add(jDateChooser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 31, 135, -1));

        jLabel63.setText("Choose");
        jPanel8.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 68, 43, -1));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Credits", "Debits" }));
        jComboBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox18ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 65, 135, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Reason", "Amount"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 99, 386, 373));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel8.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 500));

        jTabbedPane2.addTab("View Transaction", jPanel8);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setText("Grade");
        jPanel9.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 34, 43, -1));

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "I PUC", "II PUC" }));
        jComboBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox19ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 31, 142, -1));

        jLabel65.setText("Stream");
        jPanel9.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 68, 43, -1));

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Science", "Commerce" }));
        jComboBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox20ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 65, 142, -1));

        jLabel66.setText("Combination");
        jPanel9.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 102, 78, -1));

        jComboBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox21ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 99, 142, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Adno", "Name", "Age", "Father name", "Phone", "Address", "Combination"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 741, 309));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jPanel9.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 500));

        jTabbedPane2.addTab("View Students", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Summary", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 1050, 540));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1050, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        jLabel45.setVisible(true);
        jLabel46.setVisible(true);
        jLabel47.setVisible(true);
        jLabel49.setVisible(true);
        jLabel51.setVisible(true);
        jButton12.setVisible(true);
        jButton13.setVisible(true);
        jButton14.setVisible(true);
        jTextField23.setVisible(true);
        jTextField24.setVisible(true);
        jTextField22.setVisible(true);
        jTextField25.setVisible(true);
        jComboBox13.setVisible(true);
        jComboBox15.setVisible(true);
        jLabel55.setVisible(true);
        jLabel56.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        String p = jTextField23.getText();
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name,age,address from workers where phone='" + p + "' and status='Working'");
            while (rs.next()) {
                jTextField22.setText(rs.getString(1));
                jTextField24.setText(rs.getString(3));
                jTextField25.setText(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        rst();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String p = jTextField23.getText();
        String n = jTextField22.getText();
        String adr = jTextField24.getText();
        String ag = jTextField25.getText();
        String d = (String) jComboBox13.getSelectedItem();
        String s = (String) jComboBox15.getSelectedItem();
        try {
            Connection con = ConnectionProvider.getcon();
            PreparedStatement ps = con.prepareStatement("update workers set name='" + n + "',address='" + adr + "',age='" + ag + "',dept='" + d + "',status='" + s + "' where phone='" + p + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
            rst();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser3.getDate());
        String n = jTextField14.getText();
        String p = jTextField15.getText();
        String adr = jTextField16.getText();
        String ag = jTextField17.getText();
        String g;
        if (jCheckBox1.isSelected()) {
            g = "Male";
        } else {
            g = "Female";
        }
        String dep = (String) jComboBox11.getSelectedItem();
        try {
            Connection con = ConnectionProvider.getcon();
            PreparedStatement ps = con.prepareStatement("insert into workers values(?,?,?,?,?,?,?,?)");
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, adr);
            ps.setString(4, ag);
            ps.setString(5, g);
            ps.setString(6, dep);
            ps.setString(7, "Working");
            ps.setString(8, date);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucessfully Added");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String stream = (String) jComboBox5.getSelectedItem();
        String com = (String) jComboBox7.getSelectedItem();
        String adno = jTextField13.getText();
        if (stream.equals("Science")) {
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select name,age,fname,phno,address from science where com='" + com + "' and adno='" + adno + "'");
                while (rs.next()) {
                    jTextField7.setText(rs.getString(1));
                    jTextField8.setText(rs.getString(2));
                    jTextField9.setText(rs.getString(3));
                    jTextField10.setText(rs.getString(4));
                    jTextField11.setText(rs.getString(5));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select name,age,fname,phone,address from commerce where com='" + com + "' and adno='" + adno + "'");
                while (rs.next()) {
                    jTextField7.setText(rs.getString(1));
                    jTextField8.setText(rs.getString(2));
                    jTextField9.setText(rs.getString(3));
                    jTextField10.setText(rs.getString(4));
                    jTextField11.setText(rs.getString(5));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        jTextField7.setEditable(false);
        jTextField9.setEditable(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String stream = (String) jComboBox2.getSelectedItem();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        String[] science = new String[]{"pcmb", "pcmcs"};
        String[] commerce = new String[]{"SEBA", "CEBA", "BASM"};
        String stream = (String) jComboBox5.getSelectedItem();
        jComboBox7.removeAllItems();
        if (stream.equals("Science")) {
            for (int i = 0; i < science.length; i++) {
                jComboBox7.addItem(science[i]);
            }
        }
        if (stream.equals("Commerce")) {
            for (int i = 0; i < commerce.length; i++) {
                jComboBox7.addItem(commerce[i]);
            }
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String stream = (String) jComboBox2.getSelectedItem();

        String name = jTextField1.getText();
        if (stream.equals("Science")) {
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno from science where name='" + name + "'");
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Admission number is " + rs.getString(1));

                }
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, f);
            }
        } else {
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno from commerce where name='" + name + "'");
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Admission number is " + rs.getString(1));

                }
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, f);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String stream = (String) jComboBox2.getSelectedItem();
        String com = (String) jComboBox3.getSelectedItem();
        String cls = (String) jComboBox4.getSelectedItem();
        String name = jTextField1.getText();
        String fname = jTextField3.getText();
        String address = jTextField5.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser2.getDate());
        int age = Integer.parseInt(jTextField2.getText());
        int per = Integer.parseInt(jTextField6.getText());
        double phone = Double.parseDouble(jTextField4.getText());
        String grade = (String) jComboBox6.getSelectedItem();
        if (stream.equals("Science")) {

            try {

                Connection con = ConnectionProvider.getcon();
                PreparedStatement ps = con.prepareStatement("Insert into science(com,name,age,fname,phno,address,pp,cls,status,grade,cd) values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, com);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, fname);
                ps.setDouble(5, phone);
                ps.setString(6, address);
                ps.setInt(7, per);
                ps.setString(8, cls);
                ps.setString(9, "Studying");
                ps.setString(10, grade);
                ps.setString(11, date);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sucessfully added");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        if (stream.equals("Commerce")) {
            try {
                Connection con = ConnectionProvider.getcon();
                PreparedStatement ps = con.prepareStatement("Insert into commerce (com,name,age,fname,phone,address,pp,cls,status,grade,cd) values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, com);
                ps.setString(2, name);
                ps.setString(4, fname);
                ps.setString(6, address);
                ps.setString(8, cls);
                ps.setString(9, "Studiying");
                ps.setString(10, grade);
                ps.setString(11, date);
                ps.setInt(3, age);
                ps.setDouble(5, phone);
                ps.setInt(7, per);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sucessfully added");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        jComboBox3.removeAllItems();
        String stream = (String) jComboBox2.getSelectedItem();
        String[] science = new String[]{"pcmb", "pcmcs"};
        String[] commerce = new String[]{"SEBA", "CEBA", "BASM"};
        if (stream.equals("Science")) {
            for (int i = 0; i < science.length; i++) {
                jComboBox3.addItem(science[i]);
            }
        }
        if (stream.equals("Commerce")) {
            for (int i = 0; i < commerce.length; i++) {
                jComboBox3.addItem(commerce[i]);
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        jTextField30.setText(filename);

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename1 = f.getAbsolutePath();
        jTextField31.setText(filename1);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        double amount = Double.parseDouble(jTextField26.getText());
        String by = (String) jComboBox14.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");

        String date = sdf.format(jDateChooser5.getDate());
        String month = sdf1.format(jDateChooser5.getDate());
        String year = sdf2.format(jDateChooser5.getDate());

        String newpath = "D:\\Account\\credits\\";
        File directory = new File(newpath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {

            counter++;
            File sourceFile = null;
            File destinationFile = null;
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            sourceFile = new File(filename);
            destinationFile = new File(newpath + "1_" + counter + "_" + date + "_creditfile." + extension);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            Connection con = ConnectionProvider.getcon();
            PreparedStatement ps = con.prepareStatement("insert into credit values(?,?,?,?,?,?)");
            ps.setString(1, date);
            ps.setString(2, month);
            ps.setString(3, year);
            ps.setDouble(4, amount);
            ps.setString(5, by);
            ps.setString(6, "1_" + counter + "_" + date + "_creditfile");
            ps.executeUpdate();
            total(date);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTextField26.setText("");
        jTextField30.setText("");

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        double amount = Double.parseDouble(jTextField28.getText());
        String by = (String) jComboBox16.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
        String date = sdf.format(jDateChooser5.getDate());
        String month = sdf1.format(jDateChooser5.getDate());
        String year = sdf2.format(jDateChooser5.getDate());
        String newpath = "D:\\Account\\debits\\";
        File directory = new File(newpath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {

            counter1++;
            File sourceFile = null;
            File destinationFile = null;
            String extension = filename1.substring(filename1.lastIndexOf('.') + 1);
            sourceFile = new File(filename1);
            destinationFile = new File(newpath + "0_" + counter1 + "_" + date + "_debitfile." + extension);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            Connection con = ConnectionProvider.getcon();
            PreparedStatement ps = con.prepareStatement("insert into debit values(?,?,?,?,?,?)");
            ps.setString(1, date);
            ps.setString(2, month);
            ps.setString(3, year);
            ps.setDouble(4, amount);
            ps.setString(5, by);
            ps.setString(6, "0_" + counter1 + "_" + date + "debitfile");
            ps.executeUpdate();
            total1(date);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTextField28.setText("");
        jTextField31.setText("");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser5.getDate());
        total(date);


    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jComboBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox16ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooser5.getDate());
        total1(date);
    }//GEN-LAST:event_jComboBox16ActionPerformed

    private void jComboBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox21ActionPerformed
        // TODO add your handling code here:
        String stream = (String) jComboBox20.getSelectedItem();
        String grade = (String) jComboBox19.getSelectedItem();
        String com = (String) jComboBox21.getSelectedItem();
        if (stream.equals("Science")) {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno,name,age,fname,phno,address,com from science where grade='" + grade + "' and com='" + com + "'");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (stream.equals("Commerce")) {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno,name,age,fname,phone,address,com from Commerce where grade='" + grade + "' and com='" + com + "'");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jComboBox21ActionPerformed

    private void jComboBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox20ActionPerformed
        // TODO add your handling code here:
        jComboBox21.removeAllItems();
        String stream = (String) jComboBox20.getSelectedItem();
        String[] science = new String[]{"pcmb", "pcmcs"};
        String[] commerce = new String[]{"SEBA", "CEBA", "BASM"};
        if (stream.equals("Science")) {
            for (int i = 0; i < science.length; i++) {
                jComboBox21.addItem(science[i]);
            }
        }
        if (stream.equals("Commerce")) {
            for (int i = 0; i < commerce.length; i++) {
                jComboBox21.addItem(commerce[i]);
            }
        }
        String grade = (String) jComboBox19.getSelectedItem();
        if (stream.equals("Science")) {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno,name,age,fname,phno,address,com from science where grade='" + grade + "'");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (stream.equals("Commerce")) {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select adno,name,age,fname,phone,address,com from commerce where grade='" + grade + "'");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jComboBox20ActionPerformed

    private void jComboBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox19ActionPerformed

    private void jComboBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox18ActionPerformed
        // TODO add your handling code here:
        String x = (String) jComboBox18.getSelectedItem();
        if (x.equals("Credits")) {
            tableDetaile();
        } else if (x.equals("Debits")) {
            tableDetaile1();
        }
    }//GEN-LAST:event_jComboBox18ActionPerformed

    private void jComboBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox22ActionPerformed
        // TODO add your handling code here:
        String dept = (String) jComboBox22.getSelectedItem();
        if (dept.equals("All")) {
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select name,phone,age,address,dept from workers");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select name,phone,age,address,dept from workers where dept='" + dept + "'");
                while (rs.next()) {
                    dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jComboBox22ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(accounts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accounts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accounts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accounts.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox21;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
