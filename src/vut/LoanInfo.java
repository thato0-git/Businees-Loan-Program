/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

/**
 *
 * @author thato
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

//
public class LoanInfo extends JFrame {

    
     
    JLabel lblName = new JLabel("Name:");
    JLabel lblSurname = new JLabel("Surname:");
    JLabel lblHomeAdress = new JLabel("HomeAddress:");
    JLabel lblTelephone = new JLabel("Telephone:");
    JLabel lblGender = new JLabel("Gender:");
    JLabel lblStartUpBusiness = new JLabel("Start-Up-Business:");
    JLabel lblBusinessExprience = new JLabel("Business Exprience:");
    JLabel lblAmountOfLoan = new JLabel("Amount of loan:");

    
      JTextField txtsno=new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtSurname = new JTextField();
    JTextField txtHomeAddress = new JTextField();
    JTextField txtTelephone = new JTextField();
    JRadioButton radBusinessman = new JRadioButton("Woman");
    JRadioButton radBusinesswoman = new JRadioButton("Man");
    JComboBox<String> cmbStartUpBusiness = new JComboBox<>();
    JComboBox<String> cmbBusinessExprience = new JComboBox<>();
    JTextField txtAmountOfLoan = new JTextField();

    
    JButton btnShow = new JButton("Save LoanInfo");
    JButton btnClear = new JButton("Clear");


   // JTextArea TaDisplay = new JTextArea();
    
    
    //create araylist of our class DebtorClass
    private final ArrayList<DebtorClass> arrDebtor;

    
      //pass on the arraylist in our constructor
    public LoanInfo(ArrayList<DebtorClass> arrDebtor) {
        
      //inside our constructor you initailise array
        this.arrDebtor = arrDebtor;

      //TaDisplay.setEditable(false);

        cmbStartUpBusiness.addItem("Retail-owner");
        cmbStartUpBusiness.addItem("General-dealer");
        cmbStartUpBusiness.addItem("Consultant company");
        cmbStartUpBusiness.addItem("Insurance");
        cmbStartUpBusiness.addItem("Law firm");

        cmbBusinessExprience.addItem("Salesman");
        cmbBusinessExprience.addItem("Entrepreneur");
        cmbBusinessExprience.addItem("Real- estate");
        cmbBusinessExprience.addItem("Project manager");
        cmbBusinessExprience.addItem("Car dealer");

        JPanel pnl = new JPanel();
        pnl.setLayout(null);

         
       
      pnl.add(lblName);pnl.add(txtName); 
      pnl.add(lblSurname);   pnl.add(lblHomeAdress); pnl.add(lblTelephone);  pnl.add(lblGender);
      pnl.add(lblStartUpBusiness); pnl.add(lblBusinessExprience); pnl.add(lblAmountOfLoan); 
     pnl.add(txtSurname); pnl.add(txtHomeAddress); pnl.add(txtTelephone);  pnl.add(radBusinessman); pnl.add(radBusinesswoman);
        pnl.add(cmbStartUpBusiness); pnl.add(cmbBusinessExprience); pnl.add(txtAmountOfLoan);
        
      
       pnl.add(btnShow); pnl.add(btnClear);
       
      // pnl.add(TaDisplay);
          
         
        lblName.setBounds(10, 20, 140, 20);  txtName.setBounds(100, 20, 140, 20);
        lblSurname.setBounds(10, 50, 140, 20); txtSurname.setBounds(100, 50, 140, 20);
        lblHomeAdress.setBounds(10, 80, 140, 20);  txtHomeAddress.setBounds(100, 80, 140, 20);
        lblTelephone.setBounds(10, 110, 140, 20);   txtTelephone.setBounds(100, 110, 140, 20);
        lblGender.setBounds(10, 140, 140, 20); radBusinessman.setBounds(100, 140, 90, 20); radBusinesswoman.setBounds(260, 140, 90, 20);
        lblStartUpBusiness.setBounds(10, 170, 140, 20); cmbStartUpBusiness.setBounds(160, 170, 140, 20);
        lblBusinessExprience.setBounds(10, 200, 140, 20);  cmbBusinessExprience.setBounds(160, 200, 140, 20);
        lblAmountOfLoan.setBounds(10, 230, 140, 20);  txtAmountOfLoan.setBounds(100, 230, 140, 20);

        btnShow.setBounds(10, 260, 120, 20);  btnClear.setBounds(160, 260, 140, 20);

      //  TaDisplay.setBounds(10, 300, 690, 380);

        setContentPane(pnl);

         

        btnShow.addActionListener(new btnShowEvent());
        btnClear.addActionListener(new btnClearEvent());

    }

    private class btnShowEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            // call our class give it object and call in our constructor 
            DebtorClass objClass = getLoanInfo();
            arrDebtor.add(objClass);
            
            
        }


        private DebtorClass getLoanInfo() {
            
            String debtorName, debtorSurname, debtorAddress, debtorGender, startUpbusiness, exprienceBusiness;
            int debtorTelephone, loanAmount;
         
            debtorName = txtName.getText();
            debtorSurname = txtSurname.getText();
            debtorAddress = txtHomeAddress.getText();

            if (radBusinessman.isSelected()) {
                debtorGender = radBusinessman.getText();
            } else {
                debtorGender = radBusinesswoman.getText();
            }

            startUpbusiness = cmbStartUpBusiness.getSelectedItem().toString();
           exprienceBusiness = cmbBusinessExprience.getSelectedItem().toString();

            debtorTelephone = Integer.parseInt(txtTelephone.getText());

            loanAmount = Integer.parseInt(txtAmountOfLoan.getText());
               
//            TaDisplay.append(name + "\t" + surname + "\t" + homeAddress + "\t" + telephone + "\t" + gender + "\t"
//                    + startUpBusiness + "\t" + businessExprience + "\t" + amountOfLoan +"\n");

         DebtorClass objDebtor = new DebtorClass(debtorName,debtorSurname, debtorAddress, debtorGender, startUpbusiness, exprienceBusiness,loanAmount,debtorTelephone);
            
            return objDebtor;
        }

        

    }

    private class btnClearEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            
             txtsno.setText("");
          txtsno.requestFocus();
            txtName.setText("");
            txtName.requestFocus();
            txtSurname.setText("");
            txtHomeAddress.setText("");
            txtTelephone.setText("");
            radBusinessman.setSelected(false);
            radBusinesswoman.setSelected(false);
            cmbStartUpBusiness.setSelectedIndex(0);
            cmbBusinessExprience.setSelectedIndex(0);
            txtAmountOfLoan.setText("");

        }
        
     


    }


}
