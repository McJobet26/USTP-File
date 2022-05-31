/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustp_directory;

/**
 *
 * @author LAB1-PC#83
 */


import com.lowagie.text.pdf.PdfWriter;
import com.sun.glass.events.KeyEvent;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.lt;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import static jdk.nashorn.tools.ShellFunctions.input;
import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class studentInfo extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form studentInfo
     */
    public studentInfo() {
        super("studentInfo");
        initComponents();
        conn = JavaConnection.ConnectDB();
        jTable1();
        ComboBoxCourse();
        RemarksScroll();
    
       
       student_no.setVisible(false);
    }
    
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void jTable1(){
        try{
            String sql = "SELECT student_info.stud_no , student_info.stud_id , student_info.name , student_info.birthday, student_info.address, student_info.gender, student_info.status, student_info.contact, student_info.email, courses.course_title ,remark.rmrk,student_info.elementary, student_info.high_school, student_info.college ,student_info.BOR FROM student_info JOIN courses on student_info.course_id = courses.crs_id JOIN remark ON student_info.remarks_id = remark.rem_id ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            student.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    
    public void Update(){
        try{
            
            String selectdate = ((JTextField)birthday.getDateEditor().getUiComponent()).getText();
            pst = conn.prepareStatement("UPDATE student_info SET name=?,birthday=?,address=?,gender=?,status=?,contact=?,email=?,course_id=?,remarks_id=?,elementary=?,high_school=?,college=? WHERE stud_no=?");
            
            pst.setString(1, name.getText());
            pst.setString(2, selectdate);
            pst.setString(3, address.getText());
            pst.setString(4, (String) gender.getSelectedItem());
            pst.setString(5, (String) status.getSelectedItem());
            pst.setString(6, contact.getText());
            pst.setString(7, email.getText());
            pst.setString(8, elementary.getText());
            pst.setString(9, secondary.getText());
            pst.setString(10, college.getText());
            pst.setString(11, (String) course_name.getSelectedItem());
            pst.setString(12, (String) remarks_id.getSelectedItem());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        jTable1();
    }
    
    private void ComboBoxCourse(){
        try{
            String sql = "SELECT * FROM courses";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String course = rs.getString("course_title");
                course_name.addItem(course);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void RemarksScroll(){
        try{
            String sql = "SELECT * FROM remark";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String remarks = rs.getString("rmrk");
                remarks_id.addItem(remarks);
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        college = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        contact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        birthday = new com.toedter.calendar.JDateChooser();
        elementary = new javax.swing.JTextField();
        secondary = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        course_name = new javax.swing.JComboBox<>();
        College1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        student = new javax.swing.JTable();
        find = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        student_no = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        remarks_id = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BOR = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BOR_label = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 151, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Educational Details:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Birthday:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Address:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 70, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Gender:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contact no:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 90, -1));

        college.setEditable(false);
        college.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        college.setText("University of Science and Technology of Southern Philippines");
        college.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(college, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 360, 27));

        status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "Single", "Married" }));
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 151, 27));

        contact.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 151, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 90, -1));

        email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 151, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Status:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 90, -1));

        gender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "Male", "Female" }));
        gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 151, 27));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Elementary:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 180, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Personal Details:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        address.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 151, 27));

        birthday.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 150, 30));
        jPanel1.add(elementary, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 260, 30));
        jPanel1.add(secondary, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 260, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Student ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 90, 20));
        jPanel1.add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 150, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Course");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, 30));

        course_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------" }));
        jPanel1.add(course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 150, 30));

        College1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        College1.setText("College:");
        jPanel1.add(College1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 180, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student.setAutoCreateRowSorter(true);
        student.setBackground(new java.awt.Color(204, 204, 204));
        student.setBorder(new javax.swing.border.MatteBorder(null));
        student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(student);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1030, 120));

        find.setText("Search");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                findKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findKeyReleased(evt);
            }
        });
        jPanel2.add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1030, 180));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 48)); // NOI18N
        jLabel5.setText("Student Details");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("<---- Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/1111.jpeg"))); // NOI18N
        jLabel17.setText("  ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 0,80));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_noActionPerformed(evt);
            }
        });
        jPanel4.add(student_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 90, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Remarks:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 90, -1));

        remarks_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        remarks_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        remarks_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(remarks_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 151, 27));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 120, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 120, -1));

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 120, -1));

        BOR.setEditable(false);
        jPanel4.add(BOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 260, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Secondary:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 180, -1));

        BOR_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BOR_label.setText("BOR:");
        jPanel4.add(BOR_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 950, 320));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/wallpaper2.jpeg"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 630));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Secondary:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 630));

        jMenu1.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem4.setText("Search");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setText("Clear");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMouseClicked
        try{

            int row = student.getSelectedRow();
            String table_click = student.getModel().getValueAt(row, 0).toString();
            String sql = "SELECT student_info.stud_no , student_info.stud_id , student_info.name , student_info.birthday, student_info.address, student_info.gender, student_info.status, student_info.contact, student_info.email, courses.course_title ,remark.rmrk,student_info.elementary, student_info.high_school, student_info.college ,student_info.BOR FROM student_info JOIN courses on student_info.course_id = courses.crs_id JOIN remark ON student_info.remarks_id = remark.rem_id WHERE stud_no='" + table_click + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String bor = rs.getString("BOR");
            if(bor == null){
                String add1 = rs.getString("stud_no");
                student_no.setText(add1);

                String add2 = rs.getString("stud_id");
                student_id.setText(add2);

                String add3 = rs.getString("name");
                name.setText(add3);
                
                String add4 = rs.getObject("birthday").toString();
                java.util.Date dat = new SimpleDateFormat("yyyy-MM-dd").parse(add4);
                birthday.setDate(dat);
                
                String add5 = rs.getString("address");
                address.setText(add5);
                
                String add6 = rs.getString("gender");
                gender.setSelectedItem(add6);
                
                String add7 = rs.getString("status");
                status.setSelectedItem(add7);
                
                String add8 = rs.getString("contact");
                contact.setText(add8);

                String add9 = rs.getString("email");
                email.setText(add9);
                
                String add10 = rs.getString("elementary");
                elementary.setText(add10);
                
                String add11 = rs.getString("high_school");
                secondary.setText(add11);
                
                String add12 = rs.getString("college");
                college.setText(add12);
                
                String add13 = rs.getString("course_title");
                course_name.setSelectedItem(add13);
                
                String add14 = rs.getString("rmrk");
                remarks_id.setSelectedItem(add14);
                BOR.setText("");
            }
        else{
                
                String add1 = rs.getString("stud_no");
                student_no.setText(add1);

                String add2 = rs.getString("stud_id");
                student_id.setText(add2);

                String add3 = rs.getString("name");
                name.setText(add3);
                
                String add4 = rs.getObject("birthday").toString();
                java.util.Date dat = new SimpleDateFormat("yyyy-MM-dd").parse(add4);
                birthday.setDate(dat);
                
                String add5 = rs.getString("address");
                address.setText(add5);
                
                String add6 = rs.getString("gender");
                gender.setSelectedItem(add6);
                
                String add7 = rs.getString("status");
                status.setSelectedItem(add7);
                
                String add8 = rs.getString("contact");
                contact.setText(add8);

                String add9 = rs.getString("email");
                email.setText(add9);
                
                String add10 = rs.getString("elementary");
                elementary.setText(add10);
                
                String add11 = rs.getString("high_school");
                secondary.setText(add11);
                
                String add12 = rs.getString("college");
                college.setText(add12);

                String add15 = rs.getString("BOR");
                BOR.setText(add15);
                String add13 = rs.getString("course_title");
                course_name.setSelectedItem(add13);
                
                String add14 = rs.getString("rmrk");
                remarks_id.setSelectedItem(add14);
                
                
                

            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_studentMouseClicked

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed

    }//GEN-LAST:event_genderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Update();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = student.getSelectedRow();
            
        String table_click = student.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM `student_info` WHERE stud_no = '"+table_click+"'";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "deleted");
            jTable1();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            int opt=remarks_id.getSelectedIndex();
         if(remarks_id.getSelectedIndex() == 1){
            String Bor = JOptionPane.showInputDialog("Enter Your BOR");
            if(Bor == ""){
                         String selectdate = ((JTextField)birthday.getDateEditor().getUiComponent()).getText();
            int stud_id = Integer.parseInt(student_id.getText());
            String sql;
            sql = "INSERT INTO `student_info`(`stud_id`, `name`, `birthday`, `address`, `gender`, `status`, `contact`, `email`, `course_id`, `remarks_id`, `elementary`, `high_school`, `college`,`BOR`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, stud_id);
            pst.setString(2, name.getText());
            pst.setString(3, selectdate);
            pst.setString(4, address.getText());
            pst.setString(5, (String) gender.getSelectedItem());
            pst.setString(6, (String) status.getSelectedItem());
            pst.setString(7, contact.getText());
            pst.setString(8, email.getText());
            pst.setInt(9,course_name.getSelectedIndex());
            pst.setInt(10, remarks_id.getSelectedIndex());
            pst.setString(11, elementary.getText());
            pst.setString(12, secondary.getText());
            pst.setString(13, college.getText());
            pst.setString(14,Bor);
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Added");
            rs.close();
            pst.close();
           
            jTable1();
           }else{

            }
           

           
            }else if(remarks_id.getSelectedIndex() == 7){
                String trans = JOptionPane.showInputDialog("Enter Your Last School Attended");
                
                
                 if(trans == ""){
            
           }else{
                     String selectdate = ((JTextField)birthday.getDateEditor().getUiComponent()).getText();
            int stud_id = Integer.parseInt(student_id.getText());
            String sql;
            sql = "INSERT INTO `student_info`(`stud_id`, `name`, `birthday`, `address`, `gender`, `status`, `contact`, `email`, `course_id`, `remarks_id`, `elementary`, `high_school`, `college`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, stud_id);
            pst.setString(2, name.getText());
            pst.setString(3, selectdate);
            pst.setString(4, address.getText());
            pst.setString(5, (String) gender.getSelectedItem());
            pst.setString(6, (String) status.getSelectedItem());
            pst.setString(7, contact.getText());
            pst.setString(8, email.getText());
            pst.setInt(9,course_name.getSelectedIndex());
            pst.setInt(10, remarks_id.getSelectedIndex());
            pst.setString(11, elementary.getText());
            pst.setString(12, secondary.getText());
            pst.setString(13, trans);
           
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Added");
            rs.close();
            pst.close();
           
            jTable1();
            }

                
            }else if(opt==2 || opt==3 || opt==4 || opt==5 || opt==6 ){ 
                    String selectdate = ((JTextField)birthday.getDateEditor().getUiComponent()).getText();
            int stud_id = Integer.parseInt(student_id.getText());
            String sql;
            sql = "INSERT INTO `student_info`(`stud_id`, `name`, `birthday`, `address`, `gender`, `status`, `contact`, `email`, `course_id`, `remarks_id`, `elementary`, `high_school`, `college`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, stud_id);
            pst.setString(2, name.getText());
            pst.setString(3, selectdate);
            pst.setString(4, address.getText());
            pst.setString(5, (String) gender.getSelectedItem());
            pst.setString(6, (String) status.getSelectedItem());
            pst.setString(7, contact.getText());
            pst.setString(8, email.getText());
            pst.setInt(9,course_name.getSelectedIndex());
            pst.setInt(10, remarks_id.getSelectedIndex());
            pst.setString(11, elementary.getText());
            pst.setString(12, secondary.getText());
            pst.setString(13,college.getText() );
           
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Added");
            rs.close();
            pst.close();
           
            jTable1();

                
                }
            else{

            }
        }
       
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void student_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_noActionPerformed
        try{
            String sql = "SELECT stud_no FROM student_info";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int num = 0;
            
            if(rs.next()){
                num = rs.getInt(1)+1;
                sql = "UPDATE student_info SET stud_no='" + num + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            num++;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       
    }//GEN-LAST:event_student_noActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        student_id.setText("");
        name.setText("");
        birthday.setDate(null);
        gender.setSelectedIndex(0);
        status.setSelectedIndex(0);
        address.setText("");
        contact.setText("");
        email.setText("");
        elementary.setText("");
        secondary.setText("");
        college.setText("University of Science and Technology of Southern Philippines");
        course_name.setSelectedIndex(0);
        BOR.setText("");
        remarks_id.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void findKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)student.getModel();
             String search = find.getText().toLowerCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             student.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(search));
         }
         
         else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)student.getModel();
             String search = find.getText().toUpperCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             student.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(search));
         }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)student.getModel();
             String search = find.getText().toUpperCase().toLowerCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             student.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(search));
         }
    }//GEN-LAST:event_findKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      
       String path = ""; 
       JFileChooser j = new JFileChooser();
       j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       int x = j.showSaveDialog(this);
       
       if(x==JFileChooser.APPROVE_OPTION){
           path=j.getSelectedFile().getPath();
       }
       
  
       MessageFormat header = new MessageFormat("Student List");
       MessageFormat footer = new MessageFormat("page (0)");
        try {
            
            student.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       
       
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
      
    }//GEN-LAST:event_findActionPerformed

    private void findKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)student.getModel();
             String search = find.getText().toLowerCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             student.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(search));
         }
         
         else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)student.getModel();
             String search = find.getText().toUpperCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             student.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(search));
         }
    }//GEN-LAST:event_findKeyReleased

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
            java.util.logging.Logger.getLogger(studentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BOR;
    private javax.swing.JLabel BOR_label;
    private javax.swing.JLabel College1;
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JTextField college;
    private javax.swing.JTextField contact;
    private javax.swing.JComboBox<String> course_name;
    private javax.swing.JTextField elementary;
    private javax.swing.JTextField email;
    private javax.swing.JTextField find;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> remarks_id;
    private javax.swing.JTextField secondary;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable student;
    private javax.swing.JTextField student_id;
    private javax.swing.JTextField student_no;
    // End of variables declaration//GEN-END:variables
}
