/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;
import validation.myValidation;

/**
 *
 * @author HP
 */
public class account implements Comparable<account>{
    private String userName,password,isBlock;
    private double balance;

    public account(String userName, String passWord, String isBlock, double balance) {
        this.userName = userName;
        this.password = passWord;
        this.isBlock = isBlock;
        this.balance = balance;
    }
    public account(){
        userName = "";
        password = "";
        isBlock = "";
        balance = 0;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return password;
    }

    public String getIsBlock() {
        return isBlock;
    }

    public double getBalance() {
        return balance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public void setIsBlock(String isBlock) {
        this.isBlock = isBlock;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void inputUserName(Scanner scanner){
        do{
            System.out.print("Input the username : ");
            userName = scanner.nextLine();
        }while(userName.isEmpty() || userName == null);
    }
    public void inputPassword(Scanner scanner){
        do{
            System.out.print("Input the password : ");
            password = scanner.nextLine();
        }while(password.isEmpty() || password == null);
    }
    public void confirmIsBlock(Scanner scanner){
        do{
            System.out.print("Confirm is block : ");
            isBlock = scanner.nextLine();
        }while(isBlock.isEmpty() || (!isBlock.equals("no") && !isBlock.equals("yes")));
    }
    public void inputBalance(Scanner scanner){
        boolean isContinued = false;
        do{
            try{
                scanner = new Scanner(System.in);
                System.out.print("Input the balance : ");
                balance = scanner.nextDouble();
                myValidation.checkBalance(balance);
                isContinued = false;
            }catch(Exception event){
                if(event.getMessage() != null){
                    System.out.println(event.getMessage());
                }else{
                    System.out.println("System Error! please input the valid balance");
                    isContinued = true;
                }
            }
        }while(isContinued);
    }
    public void inputInfor(){
        Scanner scanner = new Scanner(System.in);
        inputUserName(scanner);
        inputPassword(scanner);
        confirmIsBlock(scanner);
        inputBalance(scanner);
    }
    public double withdraw(double money){
        return (balance = balance - money);
    }
    public double deposit(double money){
        return (balance = balance + money);
    }

    @Override
    public String toString() {
        return userName+"-"+password+"-"+isBlock+"-"+balance;
    }
    
    @Override
    public int compareTo(account Account) {
        if(userName.compareTo(Account.getUserName()) > 0) return 1;
        else if(userName.compareTo(Account.getUserName()) < 0) return -1;
        return 0;
    }
}
