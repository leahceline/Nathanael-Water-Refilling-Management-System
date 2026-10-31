/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ashley babaylan
 */
public class ArchiveFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ArchiveFrame.class.getName());

    /**
     * Creates new form ArchiveReportFrame
     */
    public ArchiveFrame() {
    initComponents();

    // Allow setBounds() to control the layout
    getContentPane().setLayout(null);

    // Background - same as CustomerFrame
    getContentPane().setBackground(
            new java.awt.Color(205, 235, 248)
    );

    // Fullscreen
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    // =========================
    // COLORS
    // =========================

    java.awt.Color buttonBlue =
            new java.awt.Color(43, 145, 225);

    java.awt.Color darkBlue =
            new java.awt.Color(8, 82, 150);

    java.awt.Color white =
            java.awt.Color.WHITE;

    // =========================
    // BUTTON STYLING
    // =========================

    btnBack.setBackground(buttonBlue);
    btnBack.setForeground(white);
    btnBack.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            14
    ));
    btnBack.setFocusPainted(false);
    btnBack.setBorderPainted(false);

    btnRestore.setBackground(buttonBlue);
    btnRestore.setForeground(white);
    btnRestore.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            14
    ));
    btnRestore.setFocusPainted(false);
    btnRestore.setBorderPainted(false);

    btnSearch.setBackground(buttonBlue);
    btnSearch.setForeground(white);
    btnSearch.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            13
    ));
    btnSearch.setFocusPainted(false);
    btnSearch.setBorderPainted(false);

    btnClearSearch.setBackground(buttonBlue);
    btnClearSearch.setForeground(white);
    btnClearSearch.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            13
    ));
    btnClearSearch.setFocusPainted(false);
    btnClearSearch.setBorderPainted(false);

    // =========================
    // LABEL STYLING
    // =========================

    lblArchiveTitle.setForeground(darkBlue);
    lblArchiveTitle.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            28
    ));

    lblSearchArchivedCustomer.setForeground(darkBlue);
    lblSearchArchivedCustomer.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.BOLD,
            14
    ));

    // =========================
    // SEARCH FIELD
    // =========================

    txtSearch.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.PLAIN,
            14
    ));

    // =========================
    // TABLE STYLING
    // =========================

    tblArchive.setRowHeight(32);

    tblArchive.setFont(new java.awt.Font(
            "SansSerif",
            java.awt.Font.PLAIN,
            13
    ));

    tblArchive.setSelectionMode(
            javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblArchive.getTableHeader().setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    13
            )
    );

    tblArchive.getTableHeader().setPreferredSize(
            new java.awt.Dimension(0, 32)
    );

    tblArchive.getTableHeader().setBackground(
            new java.awt.Color(225, 242, 250)
    );

    tblArchive.getTableHeader().setForeground(
            darkBlue
    );

    // Center table values
    javax.swing.table.DefaultTableCellRenderer centerRenderer =
            new javax.swing.table.DefaultTableCellRenderer();

    centerRenderer.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );

    tblArchive.getColumnModel().getColumn(0)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel().getColumn(1)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel().getColumn(2)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel().getColumn(3)
            .setCellRenderer(centerRenderer);

    // Address column stays left-aligned

    // =========================
    // CENTER COMPONENTS
    // =========================

    javax.swing.SwingUtilities.invokeLater(() -> {
        centerArchiveComponents();
    });

    // Re-center when window is resized
    addComponentListener(
        new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent evt) {

                centerArchiveComponents();
            }
        }
    );
    loadArchivedCustomers();
}

    private void loadArchivedCustomers() {

    ArchiveDAO dao = new ArchiveDAO();

    java.util.List<String[]> customers =
            dao.getArchivedCustomers();

    javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(
                    new String[]{
                        "Customer ID",
                        "First Name",
                        "Last Name",
                        "Contact Number",
                        "Address"
                    },
                    0
            ) {

        @Override
        public boolean isCellEditable(
                int row,
                int column) {
            return false;
        }
    };

    for (String[] customer : customers) {

        model.addRow(customer);
    }

    tblArchive.setModel(model);

    tblArchive.setRowHeight(30);

    javax.swing.table.DefaultTableCellRenderer centerRenderer =
            new javax.swing.table.DefaultTableCellRenderer();

    centerRenderer.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );

    // Center these columns
    tblArchive.getColumnModel()
            .getColumn(0)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel()
            .getColumn(1)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel()
            .getColumn(2)
            .setCellRenderer(centerRenderer);

    tblArchive.getColumnModel()
            .getColumn(3)
            .setCellRenderer(centerRenderer);

    // Address stays left-aligned
}
    
    private void centerArchiveComponents() {

    int panelWidth = getContentPane().getWidth();

    // =========================
    // BACK BUTTON
    // =========================
    btnBack.setBounds(
            20,
            35,
            110,
            45
    );

    // =========================
    // TITLE - CENTERED
    // =========================
    int titleWidth = 600;

    lblArchiveTitle.setBounds(
            (panelWidth - titleWidth) / 2,
            55,
            titleWidth,
            50
    );

    lblArchiveTitle.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );

    // =========================
    // MAIN BUTTONS
    // =========================
    
    int buttonWidth = 180;
    int buttonHeight = 55;
    int buttonGap = 15;

    int totalButtonWidth =
            (buttonWidth * 3) + (buttonGap * 2);

    int buttonX =
            (panelWidth - totalButtonWidth) / 2;
    
    int restoreWidth = 195;
    int restoreX = (getContentPane().getWidth() - restoreWidth) / 2;

    btnRestore.setBounds(
        restoreX,
        135,
        restoreWidth,
        60
    );
    // =========================
    // SEARCH AREA
    // =========================
    int searchLabelWidth = 210;
    int searchFieldWidth = 270;
    int searchButtonWidth = 150;
    int searchGap = 15;

    int totalSearchWidth =
            searchLabelWidth
            + searchFieldWidth
            + searchButtonWidth
            + searchButtonWidth
            + (searchGap * 3);

    int searchX =
            (panelWidth - totalSearchWidth) / 2;

    lblSearchArchivedCustomer.setBounds(
        searchX,
        215,
        searchLabelWidth,
        40
);

    txtSearch.setBounds(
            searchX + searchLabelWidth + searchGap,
            210,
            searchFieldWidth,
            45
    );

    btnSearch.setBounds(
            searchX
            + searchLabelWidth
            + searchGap
            + searchFieldWidth
            + searchGap,
            210,
            searchButtonWidth,
            45
    );

    btnClearSearch.setBounds(
            searchX
            + searchLabelWidth
            + searchGap
            + searchFieldWidth
            + searchGap
            + searchButtonWidth
            + searchGap,
            210,
            searchButtonWidth,
            45
    );

    // =========================
    // TABLE
    // =========================
    int tableWidth = 925;
    int tableHeight = 500;

    jScrollPane2.setBounds(
            (panelWidth - tableWidth) / 2,
            290,
            tableWidth,
            tableHeight
    );

    getContentPane().revalidate();
    getContentPane().repaint();
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArchiveTitle = new javax.swing.JLabel();
        btnRestore = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArchive = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblSearchArchivedCustomer = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClearSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lblArchiveTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblArchiveTitle.setText("ARCHIVED CUSTOMERS");

        btnRestore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRestore.setText("RESTORE");
        btnRestore.addActionListener(this::btnRestoreActionPerformed);

        tblArchive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order_ID", "Customer", "Date", "Total", "Payment Method"
            }
        ));
        jScrollPane2.setViewportView(tblArchive);
        if (tblArchive.getColumnModel().getColumnCount() > 0) {
            tblArchive.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblArchive.getColumnModel().getColumn(4).setHeaderValue("Payment Method");
        }

        btnBack.setText("← Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        lblSearchArchivedCustomer.setText("Search Archived Customer:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnClearSearch.setText("Clear");
        btnClearSearch.addActionListener(this::btnClearSearchActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnBack)
                                .addGap(48, 48, 48)
                                .addComponent(lblArchiveTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRestore)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSearchArchivedCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearSearch)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArchiveTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchArchivedCustomer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)
                        .addComponent(btnClearSearch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed

        int selectedRow = tblArchive.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a customer first."
            );

            return;
        }

        int customerId = Integer.parseInt(
                tblArchive.getValueAt(selectedRow, 0).toString()
        );

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to restore this customer?",
                "Confirm Restore",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        ArchiveDAO dao = new ArchiveDAO();

        boolean success =
                dao.restoreCustomer(customerId);

        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Customer restored successfully!"
            );

            loadArchivedCustomers();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to restore customer."
            );
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText =
            txtSearch.getText().trim().toLowerCase();

        DefaultTableModel model =
                (DefaultTableModel) tblArchive.getModel();

        model.setRowCount(0);

        ArchiveDAO dao = new ArchiveDAO();

        java.util.List<String[]> customers =
                dao.getArchivedCustomers();

        for (String[] customer : customers) {

            String firstName =
                    customer[1].toLowerCase();

            String lastName =
                    customer[2].toLowerCase();

            String fullName =
                    (firstName + " " + lastName).toLowerCase();

            String contact =
                    customer[3].toLowerCase();

            if (firstName.contains(searchText)
                    || lastName.contains(searchText)
                    || fullName.contains(searchText)
                    || contact.contains(searchText)) {

                model.addRow(customer);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        txtSearch.setText("");

        loadArchivedCustomers();
    }//GEN-LAST:event_btnClearSearchActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ArchiveFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArchiveTitle;
    private javax.swing.JLabel lblSearchArchivedCustomer;
    private javax.swing.JTable tblArchive;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
