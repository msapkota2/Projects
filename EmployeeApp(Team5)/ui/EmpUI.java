/* Author: your name
 * Date: 
 * File: EmpUI.java file
 */
package ui;

import business.Employee;
import business.EmployeeIO;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.reflect.*;
import javax.swing.JOptionPane;
import validation.Validator;

public class EmpUI extends javax.swing.JFrame {

    String filename;
    Map<Long, Employee> emps;
    Map<String, Employee> employeesByName;
    int loading = 0;
    String[] getMethods = {"getEmpNumber", "getFirstName", "getLastName",
        "getMiddleName", "getSuffix", "getAddress1", "getAddress2",
        "getCity", "getState", "getZip", "getPhone", "getGender",
        "getPayCode", "getStatus", "getHireDate", "getTermDate"};
    JTextField[] fields;
    boolean saveState;
    Map<String, JTextField> screenMap;

    public EmpUI() {
        initComponents();
        buttonGroup1.clearSelection();
        jComboBoxEmployee.removeAllItems();
        jComboBoxEmployee.setSelectedIndex(-1); //no item is selected
        JTextField[] flds = {jTextFieldEmpNo, jTextFieldFirstName,
            jTextFieldLastName, jTextFieldMiddleName, jTextFieldNameSuffix,
            jTextFieldAddress1, jTextFieldAddress2, jTextFieldCity,
            jTextFieldState, jTextFieldZip, jTextFieldPhone,
            jTextFieldGender, jTextFieldPayCode, jTextFieldStatus,
            jTextFieldHireDate, jTextFieldTerminationDate};
        fields = flds;
        screenMap = new HashMap<>();
        // associate specified value w/specified key
        for (int i = 0; i < getMethods.length; i++) {
            screenMap.put(getMethods[i], fields[i]);
        }
        setPreFileLoadEnablement();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonRaw = new javax.swing.JRadioButton();
        jRadioButtonEmpno = new javax.swing.JRadioButton();
        jRadioButtonName = new javax.swing.JRadioButton();
        jButtonPrevious = new javax.swing.JButton();
        jComboBoxEmployee = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmpNo = new SelectOnFocusTextField();
        jTextFieldLastName = new SelectOnFocusTextField();
        jTextFieldMiddleName = new SelectOnFocusTextField();
        jTextFieldFirstName = new SelectOnFocusTextField();
        jTextFieldNameSuffix = new SelectOnFocusTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAddress1 = new SelectOnFocusTextField();
        jTextFieldAddress2 = new SelectOnFocusTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCity = new SelectOnFocusTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldState = new SelectOnFocusTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldZip = new SelectOnFocusTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPhone = new SelectOnFocusTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldGender = new SelectOnFocusTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPayCode = new SelectOnFocusTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldStatus = new SelectOnFocusTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldHireDate = new SelectOnFocusTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldTerminationDate = new SelectOnFocusTextField();
        jLabelMessage = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Application");
        setResizable(false);

        buttonGroup1.add(jRadioButtonRaw);
        jRadioButtonRaw.setSelected(true);
        jRadioButtonRaw.setText("Raw HashMap w.Empno Key");
        jRadioButtonRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRawActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonEmpno);
        jRadioButtonEmpno.setText("TreeMap by Empno");
        jRadioButtonEmpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonName);
        jRadioButtonName.setText("Map with Name Key (sorted)");
        jRadioButtonName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNameActionPerformed(evt);
            }
        });

        jButtonPrevious.setText("<-");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jComboBoxEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEmployeeItemStateChanged(evt);
            }
        });

        jLabel1.setText("Employees:");

        jButtonNext.setText("->");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("EmpNo:");

        jLabel3.setText("Name: Last");

        jLabel4.setText("First");

        jLabel5.setText("Mid");

        jLabel6.setText("Suffix");

        jTextFieldEmpNo.setName("Employee Number"); // NOI18N
        jTextFieldEmpNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmpNoFocusGained(evt);
            }
        });

        jTextFieldLastName.setName("Last Name"); // NOI18N

        jTextFieldMiddleName.setName("Middle Initial"); // NOI18N

        jTextFieldFirstName.setName("First Name"); // NOI18N

        jTextFieldNameSuffix.setName("Name Suffix"); // NOI18N

        jLabel7.setText("Address:");

        jTextFieldAddress1.setName("Address 1"); // NOI18N

        jTextFieldAddress2.setName("Address 2"); // NOI18N
        jTextFieldAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddress2ActionPerformed(evt);
            }
        });

        jLabel8.setText("City:");

        jTextFieldCity.setName("City"); // NOI18N

        jLabel9.setText("State:");

        jTextFieldState.setName("State"); // NOI18N

        jLabel10.setText("ZIP Code:");

        jTextFieldZip.setName("ZIP Code"); // NOI18N

        jLabel11.setText("Phone:");

        jTextFieldPhone.setName("Phone Number"); // NOI18N

        jLabel12.setText("Gender:");

        jTextFieldGender.setName("Gender"); // NOI18N

        jLabel13.setText("Pay Code:");

        jTextFieldPayCode.setName("Pay Code"); // NOI18N
        jTextFieldPayCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPayCodeActionPerformed(evt);
            }
        });

        jLabel14.setText("Status:");

        jTextFieldStatus.setName("Status"); // NOI18N

        jLabel15.setText("Hire Date:");

        jTextFieldHireDate.setName("Hire Date"); // NOI18N

        jLabel16.setText("End Date:");

        jTextFieldTerminationDate.setName("End Date"); // NOI18N
        jTextFieldTerminationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTerminationDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldStatus)
                            .addComponent(jTextFieldCity))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldState)
                            .addComponent(jTextFieldHireDate, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jTextFieldGender))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPayCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTerminationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldZip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFirstName)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldNameSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAddress2)
                            .addComponent(jTextFieldAddress1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNameSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldPayCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldTerminationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelMessage.setFont(jLabelMessage.getFont().deriveFont(jLabelMessage.getFont().getSize()+3f));
        jLabelMessage.setText("Hello");

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Add New Emp");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonPrevious)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel1))
                            .addComponent(jRadioButtonRaw))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonEmpno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButtonName))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNext)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRaw)
                    .addComponent(jRadioButtonEmpno)
                    .addComponent(jRadioButtonName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrevious)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonExit))
                .addContainerGap())
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Load");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // declare a file chooser
        JFileChooser f = new JFileChooser(".");//display current dir
        f.setDialogTitle("Select Employee File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file (*.csv)", "CSV");
        f.setFileFilter(filter); //filter CSV files
        JDialog jd = new JDialog();
        int val = f.showOpenDialog(jd);
        if (val == JFileChooser.CANCEL_OPTION) {
            jLabelMessage.setText("Open operation canceled");
        } else {
            try {
                filename = f.getSelectedFile().getAbsolutePath();
                emps = EmployeeIO.getEmployees(filename);
                jLabelMessage.setText(String.valueOf(emps.size() + " records found"));
                setAfterFileLoadEnablement();
            } catch (Exception e) {
                emps.clear();
                filename = null;
                jLabelMessage.setText("Error occurred. Open operation aborted");
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // quit application
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearTextFields();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // save changes to employees.csv file
        try {
            // check to see if the file is loaded
            System.out.println("File loaded: " + (!emps.isEmpty()));
            try {
                EmployeeIO.setEmps(filename, emps);
                jLabelMessage.setText("Record is saved successfully. ");
                saveState = true;
                buildComboBox();
            } catch (Exception ex) {
                jLabelMessage.setText("Error occurred, Save unsuccessful.");
            }
        } catch (NullPointerException npe) {
            jLabelMessage.setText("Unexpected error occurred.");
            fileMenu.doClick();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        updateEmployee();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // add new Employee row to employees.csv file
        try {
            // check to see if the file is loaded
            System.out.println("File loaded: " + (!emps.isEmpty()));
            try {
                Employee temp = createEmployee();
                emps.put(temp.getEmpNumber(), temp);
                EmployeeIO.setEmps(filename, emps);
                jLabelMessage.setText("Record is added successfully.");
                saveState = true;
                buildComboBox();
            } catch (Exception ex) {
                jLabelMessage.setText("Error occurred, Add unsuccessful.");
            }
        } catch (NullPointerException npe) {
            jLabelMessage.setText("Unexpected error occurred.");
            fileMenu.doClick();
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // call deleteEmp() method
        deleteEmployee();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // make sure loading is complete
        if (loading == 1) {
            return;
        }
        if (jComboBoxEmployee.getSelectedIndex() < (jComboBoxEmployee.getItemCount() - 1)) {
            jComboBoxEmployee.setSelectedIndex(jComboBoxEmployee.getSelectedIndex() + 1);
            if (!(jComboBoxEmployee.getSelectedIndex() < (jComboBoxEmployee.getItemCount() - 1))) {
                jButtonNext.setEnabled(false);
            }
        } else {
            jLabelMessage.setText("Already at last record, cannot show next record.");
            jButtonNext.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void setEmptyRecordEnablement() {
        jRadioButtonEmpno.setEnabled(true);
        jRadioButtonName.setEnabled(true);
        jRadioButtonRaw.setEnabled(true);

        jComboBoxEmployee.setEnabled(true);
        jButtonClear.setEnabled(true);

        jTextFieldAddress1.setEnabled(true);
        jTextFieldAddress2.setEnabled(true);
        jTextFieldCity.setEnabled(true);
        jTextFieldEmpNo.setEnabled(true);
        jTextFieldFirstName.setEnabled(true);
        jTextFieldGender.setEnabled(true);
        jTextFieldHireDate.setEnabled(true);
        jTextFieldLastName.setEnabled(true);
        jTextFieldMiddleName.setEnabled(true);
        jTextFieldNameSuffix.setEnabled(true);
        jTextFieldPayCode.setEnabled(true);
        jTextFieldPhone.setEnabled(true);
        jTextFieldState.setEnabled(true);
        jTextFieldStatus.setEnabled(true);
        jTextFieldTerminationDate.setEnabled(true);
        jTextFieldZip.setEnabled(true);

        jButtonAdd.setEnabled(true);
        jButtonSave.setEnabled(true);

        jButtonNext.setEnabled(false);
        jButtonPrevious.setEnabled(false);

        jButtonDelete.setEnabled(false);
        jButtonUpdate.setEnabled(false);
    }

    private void jComboBoxEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEmployeeItemStateChanged
        // make sure recording loading is done
        if (loading == 1) {
            return;
        }
        if (jComboBoxEmployee.getSelectedIndex() == -1) {
            jLabelMessage.setText("No record is selected. Please select a record. ");
            setEmptyRecordEnablement();
        } else {
            Employee e;
            if (jRadioButtonName.isSelected()) {
                e = (Employee) employeesByName.get((String) jComboBoxEmployee.getSelectedItem());
            } else {
                e = (Employee) emps.get((Long) jComboBoxEmployee.getSelectedItem());
            }
            //update displayed values
            String recordinfo = "You are viewing record for: ";
            displayValues(e);
            if (String.valueOf(e.getMiddleName()).equals("null")) {
                jTextFieldMiddleName.setText("");
                recordinfo += e.getLastName() + ", " + e.getFirstName();
            } else {
                recordinfo += e.getLastName() + ", " + e.getFirstName() + " "
                        + e.getMiddleName();
            }
            jLabelMessage.setText(recordinfo);
            setAfterRadioSelectedEnablement();
        }
    }//GEN-LAST:event_jComboBoxEmployeeItemStateChanged

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        // make sure loading is complete
        if (loading == 1) {
            return;
        }
        if (jComboBoxEmployee.getSelectedIndex() > 0) {
            jComboBoxEmployee.setSelectedIndex(jComboBoxEmployee.getSelectedIndex() - 1);
            if (jComboBoxEmployee.getSelectedIndex() == 0) {
                jButtonPrevious.setEnabled(false);
            }
        } else {
            jLabelMessage.setText("Already at first record, cannot show previous record.");
            jButtonPrevious.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jRadioButtonNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNameActionPerformed
        // call buildComboBox() method
        try {
            if (jRadioButtonName.isSelected()) {
                buildComboBox();
            }
        } catch (NullPointerException e) {
            jLabelMessage.setText("Error occurred. No records loaded. "
                    + "Select a file to load first.");
            fileMenu.doClick();
            buttonGroup1.clearSelection();
        } catch (Exception e) {
            jLabelMessage.setText("Error occurred. No records loaded.");
        }
    }//GEN-LAST:event_jRadioButtonNameActionPerformed

    private void jRadioButtonEmpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpnoActionPerformed
        buildComboBox();
    }//GEN-LAST:event_jRadioButtonEmpnoActionPerformed

    private void jRadioButtonRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRawActionPerformed
        buildComboBox();
    }//GEN-LAST:event_jRadioButtonRawActionPerformed

    private void jTextFieldPayCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPayCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPayCodeActionPerformed

    private void jTextFieldAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddress2ActionPerformed

    private void jTextFieldEmpNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmpNoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmpNoFocusGained

    private void jTextFieldTerminationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTerminationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTerminationDateActionPerformed

    private Employee createEmployee() {
        // createEmployee() method attempts to return an Employee object from input fields
        try {
            for (JTextField f : fields) {
                f.setText(f.getText().replace("null", ""));
            }

            // validates the following fields are not null, even though in a real-
            // life scenario, many of these could very well be, and the null case
            // would need to be handled
            if (Validator.isTextFieldNotEmpty(jTextFieldEmpNo)) {
                if (Validator.isTextFieldLong(jTextFieldEmpNo)) {
                    if (Validator.isTextFieldNotEmpty(jTextFieldLastName)) {
                        if (Validator.isValidName(jTextFieldLastName)) {
                            if (Validator.isTextFieldNotEmpty(jTextFieldFirstName)) {
                                if (Validator.isValidName(jTextFieldFirstName)) {
                                    if (!jTextFieldMiddleName.getText().equalsIgnoreCase("")) {
                                        if (Validator.isValidName(jTextFieldMiddleName)) {
                                        } else {
                                            return null;
                                        }
                                    }
                                    if (!jTextFieldNameSuffix.getText().equalsIgnoreCase("")) {
                                        if (Validator.isValidName(jTextFieldNameSuffix)) {
                                        } else {
                                            return null;
                                        }
                                    }
                                    if (Validator.isTextFieldNotEmpty(jTextFieldAddress1)) {
                                        if (Validator.isValidAddress(jTextFieldAddress1)) {
                                            if (!jTextFieldAddress2.getText().equalsIgnoreCase("")) {
                                                if (Validator.isValidAddress(jTextFieldAddress2)) {
                                                } else {
                                                    return null;
                                                }
                                            }
                                            if (Validator.isTextFieldNotEmpty(jTextFieldCity)) {
                                                if (Validator.isValidAddress(jTextFieldCity)) {
                                                    if (Validator.isTextFieldNotEmpty(jTextFieldState)) {
                                                        if (Validator.isValidName(jTextFieldState)) {
                                                            if (Validator.isTextFieldNotEmpty(jTextFieldZip)) {
                                                                if (Validator.isTextFieldIntInRange(jTextFieldZip, 1, 99999)) {
                                                                    if (Validator.isTextFieldNotEmpty(jTextFieldPhone)) {
                                                                        if (Validator.isTextFieldLongInRange(jTextFieldPhone, 1000000000L, 9999999999L)) {
                                                                            if (Validator.isTextFieldNotEmpty(jTextFieldGender)) {
                                                                                if (Validator.isValidName(jTextFieldGender)) {
                                                                                    if (Validator.isTextFieldNotEmpty(jTextFieldPayCode)) {
                                                                                        if (Validator.isTextFieldInt(jTextFieldPayCode)) {
                                                                                            if (Validator.isTextFieldNotEmpty(jTextFieldStatus)) {
                                                                                                if (Validator.isValidName(jTextFieldStatus)) {
                                                                                                    if (Validator.isTextFieldNotEmpty(jTextFieldHireDate)) {
                                                                                                        if (Validator.isValidDate(jTextFieldHireDate)) {
                                                                                                            if (Validator.isTextFieldNotEmpty(jTextFieldTerminationDate)) {
                                                                                                                if (Validator.isValidDate(jTextFieldTerminationDate)) {
                                                                                                                    Employee createdEmployee = new Employee((long) Long.parseLong(jTextFieldEmpNo.getText()),
                                                                                                                            (long) Long.parseLong(jTextFieldPhone.getText()),
                                                                                                                            (int) Integer.parseInt(jTextFieldPayCode.getText()),
                                                                                                                            jTextFieldLastName.getText(),
                                                                                                                            jTextFieldFirstName.getText(),
                                                                                                                            jTextFieldMiddleName.getText(),
                                                                                                                            jTextFieldNameSuffix.getText(),
                                                                                                                            jTextFieldAddress1.getText(),
                                                                                                                            jTextFieldAddress2.getText(),
                                                                                                                            jTextFieldCity.getText(),
                                                                                                                            jTextFieldState.getText(),
                                                                                                                            jTextFieldZip.getText(),
                                                                                                                            jTextFieldGender.getText(),
                                                                                                                            jTextFieldStatus.getText(),
                                                                                                                            jTextFieldHireDate.getText(),
                                                                                                                            jTextFieldTerminationDate.getText());
                                                                                                                    return createdEmployee;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            jLabelMessage.setText("Unexpected error occurred.");
            return null;
        }
        return null;
    }

    private void updateEmployee() {
        try {
            //make sure there is a file loaded before attempting to update
            if (filename == null) {
                JOptionPane.showMessageDialog(rootPane, "Please load a file before "
                        + "attempting to update employee records! ", "File Not Found",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (jComboBoxEmployee.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Please select an employee ID  before "
                        + "attempting to update employee records! ", "No Employee Selected",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long empNum = Long.parseLong(jTextFieldEmpNo.getText());
            for (JTextField f : fields) {
                f.setText(f.getText().replace("null", ""));
            }

            String updateEmp = emps.get(empNum).getFullName();
            if (emps.containsKey(empNum)) {
                int confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure you "
                        + "want to update the following employee? \n\n"
                        + "******THIS CANNOT BE UNDONE*******\n\n"
                        + "Employee Number: " + updateEmp,
                        "Confirm Employee Update", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    emps.replace(empNum, createEmployee());
                    clearTextFields();
                    buildComboBox();
                    jLabelMessage.setText("Employee '" + updateEmp
                            + "' has been successfully updated.");
                }
            }
        } catch (Exception e) {
            jLabelMessage.setText("Unexpected error occurred.");
        }
    }

    private void deleteEmployee() {
        try {
            //make sure there is a file loaded before attempting to delete
            if (filename == null) {
                JOptionPane.showMessageDialog(rootPane, "Please load a file before "
                        + "attempting to delete employee records! ", "File Not Found",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (jComboBoxEmployee.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Please select an employee ID  before "
                        + "attempting to delete employee records! ", "No Employee Selected",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long empNum = Long.parseLong(jTextFieldEmpNo.getText());
            String deleteEmp = emps.get(empNum).getFullName();
            if (emps.containsKey(empNum)) {
                int confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure you "
                        + "want to remove the following employee from the Employee.csv file? \n\n"
                        + "******THIS CANNOT BE UNDONE*******\n\n"
                        + "Employee Number: " + emps.get(empNum).getFullName(),
                        "Confirm Employee Deletion", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    emps.remove(empNum);
                    clearTextFields();
                    buildComboBox();
                    jLabelMessage.setText("Employee '" + deleteEmp
                            + "' has been successfully removed.");
                }
            }
        } catch (Exception e) {
            jLabelMessage.setText("Unexpected error occurred.");
        }
    }

    public void buildComboBox() {
        int loading = 1; // 1 is loading and 0 is finished loading
        int currentSelectedIndex = jComboBoxEmployee.getSelectedIndex();
        try {
            jComboBoxEmployee.removeAllItems();
            if (jRadioButtonRaw.isSelected()) {
                HashMap<Long, Employee> employeesHashMap = new HashMap<>(emps);
                for (Map.Entry<Long, Employee> entry : employeesHashMap.entrySet()) {
                    Long k = entry.getKey();
                    jComboBoxEmployee.addItem(k);
                }
            } else if (jRadioButtonEmpno.isSelected()) {
                TreeMap<Long, Employee> employeesTreeMap = new TreeMap<>(emps);
                for (Map.Entry<Long, Employee> entry : employeesTreeMap.entrySet()) {
                    Long k = entry.getKey();
                    jComboBoxEmployee.addItem(k);
                }
            } else if (jRadioButtonName.isSelected()) {
                employeesByName = new TreeMap<>();
                for (Map.Entry<Long, Employee> entry : emps.entrySet()) {
                    Employee e = entry.getValue();
                    String name = e.getLastName() + ", " + e.getFirstName()
                            + " " + e.getMiddleName();
                    employeesByName.put(name, e);
                }
                for (Map.Entry<String, Employee> entry : employeesByName.entrySet()) {
                    String k = entry.getKey();
                    jComboBoxEmployee.addItem(k);
                }
            }
        } catch (Exception e) {
            jLabelMessage.setText("Unexpected error occurred.");
        }

        loading = 0; //load is complete   
        if (currentSelectedIndex > -1) {
            jComboBoxEmployee.setSelectedIndex(currentSelectedIndex);
            setAfterRadioSelectedEnablement();
        } else {
            setEmptyRecordEnablement();
        }
    }

    private void setAfterRadioSelectedEnablement() {
        jRadioButtonEmpno.setEnabled(true);
        jRadioButtonName.setEnabled(true);
        jRadioButtonRaw.setEnabled(true);

        jComboBoxEmployee.setEnabled(true);
        jButtonClear.setEnabled(true);

        if (jComboBoxEmployee.getSelectedIndex() < (jComboBoxEmployee.getItemCount() - 1)) {
            jButtonNext.setEnabled(true);
        } else {
            jButtonNext.setEnabled(false);
        }
        if (jComboBoxEmployee.getSelectedIndex() > 0) {
            jButtonPrevious.setEnabled(true);
        } else {
            jButtonPrevious.setEnabled(false);
        }

        jTextFieldAddress1.setEnabled(true);
        jTextFieldAddress2.setEnabled(true);
        jTextFieldCity.setEnabled(true);
        jTextFieldEmpNo.setEnabled(true);
        jTextFieldFirstName.setEnabled(true);
        jTextFieldGender.setEnabled(true);
        jTextFieldHireDate.setEnabled(true);
        jTextFieldLastName.setEnabled(true);
        jTextFieldMiddleName.setEnabled(true);
        jTextFieldNameSuffix.setEnabled(true);
        jTextFieldPayCode.setEnabled(true);
        jTextFieldPhone.setEnabled(true);
        jTextFieldState.setEnabled(true);
        jTextFieldStatus.setEnabled(true);
        jTextFieldTerminationDate.setEnabled(true);
        jTextFieldZip.setEnabled(true);

        jButtonAdd.setEnabled(true);
        jButtonDelete.setEnabled(true);

        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(true);
    }

    private void clearTextFields() {
        for (JTextField fld : fields) {
            fld.setText("");
        }
        jLabelMessage.setText("");
    }

    private void displayValues(Employee e) {
        clearTextFields(); //call clearTextFields() method

        // use reflection method in java.lang.reflect package
        Class empClass = e.getClass();
        Method[] methods = empClass.getMethods();//Method class is obtained from Class
        try {
            for (Method m : methods) {
                if (screenMap.containsKey(m.getName())) {//ensure field exists in screenMap
                    JTextField fld = screenMap.get(m.getName());//obtain target field
                    switch (m.getName()) {
                        case "getEmpNumber":
                            long x = (long) m.invoke(e, null);
                            fld = screenMap.get(m.getName());
                            fld.setText(String.valueOf(x));
                            break;
                        case "getPhone":
                            long y = (long) m.invoke(e, null);
                            fld = screenMap.get(m.getName());
                            fld.setText(String.valueOf(y));
                            break;
                        case "getPayCode":
                            long z = (int) m.invoke(e, null);
                            fld = screenMap.get(m.getName());
                            fld.setText(String.valueOf(z));
                            break;
                        default:
                            if (String.valueOf(m.invoke(e, null)).equals("null")) {
                                fld.setText("");
                            } else {
                                fld.setText(String.valueOf(m.invoke(e, null)));
                            }
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setPreFileLoadEnablement() {
        jRadioButtonEmpno.setEnabled(false);
        jRadioButtonName.setEnabled(false);
        jRadioButtonRaw.setEnabled(false);

        jComboBoxEmployee.setEnabled(false);
        jButtonClear.setEnabled(false);

        jButtonNext.setEnabled(false);
        jButtonPrevious.setEnabled(false);

        jTextFieldAddress1.setEnabled(false);
        jTextFieldAddress2.setEnabled(false);
        jTextFieldCity.setEnabled(false);
        jTextFieldEmpNo.setEnabled(false);
        jTextFieldFirstName.setEnabled(false);
        jTextFieldGender.setEnabled(false);
        jTextFieldHireDate.setEnabled(false);
        jTextFieldLastName.setEnabled(false);
        jTextFieldMiddleName.setEnabled(false);
        jTextFieldNameSuffix.setEnabled(false);
        jTextFieldPayCode.setEnabled(false);
        jTextFieldPhone.setEnabled(false);
        jTextFieldState.setEnabled(false);
        jTextFieldStatus.setEnabled(false);
        jTextFieldTerminationDate.setEnabled(false);
        jTextFieldZip.setEnabled(false);

        jButtonAdd.setEnabled(false);
        jButtonDelete.setEnabled(false);

        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);

    }

    private void setAfterFileLoadEnablement() {
        jRadioButtonEmpno.setEnabled(true);
        jRadioButtonName.setEnabled(true);
        jRadioButtonRaw.setEnabled(true);

        jComboBoxEmployee.setEnabled(false);
        jButtonClear.setEnabled(false);

        jButtonNext.setEnabled(false);
        jButtonPrevious.setEnabled(false);

        jTextFieldAddress1.setEnabled(false);
        jTextFieldAddress2.setEnabled(false);
        jTextFieldCity.setEnabled(false);
        jTextFieldEmpNo.setEnabled(false);
        jTextFieldFirstName.setEnabled(false);
        jTextFieldGender.setEnabled(false);
        jTextFieldHireDate.setEnabled(false);
        jTextFieldLastName.setEnabled(false);
        jTextFieldMiddleName.setEnabled(false);
        jTextFieldNameSuffix.setEnabled(false);
        jTextFieldPayCode.setEnabled(false);
        jTextFieldPhone.setEnabled(false);
        jTextFieldState.setEnabled(false);
        jTextFieldStatus.setEnabled(false);
        jTextFieldTerminationDate.setEnabled(false);
        jTextFieldZip.setEnabled(false);

        jButtonAdd.setEnabled(false);
        jButtonDelete.setEnabled(false);

        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
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
            java.util.logging.Logger.getLogger(EmpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonEmpno;
    private javax.swing.JRadioButton jRadioButtonName;
    private javax.swing.JRadioButton jRadioButtonRaw;
    private javax.swing.JTextField jTextFieldAddress1;
    private javax.swing.JTextField jTextFieldAddress2;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldEmpNo;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldGender;
    private javax.swing.JTextField jTextFieldHireDate;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldMiddleName;
    private javax.swing.JTextField jTextFieldNameSuffix;
    private javax.swing.JTextField jTextFieldPayCode;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldTerminationDate;
    private javax.swing.JTextField jTextFieldZip;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration//GEN-END:variables

}
