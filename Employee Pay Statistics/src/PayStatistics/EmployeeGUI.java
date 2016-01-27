package PayStatistics;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class EmployeeGUI extends javax.swing.JFrame {

    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private final String fileName = "src/data/Employees.txt";
    private DecimalFormat number = new DecimalFormat("#,##0");

    /**
     * Creates new form EmployeeGUI
     */
    public EmployeeGUI() {
        initComponents();
        // Center the form:
        this.setLocationRelativeTo(null);
        // Set the default button to the display button:
        this.getRootPane().setDefaultButton(displayJButton);
        // Add an icon to the form:
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/PayStatistics/EmployeeLogo.jpg"));
        //Read employees from an external file and populate the arraylist:
        readFromFile(fileName);
        //Show the employee names in the combobox:
        fillComboBox();
        //Show the gross pay for the selected employee:

    }

    public void saveEmployees(String fileName) {
        try {
            FileWriter filePointer = new FileWriter(fileName, false);
            PrintWriter output = new PrintWriter(filePointer);
            //Go through emplyees arraylist, set temp to output format, output to file
            for (int i = 0; i < employees.size(); i++) {
                Employee tempEmployee = employees.get(i);
                String line = tempEmployee.getName()
                        + "," + tempEmployee.getHours()
                        + "," + tempEmployee.getRate();
                output.println(line);
            }
            output.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public void fillComboBox() {
        insertionSort(employees);
        String[] employeesNames = new String[employees.size()];
        for (int i = 0; i < employeesNames.length; i++) {
            employeesNames[i] = employees.get(i).getName();
        }
        employeeJComboBox.setModel(new DefaultComboBoxModel(employeesNames));
    }

    //javadocs needed for insertion sort
    public void insertionSort(ArrayList<Employee> employees) {
        int i, j;
        for (i = 0; i < employees.size(); i++) {
            Employee temp = employees.get(i);
            j = i - 1;
            while (j >= 0 && employees.get(j).getName().
                    compareToIgnoreCase(temp.getName()) > 0) {
                {
                    employees.set(j + 1, employees.get(j));
                    j--;
                }
                employees.set(j + 1, temp);
            }
        }
    }

    /**
     * Read from file
     *
     * @param file
     */
    public void readFromFile(String file) {
        try {
            employees.clear();
            FileReader inputFile = new FileReader(file);
            BufferedReader input = new BufferedReader(inputFile);
            String line = input.readLine();
            while (line != null) {
                Employee emp = new Employee();
                //use the stringtokenizer class to separate the file
                StringTokenizer token = new StringTokenizer(line, ",");
                while (token.hasMoreTokens()) {
                    emp.setName(token.nextToken());
                    emp.setHours(Float.parseFloat(token.nextToken()));
                    emp.setRate(Float.parseFloat(token.nextToken()));
                }
                //add the employee to the array list
                employees.add(emp);
                line = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
            //better:JFileChooser to select file
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    //Javadocs needed for searchEmployee
    private void searchEmployee(String name) {
        if (name != null && name.length() > 0) {
            // Sort JList by names

            // Create string array of names only
            String[] employeeArray = new String[employees.size()];
            for (int i = 0; i < employeeArray.length; i++) {
                employeeArray[i] = employees.get(i).getName();
            }

            // Call binary search to find the name
            int index = linearSearch(employeeArray, name);
            //int index = binarySearch(employeeArray, name);
            if (index == -1) {
                JOptionPane.showMessageDialog(null, name + " not found",
                        "Search Result", JOptionPane.INFORMATION_MESSAGE);
                employeeJComboBox.setSelectedIndex(0);
            } else {
                employeeJComboBox.setSelectedIndex(index);
            }
        }

    }

    public int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().contains(key.toLowerCase())) {
                return i;
            }
        }
        return -1; //employee not found
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
        titleJLabel = new javax.swing.JLabel();
        employeeInfoJPanel = new javax.swing.JPanel();
        employeeJLabel = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox<>();
        displayJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        statsJPanel = new javax.swing.JPanel();
        dataJScrollPane = new javax.swing.JScrollPane();
        dataJList = new javax.swing.JList<>();
        employeeJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        employeeJMenu = new javax.swing.JMenu();
        newJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        statisticsJMenu = new javax.swing.JMenu();
        meanJMenuItem = new javax.swing.JMenuItem();
        medianJMenuItem = new javax.swing.JMenuItem();
        stdJMenuItem = new javax.swing.JMenuItem();
        allJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleJLabel.setText("Employee Gross Pay Statistics");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(titleJLabel)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(titleJLabel)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(titleJPanel, java.awt.BorderLayout.PAGE_START);

        employeeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeJLabel.setText("Select Employee");

        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        displayJButton.setText("Display Gross Pay");
        displayJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayJButtonActionPerformed(evt);
            }
        });

        quitJButton.setText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeInfoJPanelLayout = new javax.swing.GroupLayout(employeeInfoJPanel);
        employeeInfoJPanel.setLayout(employeeInfoJPanelLayout);
        employeeInfoJPanelLayout.setHorizontalGroup(
            employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeInfoJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(employeeJLabel)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayJButton)
                    .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        employeeInfoJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {displayJButton, employeeJComboBox, quitJButton});

        employeeInfoJPanelLayout.setVerticalGroup(
            employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeJLabel)
                .addGap(16, 16, 16)
                .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitJButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        employeeInfoJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {displayJButton, employeeJComboBox, employeeJLabel, quitJButton});

        getContentPane().add(employeeInfoJPanel, java.awt.BorderLayout.LINE_START);

        dataJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dataJList.setPreferredSize(new java.awt.Dimension(225, 200));
        dataJScrollPane.setViewportView(dataJList);

        statsJPanel.add(dataJScrollPane);

        getContentPane().add(statsJPanel, java.awt.BorderLayout.CENTER);

        fileJMenu.setMnemonic('f');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('c');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('p');
        printJMenuItem.setText("Print");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        quitJMenuItem.setMnemonic('q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        employeeJMenuBar.add(fileJMenu);

        employeeJMenu.setMnemonic('e');
        employeeJMenu.setText("Employee Data");

        newJMenuItem.setMnemonic('n');
        newJMenuItem.setText("New Employee");
        newJMenuItem.setToolTipText("Add, Delete, Modify and Search Employees");
        newJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJMenuItemActionPerformed(evt);
            }
        });
        employeeJMenu.add(newJMenuItem);

        editJMenuItem.setMnemonic('e');
        editJMenuItem.setText("Edit Employee");
        employeeJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('d');
        deleteJMenuItem.setText("Delete Employee");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        employeeJMenu.add(deleteJMenuItem);

        searchJMenuItem.setMnemonic('s');
        searchJMenuItem.setText("Search Employee");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        employeeJMenu.add(searchJMenuItem);

        employeeJMenuBar.add(employeeJMenu);

        statisticsJMenu.setMnemonic('s');
        statisticsJMenu.setText("Statistics");

        meanJMenuItem.setMnemonic('m');
        meanJMenuItem.setText("Mean");
        meanJMenuItem.setToolTipText("");
        statisticsJMenu.add(meanJMenuItem);

        medianJMenuItem.setMnemonic('d');
        medianJMenuItem.setText("Median");
        statisticsJMenu.add(medianJMenuItem);

        stdJMenuItem.setMnemonic('s');
        stdJMenuItem.setText("Standard Deviation");
        stdJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdJMenuItemActionPerformed(evt);
            }
        });
        statisticsJMenu.add(stdJMenuItem);

        allJMenuItem.setMnemonic('t');
        allJMenuItem.setText("All Three");
        statisticsJMenu.add(allJMenuItem);

        employeeJMenuBar.add(statisticsJMenu);

        helpJMenu.setMnemonic('h');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('a');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        employeeJMenuBar.add(helpJMenu);

        setJMenuBar(employeeJMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        //Delete an Employee
        int result = JOptionPane.showConfirmDialog(null,
                "Are you sure that you wish to delete the employee?", "Delete Employee",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (result == 0) { //confirm yes
            int index = employeeJComboBox.getSelectedIndex();
            employees.remove(index);
            saveEmployees(fileName); //save to external file
            fillComboBox();
        }
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    private void stdJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdJMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdJMenuItemActionPerformed

    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    private void displayJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayJButtonActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

    private void newJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJMenuItemActionPerformed
        try {
            //Create an instance of AddEmployee JDialog
            AddEmployee newEmployee = new AddEmployee();
            newEmployee.setVisible(true);

            //Get the newly created Employee forom the JDialog object
            Employee anEmployee = newEmployee.getEmployee();
            //Create the employee and add to the arraylist and file
            if (anEmployee != null) { //&& !employeeExists(anEmployee)
                //Add employee to arraylist, to database and update display
                employees.add(anEmployee);
                searchEmployee(anEmployee.getName());
                fillComboBox();
                saveEmployees(fileName);
            }
        } catch (NullPointerException nullexp) {
            nullexp.printStackTrace();
        }
    }//GEN-LAST:event_newJMenuItemActionPerformed

    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        //Find specified employee
        String employeeName = JOptionPane.showInputDialog("Enter name of employee:");
        searchEmployee(employeeName);
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem allJMenuItem;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JList<String> dataJList;
    private javax.swing.JScrollPane dataJScrollPane;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JButton displayJButton;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JPanel employeeInfoJPanel;
    private javax.swing.JComboBox<String> employeeJComboBox;
    private javax.swing.JLabel employeeJLabel;
    private javax.swing.JMenu employeeJMenu;
    private javax.swing.JMenuBar employeeJMenuBar;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenuItem meanJMenuItem;
    private javax.swing.JMenuItem medianJMenuItem;
    private javax.swing.JMenuItem newJMenuItem;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JMenu statisticsJMenu;
    private javax.swing.JPanel statsJPanel;
    private javax.swing.JMenuItem stdJMenuItem;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    // End of variables declaration//GEN-END:variables
}
