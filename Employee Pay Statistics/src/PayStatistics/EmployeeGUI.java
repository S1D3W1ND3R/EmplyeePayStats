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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * EmployeeGUI.java A class to manage employees and their pay statistics.
 * <pre>
 *      Project: Employee Pay Statistics (Project 1)
 *      Platform: jdk 8.0_66, Netbeans 8.1, Windows 10
 *      Course: CS 142C
 *      Hours: 10 hours
 *      Date: 1/27/2016
 *      Revision:
 * </pre>
 *
 * @author Mitchell Nye
 * @author Alexander Jordan
 * @version %1
 */
public class EmployeeGUI extends javax.swing.JFrame {

    // Instance variables:
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private final String fileName = "src/data/Employees.txt";
    private DecimalFormat number = new DecimalFormat("#,##0");

    /**
     * Creates new form EmployeeGUI
     *
     * @see readFromFile
     * @see displayEmployees
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
        displayEmployees();
        //Show the gross pay for the selected employee:

    }

    /**
     * readFromFile fills an array by reading a text file and separating data by
     * using the comma as a token.
     *
     * @param file
     */
    public void readFromFile(String file) {
        try {
            // Clear employees arrayList in case it has something in it:
            employees.clear();
            FileReader inputFile = new FileReader(file);
            BufferedReader input = new BufferedReader(inputFile);
            String line = input.readLine();
            // Read the file line by line:
            while (line != null) {
                Employee emp = new Employee();
                // StringTokenizer further seperates the data (using comma):
                StringTokenizer token = new StringTokenizer(line, ",");
                // Each line should have a name, hours and rate:
                while (token.hasMoreTokens()) {
                    emp.setName(token.nextToken());
                    emp.setHours(Float.parseFloat(token.nextToken()));
                    emp.setRate(Float.parseFloat(token.nextToken()));
                }
                // Add the temp employee (emp) to an index of employees:
                employees.add(emp);
                // Move to the next line (if there is one):
                line = input.readLine();
            }
            // Close the file:
            input.close();
            //Catch exceptions:
        } catch (FileNotFoundException exp) {
            // Implement JFileChooser in a later version:
            exp.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * displayEmployees displays the list of employees in the employeeJComboBox.
     *
     * @see insertionSort
     * @param fileName
     */
    private void displayEmployees() {
        // Create an arrayList that will hold employee names:
        String[] employeesNames = new String[employees.size()];
        // Sort the employees arraylist using insertion sort by name:
        insertionSort(employees);
        // Fill new string array with employee names:
        for (int i = 0; i < employeesNames.length; i++) {
            employeesNames[i] = employees.get(i).getName();
        }
        // Clear combobox and fill it with employee names:
        employeeJComboBox.removeAllItems();
        for (int i = 0; i < employees.size(); i++) {
            employeeJComboBox.addItem(employeesNames[i]);
        }
    }

    /**
     * saveEmployees writes the employees arrayList to a file.
     *
     * @param fileName
     */
    public void saveEmployees(String fileName) {
        try {
            FileWriter filePointer = new FileWriter(fileName, false);
            PrintWriter output = new PrintWriter(filePointer);
            // Go through employees arraylist, set temp to output format, 
            // output to file:
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

    /**
     * insertionSort places small values at the beginning of the list by
     * comparing two values at a time and swapping them if necessary.
     *
     * @param employees
     */
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
     * searchEmployee sorts the array, stores employee names in an arrayList,
     * then uses linear search to determine if there is a value that contains
     * the given String.
     *
     * @see insertionSort
     * @param name
     */
    private void searchEmployee(String name) {
        if (name != null && name.length() > 0) {
            // Sort employees by name:
            insertionSort(employees);
            // Create string array of names only:
            String[] employeeArray = new String[employees.size()];
            for (int i = 0; i < employeeArray.length; i++) {
                employeeArray[i] = employees.get(i).getName();
            }
            // Call linearSearch to find the name:
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

    /**
     * linearSearch checks if the array has an index that contains the same set
     * of Strings as the one given to it. It returns the index if it finds one,
     * and a -1 if it doesn't.
     *
     * @param array
     * @param key
     * @return
     */
    public int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().contains(key.toLowerCase())) {
                return i;
            }
        }
        // Employee not found:
        return -1;
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
        jScrollPane1 = new javax.swing.JScrollPane();
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
        setPreferredSize(new java.awt.Dimension(410, 280));
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleJLabel.setText("Employee Gross Pay Statistics");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel)
                .addGap(165, 165, 165))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(titleJLabel)
                .addContainerGap())
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
                .addGap(10, 10, 10)
                .addGroup(employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(employeeJLabel)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayJButton)
                    .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        employeeInfoJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {displayJButton, employeeJComboBox, quitJButton});

        employeeInfoJPanelLayout.setVerticalGroup(
            employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitJButton)
                .addContainerGap())
        );

        employeeInfoJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {displayJButton, employeeJComboBox, employeeJLabel, quitJButton});

        getContentPane().add(employeeInfoJPanel, java.awt.BorderLayout.LINE_START);

        jScrollPane1.setViewportView(dataJList);

        statsJPanel.add(jScrollPane1);

        getContentPane().add(statsJPanel, java.awt.BorderLayout.LINE_END);

        fileJMenu.setMnemonic('f');
        fileJMenu.setText("File");
        fileJMenu.setToolTipText("");

        clearJMenuItem.setMnemonic('c');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear the data from the form.");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('p');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print this form.");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        quitJMenuItem.setMnemonic('q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("Exit Employee Pay Statistics.");
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
        newJMenuItem.setToolTipText("Add an employee.");
        newJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJMenuItemActionPerformed(evt);
            }
        });
        employeeJMenu.add(newJMenuItem);

        editJMenuItem.setMnemonic('e');
        editJMenuItem.setText("Edit Employee");
        editJMenuItem.setToolTipText("Edit an employee.");
        employeeJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('d');
        deleteJMenuItem.setText("Delete Employee");
        deleteJMenuItem.setToolTipText("Delete selected employee.");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        employeeJMenu.add(deleteJMenuItem);

        searchJMenuItem.setMnemonic('s');
        searchJMenuItem.setText("Search Employee");
        searchJMenuItem.setToolTipText("Search for an employee.");
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
        meanJMenuItem.setToolTipText("Show the mean gross pay.");
        statisticsJMenu.add(meanJMenuItem);

        medianJMenuItem.setMnemonic('d');
        medianJMenuItem.setText("Median");
        medianJMenuItem.setToolTipText("Show the median gross pay.");
        statisticsJMenu.add(medianJMenuItem);

        stdJMenuItem.setMnemonic('s');
        stdJMenuItem.setText("Standard Deviation");
        stdJMenuItem.setToolTipText("Show the standard deviation.");
        stdJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdJMenuItemActionPerformed(evt);
            }
        });
        statisticsJMenu.add(stdJMenuItem);

        allJMenuItem.setMnemonic('t');
        allJMenuItem.setText("All Three");
        allJMenuItem.setToolTipText("Show the mean, median and standard deviation.");
        statisticsJMenu.add(allJMenuItem);

        employeeJMenuBar.add(statisticsJMenu);

        helpJMenu.setMnemonic('h');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('a');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("View the about form.");
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
        // Display a dialog confirming that the employee is to be deleted:
        int result = JOptionPane.showConfirmDialog(null,
                "Are you sure that you wish to delete the employee?", "Delete Employee",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (result == 0) { // Confirm
            // Get the selected index and remove it from the arrayList:
            int index = employeeJComboBox.getSelectedIndex();
            employees.remove(index);
            // Save the updated list to the external file:
            saveEmployees(fileName);
            // Display updated arrayList in the combobox:
            displayEmployees();
        }
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    private void stdJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdJMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdJMenuItemActionPerformed

    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        // Close the program:
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    private void displayJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayJButtonActionPerformed
        // Create a default list model so that we can modify our JList:
        DefaultListModel listModel = new DefaultListModel();
        // Get the element selected on the combobox:
        int index = employeeJComboBox.getSelectedIndex();
        // Set the first line of the JList to be descriptive:
        listModel.addElement("Gross Pay for "
                + employees.get(index).getName() + ":");
        // Multiply rate with hours to get the gross pay for the employee:
        listModel.addElement("$" + employees.get(index).getHours()
                * employees.get(index).getRate());
        // Set our JList's model to be the same as our default list model:
        dataJList.setModel(listModel);
    }//GEN-LAST:event_displayJButtonActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // Display the print utilities form:
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // Create a default list model so that we can modify our JList:
        DefaultListModel listModel = new DefaultListModel();
        // Set our JList model equal to the empty one we just made:
        dataJList.setModel(listModel);
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        // Close the program:
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

    private void newJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJMenuItemActionPerformed
        try {
            // Create an instance of AddEmployee JDialog:
            AddEmployee newEmployee = new AddEmployee();
            newEmployee.setVisible(true);
            // Get the newly created Employee from the JDialog object:
            Employee anEmployee = newEmployee.getEmployee();
            // Create the employee and add to the arrayList and file:
            if (anEmployee != null) {
                // Add employee to arrayList, to database and update display
                employees.add(anEmployee);
                // Search for existing employees:
                searchEmployee(anEmployee.getName());
                // Save updated list to file:
                saveEmployees(fileName);
                // Display employees in combobox:
                displayEmployees();
            }
        } catch (NullPointerException nullexp) {
            nullexp.printStackTrace();
        }
    }//GEN-LAST:event_newJMenuItemActionPerformed

    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        // Take input from the user via dialog, then search for the name:
        String employeeName = JOptionPane.showInputDialog("Enter name of employee:");
        searchEmployee(employeeName);
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // Display the about menu when the menu item's action is performed:
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
    private javax.swing.JScrollPane jScrollPane1;
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
