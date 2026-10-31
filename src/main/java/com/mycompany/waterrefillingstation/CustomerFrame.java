/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;

import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ashley babaylan
 */
public class CustomerFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerFrame.class.getName());

    /**
     * Creates new form CustomerFrame
     */
    public CustomerFrame() {
    initComponents();
    
    tblCustomers.setDefaultEditor(Object.class, null);
    getContentPane().setLayout(null);

    tblCustomers.setRowHeight(30);

    tblCustomers.setFont(
        new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13)
    );

    tblCustomers.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblCustomers.getTableHeader().setFont(
        new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13)
    );

    tblCustomers.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 32)
    );

    tblCustomers.getTableHeader().setBackground(
        new java.awt.Color(225, 240, 250)
    );

    tblCustomers.getTableHeader().setForeground(
        new java.awt.Color(0, 82, 150)
    );

    getContentPane().setBackground(
        new java.awt.Color(205, 235, 248)
    );

    setExtendedState(
        javax.swing.JFrame.MAXIMIZED_BOTH
    );

    javax.swing.SwingUtilities.invokeLater(() -> {
        centerCustomerComponents();
    });

    addComponentListener(
        new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent evt) {

                centerCustomerComponents();
            }
        }
    );

    formatCustomerTable();
    
    // ==========================================
// CENTER TABLE VALUES
// ==========================================

javax.swing.table.DefaultTableCellRenderer centerRenderer =
        new javax.swing.table.DefaultTableCellRenderer();

centerRenderer.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
);

tblCustomers.getColumnModel()
        .getColumn(0)
        .setCellRenderer(centerRenderer);

tblCustomers.getColumnModel()
        .getColumn(1)
        .setCellRenderer(centerRenderer);

tblCustomers.getColumnModel()
        .getColumn(2)
        .setCellRenderer(centerRenderer);

tblCustomers.getColumnModel()
        .getColumn(3)
        .setCellRenderer(centerRenderer);
    loadCustomers();
}
    
    private void centerCustomerComponents() {

    int panelWidth = getContentPane().getWidth();

        // ==========================================
    // BACK BUTTON
    // ==========================================

    btnBack.setBounds(
            20,
            60,
            120,
            50
    );
    // ==========================================
    // MAIN TITLE
    // ==========================================

    int titleWidth = 500;
    int titleX = (panelWidth - titleWidth) / 2;

    lblCustomerTitle.setBounds(
            titleX,
            35,
            titleWidth,
            40
    );


    // ==========================================
    // CUSTOMER INFORMATION
    // ==========================================

    int formWidth = 500;
    int formX = (panelWidth - formWidth) / 2;

    lblCustomerInformation.setBounds(
            formX,
            95,
            formWidth,
            30
    );


    // Labels
    int labelX = formX;
    int fieldX = formX + 260;

    lblFirstName.setBounds(
            labelX,
            145,
            150,
            30
    );

    lblLastName.setBounds(
            labelX,
            185,
            150,
            30
    );

    lblContactNumber.setBounds(
            labelX,
            225,
            150,
            30
    );

    lblAddress.setBounds(
            labelX,
            265,
            150,
            30
    );


    // Text fields
    txtFirstName.setBounds(
            fieldX,
            140,
            240,
            35
    );

    txtLastName.setBounds(
            fieldX,
            180,
            240,
            35
    );

    txtContactNumber.setBounds(
            fieldX,
            220,
            240,
            35
    );

    txtAddress.setBounds(
            fieldX,
            260,
            240,
            35
    );


    // ==========================================
    // BUTTONS
    // ==========================================

    int buttonWidth = 120;
    int buttonHeight = 45;
    int buttonGap = 20;

    int totalButtonWidth =
            (buttonWidth * 4) + (buttonGap * 3);

    int buttonX =
            (panelWidth - totalButtonWidth) / 2;

    int buttonY = 320;

    btnAdd.setBounds(
            buttonX,
            buttonY,
            buttonWidth,
            buttonHeight
    );

    btnUpdate.setBounds(
            buttonX + buttonWidth + buttonGap,
            buttonY,
            buttonWidth,
            buttonHeight
    );

    btnArchive.setBounds(
            buttonX + (buttonWidth + buttonGap) * 2,
            buttonY,
            buttonWidth,
            buttonHeight
    );

    btnClear.setBounds(
            buttonX + (buttonWidth + buttonGap) * 3,
            buttonY,
            buttonWidth,
            buttonHeight
    );


    // ==========================================
    // CUSTOMER RECORDS TITLE
    // ==========================================

    int recordsWidth = 700;
    int recordsX =
            (panelWidth - recordsWidth) / 2;

    lblCustomerRecords.setBounds(
            recordsX,
            410,
            recordsWidth,
            35
    );


    // ==========================================
    // SEARCH
    // ==========================================

    int searchLabelWidth = 150;
    int searchFieldWidth = 270;
    int searchButtonWidth = 110;
    int clearButtonWidth = 110;
    int searchGap = 15;

    int searchTotalWidth =
            searchLabelWidth
            + searchFieldWidth
            + searchButtonWidth
            + clearButtonWidth
            + (searchGap * 3);

    int searchX =
            (panelWidth - searchTotalWidth) / 2;

    int searchY = 455;

    lblSearchCustomer.setBounds(
            searchX,
            searchY,
            searchLabelWidth,
            35
    );

    txtSearch.setBounds(
            searchX + searchLabelWidth + searchGap,
            searchY,
            searchFieldWidth,
            35
    );

    btnSearch.setBounds(
            searchX
            + searchLabelWidth
            + searchGap
            + searchFieldWidth
            + searchGap,
            searchY,
            searchButtonWidth,
            35
    );

    btnClearSearch.setBounds(
            searchX
            + searchLabelWidth
            + searchGap
            + searchFieldWidth
            + searchGap
            + searchButtonWidth
            + searchGap,
            searchY,
            clearButtonWidth,
            35
    );


    // ==========================================
    // CUSTOMER TABLE
    // ==========================================

    javax.swing.JScrollPane tableScrollPane =
            (javax.swing.JScrollPane)
            tblCustomers.getParent().getParent();

    int tableWidth = 1080;
    int tableHeight = 350;

    int tableX =
            (panelWidth - tableWidth) / 2;

    int tableY = 505;

    tableScrollPane.setBounds(
            tableX,
            tableY,
            tableWidth,
            tableHeight
    );


    // Refresh layout
    getContentPane().revalidate();
    getContentPane().repaint();
}
    

private void loadCustomers() {

    CustomerDAO dao = new CustomerDAO();

    java.util.List<String[]> customers = dao.getAllCustomers();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblCustomers.getModel();

    model.setRowCount(0);

    for (String[] customer : customers) {
        model.addRow(customer);
    }
}

private void formatCustomerTable() {

    DefaultTableCellRenderer leftRenderer =
            new DefaultTableCellRenderer();

    leftRenderer.setHorizontalAlignment(
            SwingConstants.LEFT
    );

    for (int i = 0; i < tblCustomers.getColumnCount(); i++) {

        tblCustomers
                .getColumnModel()
                .getColumn(i)
                .setCellRenderer(leftRenderer);
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

        jPasswordField1 = new javax.swing.JPasswordField();
        lblCustomerTitle = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnArchive = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblCustomerRecords = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblSearchCustomer = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClearSearch = new javax.swing.JButton();
        lblCustomerInformation = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(205, 235, 248));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 650));

        lblCustomerTitle.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblCustomerTitle.setForeground(new java.awt.Color(8, 82, 150));
        lblCustomerTitle.setText("CUSTOMER MANAGEMENT");

        lblFirstName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(8, 82, 150));
        lblFirstName.setText("First Name:");

        lblLastName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(8, 82, 150));
        lblLastName.setText("Last Name:");

        lblContactNumber.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblContactNumber.setForeground(new java.awt.Color(8, 82, 150));
        lblContactNumber.setText("Contact Number:");

        lblAddress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(8, 82, 150));
        lblAddress.setText("Address:");

        btnAdd.setBackground(new java.awt.Color(43, 145, 225));
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(43, 145, 225));
        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnArchive.setBackground(new java.awt.Color(43, 145, 255));
        btnArchive.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnArchive.setForeground(new java.awt.Color(255, 255, 255));
        btnArchive.setText("ARCHIVE");
        btnArchive.setFocusPainted(false);
        btnArchive.addActionListener(this::btnArchiveActionPerformed);

        btnClear.setBackground(new java.awt.Color(43, 145, 225));
        btnClear.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(this::btnClearActionPerformed);

        lblCustomerRecords.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblCustomerRecords.setForeground(new java.awt.Color(8, 82, 150));
        lblCustomerRecords.setText("Customer Records");

        tblCustomers.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "First Name", "Last Name", "Contact Number", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.setRowHeight(30);
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);
        if (tblCustomers.getColumnModel().getColumnCount() > 0) {
            tblCustomers.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblCustomers.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblCustomers.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblCustomers.getColumnModel().getColumn(3).setPreferredWidth(180);
            tblCustomers.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        txtFirstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtContactNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtAddress.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        btnBack.setBackground(new java.awt.Color(43, 145, 255));
        btnBack.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("← Back");
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this::btnBackActionPerformed);

        lblSearchCustomer.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSearchCustomer.setForeground(new java.awt.Color(8, 82, 150));
        lblSearchCustomer.setText("Search Customer:");

        txtSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        btnSearch.setBackground(new java.awt.Color(43, 145, 225));
        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH");
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnClearSearch.setBackground(new java.awt.Color(43, 145, 255));
        btnClearSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnClearSearch.setText("CLEAR");
        btnClearSearch.setFocusPainted(false);
        btnClearSearch.addActionListener(this::btnClearSearchActionPerformed);

        lblCustomerInformation.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCustomerInformation.setForeground(new java.awt.Color(8, 82, 150));
        lblCustomerInformation.setText("CUSTOMER INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(52, 52, 52)
                                .addComponent(lblCustomerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearchCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirstName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress)
                                    .addComponent(lblContactNumber)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLastName))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAddress)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblCustomerRecords)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCustomerInformation)
                .addGap(448, 448, 448))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCustomerInformation)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactNumber)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(lblCustomerRecords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchCustomer)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnClearSearch))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String firstName =
            txtFirstName.getText().trim();

        String lastName =
                txtLastName.getText().trim();

        String contactNumber =
                txtContactNumber.getText().trim();

        String address =
                txtAddress.getText().trim();

        // Check empty fields
        if (firstName.isEmpty()
                || lastName.isEmpty()
                || contactNumber.isEmpty()
                || address.isEmpty()) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please complete all customer information fields."
            );

            return;
        }

        // Validate names
        if (!firstName.matches("[a-zA-Z ]+")
                || !lastName.matches("[a-zA-Z ]+")) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "First Name and Last Name must contain letters only."
            );

            return;
        }

        // Validate contact number
        if (!contactNumber.matches("\\d{11}")) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Contact Number must contain exactly 11 digits."
            );

            return;
        }

        CustomerDAO dao = new CustomerDAO();

        // Check if customer already exists
        boolean duplicate = dao.customerExists(
                firstName,
                lastName,
                contactNumber,
                address,
                0
        );

        if (duplicate) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "A customer with the same information already exists."
            );

            return;
        }

        // Add customer
        boolean success = dao.addCustomer(
                firstName,
                lastName,
                contactNumber,
                address
        );

        if (success) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Customer added successfully."
            );

            loadCustomers();

            // Clear fields
            txtFirstName.setText("");
            txtLastName.setText("");
            txtContactNumber.setText("");
            txtAddress.setText("");

        } else {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Failed to add customer."
            );
        }
    
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    int selectedRow = tblCustomers.getSelectedRow();

    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please select a customer first."
        );
        return;
    }

    // Get OLD information from selected row
    String oldFirstName =
            tblCustomers.getValueAt(selectedRow, 1).toString();

    String oldLastName =
            tblCustomers.getValueAt(selectedRow, 2).toString();

    String oldContactNumber =
            tblCustomers.getValueAt(selectedRow, 3).toString();

    String oldAddress =
            tblCustomers.getValueAt(selectedRow, 4).toString();

    // Get NEW information from text fields
    String newFirstName =
            txtFirstName.getText().trim();

    String newLastName =
            txtLastName.getText().trim();

    String newContactNumber =
            txtContactNumber.getText().trim();

    String newAddress =
            txtAddress.getText().trim();

    // Check if there are NO changes
    if (oldFirstName.equals(newFirstName)
            && oldLastName.equals(newLastName)
            && oldContactNumber.equals(newContactNumber)
            && oldAddress.equals(newAddress)) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "No changes detected. Customer information is already up to date."
        );

        return;
    }

    // Check empty fields
    if (newFirstName.isEmpty()
            || newLastName.isEmpty()
            || newContactNumber.isEmpty()
            || newAddress.isEmpty()) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please complete all customer information fields."
        );

        return;
    }

    // Validate names
    if (!newFirstName.matches("[a-zA-Z ]+")
            || !newLastName.matches("[a-zA-Z ]+")) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "First Name and Last Name must contain letters only."
        );

        return;
    }

    // Validate contact number
    if (!newContactNumber.matches("\\d{11}")) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Contact Number must contain exactly 11 digits."
        );

        return;
    }

    // Get Customer ID
    int customerId = Integer.parseInt(
            tblCustomers.getValueAt(selectedRow, 0).toString()
    );

    CustomerDAO dao = new CustomerDAO();

    // Check if another customer already has the same information
    boolean duplicate = dao.customerExists(
            newFirstName,
            newLastName,
            newContactNumber,
            newAddress,
            customerId
    );

    if (duplicate) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "A customer with the same information already exists."
        );

        return;
    }

    // Update database
    boolean success = dao.updateCustomer(
            customerId,
            newFirstName,
            newLastName,
            newContactNumber,
            newAddress
    );

    if (success) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Customer updated successfully."
        );

        loadCustomers();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Failed to update customer."
        );
    }

    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed
                                        
    int selectedRow = tblCustomers.getSelectedRow();

    // Check if a customer is selected
    if (selectedRow == -1) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please select a customer first."
        );

        return;
    }

    // Get Customer ID from selected row
    int customerId = Integer.parseInt(
            tblCustomers.getValueAt(selectedRow, 0).toString()
    );

    // Archive customer
    CustomerDAO dao = new CustomerDAO();

    boolean success = dao.archiveCustomer(customerId);

    if (success) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Customer archived successfully."
        );

        // Refresh customer table
        loadCustomers();

        // Clear text fields
        txtFirstName.setText("");
        txtLastName.setText("");
        txtContactNumber.setText("");
        txtAddress.setText("");

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Failed to archive customer."
        );
    
}   // TODO add your handling code here:
    }//GEN-LAST:event_btnArchiveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtFirstName.setText("");
        txtLastName.setText("");
        txtContactNumber.setText("");
        txtAddress.setText("");
        
        tblCustomers.clearSelection();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
int selectedRow = tblCustomers.getSelectedRow();

if (selectedRow != -1) {

    txtFirstName.setText(
            tblCustomers.getValueAt(selectedRow, 1).toString()
    );

    txtLastName.setText(
            tblCustomers.getValueAt(selectedRow, 2).toString()
    );

    txtContactNumber.setText(
            tblCustomers.getValueAt(selectedRow, 3).toString()
    );

    txtAddress.setText(
            tblCustomers.getValueAt(selectedRow, 4).toString()
    );
}        // TODO add your handling code here:
    }//GEN-LAST:event_tblCustomersMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText = txtSearch.getText().trim().toLowerCase();

        DefaultTableModel model =
                (DefaultTableModel) tblCustomers.getModel();

        model.setRowCount(0);

        CustomerDAO dao = new CustomerDAO();

        java.util.List<String[]> customers =
                dao.getAllCustomers();

        for (String[] customer : customers) {

            String fullName =
                    (customer[1] + " " + customer[2]).toLowerCase();

            String contact =
                    customer[3].toLowerCase();

            if (fullName.contains(searchText)
                    || contact.contains(searchText)) {

                model.addRow(customer);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        txtSearch.setText("");

        loadCustomers();
    }//GEN-LAST:event_btnClearSearchActionPerformed

    /**
     * @param args the command line arguments */  public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CustomerFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblCustomerInformation;
    private javax.swing.JLabel lblCustomerRecords;
    private javax.swing.JLabel lblCustomerTitle;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSearchCustomer;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

