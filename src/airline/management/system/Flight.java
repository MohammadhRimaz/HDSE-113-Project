/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airline.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AL MUBDIE
 */
public class Flight extends javax.swing.JFrame {

    private String sourcePage;
    String jdbcUrl = "jdbc:mysql://localhost:3306/airline_management_system";
    String user = "root";
    String dbpassword = "";
    
    /**
     * Creates new form Flight
     */
    public Flight(String sourcePage) {
        initComponents();
        this.sourcePage = sourcePage;
        tpe.setEnabled(false);
        tpb.setEnabled(false);
        tpf.setEnabled(false);
        table_update();
    }
    
    Connection con;
    PreparedStatement pst;
    
    public void table_update()
    {
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            
            pst = con.prepareStatement("select * from flight");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData rd = Rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            while(Rs.next())
            {
                Vector v2 = new Vector();
                
                for (int i=1;i<=c;i++)
                {
                    v2.add(Rs.getString("No"));
                    v2.add(Rs.getString("Airline"));
                    v2.add(Rs.getString("Flight_No"));
                    v2.add(Rs.getString("No_of_Seats"));                
                    v2.add(Rs.getString("Seat_Type"));
                    v2.add(Rs.getString("Source"));
                    v2.add(Rs.getString("Departure_Date"));
                    v2.add(Rs.getString("Departure_Time"));                
                    v2.add(Rs.getString("Arrival_Date"));
                    v2.add(Rs.getString("Arrival_Time"));
                    v2.add(Rs.getString("Ticket_Price"));
                }
               df.addRow(v2);
            }
            con.close(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        F_no = new javax.swing.JTextField();
        destinybox = new javax.swing.JComboBox<>();
        sourcebox = new javax.swing.JComboBox<>();
        seats = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        airline = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Ebox = new javax.swing.JCheckBox();
        Bbox = new javax.swing.JCheckBox();
        Fbox = new javax.swing.JCheckBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tpe = new javax.swing.JTextField();
        tpb = new javax.swing.JTextField();
        tpf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Dtime = new javax.swing.JTextField();
        Atime = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Flight No");

        jLabel3.setText("Destination");

        jLabel4.setText("Source");

        jLabel5.setText("Departure Date");

        jLabel6.setText("No. of Seats");

        destinybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chennai - India", "Delhi - India", "Bangalore - India", "Colombo - Sri Lanka", "Sydney - Australia", "Melbourne - Australia", "Hong Kong - China", "Tokyo - China", "Osaka - China", "Lahore - Pakistan", "Karachi - Pakistan", "Singapore - Singapore", "Kuala Lamoure - Malaysia", "Bangkok - Thailand", "Male - Maldives", "Dhaka - Bangladesh", "Auckland - New Zealand" }));

        sourcebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colombo - Sri Lanka", "Sydney - Australia", "Melbourne - Australia", "Hong Kong - China", "Tokyo - China", "Osaka - China", "Lahore - Pakistan", "Karachi - Pakistan", "Chennai - India", "Delhi - India", "Bangalore - India", "Singapore - Singapore", "Kuala Lamoure - Malaysia", "Bangkok - Thailand", "Male - Maldives", "Dhaka - Bangladesh", "Auckland - New Zealand" }));
        sourcebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceboxActionPerformed(evt);
            }
        });

        delete.setText("Delete");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setText("Edit");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Air Line", "Flight No", "No of Seats", "Seat Type", "Source", "Departure Date", "Departure Time", "Destination", "Arrival Date", "Arrival Time", "Ticket Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Air Line");

        jLabel8.setText("Seat Type");

        jLabel9.setText("Arrival Date");

        // Add ActionListener to Ebox
        Ebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Ebox.isSelected()) {
                    tpe.setEnabled(true); // Enable the text field
                } else {
                    tpe.setEnabled(false); // Disable the text field
                }
            }
        });
        Ebox.setText("Economy Class");

        // Add ActionListener to Ebox
        Bbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Bbox.isSelected()) {
                    tpb.setEnabled(true); // Enable the text field
                } else {
                    tpb.setEnabled(false); // Disable the text field
                }
            }
        });
        Bbox.setText("Business Class");

        // Add ActionListener to Ebox
        Fbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Fbox.isSelected()) {
                    tpf.setEnabled(true); // Enable the text field
                } else {
                    tpf.setEnabled(false); // Disable the text field
                }
            }
        });
        Fbox.setText("First Class");

        jLabel10.setText("Departure Time");

        jLabel11.setText("Arrival Time");

        jLabel12.setText("Ticket Price :");

        tpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpeActionPerformed(evt);
            }
        });

        jLabel13.setText("Economy Class");

        jLabel14.setText("Business Class");

        jLabel15.setText("First Class");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Ebox, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(seats, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F_no, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airline, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bbox, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(Fbox, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tpb, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tpe, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tpf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sourcebox, 0, 158, Short.MAX_VALUE)
                                    .addComponent(Dtime))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Atime))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(destinybox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 102, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(add)
                .addGap(60, 60, 60)
                .addComponent(edit)
                .addGap(48, 48, 48)
                .addComponent(delete)
                .addGap(70, 70, 70)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Bbox, Ebox, Fbox});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(airline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sourcebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(destinybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(F_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(seats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(Dtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Atime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Ebox)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(tpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fbox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Bbox, Ebox, Fbox});

        jLabel1.setText("Flight Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // For back Button
        this.dispose(); // Close the current page
    
        if (sourcePage.equals("MainMenuAdmin")) {
            MainMenuAdmin adminPage = new MainMenuAdmin();
            adminPage.setVisible(true);
        } else if (sourcePage.equals("MainMenuStaff")) {
            MainMenuStaff staffPage = new MainMenuStaff();
            staffPage.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sourceboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceboxActionPerformed

    private void tpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpeActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //Add Button...     
        String Fairline = airline.getText();
        String Fno = F_no.getText();        
        String Fseats = seats.getText();
        // Get the state of each checkbox
        boolean economyChecked = Ebox.isSelected();
        boolean businessChecked = Bbox.isSelected();
        boolean firstClassChecked = Fbox.isSelected();

        // Initialize a StringBuilder to build the combined data string
        StringBuilder combinedSeatTypeData = new StringBuilder();

        // Add selected seat types to the combined data string
        if (economyChecked) {
            combinedSeatTypeData.append("Economy Class");
        }

        if (businessChecked) {
            if (combinedSeatTypeData.length() > 0) {
                combinedSeatTypeData.append(", ");
            }
                combinedSeatTypeData.append("Business Class");
        }

        if (firstClassChecked) {
            if (combinedSeatTypeData.length() > 0) {
                combinedSeatTypeData.append(", ");
            }
            combinedSeatTypeData.append("First Class");
        }

        String Fsource = sourcebox.getSelectedItem().toString();
        //departure date declared
        SimpleDateFormat Date_Format = new SimpleDateFormat ("yyyy/MM/dd");
        String date = Date_Format.format(jDateChooser1.getDate());
        String Dptime = Dtime.getText();
        String Fsource2 = destinybox.getSelectedItem().toString();
        //arrival date declared
        SimpleDateFormat Date_Format2 = new SimpleDateFormat ("yyyy/MM/dd");
        String date2 = Date_Format2.format(jDateChooser2.getDate());
        String arvltime = Atime.getText();
        String ETicprice = tpe.getText();
        String BTicprice = tpb.getText();
        String FTicprice = tpf.getText();
        //getting 3 variables and setting into one variable....
        String combinedpriceData = ETicprice + ", " + BTicprice + ", " + FTicprice;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            
            if (Fairline.equals("")||Fno.equals("")||Fseats.equals("")||Fsource.equals("")||date.equals("")||Dptime.isEmpty()||Fsource2.equals("")||date2.isEmpty()||arvltime.equals("")||(Ebox.isSelected() && ETicprice.isEmpty()) ||(Bbox.isSelected() && BTicprice.isEmpty()) || (Fbox.isSelected() && FTicprice.isEmpty())) 
            {
                JOptionPane.showMessageDialog(this, "Some Fields are empty");   
            }
            else
            {
                pst = con.prepareStatement("insert into flight(Airline ,Flight_No,No_of_Seats,Seat_Type,Source,Departure_Date,Departure_Time,Destination,Arrival_Date,Arrival_Time,Ticket_Price) values (?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, Fairline);
                pst.setString(2, Fno);
                pst.setString(3, Fseats);
                // Set the combined seat type data
                pst.setString(4, combinedSeatTypeData.toString());
                pst.setString(5, Fsource);
                pst.setString(6, date);
                pst.setString(7, Dptime);
                pst.setString(8, Fsource2);
                pst.setString(9, date2);
                pst.setString(10, arvltime);
                pst.setString(11, combinedpriceData);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Flight Added.");
            
                airline.setText("");            
                F_no.setText("");
                seats.setText("");
                Ebox.setSelected(false);
                Bbox.setSelected(false);
                Fbox.setSelected(false);
                sourcebox.setSelectedIndex(0);
                jDateChooser1.setDate(null);
                Dtime.setText("");
                destinybox.setSelectedIndex(0);
                jDateChooser2.setDate(null);
                Atime.setText("");
                tpe.setText("");            
                tpb.setText("");
                tpf.setText("");
                
                airline.requestFocus();
                table_update();
            }
            con.close(); 
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addActionPerformed

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
            java.util.logging.Logger.getLogger(Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flight("MainMenuAdmin").setVisible(true);
                new Flight("MainMenuStaff").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Atime;
    private javax.swing.JCheckBox Bbox;
    private javax.swing.JTextField Dtime;
    private javax.swing.JCheckBox Ebox;
    private javax.swing.JTextField F_no;
    private javax.swing.JCheckBox Fbox;
    private javax.swing.JButton add;
    private javax.swing.JTextField airline;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> destinybox;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField seats;
    private javax.swing.JComboBox<String> sourcebox;
    private javax.swing.JTextField tpb;
    private javax.swing.JTextField tpe;
    private javax.swing.JTextField tpf;
    // End of variables declaration//GEN-END:variables
}
