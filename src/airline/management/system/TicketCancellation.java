/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airline.management.system;

import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;
/**
 *
 * @author moham
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class TicketCancellation extends javax.swing.JFrame {

    private String sourcePage;
    String jdbcUrl = "jdbc:mysql://localhost:3306/airline_management_system";
    String user = "root";
    String dbpassword = "";
    /**
     * Creates new form TicketCancellation
     */
    
      
    Connection con;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst1 = null;
    ResultSet rs;
    ResultSet rs1;
    
    public TicketCancellation(String sourcePage) {
        initComponents();
        this.sourcePage = sourcePage;
        LoadTicID ();
        table_update();
        
        //For making all text fields empty...
        ticID.setSelectedIndex(-1);   
        cusname.setText("");
        psprt.setText("");
        cusid.setText("");
        source.setText("");
        Ddate.setText("");
        Dtime.setText("");
        destination.setText("");
        Adate.setText("");
        Atime.setText("");
        ticPrice.setText("");
        refund.setText("");
        fine.setText("");
        flightno.setText("");
        bookingdate.setText("");
        seattype.setText("");
        jDateChooser1.setDate(null);
        
        // Add an ActionListener to the discount field
        fine.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                discountActionPerformed(evt);
            }

            private void discountActionPerformed(ActionEvent evt) 
            {
                try {
                    // Get the discount value entered by the user
                    double enteredFine = Double.parseDouble(fine.getText());

                    // Retrieve the ticket price from the "Ticket Price" field
                    double ticketPrice = Double.parseDouble(ticPrice.getText());

                    // Calculate the discount price
                    double Refund = ticketPrice - enteredFine;

                    // Update the "Discount Price" field with the calculated value
                    refund.setText(String.format("%.2f", Refund));
                } catch (NumberFormatException ex) {
                    // Handle the case where the user enters an invalid discount value
                    refund.setText(""); // Clear the "Discount Price" field
                }
            }
        });
        
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
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cusname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        psprt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        source = new javax.swing.JTextField();
        Ddate = new javax.swing.JTextField();
        Dtime = new javax.swing.JTextField();
        Atime = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Adate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ticPrice = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ticID = new javax.swing.JComboBox<>();
        seattype = new javax.swing.JTextField();
        flightno = new javax.swing.JTextField();
        cusid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fine = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        refund = new javax.swing.JTextField();
        bookingdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setText("Ticket Cancellation");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setText("Customer ID");

        cancel.setText("Cancel");
        cancel.setToolTipText("");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tic_ID", "Cus_ID", "Cus Name", "Pssport No", "Flight No", "Booked Date", "Cancel Date", "Seat Type", "Source", "Destination", "Fine", "Refund"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cusname.setEditable(false);

        jLabel2.setText("Customer Name");

        jLabel3.setText("Passport No");

        psprt.setEditable(false);

        jLabel6.setText("Flight No");

        jLabel7.setText("Source");

        jLabel8.setText("Depature Date");

        jLabel9.setText("Depature Time");

        source.setEditable(false);

        Ddate.setEditable(false);

        Dtime.setEditable(false);

        Atime.setEditable(false);

        jLabel10.setText("Arrival Time");

        jLabel11.setText("Destination");

        destination.setEditable(false);

        jLabel12.setText("Arrival Date");

        Adate.setEditable(false);

        jLabel14.setText("Seat Type");

        jLabel15.setText("Ticket Price");

        ticPrice.setEditable(false);

        jLabel18.setText("Ticket ID");

        ticID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticIDActionPerformed(evt);
            }
        });

        seattype.setEditable(false);

        flightno.setEditable(false);

        cusid.setEditable(false);

        jLabel5.setText("Fine");

        jLabel16.setText("Refund");

        refund.setEditable(false);

        bookingdate.setEditable(false);

        jLabel13.setText("Booked Date");

        jLabel17.setText("Cancel Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bookingdate)
                    .addComponent(cusname)
                    .addComponent(psprt)
                    .addComponent(ticID, 0, 160, Short.MAX_VALUE)
                    .addComponent(cusid)
                    .addComponent(flightno))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(source, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ddate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dtime, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fine)
                            .addComponent(seattype))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancel)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destination, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(Adate, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(Atime, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(ticPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(refund)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(back)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Adate, Atime, Ddate, Dtime, bookingdate, cusid, cusname, destination, fine, flightno, jDateChooser1, psprt, refund, seattype, source, ticID, ticPrice});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {back, cancel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(ticID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(Ddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(Adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(Dtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(Atime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psprt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)
                            .addComponent(seattype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(ticPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(flightno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(fine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(refund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bookingdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addComponent(jLabel13)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(back))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Adate, Atime, Ddate, Dtime, bookingdate, cusid, cusname, destination, fine, flightno, jDateChooser1, psprt, refund, seattype, source, ticID, ticPrice});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {back, cancel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void table_update()
    {  
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl,user,dbpassword);
            
            pst = con.prepareStatement("select * from ticket_cancellation");
            rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("Tic_ID"));
                    v2.add(rs.getString("Customer_ID"));
                    v2.add(rs.getString("Customer_Name"));
                    v2.add(rs.getString("Passport_No"));
                    v2.add(rs.getString("Flight_No"));
                    v2.add(rs.getString("Booked_Date"));
                    v2.add(rs.getString("Cancelled_Date"));
                    v2.add(rs.getString("Seat_Type"));
                    v2.add(rs.getString("Source"));
                    v2.add(rs.getString("Destination"));
                    v2.add(rs.getString("Fine"));
                    v2.add(rs.getString("Refund"));
                }
                df.addRow(v2);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadTicID (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            pst1 = con.prepareStatement("select * from ticket_booking");
            rs1 = pst1.executeQuery();
            ticID.removeAllItems();
            
            while (rs1.next())
            {
                ticID.addItem(rs1.getString(1));
            }
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // For back Button
        this.dispose(); // Close the current page
    
        if (sourcePage.equals("MainMenuAdmin")) {
            MainMenuAdmin adminPage = new MainMenuAdmin();
            adminPage.setVisible(true);
        } else if (sourcePage.equals("MainMenuStaff")) {
            MainMenuStaff staffPage = new MainMenuStaff();
            staffPage.setVisible(true);
        }
    }//GEN-LAST:event_backActionPerformed

    private void ticIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticIDActionPerformed
        //All details will display when Ticket ID clicked....
        if (ticID.getSelectedIndex() != -1) {  
        String ticketid = ticID.getSelectedItem().toString();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl,user,dbpassword);

            pst = con.prepareStatement("select * from ticket_booking where Tic_ID = ?");
            pst.setString(1, ticketid);
            rs = pst.executeQuery();
              
            if (rs.next()) 
            {
                // Retrieve customer details from the database
                String customerid = rs.getString("Cus_ID");
                String bookeddate = rs.getString("Booking_Date");
                String customername = rs.getString("Customer_Name");
                String passport = rs.getString("Passport_No");
                String Fno = rs.getString("Flight_No");
                String src = rs.getString("Source");
                String Depdate = rs.getString("Departure_Date");
                String Deptime = rs.getString("Departure_Time");
                String Destination = rs.getString("Destination");
                String ArvlDate = rs.getString("Arrival_Date");
                String Arvltime = rs.getString("Arrival_Time");
                String seatType = rs.getString("Seat_Type");
                String ticprice = rs.getString("Ticket_Price");
                
                // Populate the text fields with retrieved information
                cusid.setText(customerid);
                cusname.setText(customername);
                psprt.setText(passport);
                flightno.setText(Fno);
                bookingdate.setText(bookeddate);
                source.setText(src);
                Ddate.setText(Depdate);
                Dtime.setText(Deptime);
                destination.setText(Destination);
                Adate.setText(ArvlDate);
                Atime.setText(Arvltime);
                seattype.setText(seatType);
                ticPrice.setText(ticprice);
             } 
             else
             {
                JOptionPane.showMessageDialog(this, "Customer Not Found");
             }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_ticIDActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        //Ticket Cancel Button
        String tid = ticID.getSelectedItem().toString();
        String Cdate = jDateChooser1.getDate() != null ? new SimpleDateFormat ("yyyy/MM/dd").format(jDateChooser1.getDate()) : null;
        String Bdate = bookingdate.getText();
        String cid = cusid.getText();
        String cname = cusname.getText();
        String passport = psprt.getText();
        String fno = flightno.getText();
        String src = source.getText();
        String dstnt = destination.getText();
        String f = fine.getText();
        String Rf = refund.getText(); 
        String ST = seattype.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl,user,dbpassword);
            
            if (f.equals("")||Cdate == null||Rf.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Some Fields are empty");   
            }
            else
            {              
                pst = con.prepareStatement("insert into ticket_cancellation(Tic_ID,Customer_ID,Customer_Name,Passport_No,Flight_No,Booked_Date,Cancelled_Date,Seat_Type,Source,Destination,Fine,Refund) values (?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, tid);
                pst.setString(2, cid);
                pst.setString(3, cname);            
                pst.setString(4, passport);
                pst.setString(5, fno);
                pst.setString(6, Bdate);
                pst.setString(7, Cdate);
                pst.setString(8, ST);
                pst.setString(9, src);            
                pst.setString(10, dstnt);
                pst.setString(11, f);
                pst.setString(12, Rf);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Ticket Cancelled.");
                
                // Update the flight table with new values for Booked_Seats and Available_Seats
                updateFlightSeats(fno);
                
                //For making all text fields empty...
                ticID.setSelectedIndex(-1);   
                cusname.setText("");
                psprt.setText("");
                cusid.setText("");
                source.setText("");
                Ddate.setText("");
                Dtime.setText("");
                destination.setText("");
                Adate.setText("");
                Atime.setText("");
                ticPrice.setText("");
                refund.setText("");
                fine.setText("");
                flightno.setText("");
                bookingdate.setText("");
                seattype.setText("");
                jDateChooser1.setDate(null);
                table_update();
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cancelActionPerformed

    private void updateFlightSeats(String flightNo) {
        try {
            //Update ticket Details in Flight Table.....
            // Retrieve the current values of Booked_Seats and Available_Seats
            pst = con.prepareStatement("SELECT Booked_Seats, Available_Seats FROM flight WHERE Flight_No = ?");
            pst.setString(1, flightNo);
            rs = pst.executeQuery();

            if (rs.next()) 
            {
                int bookedSeats = rs.getInt("Booked_Seats");
                int availableSeats = rs.getInt("Available_Seats");

                // Decrease Booked_Seats by 1 and increase Available_Seats by 1
                bookedSeats -= 1;
                availableSeats += 1;

                // Update the flight table with the new values
                pst = con.prepareStatement("UPDATE flight SET Booked_Seats = ?, Available_Seats = ? WHERE Flight_No = ?");
                pst.setInt(1, bookedSeats);
                pst.setInt(2, availableSeats);
                pst.setString(3, flightNo);
                pst.executeUpdate();
             }
        } catch (SQLException ex) {
            Logger.getLogger(TicketCancellation.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
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
            java.util.logging.Logger.getLogger(TicketCancellation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketCancellation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketCancellation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketCancellation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketCancellation("MainMenuAdmin").setVisible(true);
                new TicketCancellation("MainMenuStaff").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adate;
    private javax.swing.JTextField Atime;
    private javax.swing.JTextField Ddate;
    private javax.swing.JTextField Dtime;
    private javax.swing.JButton back;
    private javax.swing.JTextField bookingdate;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField cusid;
    private javax.swing.JTextField cusname;
    private javax.swing.JTextField destination;
    private javax.swing.JTextField fine;
    private javax.swing.JTextField flightno;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField psprt;
    private javax.swing.JTextField refund;
    private javax.swing.JTextField seattype;
    private javax.swing.JTextField source;
    private javax.swing.JComboBox<String> ticID;
    private javax.swing.JTextField ticPrice;
    // End of variables declaration//GEN-END:variables
}
