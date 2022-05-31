/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustp_directory;

/**
 *
 * @author LAB1-PC#85
 */

import com.sun.glass.events.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
public class grading extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form grading
     */
    public grading() {
        super("grading");
        initComponents();
        btn_update.setVisible(false);
        rec.setVisible(false);
        year_take.setVisible(false);
        year_taken.setVisible(false);
        btn_delete.setVisible(false);
        conn = JavaConnection.ConnectDB();
      
        studentList();
        semester();
      ComboBoxSemester();
        schoolYear();
        remarkID();
        grading();
    }
     private void ComboBoxSemester(){
        try{
            String sql = "SELECT * FROM `courses`";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String cse = rs.getString("course_title");
                course.addItem(cse);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void gradeTable(){
        try{

            String sql = "SELECT grades.rec_id,grades.stud_no_id, grades.name, subjects.description ,grading.grds, mark.marking FROM grades JOIN subjects ON subjects.subject_no = grades.subject_id JOIN mark ON mark.mark_id = grades.stat JOIN grading ON grading.grd_id = grades.grades";            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            gradelist.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
    public void studentList(){
        try{
            String sql ="SELECT student_info.stud_no, student_info.stud_id,student_info.name, student_info.contact,student_info.email, courses.course_title FROM student_info JOIN courses ON student_info.course_id = courses.crs_id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            studentlist.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Update(){
        try{
            int ids = Integer.parseInt(school_id.getText());

            if(semester.getSelectedIndex()== 9){
            int id = Integer.parseInt(rec.getText());
            int year = Integer.parseInt(year_take.getText());
            pst = conn.prepareStatement("UPDATE `grades` SET `stud_no_id`=?, `name`=?, `course`=?, `s_year_id`=?, `sem_no_id`=?,`taken`=?, `subject_id`=?, `grades`=?, `stat`=? WHERE `rec_id`=?");
            pst.setInt(1, ids);
            pst.setString(2, student_name.getText());
            pst.setString(3, (String) course.getSelectedItem());
            pst.setInt(4, school_year.getSelectedIndex());
            pst.setInt(5, semester.getSelectedIndex());
            pst.setInt(6, year);
            pst.setInt(7, subject.getSelectedIndex());
            pst.setInt(8, grading.getSelectedIndex());
            pst.setInt(9, remarks_id.getSelectedIndex());
            pst.setInt(10, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            gradeTable();
            rs.close();
            pst.close();
            
            }else{
                int id = Integer.parseInt(rec.getText());

            String sql = "UPDATE `grades` SET `stud_no_id`=?, `name`=?, `course`=?, `s_year_id`=?, `sem_no_id`=?,`subject_id`=?, `grades`=?, `stat`=? WHERE `rec_id`=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, ids);
            pst.setString(2, student_name.getText());
            pst.setString(3, (String) course.getSelectedItem());
            pst.setInt(4, school_year.getSelectedIndex());
            pst.setInt(5, semester.getSelectedIndex());
            pst.setInt(6, subject.getSelectedIndex());
            pst.setInt(7, grading.getSelectedIndex());
            pst.setInt(8, remarks_id.getSelectedIndex());
            pst.setInt(9, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            rs.close();
            pst.close();
            gradeTable();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    

    
    private void semester(){
        try{
            String sql = "SELECT * FROM semester";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String sem = rs.getString("semester_description");
                semester.addItem(sem);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void grading(){
        try{
            String sql = "SELECT * FROM grading";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String sem = rs.getString("grds");
                grading.addItem(sem);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    
   
    
    private void schoolYear(){
        try{
            String sql = "SELECT * FROM schl_year";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            while(rs.next()){
                String year = rs.getString("sy_year");
                school_year.addItem(year);
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    

    
    private void remarkID(){
        try{
            String sql = "SELECT * FROM mark";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String remarks = rs.getString("marking");
                remarks_id.addItem(remarks);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void clearRecord(){
        school_id.setText("");
        student_name.setText("");
        course.setSelectedItem(0);
        grading.setSelectedIndex(0);
        
        btn_update.setVisible(false);
        btn_save.setVisible(true);
        
        school_year.setSelectedIndex(0);
        semester.setSelectedIndex(0);
        subject.setSelectedIndex(0);
        year_take.setVisible(false);
        year_take.setText("");
        year_taken.setVisible(false);
        remarks_id.setSelectedIndex(0);
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
        Wallpaper1 = new javax.swing.JLabel();
        school_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentlist = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        Wallpaper2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradelist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        school_year = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        remarks_id = new javax.swing.JComboBox<>();
        year_taken = new javax.swing.JLabel();
        semester = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        grading = new javax.swing.JComboBox<>();
        rec = new javax.swing.JTextField();
        year_take = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Wallpaper1.setFont(new java.awt.Font("Arial Black", 3, 48)); // NOI18N
        Wallpaper1.setText("Records of Grades");
        jPanel1.add(Wallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        school_id.setEditable(false);
        school_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        school_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        school_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                school_idMouseReleased(evt);
            }
        });
        school_id.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                school_idInputMethodTextChanged(evt);
            }
        });
        school_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                school_idActionPerformed(evt);
            }
        });
        school_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                school_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                school_idKeyTyped(evt);
            }
        });
        jPanel1.add(school_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentlist);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 440));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Name of Student :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 210, 30));

        Wallpaper2.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        Wallpaper2.setForeground(new java.awt.Color(255, 255, 255));
        Wallpaper2.setText("Name of Student");
        jPanel2.add(Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 380, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/images (4).jpeg"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 470, 600));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 470, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "student no.", "Subjects", "Grades", "Status"
            }
        ));
        gradelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradelistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradelist);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Student Record:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btn_update.setBackground(new java.awt.Color(0, 255, 0));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, -1));

        btn_delete.setBackground(new java.awt.Color(0, 255, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 120, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/images (4).jpeg"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 260));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 470, 260));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name of Student:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Remarks:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        student_name.setEditable(false);
        student_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 30));

        school_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------------" }));
        jPanel1.add(school_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 210, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Course:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        remarks_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------" }));
        jPanel1.add(remarks_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 30));

        year_taken.setBackground(new java.awt.Color(255, 255, 255));
        year_taken.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        year_taken.setForeground(new java.awt.Color(255, 255, 255));
        year_taken.setText("Year taken:");
        jPanel1.add(year_taken, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------" }));
        jPanel1.add(semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name of Subject:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grade:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------------" }));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });
        jPanel1.add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 210, 30));

        btn_save.setBackground(new java.awt.Color(0, 255, 0));
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_save.setText("Save");
        btn_save.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 120, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 1, 970, 678));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("<---- Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/asdasdas.jpeg"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 70));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("School ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Semester Taken:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        grading.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------------------------------------" }));
        jPanel1.add(grading, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 210, 30));
        jPanel1.add(rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, 40));
        jPanel1.add(year_take, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 100, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("School Year:  ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        course.setEditable(true);
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------" }));
        course.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseItemStateChanged(evt);
            }
        });
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system picture/images (3).jpeg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 970, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 680));

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Clear");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        Update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try{
            int id = Integer.parseInt(school_id.getText());

            if(semester.getSelectedIndex()== 9){
            
            String take = JOptionPane.showInputDialog(null,"Enter Year Taken");
            int year =Integer.parseInt(take);
            String sql = "INSERT INTO `grades`(`stud_no_id`, `name`, `course`, `s_year_id`, `sem_no_id`,`taken`, `subject_id`, `grades`, `stat`) VALUES (?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, student_name.getText());
            pst.setString(3, (String) course.getSelectedItem());
            pst.setInt(4, school_year.getSelectedIndex());
            pst.setInt(5, semester.getSelectedIndex());
            pst.setInt(6, year);
            pst.setInt(7, subject.getSelectedIndex());
            pst.setInt(8, grading.getSelectedIndex());
            pst.setInt(9, remarks_id.getSelectedIndex());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added");
            gradeTable();
            rs.close();
            pst.close();
            
            }else{
            String sql = "INSERT INTO `grades`(`stud_no_id`, `name`, `course`, `s_year_id`, `sem_no_id`, `subject_id`, `grades`, `stat`) VALUES (?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, student_name.getText());
            pst.setString(3, (String) course.getSelectedItem());
            pst.setInt(4, school_year.getSelectedIndex());
            pst.setInt(5, semester.getSelectedIndex());
            pst.setInt(6, subject.getSelectedIndex());
            pst.setInt(7, grading.getSelectedIndex());
            pst.setInt(8, remarks_id.getSelectedIndex());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added");
            rs.close();
            pst.close();
            gradeTable();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)studentlist.getModel();
             String find = search.getText().toLowerCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             studentlist.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(find));
         }
         
         else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)studentlist.getModel();
             String find = search.getText().toUpperCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             studentlist.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(find));
         }
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        //Search Query Key Released
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)studentlist.getModel();
             String find = search.getText().toLowerCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             studentlist.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(find));
         }
         
         else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             DefaultTableModel model = (DefaultTableModel)studentlist.getModel();
             String find = search.getText().toUpperCase();
             TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(model);
             studentlist.setRowSorter(tr);
             tr.setRowFilter(RowFilter.regexFilter(find));
         }
    }//GEN-LAST:event_searchKeyReleased

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        
    }//GEN-LAST:event_subjectActionPerformed

    private void studentlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentlistMouseClicked
            try{
                int row = studentlist.getSelectedRow();
                String table_click1 = studentlist.getModel().getValueAt(row, 0).toString();
                String sql = "SELECT student_info.stud_no , student_info.stud_id , student_info.name , student_info.birthday, student_info.address, student_info.gender, student_info.status, student_info.contact, student_info.email, courses.course_title ,remark.rmrk,student_info.elementary, student_info.high_school, student_info.college ,student_info.BOR FROM student_info JOIN courses on student_info.course_id = courses.crs_id JOIN remark ON student_info.remarks_id = remark.rem_id WHERE stud_no='" + table_click1 + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
            
                if(rs.next()){
                    btn_update.setVisible(false);
                    btn_save.setVisible(true);
                    String add1 = rs.getString("stud_id");
                    school_id.setText(add1);
                    
                    String add2 = rs.getString("name");
                    student_name.setText(add2);
                    
                    String add3 = rs.getString("course_title");
                    course.setSelectedItem(add3);
                    
                    btn_delete.setVisible(false);
                    
                    String sql1 = "SELECT grades.rec_id,grades.stud_no_id, grades.name, subjects.description ,grading.grds, mark.marking FROM grades JOIN subjects ON subjects.subject_no = grades.subject_id JOIN mark ON mark.mark_id = grades.stat JOIN grading ON grading.grd_id = grades.grades WHERE grades.stud_no_id ="+add1;            
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            gradelist.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_studentlistMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        school_id.setText("");
        student_name.setText("");
        course.setSelectedIndex(0);
        grading.setSelectedIndex(0);
        
        btn_update.setVisible(false);
        btn_save.setVisible(true);
        
        school_year.setSelectedIndex(0);
        semester.setSelectedIndex(0);
        subject.setSelectedIndex(0);
        year_take.setVisible(false);
        year_take.setText("");
        year_taken.setVisible(false);
        remarks_id.setSelectedIndex(0);
        btn_delete.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void gradelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradelistMouseClicked
        try{
            
            int row = gradelist.getSelectedRow();
            String table_click = gradelist.getModel().getValueAt(row, 0).toString();
            String sql = "SELECT grades.rec_id,grades.stud_no_id,grades.name,grades.course,schl_year.sy_year,semester.semester_description,grades.taken,subjects.description,subjects.subject_code, grading.grds,mark.marking FROM grades JOIN schl_year ON schl_year.sy_id = grades.s_year_id JOIN semester ON semester.sem_id = grades.sem_no_id JOIN subjects ON subjects.subject_no = grades.subject_id JOIN grading ON grading.grd_id =grades.grades JOIN mark ON mark.mark_id =grades.stat WHERE rec_id='" + table_click + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String takes=rs.getString("taken");
                
                if(takes == null ){
                    
                String add0 = rs.getString("rec_id");
                rec.setText(add0);
                String add1 = rs.getString("stud_no_id");
                school_id.setText(add1);
                String add2 = rs.getString("name");
                student_name.setText(add2);
                String add3 = rs.getString("course");
                course.setSelectedItem(add3);
                String add4 = rs.getString("sy_year");
                school_year.setSelectedItem(add4);
                String add5 = rs.getString("semester_description");
                semester.setSelectedItem(add5);
                String add6 = rs.getString("subject_code");
                subject.setSelectedItem(add6);
                String add7 = rs.getString("grds");
                grading.setSelectedItem(add7);
                String add8 = rs.getString("marking");
                remarks_id.setSelectedItem(add8);
                btn_update.setVisible(true);
                btn_save.setVisible(false);
                year_take.setVisible(false);
                year_taken.setVisible(false);
                btn_delete.setVisible(true);
                
                }else{
                String add0 = rs.getString("rec_id");
                rec.setText(add0);
                String add1 = rs.getString("stud_no_id");
                school_id.setText(add1);
                String add2 = rs.getString("name");
                student_name.setText(add2);
                String add3 = rs.getString("course");
                course.setSelectedItem(add3);
                String add4 = rs.getString("sy_year");
                school_year.setSelectedItem(add4);
                String add5 = rs.getString("semester_description");
                semester.setSelectedItem(add5);
                String taken = rs.getString("taken");
                year_take.setText(taken);
                String add6 = rs.getString("description");
                subject.setSelectedItem(add6);
                String add7 = rs.getString("grds");
                grading.setSelectedItem(add7);
                String add8 = rs.getString("marking");
                remarks_id.setSelectedItem(add8);
                year_take.setVisible(true);
                year_taken.setVisible(true);
                btn_update.setVisible(true);
                btn_save.setVisible(false);
                btn_delete.setVisible(true);
                }
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_gradelistMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int p=JOptionPane.showConfirmDialog(null, "Do you really want to delete","delete",JOptionPane.YES_NO_OPTION);
        
        if(p == 0){
         
            String sql = "DELETE FROM `grades` WHERE rec_id=?";
            
            try{
                pst = conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(rec.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "deleted");
                gradeTable();
                clearRecord();
                btn_delete.setVisible(false);
                
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        else{
            
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void school_idMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_school_idMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_school_idMouseReleased

    private void school_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_school_idKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_school_idKeyReleased

    private void school_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_school_idKeyTyped
        // TODO add your handling code here:
    
    }//GEN-LAST:event_school_idKeyTyped

    private void courseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_courseItemStateChanged
        // TODO add your handling code here:
         try{
        subject.removeAllItems();
        int crs = course.getSelectedIndex();
        String sql="SELECT * FROM `subjects` WHERE crse_id ="+crs;
        pst= conn.prepareStatement(sql);
        rs =pst.executeQuery();
        
        while(rs.next()){
        
        String sub = rs.getString("subject_code");
                subject.addItem(sub);
        
        
        }
        }catch(Exception e){
        
        
        
        }
    }//GEN-LAST:event_courseItemStateChanged

    private void school_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_school_idActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_school_idActionPerformed

    private void school_idInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_school_idInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_school_idInputMethodTextChanged

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        new view_list_dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(grading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper1;
    private javax.swing.JLabel Wallpaper2;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JTable gradelist;
    private javax.swing.JComboBox<String> grading;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField rec;
    private javax.swing.JComboBox<String> remarks_id;
    private javax.swing.JTextField school_id;
    private javax.swing.JComboBox<String> school_year;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JTextField student_name;
    private javax.swing.JTable studentlist;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JTextField year_take;
    private javax.swing.JLabel year_taken;
    // End of variables declaration//GEN-END:variables
}
