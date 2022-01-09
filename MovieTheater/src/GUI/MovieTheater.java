/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import DTO.Ticket;
import Manager.Manager;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class MovieTheater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Manager obj=new Manager();
        boolean loop = true;

        int choice = 0;  
        do {
            System.out.println("╔===========================╗");
            System.out.println("|    __  ________  ____  __  |\n" +
                                "|   /  |/  / __/ |/ / / / /  |\n" +
                                "|  / /|_/ / _//    / /_/ /   |\n" +
                                "| /_/  /_/___/_/|_/\\____/    |");
            System.out.println("╠===========================╣");
            System.out.println("| 1. Add a ticket            |");
            System.out.println("| 2. Sort by ticket's ID     |");
            System.out.println("| 3. Write to file           |");    
            System.out.println("| 4. Exit                    |");
            System.out.println("╚===========================╝"); 
            boolean liLoop=false;
            do{
                try{
                    sc = new Scanner(System.in);
                    System.out.print(" >> Choice: ");
                    choice = sc.nextInt();
                    if(choice < 1 || choice > 4){
                        System.out.println("\tPlease Input from 1-4!\n");
                        liLoop = true;
                    }
                    liLoop = false;
                }catch (Exception e){
                        System.out.println("\tYour choice is inValid! Please Input Again!\n");
                        liLoop = true;
                }
            }while(liLoop);
                switch (choice) {
                    case 1:
                        Ticket ti=new Ticket();
                        ti.inputTicket();
                        obj.addTicket(ti);
                        break;
                    case 2:
                        obj.SortTicket();
                        obj.Display();
                        break;
                    case 3:    
                        obj.SortTicket();
                        obj.writeFile("out.txt");
                        break;
                    case 4:
                        System.out.println("                                 __ \n" +
" _____           _ _____        |  |\n" +
"|   __|___ ___ _| | __  |_ _ ___|  |\n" +
"|  |  | . | . | . | __ -| | | -_|__|\n" +
"|_____|___|___|___|_____|_  |___|__|\n" +
"                        |___|       ");
                        loop=false;
                        break;
            }
        } while (loop);
    }
}
    

