/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.waterrefillingstation;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class ReportFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportFrame.class.getName());

    /**
     * Creates new form ReportFrame
     */
public ReportFrame() {
    initComponents();
    
    tblReports.setDefaultEditor(Object.class, null);
    tblReports.getTableHeader().setFont(
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13)
);
    
    // =========================
// GUI DESIGN
// =========================

// Background
getContentPane().setBackground(
    new java.awt.Color(205, 235, 248)
);

// Main title
lblReportTitle.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 28)
);

lblReportTitle.setForeground(
    new java.awt.Color(8, 82, 150)
);

lblReportTitle.setHorizontalAlignment(
    javax.swing.SwingConstants.CENTER
);

// Labels
jLabel1.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);

jLabel1.setForeground(
    new java.awt.Color(8, 82, 150)
);

jLabel2.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
);

jLabel2.setForeground(
    new java.awt.Color(8, 82, 150)
);

// Text field
txtSearch.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14)
);

txtSearch.setForeground(java.awt.Color.BLACK);
txtSearch.setBackground(java.awt.Color.WHITE);

// Combo box
cmbReportPeriod.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14)
);

cmbReportPeriod.setForeground(java.awt.Color.BLACK);
cmbReportPeriod.setBackground(java.awt.Color.WHITE);

// Buttons
java.awt.Font buttonFont =
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14);

java.awt.Color buttonBlue =
    new java.awt.Color(43, 145, 225);


btnSearch.setFont(buttonFont);
btnSearch.setBackground(buttonBlue);
btnSearch.setForeground(java.awt.Color.WHITE);

btnClearSearch.setFont(buttonFont);
btnClearSearch.setBackground(buttonBlue);
btnClearSearch.setForeground(java.awt.Color.WHITE);

btnBack.setFont(buttonFont);
btnBack.setBackground(buttonBlue);
btnBack.setForeground(java.awt.Color.WHITE);

// Table
tblReports.setFont(
    new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13)
);

tblReports.setRowHeight(30);

tblReports.getTableHeader().setFont(
    new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13)
);

tblReports.getTableHeader().setForeground(
    new java.awt.Color(8, 82, 150)
);

tblReports.getTableHeader().setPreferredSize(
    new java.awt.Dimension(0, 32)
);

tblReports.setRowHeight(28);

    // Allow manual positioning with setBounds()
    getContentPane().setLayout(null);

    javax.swing.table.DefaultTableCellRenderer centerRenderer =
        new javax.swing.table.DefaultTableCellRenderer();

    centerRenderer.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    for (int i = 0; i < tblReports.getColumnCount(); i++) {
        tblReports.getColumnModel()
                .getColumn(i)
                .setCellRenderer(centerRenderer);
    }

    getContentPane().setBackground(
        new java.awt.Color(205, 235, 248)
    );

    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    lblReportTitle.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

  

for (int i = 0; i < tblReports.getColumnCount(); i++) {
    tblReports.getColumnModel()
            .getColumn(i)
            .setCellRenderer(centerRenderer);
}

    // Background
    getContentPane().setBackground(
            new java.awt.Color(205, 235, 248)
    );

    // Fullscreen
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    // Title alignment
    lblReportTitle.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER
    );

    // Table styling
    tblReports.setRowHeight(30);

    tblReports.getTableHeader().setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.BOLD,
                    13
            )
    );

    tblReports.getTableHeader().setPreferredSize(
            new java.awt.Dimension(0, 32)
    );

    tblReports.setFont(
            new java.awt.Font(
                    "SansSerif",
                    java.awt.Font.PLAIN,
                    13
            )
    );

    tblReports.setSelectionMode(
            javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    // Center components
    javax.swing.SwingUtilities.invokeLater(() -> {
        centerReportComponents();
    });

    addComponentListener(
            new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(
                        java.awt.event.ComponentEvent evt) {

                    centerReportComponents();
                }
            }
    );

    loadReports();
}

private void centerReportComponents() {

    int panelWidth = getContentPane().getWidth();

    int contentWidth = 900;

    int x = (panelWidth - contentWidth) / 2;

    // =========================
    // TITLE
    // =========================

    lblReportTitle.setBounds(
            x,
            40,
            contentWidth,
            40
    );

    // =========================
    // REPORT PERIOD
    // =========================

    jLabel2.setBounds(
            x + 100,
            120,
            150,
            30
    );

    cmbReportPeriod.setBounds(
            x + 260,
            115,
            200,
            40
    );

    // =========================
    // SEARCH
    // =========================

    jLabel1.setBounds(
            x + 100,
            185,
            150,
            30
    );

    txtSearch.setBounds(
            x + 260,
            180,
            320,
            40
    );

    btnSearch.setBounds(
            x + 600,
            180,
            130,
            40
    );

    btnClearSearch.setBounds(
            x + 750,
            180,
            150,
            40
    );

    // =========================
    // VIEW / CLEAR
    // =========================

    // =========================
    // TABLE
    // =========================

    jScrollPane1.setBounds(
    40,
    320,
    getContentPane().getWidth() - 80,
    490
);

    // =========================
    // BACK BUTTON
    // =========================

    btnBack.setBounds(
            20,
            35,
            110,
            45
    );

    getContentPane().revalidate();
    getContentPane().repaint();
}
    // centering code here

    
    private void loadReports() {

        String period =
                cmbReportPeriod.getSelectedItem().toString();

        ReportDAO dao =
                new ReportDAO();

        java.util.List<String[]> transactions =
                dao.getTransactionsByPeriod(period);

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel)
                tblReports.getModel();

        model.setColumnCount(12);

        model.setColumnIdentifiers(new Object[]{
            "Order ID",
            "Customer",
            "Address",
            "Date",
            "Order Type",
            "Delivery Status",
            "Delivery Fee",
            "Total",
            "Amount Paid",
            "Change",
            "Payment Method",
            "Reference Code"
        });

        model.setRowCount(0);

        for (String[] transaction : transactions) {

            model.addRow(transaction);
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

        lblReportTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClearSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbReportPeriod = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TRANSACTION REPORTS");
        setResizable(false);

        lblReportTitle.setText("TRANSACTION REPORTS");

        tblReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Date", "Order Type", "Delivery Status ", "Delivery Fee", "Total", "Amount Paid", "Change", "Payment Method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReports);

        btnBack.setText("← Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel1.setText("Search Transaction:");

        txtSearch.addActionListener(this::txtSearchActionPerformed);

        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnClearSearch.setText("Clear Search");
        btnClearSearch.addActionListener(this::btnClearSearchActionPerformed);

        jLabel2.setText("Report Period:");

        cmbReportPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Daily", "Weekly", "Monthly", "Yearly" }));
        cmbReportPeriod.addActionListener(this::cmbReportPeriodActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(298, 298, 298)
                        .addComponent(lblReportTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbReportPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSearch)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClearSearch))
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 474, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblReportTitle)
                    .addComponent(btnBack))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbReportPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnClearSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText =
            txtSearch.getText()
            .trim()
            .toLowerCase();

        String period =
                cmbReportPeriod.getSelectedItem().toString();

        DefaultTableModel model =
                (DefaultTableModel) tblReports.getModel();

        model.setRowCount(0);

        ReportDAO dao =
                new ReportDAO();

        java.util.List<String[]> transactions =
                dao.getTransactionsByPeriod(period);

        for (String[] transaction : transactions) {

            String orderId =
                    transaction[0].toLowerCase();

            String customer =
                    transaction[1].toLowerCase();

            if (orderId.contains(searchText)
                    || customer.contains(searchText)) {

                model.addRow(transaction);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        txtSearch.setText("");

        loadReports();
    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void cmbReportPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportPeriodActionPerformed
        loadReports();
    }//GEN-LAST:event_cmbReportPeriodActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ReportFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbReportPeriod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReportTitle;
    private javax.swing.JTable tblReports;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
