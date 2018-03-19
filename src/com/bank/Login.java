package com.bank;

import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Id:");
        int custId = sc.nextInt();
        System.out.println("Enter password:");
        String pwd = sc.next();
//        try{
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//                md.update(pwd.getBytes());
//                //System.out.println(md.digest()); 
//        }catch(NoSuchAlgorithmException e){
//            System.err.println(e.getMessage());
//        }
         LoginDao lgd = new LoginDao();
         boolean b = lgd.validate(custId,pwd);
        if(b){
            System.out.println("Login Successful\nWelcome to ABC Online Banking");
            System.out.println("Enter your choices:\n1.View Account Summary\n" +
                  "2.Transfer Funds\n" +
                  "3.Update Address Deatils\n4.Change Login Password\n5.Change Transaction Password\n" +
                  "6.View Account Activities \n7.Log Out\n");
            int choice = sc.nextInt();
            FunctionsClass f = new FunctionsClass();
            switch(choice){
            case 1: 
                    f.viewAccBalance();
                break;
            case 2: f.transferFunds();
                break;
            case 3: f.updateAddress();
                break;
            case 4: f.changeLoginPassword();
                break;
            case 5: f.changeTransPassword();
                break;
            case 6: f.viewTransStatement();
                break;
            case 7:System.out.println("Logged out successfully");
                return;
            default: System.out.println("Invalid Choice");
            
            }
        }
        else System.out.println("Invalid Username or Password");
    }
}
