
package za.ac.cput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ItemListener, ActionListener{
    // combo box
    private JComboBox<String> cboDept;

    // labels
    private JLabel lblDept;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmpType;

    // textfields
    private JTextField txtFirstName;
    private JTextField txtLastName;

    // radio buttons
    private JRadioButton radPermanent;
    private JRadioButton radTemp;

    private ButtonGroup group;
    
    // panels
    private JPanel pnlForm;
    private JPanel pnlEmpType;
    private JPanel pnlButtons;
    
    // table
    DefaultTableModel tableModel;
    JTable table;
    
    // buttons
    private JButton btnSaveToFile;
    private JButton btnExit;
    
    // constructor
    public GUI() {
        super("University Staff Application");

        setLayout(new GridLayout(3, 1));
        
        // panels
        pnlForm = new JPanel();
        pnlEmpType = new JPanel();
        pnlButtons = new JPanel();
        
        pnlForm.setLayout(new GridLayout(4,2));
        pnlEmpType.setLayout(new GridLayout(2, 1));
        pnlButtons.setLayout(new GridLayout(1,2));

        // labels
        lblDept = new JLabel("Department:");
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblEmpType = new JLabel("Employment Type:");

        // combo box
        cboDept = new JComboBox();
        
        // text fields
        txtFirstName = new JTextField(10);
        txtLastName = new JTextField(10);

        // radio buttons
        radPermanent = new JRadioButton("Permanent");
        radTemp = new JRadioButton("Temporary");
        group = new ButtonGroup();
        
        // table
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        
        // buttons
        btnSaveToFile = new JButton("Save To File");
        btnExit = new JButton("EXIT");
        
        pnlForm.add(lblDept);
        
        cboDept.addItem("select");
        cboDept.addItem("Graphic Design");
        cboDept.addItem("Civil Engineering");
        cboDept.addItem("Information Technology");

        cboDept.addItemListener(this);

        pnlForm.add(cboDept);
        pnlForm.add(lblFirstName);
        pnlForm.add(txtFirstName);
        pnlForm.add(lblLastName);
        pnlForm.add(txtLastName);
        pnlForm.add(lblEmpType);
        
        group.add(radPermanent);
        group.add(radTemp);
        pnlEmpType.add(radPermanent);
        pnlEmpType.add(radTemp);
        
        pnlForm.add(pnlEmpType);
        add(pnlForm);
        
        setGui();
        
        pnlButtons.add(btnSaveToFile);
        pnlButtons.add(btnExit);
        add(pnlButtons);
        
        btnSaveToFile.addActionListener(this);
        btnExit.addActionListener(this);
    }
    
    public void setGui(){
      //tableModel.setColumnIdentifiers(columns);
      tableModel.addColumn("Department");
      tableModel.addColumn("First Name");
      tableModel.addColumn("Last Name");
      tableModel.addColumn("Employment Type");
      add(new JScrollPane(table));
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String query = cboDept.getSelectedItem().toString();
            if (!query.equals("select")) {
                JOptionPane.showMessageDialog(null, query);
            }
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaveToFile) {
            String department = cboDept.getSelectedItem().toString();
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            
            if(radPermanent.isSelected()){
                String permanent = radPermanent.getText();
                tableModel.addRow(new Object[] {department, firstName, lastName,permanent});
                Employee emp = new Employee(department, firstName, lastName, permanent);
                emp.writeToFile();
                
                cboDept.setSelectedItem("select");
                txtFirstName.setText("");
                txtLastName.setText("");
                group.clearSelection();
            }
            
            if(radTemp.isSelected()){
                String temporary = radTemp.getText();
                tableModel.addRow(new Object[] {department, firstName, lastName,temporary});
                Employee emp = new Employee(department, firstName, lastName, temporary);
                emp.writeToFile();
                
                cboDept.setSelectedItem("select");
                txtFirstName.setText("");
                txtLastName.setText("");
                group.clearSelection();
            }    
        }
        
        if (e.getSource() == btnExit){
            dispose();
        }

    }
    
}// end of class
