/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountporject;

import DTO.account;
import DTO.accountList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class AccountPorject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        account Account = null;
        accountList list = new accountList();
        int choice;
        boolean isContinued = true;
        do {
            System.out.println("Press 1 to Add a new account");
            System.out.println("Press 2 to display all accounts");
            System.out.println("Press 3 to check login");
            System.out.println("Press 4 to exit");
            System.out.print("Choose your option : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Account = new account();
                    Account.inputInfor();
                    if (list.addAccount(Account)) {
                        System.out.println("add successfully");
                    }
                    break;
                case 2:
                    list.displayAll();
                    break;
                case 3:
                    scanner = new Scanner(System.in);
                    System.out.print("Input the username : ");
                    String username = scanner.nextLine();
                    System.out.print("Input the password : ");
                    String password = scanner.nextLine();
                    account foundAccount = list.checkValidInfor(username, password);
                    if (foundAccount == null) {
                        System.out.print("Maybe your username or your password is invalid with any account");
                    } else {
                        if (foundAccount.getIsBlock().equals("yes")) {
                            System.out.println("Your account is Block, please contact the center to remove the block and come next time!");
                        } else {
                            scanner = new Scanner(System.in);
                            int subChoice;
                            boolean isContinued2 = true;
                            do {
                                System.out.println("Press 1 to withdraw");
                                System.out.println("Press 2 to depoist");
                                System.out.println("Press 3 to exit");
                                subChoice = scanner.nextInt();
                                switch (subChoice) {
                                    case 1:
                                        scanner = new Scanner(System.in);
                                        System.out.print("Input the money you wanna withdraw : ");
                                        double withdrawMoney = scanner.nextDouble();
                                        foundAccount.withdraw(withdrawMoney);
                                        break;
                                    case 2:
                                        scanner = new Scanner(System.in);
                                        System.out.print("Input the money you wanna send in : ");
                                        double depoistMoney = scanner.nextDouble();
                                        foundAccount.deposit(depoistMoney);
                                        break;
                                    case 3:
                                        isContinued2 = false;
                                        break;
                                }
                            } while (isContinued2);
                        }
                    }
                case 4:
                    isContinued = false;
                    break;
            }
        } while (isContinued);
    }

}
