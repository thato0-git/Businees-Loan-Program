/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thato
 */
public class MainMenuScreen extends JFrame{
    
    JMenuItem miaddDebtor,miDisplayDebtor,miSearchDebtor,miHighestDebtor,miExit;
    JMenuItem mnFile, mnDebtor;
    
    private ArrayList<DebtorClass> arrDebtor;
    
    public MainMenuScreen(){
    
        arrDebtor = new ArrayList<>();
        
        miaddDebtor = new JMenuItem("Add new debtor to the form");
        miDisplayDebtor = new JMenuItem("Display all the debtors");
        miSearchDebtor = new JMenuItem("Search the name of debtor");
        miHighestDebtor = new JMenuItem("get the highest debtor");
        miExit = new JMenuItem("Exit the application");
       
        
        
        mnFile = new JMenu("File");
        mnFile.add(miSearchDebtor);
        mnFile.add(miHighestDebtor);
        mnFile.add(miExit);
   
        
        mnDebtor = new JMenu("Debtor");
        mnDebtor.add(miaddDebtor);
        mnDebtor.add(miDisplayDebtor);
        
        JMenuBar jmb = new JMenuBar();
        
        jmb.add(mnFile);
        jmb.add(mnDebtor);
       
        setJMenuBar(jmb);
        
        miaddDebtor.addActionListener( new miaddDebtorEvent());
        miDisplayDebtor.addActionListener(new miDisplayDebtorEvent());
        miSearchDebtor.addActionListener(new miSearchDebtorEvent());
        miHighestDebtor.addActionListener( new miHighestDebtorEvent());
        miExit.addActionListener(new miExitEvent());
        
        
        readFromStreamFile();
        
    
    }

    private void readFromStreamFile()  {
        
        try {
            FileInputStream fis = new FileInputStream("DebtFile.dat");
            ObjectInputStream objread = new ObjectInputStream(fis);
            arrDebtor = (ArrayList<DebtorClass>) objread.readObject();
            objread.close();    
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "No data in the file" + ex.getMessage());
           arrDebtor = new ArrayList<>();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }


     
    private class miaddDebtorEvent implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
          
            LoanInfo frm = new LoanInfo(arrDebtor);
            frm.setVisible(true);
            frm.setTitle("Add Debtor by Thato");
            frm.setSize(500, 500);
            frm.setResizable(false);
          
        }
    }

    private  class miDisplayDebtorEvent implements ActionListener {

     
        @Override
        public void actionPerformed(ActionEvent e) {
         
            DisplayScreen frm = new DisplayScreen(arrDebtor);
            frm.setVisible(true);
            frm.setTitle("Display debtor information");
            frm.setSize(850,650);
            frm.setResizable(false);
            
          
        }
    }

    private class miSearchDebtorEvent implements ActionListener {

    

        @Override
        public void actionPerformed(ActionEvent e) {
          
            String debtorName = JOptionPane.showInputDialog("Enter the name of the debtor:");
             Boolean found = false;
             
             for(DebtorClass debtor: arrDebtor){
              if(debtor.getDebtorName().equals(debtorName)){
                 JOptionPane.showMessageDialog(null, "debtor name found" + debtorName);
                 
                 found = true;
                 break;
              }
             
             }
        }
    }

    private  class miHighestDebtorEvent implements ActionListener {

      
        @Override
        public void actionPerformed(ActionEvent e) {
           
            DebtorClass HighestLoan = arrDebtor.get(0);
            
            for(DebtorClass debtor: arrDebtor){
             if(debtor.getLoanAmount() > HighestLoan.getLoanAmount()){
               HighestLoan = debtor;
             }
            
            }
            
            JOptionPane.showMessageDialog(null, "Debtor with the highest loan:\n" + "debtor name:" + HighestLoan.getDebtorName() + 
                    "\n" + "Amount loaned:" + HighestLoan.getLoanAmount());
                
        }
    }

    private class miExitEvent implements ActionListener {

       

        @Override
        public void actionPerformed(ActionEvent e) {
         
           int resp;
           
          resp=JOptionPane.showConfirmDialog(null, "Do you want to exit?", "confirm", JOptionPane.YES_NO_OPTION);
          
        if (resp== JOptionPane.YES_OPTION){
            
            saveToStreamFile();
            System.exit(0);
        } else {
           mnDebtor.requestFocus();
         }
        }

        private void saveToStreamFile() {
            try {
                FileOutputStream fos = new FileOutputStream("DebtFile.dat");
                ObjectOutputStream objwrite = new ObjectOutputStream(fos);
                objwrite.writeObject(arrDebtor);
                objwrite.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch(IOException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
   

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MainMenuScreen frm = new MainMenuScreen();
        frm.setVisible(true);
        frm.setTitle("Debtor Application");
        frm.setSize(500,400);
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    
}


