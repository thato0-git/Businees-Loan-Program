/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author thato
 */
public class DebtorClass implements Serializable {

    private String debtorName, debtorSurname, debtorAddress, debtorGender, startUpbusiness, exprienceBusiness;
    private int loanAmount, debtorTelephone;

    public DebtorClass() {
    }

    public DebtorClass(String debtorName, String debtorSurname, String debtorAddress, String debtorGender, String startUpbusiness, String exprienceBusiness, int loanAmount, int debtorTelephone) {
        setDebtorName(debtorName);
        setDebtorSurname(debtorSurname);
        setDebtorAddress(debtorAddress);
        setDebtorGender(debtorGender);
        setStartUpbusiness(startUpbusiness);
        setExprienceBusiness(exprienceBusiness);
        setLoanAmount(loanAmount);
        setDebtorTelephone(debtorTelephone);
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getDebtorSurname() {
        return debtorSurname;
    }

    public void setDebtorSurname(String debtorSurname) {
        this.debtorSurname = debtorSurname;
    }

    public String getDebtorAddress() {
        return debtorAddress;
    }

    public void setDebtorAddress(String debtorAddress) {
        this.debtorAddress = debtorAddress;
    }

    public String getDebtorGender() {
        return debtorGender;
    }

    public void setDebtorGender(String debtorGender) {
        this.debtorGender = debtorGender;
    }

    public String getStartUpbusiness() {
        return startUpbusiness;
    }

    public void setStartUpbusiness(String startUpbusiness) {
        this.startUpbusiness = startUpbusiness;
    }

    public String getExprienceBusiness() {
        return exprienceBusiness;
    }

    public void setExprienceBusiness(String exprienceBusiness) {
        this.exprienceBusiness = exprienceBusiness;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDebtorTelephone() {
        return debtorTelephone;
    }

    public void setDebtorTelephone(int debtorTelephone) {
        this.debtorTelephone = debtorTelephone;
    }

    @Override
    public String toString() {
         NumberFormat curr = NumberFormat.getCurrencyInstance();
        return  debtorName+"\t"+debtorSurname+"\t"+debtorAddress+"\t"+debtorGender+"\t"+startUpbusiness+ "\t" + "\t"+exprienceBusiness+"\t"+ "\t"+curr.format(loanAmount)+"\t"+debtorTelephone+"\n";
    }
    
    
    
}
