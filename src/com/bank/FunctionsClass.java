package com.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class FunctionsClass {

    public void viewAccBalance(){
       int acc = LoginDao.accNo ;
       int cid = LoginDao.cid;
       int bal = AccountDao.getBalance(acc);
       String name = AccountDao.getName(cid);
       String type = AccountDao.getAccType(acc);
       System.out.println("Account No: "+ acc);
       System.out.println("Name: " + name);
       System.out.println("Account type: "+ type);
       System.out.println("Account Balance: Rs "+bal);
       
    }
    
    public void transferFunds(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Beneficiary A/c no:");
        int toAccNo = sc.nextInt();
        System.out.println("Enter amount to transfer:");
        int amt = sc.nextInt();
        System.out.println("Press enter your transaction password");
        String trans =sc.next();
        boolean check = TransactionDao.confirmTransPwd(trans,LoginDao.accNo);
        if(check){
            exectueTransfer(toAccNo,LoginDao.accNo,amt);
        } else {
            System.out.println("Transaction password incorrect");
            return;
            
        }
    }
    

    public void exectueTransfer(int toAcc, int fromAcc, int amt) {
        int bal1 = AccountDao.getBalance(fromAcc);
        int bal2 = AccountDao.getBalance(toAcc);
        if(amt>bal1){
            System.out.println("Unsufficient Balance in Account");
        }
        else {
            bal2 = bal2 + amt;
            bal1 = bal1 - amt;
           TransactionDao.updateTransactionTable(bal1,bal2,fromAcc,toAcc, amt);
            System.out.println("Transaction Completed Successfully");
        }
        
    }
    
    public void updateAddress(){
        String street,state,city;
        int pin;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Streen Name, State, City and Pin for the updated location");
        street = sc.next();
        state= sc.next();
        city =sc.next();
        pin=sc.nextInt();
        AddressDao.updateAddress(street, state, city, pin);
    }
    public void changeLoginPassword(){
        System.out.println("Login Password Change Window");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Current Login Password");
        String curloginPwd = sc.next();
        boolean b = PasswordDao.checkLoginPwd(curloginPwd);
        if(b){
        System.out.println("Enter new login password:");
        String newLogin = sc.next();
        PasswordDao.updateLoginPwd(newLogin,curloginPwd);
        } else {
            System.out.println("Incorrect Login Password");
        }
    }
    
    public void changeTransPassword(){
        System.out.println("Transaction Password Change Window");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Current Transaction Password");
        String curTransPwd = sc.next();
        boolean b = TransPasswordDao.checkTransPwd(curTransPwd);
        if(b){
        System.out.println("Enter new Transaction password:");
        String newTrans = sc.next();
        TransPasswordDao.updateTransPwd(newTrans,curTransPwd);
        } else {
            System.out.println("Incorrect Transaction Password");
        }
    }
    
    public void viewTransStatement(){
        System.out.println("The Transaction details for your account are as follows:");
        TransStatementDao td = new TransStatementDao();
        ArrayList<TransactionDetails> transList=td.readAllTrans();
                for(TransactionDetails tList:transList){
                    System.out.println("Transaction Id: "+tList.getTranscId());
                    System.out.println("Reference No: "+tList.getReferenceNo());
                    System.out.println("Account No: "+tList.getAccNo());
                    System.out.println("Transaction Type: "+tList.getTranscType());
                    System.out.println("Transaction Date: "+tList.getTranscDateTime());
                    System.out.println("Transfer Amount: "+tList.getTransferAmount());
                    
                }
        
    }
}
