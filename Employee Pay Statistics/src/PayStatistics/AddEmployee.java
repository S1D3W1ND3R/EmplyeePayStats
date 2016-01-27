package PayStatistics;

import PayStatistics.Employee;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AddEmployee extends javax.swing.JDialog {

    //Instance Variables:
    private String name;
    private float hours;
    private float rate;
    private Employee newEmployee;

    public AddEmployee() {
        initComponents();
        // center form
        this.setLocationRelativeTo(null);
        // set default button to add
        this.getRootPane().setDefaultButton(saveJButton);
        // add icon to the form
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/PayStatistics/EmployeeLogo.jpg"));
        nameJTextField.requestFocus();
        newEmployee = null;
        this.setAlwaysOnTop(true);
        this.setModal(true); //vital!!!
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJPanel = new javax.swing.JPanel();
        displayJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        hoursJLabel = new javax.swing.JLabel();
        hoursJTextField = new javax.swing.JTextField();
        rateJLabel = new javax.swing.JLabel();
        rateJTextField = new javax.swing.JTextField();
        controlJButton3 = new javax.swing.JPanel();
        saveJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Employee");
        setAlwaysOnTop(true);
        setModal(true);
        setPreferredSize(new java.awt.Dimension(500, 359));
        setResizable(false);

        titleJPanel.setLayout(new java.awt.GridLayout());

        displayJPanel.setPreferredSize(new java.awt.Dimension(400, 75));
        displayJPanel.setLayout(new java.awt.GridLayout(3, 2));

        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("Name of Employee: ");
        displayJPanel.add(nameJLabel);
        displayJPanel.add(nameJTextField);

        hoursJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hoursJLabel.setText("Hours Worked Weekly:");
        displayJPanel.add(hoursJLabel);
        displayJPanel.add(hoursJTextField);

        rateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rateJLabel.setText("Hourly Pay Rate:");
        displayJPanel.add(rateJLabel);
        displayJPanel.add(rateJTextField);

        controlJButton3.setPreferredSize(new java.awt.Dimension(724, 100));
        controlJButton3.setLayout(new java.awt.GridLayout());

        saveJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        saveJButton.setMnemonic('s');
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        controlJButton3.add(saveJButton);

        cancelJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelJButton.setMnemonic('c');
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });
        controlJButton3.add(cancelJButton);

        titleJLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleJLabel.setText("Add New Employee");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(titleJLabel)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(48, Short.MAX_VALUE)
                    .addComponent(controlJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(titleJLabel)
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(106, 106, 106)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(264, Short.MAX_VALUE)
                    .addComponent(controlJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed

        //Create an instance of a new employee jdialog to get the employee
        // and add it to the database -- need validation
        try {
            //Create an instance of AddEmployee JDialog
            name = nameJTextField.getText();
            hours = Float.parseFloat(hoursJTextField.getText());
            rate = Float.parseFloat(rateJTextField.getText());

            //Get the newly created employee forom the JDialog object
            newEmployee = new Employee(name, hours, rate);
            this.dispose();
            //Create the employee and add to the arraylist and file
            
        } catch (NullPointerException nullexp) {
            nullexp.printStackTrace();
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    public Employee getEmployee() {
        return newEmployee;
    }

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJButton;
    private javax.swing.JPanel controlJButton3;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel hoursJLabel;
    private javax.swing.JTextField hoursJTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel rateJLabel;
    private javax.swing.JTextField rateJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    // End of variables declaration//GEN-END:variables
}
