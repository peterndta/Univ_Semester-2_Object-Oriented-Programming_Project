/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Phone;
import java.util.Scanner;
import manager.PhoneList;

/**
 *
 * @author Peter
 */
public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneList list = new PhoneList();
        list.inportPhoneList("data.dat");
        boolean loop = true;
        int choice = 0;
        do {
            System.out.println("Welcome to HKT Store - @ 2021 by <SE150640 - Nguyen Dang Truong Anh>");
            System.out.println(" 1. Add a phone");
            System.out.println(" 2. Search a phone by model");
            System.out.println(" 3. Update the phone by model");
            System.out.println(" 4. Remove the phone by model");
            System.out.println(" 5. Print the phone list in the descending order of Model");
            System.out.println(" 6. Store the phone list to text file");
            System.out.println(" 7. Exit");
            boolean liLoop = true;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print(" >> Choice: ");
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 7) {
                        System.out.println("\tPlease Input from 1-7!\n");
                    }
                    liLoop = false;
                } catch (Exception e) {
                    System.out.println("\tYour choice is inValid! Please Input Again!\n");
                    liLoop = true;
                }
            } while (liLoop);
            System.out.print("\n");
            switch (choice) {
                case 1:
                    String confirm;
                    do {
                        Phone phone = new Phone();
                        sc = new Scanner(System.in);
                        phone.inputPhone();
                        //Kiem tra trung va them Phone vao List
                        if (list.duplicateModel(phone.getModel()) == true) {
                            System.out.println("\tFailed to add! Phone already has in list!\n");
                        } else {
                            list.addPhone(phone);
                            System.out.println("\tPhone successfully added!\n");
                        }

                        do {
                            //Kiem tra User co tiep tuc hay khong    
                            System.out.print("Do you want to continue?(yes/no): ");
                            confirm = sc.nextLine();
                            if (!confirm.equals("yes") && !confirm.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                        } while (!confirm.equals("yes") && !confirm.equals("no"));
                    } while (!confirm.equals("no"));
                    System.out.println("\tReturning Menu!\n");
                    break;

                case 2:
                    do {
                        sc = new Scanner(System.in);
                        //Xuat ra danh sach Model va kiem tra list trống
                        System.out.println("[Model List]");
                        if (list.checkEmpty() == true) {
                            System.out.println("\tThe list is empty!");
                            break;
                        } else {
                            list.viewModelList();
                            //Nhap Model can tim
                            System.out.print("\nModel to find: ");
                            String findModel = sc.nextLine();
                            if (list.searchPhone(findModel) == false) {
                                System.out.println("\tNo matching results were found!\n");
                            }
                        }

                        do {
                            //Kiem tra User co tiep tuc hay khong                            
                            System.out.print("Do you want to continue?(yes/no): ");
                            confirm = sc.nextLine();
                            if (!confirm.equals("yes") && !confirm.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                        } while (!confirm.equals("yes") && !confirm.equals("no"));

                    } while (!confirm.equals("no"));
                    System.out.println("\tReturning Menu!\n");
                    break;

                case 3:
                    do {
                        sc = new Scanner(System.in);
                        // Xuat ra danh sach Model va kiem tra list trống
                        System.out.println("[Model List]");
                        if (list.checkEmpty() == true) {
                            System.out.println("\tThe list is empty!");
                            break;
                        } else {
                            list.viewModelList();
                            //Nhap Model can update
                            System.out.print("\nModel to update: ");
                            String updateModel = sc.nextLine();
                            if (list.updatePhone(updateModel) == true) {
                                System.out.println("\tFinished Update!\n");
                            }
                        }

                        do {
                            //Kiem tra User co tiep tuc hay khong                            
                            System.out.print("Do you want to continue?(yes/no): ");
                            confirm = sc.nextLine();
                            if (!confirm.equals("yes") && !confirm.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                        } while (!confirm.equals("yes") && !confirm.equals("no"));
                    } while (!confirm.equals("no"));
                    System.out.println("\tReturning Menu!\n");
                    break;

                case 4:
                    do {
                        // Xuat ra danh sach Model va kiem tra list trống
                        sc = new Scanner(System.in);
                        System.out.println("[Model List]");
                        if (list.checkEmpty() == true) {
                            System.out.println("\tThe list is empty!");
                            break;
                        } else {
                            //Xoa phan tu
                            list.viewModelList();
                            list.removePhone();
                        }

                        do {
                            //Kiem tra User co tiep tuc hay khong                            
                            System.out.print("Do you want to continue?(yes/no): ");
                            confirm = sc.nextLine();
                            if (!confirm.equals("yes") && !confirm.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                        } while (!confirm.equals("yes") && !confirm.equals("no"));
                    } while (!confirm.equals("no"));
                    System.out.println("\tReturning Menu!\n");
                    break;

                case 5:
                    // Xuat ra danh sach Phone va kiem tra list trống
                    if (list.checkEmpty() == true) {
                        System.out.println("\tThe list is empty!\n");
                        break;
                    } else {
                        System.out.println("╔═══════════════════════════════"
                                + "════════════════════════════════════════════════════╗");
                        System.out.printf("%-12s %-18s %-12s %-12s %-20s %-14s %-15s %-12s \n",
                                "║ MODEL", " ║ CPU", "  ║ RAM", "   ║ CAM", "    ║ SCREEN SIZE", "  ║     PRICE", " ║ COLOR", " ║ BRAND");
                        System.out.println("╠════════════════════════════════"
                                + "═══════════════════════════════════════════════════╝");
                        list.outputList();
                    }
                    break;

                case 6:
                    //Kiem tra list trống 
                    if (list.checkEmpty() == true) {
                        System.out.println("\tThe list is empty!\n");
                        break;
                    } else {
                        // Xuat File
                        list.exportPhoneList("data.dat");
                        System.out.println("\tPhone successfully stored!\n");
                    }
                    break;

                case 7:
                    System.out.println("\tSEE YOU LATER!");
                    loop = false;
                    break;
            }
        } while (loop);
    }
}
