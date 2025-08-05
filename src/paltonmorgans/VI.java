/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paltonmorgans;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Color;
import java.awt.Window;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class VI extends javax.swing.JFrame {

    private JTextField AssetCode;
    private StringBuilder barcode = new StringBuilder();
    private Timer timer;
    private DrawerController drawer;
public VI() {
        initComponents();
        drawerFields();
        fetchAssetList();
        GetCat();
    }

    private void GetCat() {
        try {
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();
            String query = "Select * FROM public.departments";
            Rs = St.executeQuery(query);
            while (Rs.next()) {
                String Mycat = Rs.getString("NAME");
                Department.addItem(Mycat);
                Departments.addItem(Mycat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SerialNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AssetDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Model = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Accessories = new javax.swing.JComboBox<>();
        UpdateBtn = new javax.swing.JButton();
        FifterBtn = new javax.swing.JButton();
        CleanBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        TableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssetTable = new javax.swing.JTable();
        AssetClass = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Floor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Building = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ReconciliationRemark = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AssetCode1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AssetStatus1 = new javax.swing.JComboBox<>();
        Department = new javax.swing.JComboBox<>();
        Departments = new javax.swing.JComboBox<>();
        Location = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("MANAGE ASSET");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 144, 35));

        sn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(sn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 244, 27));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("SerialNo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 73, 28));

        SerialNo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(SerialNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 244, 27));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("S/N");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 73, 28));

        AssetDesc.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(AssetDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 244, 27));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("AssetDesc");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 76, 28));

        Model.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(Model, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 244, 27));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Model");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 76, 28));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("AssetStatus");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 35));

        Accessories.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Accessories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FURNITURE AND FITTINGS", "OFFICE EQUIPMENT", "COMPUTER EQUIPMENT", "MOTOR VEHICLE", "MACHINE AND PLANT", " " }));
        Accessories.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Accessories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccessoriesActionPerformed(evt);
            }
        });
        jPanel2.add(Accessories, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 241, 29));

        UpdateBtn.setBackground(new java.awt.Color(255, 153, 0));
        UpdateBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        UpdateBtn.setText("Edit");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 90, 33));

        FifterBtn.setBackground(new java.awt.Color(255, 153, 0));
        FifterBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        FifterBtn.setText("Filter");
        FifterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FifterBtnMouseClicked(evt);
            }
        });
        FifterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FifterBtnActionPerformed(evt);
            }
        });
        jPanel2.add(FifterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 90, 33));

        CleanBtn.setBackground(new java.awt.Color(255, 153, 0));
        CleanBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        CleanBtn.setText("Clear");
        CleanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanBtnActionPerformed(evt);
            }
        });
        jPanel2.add(CleanBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 90, 33));

        AddBtn.setBackground(new java.awt.Color(255, 153, 0));
        AddBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel2.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 90, 33));

        TableTitle.setBackground(new java.awt.Color(255, 255, 255));
        TableTitle.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        TableTitle.setText("VI ASSET LIST");
        jPanel2.add(TableTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 368, 490, 35));

        AssetTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AssetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S/N", "AssetCode", "AssetDesc", "AssetClass", "SerialNo", "Model", "Username", "Asset Status", "Department", "Location", "Floor", "Building", "TaggingRemark REMARK "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AssetTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        AssetTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                AssetTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        AssetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssetTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AssetTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1330, 303));

        AssetClass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(AssetClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 140, 244, 27));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("AssetClass");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 76, 28));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Location");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 76, 28));

        Username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jPanel2.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 244, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Username");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 73, 28));

        Floor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(Floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, 244, 27));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("Department");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 89, 28));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("Floor");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 230, 76, 28));

        Building.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(Building, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 244, 27));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("Building");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 76, 28));

        ReconciliationRemark.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(ReconciliationRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 280, 244, 27));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("ReconciliationRemark");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, -1, 28));

        AssetCode1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(AssetCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 244, 27));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("AssetCode");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 90, 28));

        AssetStatus1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AssetStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select you Item", "Good", "Bad", "Disposed" }));
        jPanel2.add(AssetStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 241, 29));

        Department.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department" }));
        jPanel2.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 241, 29));

        Departments.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Departments.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Location" }));
        jPanel2.add(Departments, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, 241, 29));

        Location.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(Location, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 244, 27));

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jToggleButton1.setText("|||");
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1352, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccessoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccessoriesActionPerformed
       
    }//GEN-LAST:event_AccessoriesActionPerformed

    private void AssetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssetTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) AssetTable.getModel();
        int selectedRow = AssetTable.getSelectedRow();

        if (selectedRow != -1) {
            sn.setText(model.getValueAt(selectedRow, 0).toString());
            AssetCode1.setText(model.getValueAt(selectedRow, 1).toString());
            AssetDesc.setText(model.getValueAt(selectedRow, 2).toString());
            AssetClass.setText(model.getValueAt(selectedRow, 3).toString());
            SerialNo.setText(model.getValueAt(selectedRow, 4).toString());
            Model.setText(model.getValueAt(selectedRow, 5).toString());
            Username.setText(model.getValueAt(selectedRow, 6).toString());

            AssetStatus1.setSelectedItem(model.getValueAt(selectedRow, 7).toString());
            Department.setSelectedItem(model.getValueAt(selectedRow, 8).toString());

            Location.setText(model.getValueAt(selectedRow, 9).toString());
            Floor.setText(model.getValueAt(selectedRow, 10).toString());
            Building.setText(model.getValueAt(selectedRow, 11).toString());
            ReconciliationRemark.setText(model.getValueAt(selectedRow, 12).toString());

        }


    }//GEN-LAST:event_AssetTableMouseClicked
    private String getSafeString(DefaultTableModel model, int row, int col) {
        Object value = model.getValueAt(row, col);
        return value != null ? value.toString() : "";
    }
// this method is to drawe Fields...............................................
    private void drawerFields() {
        drawer = Drawer.newDrawer(this)
                .background(new Color(90, 90, 90))
                .closeOnPress(true)
                .backgroundTransparent(0.3f)
                .leftDrawer(true)
                .enableScroll(true)
                .enableScrollUI(false)
                .headerHeight(160)
                .space(3)
                .addChild(new DrawerItem("User").icon(new ImageIcon(getClass().getResource("/icon/user.png"))).build())
                .addChild(new DrawerItem("CHURCH GATE ABJ").icon(new ImageIcon(getClass().getResource("/icon/data.png"))).build())
                .addChild(new DrawerItem("VI").icon(new ImageIcon(getClass().getResource("/icon/data.png"))).build())
                .addChild(new DrawerItem("SANGOTEDO").icon(new ImageIcon(getClass().getResource("/icon/data.png"))).build())
                .addChild(new DrawerItem("IKEJA").icon(new ImageIcon(getClass().getResource("/icon/data.png"))).build())
                .addChild(new DrawerItem("VI OFFICE").icon(new ImageIcon(getClass().getResource("/icon/data.png"))).build())
                .addFooter(new DrawerItem("Exit").icon(new ImageIcon(getClass().getResource("/icon/exit.png"))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                        if (drawer.isShow()) {
                            drawer.hide();
                        }

                        String name = item.getName();  // Don't call trim immediately
                        if (index == 10) {
                            JOptionPane.showMessageDialog(null, "Drawer item name is null at index " + index);
                            return;
                        }

                        switch (index) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Drawer item name is null at index " + index);
                                break;
                            case 2:

                                JOptionPane.showMessageDialog(null, "Drawer item name is null at index " + index);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Drawer item name is null at index " + index);
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Drawer item name is null at index " + index);
                                break;
                            case 0:
                                new AssetPoint().setVisible(true);
                                dispose();  // Dispose this frame
                                break;
                            case 6:
                                new AssetPoint().setVisible(true);
                                dispose();  // Dispose this frame
                                break;
                            case 7:
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Unknown menu: " + name);
                        }
                    }

                })
                .build();
    }

    // this method is to update table .......................................................
    private void UpdateBtn() {
    String originalAssetCode = AssetCode1.getText().trim(); // Original code (used in WHERE clause)

    if (SerialNo.getText().trim().isEmpty() || AssetDesc.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Missing Required Information");
        return;
    }

    try {
        con = DriverManager.getConnection(localhost, username, password);

        String selectedAccessories = Accessories.getSelectedItem().toString().trim();
        String tableName = "";

        switch (selectedAccessories) {
            case "FURNITURE AND FITTINGS":
                tableName = "public.VIFAF";
                 JOptionPane.showMessageDialog(this, "FURNITURE AND FITTINGS Asset updated successfully!");
                break;
            case "COMPUTER EQUIPMENT":
                tableName = "public.VICEQ";
                 JOptionPane.showMessageDialog(this, "COMPUTER EQUIPMENT Asset updated successfully!");
                break;
            case "OFFICE EQUIPMENT":
                tableName = "public.VIOFEQ";
                 JOptionPane.showMessageDialog(this, "OFFICE EQUIPMENT Asset updated successfully!");
                break;
            case "MOTOR VEHICLE":
                tableName = "public.VIMAV"; 
 JOptionPane.showMessageDialog(this, "MOTOR VEHICLE Asset updated successfully!");// You had VIMP in insert, confirm correct table
                break;
            case "MACHINE AND PLANT":
                tableName = "public.VIMP";
                 JOptionPane.showMessageDialog(this, "MACHINE AND PLANT Asset updated successfully!");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown accessory type.");
                return;
        }

        String query = "UPDATE " + tableName + " SET "
                + "asset_code=?, asset_description=?, asset_class=?, serial_no=?, "
                + "model=?, user_name=?, asset_status=?, department=?, "
                + "location=?, floor=?, building=?, tagging_remark=? "
                + "WHERE asset_code=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, AssetCode1.getText().trim());
        pst.setString(2, AssetDesc.getText().trim());
        pst.setString(3, AssetClass.getText().trim());
        pst.setString(4, SerialNo.getText().trim());
        pst.setString(5, Model.getText().trim());
        pst.setString(6, Username.getText().trim());
        pst.setString(7, AssetStatus1.getSelectedItem() != null ? AssetStatus1.getSelectedItem().toString() : "");
        pst.setString(8, Department.getSelectedItem() != null ? Department.getSelectedItem().toString() : "");
        pst.setString(9, Location.getText().trim());
        pst.setString(10, Floor.getText().trim());
        pst.setString(11, Building.getText().trim());
        pst.setString(12, ReconciliationRemark.getText().trim());
        pst.setString(13, originalAssetCode);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
           
            fetchAssetList(); // Optional: Refresh table
        } else {
            JOptionPane.showMessageDialog(this, "Asset not found or update failed.");
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error occurred: " + e.getMessage());
    }
}

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        UpdateBtn();

    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void CleanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanBtnActionPerformed
        resetFields();        // TODO add your handling code here:
    }//GEN-LAST:event_CleanBtnActionPerformed

    private void AssetTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_AssetTableAncestorAdded

        int selectedRow = AssetTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row first.");
            return; // stop further execution
        }

// Now it's safe to get values
        DefaultTableModel model = (DefaultTableModel) AssetTable.getModel();

        sn.setText(getSafeValue(model, selectedRow, 0));
        AssetCode1.setText(getSafeValue(model, selectedRow, 1));
        AssetDesc.setText(getSafeValue(model, selectedRow, 2));
        AssetClass.setText(getSafeValue(model, selectedRow, 3));
        SerialNo.setText(getSafeValue(model, selectedRow, 4));
        Model.setText(getSafeValue(model, selectedRow, 5));
        Username.setText(getSafeValue(model, selectedRow, 6));
        Location.setText(getSafeValue(model, selectedRow, 10));
        Floor.setText(getSafeValue(model, selectedRow, 11));
        Building.setText(getSafeValue(model, selectedRow, 12));
        ReconciliationRemark.setText(getSafeValue(model, selectedRow, 13));

        // TODO add your handling code here:
    }//GEN-LAST:event_AssetTableAncestorAdded
    private String getSafeValue(DefaultTableModel model, int row, int col) {
        Object val = model.getValueAt(row, col);
        return val != null ? val.toString() : "";
    }
    private void FifterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FifterBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FifterBtnMouseClicked

    // THIS METHOD IS TO RESET ALL TESTFIELD .............................................
    private void resetFields() {
        sn.setText("");
        SerialNo.setText("");
        AssetCode1.setText("");
        AssetDesc.setText("");
        AssetClass.setText("");
        Model.setText("");
        Username.setText("");
        Location.setText("");
        Floor.setText("");
        Building.setText("");
        ReconciliationRemark.setText("");

        if (AssetStatus1 != null) {
            AssetStatus1.setSelectedIndex(-1);
        }
        if (Department != null) {
            Department.setSelectedIndex(-1);
        }

        // Optionally clear table selection
        if (AssetTable != null) {
            AssetTable.clearSelection();
        }
    }

    // THIS METHOD TO ADD ASSET........................................................
  private void addFields() {

    if (AssetDesc.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Missing required information!");
        return;
    }

    try {
        con = DriverManager.getConnection(localhost, username, password);

        String selectedAccessories = Accessories.getSelectedItem().toString().trim();
        String insertQuery = "";
        String title = "";

        // Decide which table to insert into based on selected accessory
        if (selectedAccessories.equals("FURNITURE AND FITTINGS")) {
            insertQuery = "INSERT INTO public.VIFAF ";
            title = "VI FURNITURE AND FITTINGS LIST FOR ";
        } else if (selectedAccessories.equals("COMPUTER EQUIPMENT")) {
            insertQuery = "INSERT INTO public.VICEQ ";
            title = "VI OFFICE EQUIPMENT LIST FOR ";
        } else if (selectedAccessories.equals("OFFICE EQUIPMENT")) {
            insertQuery = "INSERT INTO public.VIOFEQ ";
            title = "VI OFFICE FURNISHINGS LIST FOR ";
        } else if (selectedAccessories.equals("MOTOR VEHICLE")) {
            insertQuery = "INSERT INTO public.VIMP ";
            title = "VI MOTOR VEHICLE LIST FOR ";
        } else {
            fetchAssetList(); // fallback
            return;
        }

        // Check if asset_code already exists in the selected table
        String checkQuery = insertQuery.replace("INSERT INTO", "SELECT * FROM") + " WHERE asset_code = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
        checkStmt.setString(1, AssetCode1.getText().trim());
        ResultSet checkRs = checkStmt.executeQuery();
        if (checkRs.next()) {
            JOptionPane.showMessageDialog(this, "Asset with this code already exists!");
            return;
        }

        // Complete the insert query
        insertQuery += "(asset_code, asset_description, asset_class, serial_no, model, user_name, asset_status, department, location, floor, building, tagging_remark) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(insertQuery);

        pst.setString(1, AssetCode1.getText().trim());
        pst.setString(2, AssetDesc.getText(). trim());
        pst.setString(3, AssetClass.getText().trim());
        pst.setString(4, SerialNo.getText().trim());
        pst.setString(5, Model.getText().trim());
        pst.setString(6, Username.getText().trim());
        pst.setString(7, AssetStatus1.getSelectedItem() != null ? AssetStatus1.getSelectedItem().toString() : "");
        pst.setString(8, Department.getSelectedItem() != null ? Department.getSelectedItem().toString() : "");
        pst.setString(9, Location.getText().trim());
        pst.setString(10, Floor.getText().trim());
        pst.setString(11, Building.getText().trim());
        pst.setString(12, ReconciliationRemark.getText().trim());

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Asset added successfully!");
            fetchAssetList(); // Optional: Refresh table data
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add asset.");
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

}
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        addFields(); // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    //THIS METHOD IS TO FIFTER 
   private void FifterBtn() {
    try {
        String selectedDept = Department.getSelectedItem() != null ? Department.getSelectedItem().toString().trim() : "";
        String selectedAccessories = Accessories.getSelectedItem() != null ? Accessories.getSelectedItem().toString().trim() : "";

        if (selectedDept.isEmpty() || selectedAccessories.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select both Department and Accessories.");
            return;
        }

        String sql = "";
        String title = "";

        switch (selectedAccessories) {
            case "FURNITURE AND FITTINGS":
                sql = "SELECT * FROM public.VIFAF WHERE department = ? ORDER BY id ASC";
                title = "VI FURNITURE AND FITTINGS LIST FOR " + selectedDept;
                break;
            case "COMPUTER EQUIPMENT":
                sql = "SELECT * FROM public.VICEQ WHERE department = ? ORDER BY id ASC";
                title = "VI COMPUTER EQUIPMENT LIST FOR " + selectedDept;
                break;
            case "OFFICE EQUIPMENT":
                sql = "SELECT * FROM public.VIOFEQ WHERE department = ? ORDER BY id ASC";
                title = "VI OFFICE EQUIPMENT LIST FOR " + selectedDept;
                break;
            case "MOTOR VEHICLE":
                sql = "SELECT * FROM public.VIMAV WHERE department = ? ORDER BY id ASC";
                title = "VI MOTOR VEHICLE LIST FOR " + selectedDept;
                break;
            case "MACHINE AND PLANT":
                sql = "SELECT * FROM public.VIMP WHERE department = ? ORDER BY id ASC";
                title = "VI MACHINE AND PLANT LIST FOR " + selectedDept;
                break;
            default:
                fetchAssetList(); // fallback
                return;
        }

        con = DriverManager.getConnection(localhost, username, password);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, selectedDept);
        ResultSet rs = pst.executeQuery();

        AssetTable.setModel(DbUtils.resultSetToTableModel(rs));
        TableTitle.setText(title);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    private void FifterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FifterBtnActionPerformed

        FifterBtn();
     }//GEN-LAST:event_FifterBtnActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }     }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void readBarcodeFromSerial() {
        SerialPort[] ports = SerialPort.getCommPorts();

        if (ports.length == 0) {
            JOptionPane.showMessageDialog(this, "No serial ports detected!");
            return;
        }

        // Print available ports
        for (SerialPort p : ports) {
            System.out.println("Available port: " + p.getSystemPortName());
        }

        SerialPort port = ports[0]; // You can update this to a specific COM port
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
                                final String result = buffer.toString().trim().replace('#', '/').toUpperCase();

                                SwingUtilities.invokeLater(() -> {
                                    AssetCode1.setText(result);
                                    fetchAssetByBarcode(result);
                                });
                                SwingUtilities.invokeLater(() -> AssetCode1.requestFocusInWindow());

                                buffer.setLength(0);
                            }
                        } else {
                            buffer.append((char) data);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error reading from serial port:\n" + ex.getMessage());
                } finally {
                    port.closePort();
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to open port!");
        }
    }

    String localhost = "jdbc:postgresql://dpg-d1t09bjipnbc7380ert0-a.oregon-postgres.render.com/pms_vel1";
    String username = "pms_vel1_user";
    String password = "IJuc6JpYRt8joqbzXYMe74uEAQtTIjzC";

//String[] AssetStatus = {"Item 1", "Item 2", "Item 3"};
    private String getStringValue(Object value) {
        return value != null ? value.toString() : "";
    }

    private void searchBarcode() {
        String barcode = AssetCode1.getText().trim().toUpperCase();

        sn.setText(barcode);
        if (!barcode.isEmpty()) {
            fetchAssetByBarcode(barcode);
        }
    }
    Connection con = null;
    Statement St = null;
    ResultSet Rs = null;

    public void fetchAssetList() {
        String selectedDept = Department.getSelectedItem().toString();
        String selectedAccessories = Accessories.getSelectedItem().toString();

        try {
            con = DriverManager.getConnection(localhost, username, password);
            St = con.createStatement();

            if (selectedAccessories.equals("FURNITURE AND FITTINGS")) {
                Rs = St.executeQuery("SELECT * FROM public.VIFAF ORDER BY id ASC");
                TableTitle.setText("VI FURNITURE AND FITTINGS LIST");
            } else if (selectedAccessories.equals("OFFICE EQUIPMENT")) {
                TableTitle.setText("VI OFFICE EQUIPMENT LIST");
                Rs = St.executeQuery("SELECT * FROM public.VICEQ ORDER BY id ASC");
            } else if (selectedAccessories.equals("MOTOR VEHICLE")) {
                TableTitle.setText("VI OFFICE FURNISHINGS LIST");
                Rs = St.executeQuery("SELECT * FROM public.VIMAV ORDER BY id ASC");
            } else if (selectedAccessories.equals("COMPUTER EQUIPMENT")) {
                TableTitle.setText("VI COMPUTER EQUIPMENT LIST");
                Rs = St.executeQuery("SELECT * FROM public.VICEQ ORDER BY id ASC");
            } else {
                TableTitle.setText("VI MACHINE AND PLATING LIST");
                Rs = St.executeQuery("SELECT * FROM public.VIMP ORDER BY id ASC");
            }

            AssetTable.setModel(DbUtils.resultSetToTableModel(Rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchAssetData() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(localhost, username, password);
            String asset_code = sn.getText().trim();

            String query = "SELECT * FROM public.VIFAF WHERE asset_code = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, asset_code);

            rs = pst.executeQuery();

            // Create table model with headers (column names based on your uploaded image)
            String[] columnNames = {
                "S/N", "ASSET CODE", "ASSET DESCRIPTION", "ASSET CLASS",
                "SERIAL NO.", "MODEL", "USER NAME", "AssetStatus1",
                "DEPARTMENT", "LOCATION", "FLOOR", "BUILDING", "TAGGING REMARK"
            };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            int serialNumber = 1;

            while (rs.next()) {
                Object[] row = new Object[]{
                    serialNumber++, // S/N
                    rs.getString("asset_code"),
                    rs.getString("asset_description"),
                    rs.getString("asset_class"),
                    rs.getString("serial_no"),
                    rs.getString("model"),
                    rs.getString("user_name"),
                    rs.getString("asset_status"),
                    rs.getString("department"),
                    rs.getString("location"),
                    rs.getString("floor"),
                    rs.getString("building"),
                    rs.getString("tagging_remark") // Assuming this is "TAGGING REMARK"
                };
                model.addRow(row);
            }

            AssetTable.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching asset data: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void fetchAssetByBarcode(String barcode) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        // List of views to search
        String[] views = {
            "public.VIFAF",
            "public.VICEQ",
            "public.VIMAV",
            "public.VIMP",
            "public.VIOFEQ"
        };

        try {
            conn = DriverManager.getConnection(localhost, username, password);

            boolean assetFound = false;

            for (String view : views) {
                String sql = "SELECT * FROM " + view + " WHERE asset_code = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, barcode);
                rs = pst.executeQuery();

                if (rs.isBeforeFirst()) { // Data found
                    AssetTable.setModel(DbUtils.resultSetToTableModel(rs));
                    sn.setText("");
                    assetFound = true;
                    break;
                }
                // Close previous ResultSet before next query
                rs.close();
                pst.close();
            }

            if (!assetFound) {
                JOptionPane.showMessageDialog(this, "No asset found for barcode: " + barcode);
                AssetCode1.setText("");
            }

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
            java.util.logging.Logger.getLogger(VI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Accessories;
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField AssetClass;
    private javax.swing.JTextField AssetCode1;
    private javax.swing.JTextField AssetDesc;
    private javax.swing.JComboBox<String> AssetStatus1;
    private javax.swing.JTable AssetTable;
    private javax.swing.JTextField Building;
    private javax.swing.JButton CleanBtn;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JComboBox<String> Departments;
    private javax.swing.JButton FifterBtn;
    private javax.swing.JTextField Floor;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField Model;
    private javax.swing.JTextField ReconciliationRemark;
    private javax.swing.JTextField SerialNo;
    private javax.swing.JLabel TableTitle;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField sn;
    // End of variables declaration//GEN-END:variables
}
