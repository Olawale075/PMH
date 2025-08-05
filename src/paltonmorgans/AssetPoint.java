/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paltonmorgans;

import com.fazecast.jSerialComm.SerialPort;
import java.util.List;
import java.util.ArrayList;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hp
 */
public class AssetPoint extends javax.swing.JFrame {

    /**
     * Creates new form Seler
     */
    String localhost = "jdbc:postgresql://dpg-d1t09bjipnbc7380ert0-a.oregon-postgres.render.com/pms_vel1";
    String username = "pms_vel1_user";
    String password = "IJuc6JpYRt8joqbzXYMe74uEAQtTIjzC";

    public AssetPoint() {
        initComponents();

        fetchAssetList();

        GetCat();
    }

    public void fetchAssetList() {
        try {
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();

            Rs = St.executeQuery("SELECT * FROM public.VIMP ORDER BY id ASC");

            AssetTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Connection con = null;
    Statement St = null;
    ResultSet Rs = null;

    @SuppressWarnings("unchecked")
    private void readBarcodeFromSerial() {
        SerialPort[] ports = SerialPort.getCommPorts();

        if (ports.length == 0) {
            JOptionPane.showMessageDialog(this, "No serial ports detected!");
            return;
        }

        SerialPort port = ports[0];
        port.setBaudRate(9600);

        if (port.openPort()) {
            JOptionPane.showMessageDialog(this, "Connected to " + port.getSystemPortName());

            new Thread(() -> {
                try (InputStream in = port.getInputStream()) {
                    StringBuilder buffer = new StringBuilder();
                    int data;
                    while ((data = in.read()) != -1) {
                        if (data == '\n' || data == '\r') {
                            if (buffer.length() > 0) {
                                final String result = buffer.toString().trim();

                                SwingUtilities.invokeLater(() -> {
                                    AssetCode.setText(result); // Set text field
                                    fetchAssetByBarcode(result); // Search DB and update table
                                });

                                buffer.setLength(0);
                            }
                        } else {
                            buffer.append((char) data);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    port.closePort();
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to open port!");
        }
    }

    private void fetchAssetByBarcode(String barcode) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(localhost, username, password); // ✅ fixed here

            String sql = "SELECT * FROM pmh.ASSET WHERE asset_code = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, barcode);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { // No data found
                JOptionPane.showMessageDialog(this, "No asset found for barcode: " + barcode);
                AssetCode.setText("");
                return;
            }

            // If data exists, load it into the table
            AssetTable.setModel(DbUtils.resultSetToTableModel(rs));
            AssetCode.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching asset: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AssetCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Location = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        DeleteBtn = new javax.swing.JButton();
        Filter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssetTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        AssetDesc = new javax.swing.JTable();
        AssetStatus = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("ASSET PIONT");

        AssetCode.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        AssetCode.setForeground(new java.awt.Color(255, 51, 0));
        AssetCode.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                AssetCodeComponentAdded(evt);
            }
        });
        AssetCode.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                AssetCodeHierarchyChanged(evt);
            }
        });
        AssetCode.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                AssetCodeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        AssetCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AssetCodeFocusGained(evt);
            }
        });
        AssetCode.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AssetCodeComponentShown(evt);
            }
        });
        AssetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssetCodeActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Asset Location");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("ASSETID");

        Location.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Location" }));
        Location.setToolTipText("");
        Location.setOpaque(true);
        Location.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LocationItemStateChanged(evt);
            }
        });
        Location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LocationMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("ASSET LIST");

        DeleteBtn.setBackground(new java.awt.Color(255, 204, 0));
        DeleteBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        DeleteBtn.setText("Refresh");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        Filter.setBackground(new java.awt.Color(255, 204, 0));
        Filter.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Filter.setText("filter");
        Filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FilterItemStateChanged(evt);
            }
        });
        Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterMouseClicked(evt);
            }
        });
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        AssetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "AssetCode", "AssetDesc", "PRODQTY", "AssetClass", "CATEGORY", "SerialNo", "Model", "Username", "Department", "Location", "Floor", "Building"
            }
        ));
        AssetTable.setSelectionBackground(new java.awt.Color(255, 204, 0));
        AssetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssetTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AssetTable);

        AssetDesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LOCID", "LOCAL NAME", "ADDRESS"
            }
        ));
        jScrollPane2.setViewportView(AssetDesc);

        AssetStatus.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AssetStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Staus", "Good", "Bad", "Disposed" }));
        AssetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssetStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AssetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AssetStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(488, 488, 488)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AssetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(AssetStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel7.setText("LogOut");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked
    int prid, newQty;

    private void GetCat() {
        try {
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();
            String query = "Select * FROM       pmh.LOCATIONTB";
            Rs = St.executeQuery(query);
            while (Rs.next()) {
                String Mycat = Rs.getString("LOCNAME");
                Location.addItem(Mycat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Double Uprice, ProdTot = 0.0, GrdTotal = 0.0;
    int AvailQty;
    int i = 0;
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new Login().setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void AssetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetTableMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) AssetTable.getModel();
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();
            int Myindex = AssetTable.getSelectedRow();
            Rs = St.executeQuery("Select * FROM       pmh.LOCATIONTB where LOCNAME='" + Location.getSelectedItem().toString() + "'");

            AssetDesc.setModel(DbUtils.resultSetToTableModel(Rs));
            AssetCode.setText(model.getValueAt(Myindex, 0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AssetTableMouseClicked

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterActionPerformed
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private void FilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterMouseClicked
        try {
    con = DriverManager.getConnection(localhost, username, password);  // ✅ Correct connection variable

    String selectedStatus = AssetStatus.getSelectedItem().toString();
    String selectedLocation = Location.getSelectedItem().toString();

    if (!selectedStatus.equals("Select Item Staus") && !selectedLocation.equals("Select Location")) {
        String sql = "SELECT * FROM pmh.ASSET WHERE asset_status = ? AND LOCATION = ?";
        pst = con.prepareStatement(sql);  // ✅ Use 'con' here
        pst.setString(1, selectedStatus);
        pst.setString(2, selectedLocation);
        rs = pst.executeQuery();
        AssetTable.setModel(DbUtils.resultSetToTableModel(rs));

    } else if (!selectedStatus.equals("Select Item Staus") && selectedLocation.equals("Select Location")) {
        String sql = "SELECT * FROM pmh.ASSET WHERE asset_status = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, selectedStatus);
        rs = pst.executeQuery();
        AssetTable.setModel(DbUtils.resultSetToTableModel(rs));

    } else if (selectedStatus.equals("Select Item Staus") && !selectedLocation.equals("Select Location")) {
        String sql = "SELECT * FROM pmh.ASSET WHERE LOCATION = ?";  // ✅ Fix: LOCATION, not asset_status
        pst = con.prepareStatement(sql);
        pst.setString(1, selectedLocation);  // ✅ Use location value, not asset status
        rs = pst.executeQuery();
        AssetTable.setModel(DbUtils.resultSetToTableModel(rs));

    } else {
        JOptionPane.showMessageDialog(null, "Input Your Parameter");
    }

} catch (Exception e) {
    e.printStackTrace();
}

        // TODO add your handling code here:
    }//GEN-LAST:event_FilterMouseClicked

    private void FilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FilterItemStateChanged
        try {
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();

            Rs = St.executeQuery("Select * FROM       pmh.LOCATIONTB where LOCNAME='" + Location.getSelectedItem().toString() + "'");

            AssetTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
            e.printStackTrace();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_FilterItemStateChanged

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        fetchAssetList();
        AssetCode.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        fetchAssetList();     // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void LocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LocationMouseClicked

    }//GEN-LAST:event_LocationMouseClicked

    private void LocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LocationItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_LocationItemStateChanged

    private void AssetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssetCodeActionPerformed
        searchBarcode(); // TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeActionPerformed

    private void AssetCodeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AssetCodeComponentShown
// TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeComponentShown

    private void AssetCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AssetCodeFocusGained
        searchBarcode();
// TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeFocusGained

    private void AssetCodeComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_AssetCodeComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeComponentAdded

    private void AssetCodeHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_AssetCodeHierarchyChanged
       ;// TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeHierarchyChanged

    private void AssetCodeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_AssetCodeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_AssetCodeAncestorAdded

    private void AssetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssetStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AssetStatusActionPerformed
    private void searchBarcode() {
        String barcode = AssetCode.getText().trim();
        if (!barcode.isEmpty()) {
            fetchAssetByBarcode(barcode);
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
            java.util.logging.Logger.getLogger(AssetPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssetPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssetPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssetPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssetPoint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AssetCode;
    private javax.swing.JTable AssetDesc;
    private javax.swing.JComboBox<String> AssetStatus;
    private javax.swing.JTable AssetTable;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton Filter;
    private javax.swing.JComboBox<String> Location;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
