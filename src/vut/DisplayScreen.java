/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author thato
 */
public class DisplayScreen extends JFrame{
    
     JTextArea TaDisplay = new JTextArea();
     
   public DisplayScreen(ArrayList<DebtorClass> arrDebtor){
       
         TaDisplay.setEditable(false);
         TaDisplay.setText("");
         
                  TaDisplay.append("debtorName\tdebtorSurname\tdebtorAddress\tGender\tStartUpBusiness\tBusinessExprience\tloanAmount\tdebtorTelephone\n");
                
                
                    arrDebtor.stream().forEach((debtor) -> {
            TaDisplay.append(debtor.toString());
        });
        
           
                    JScrollPane  scrollPane = new JScrollPane(TaDisplay);
                    
                    add(scrollPane);
         
     }


  
    
}
