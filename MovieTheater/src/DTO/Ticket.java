/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import MyLIB.Validation;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Ticket implements Comparable<Ticket>{
    protected int id;
    protected int price;
    protected Movie formovie;
    protected String comsumer_name;


    public Ticket(int id, int price, Movie formovie, String comsumer_name) {
        this.id = id;
        this.price = price;
        this.formovie = formovie;
        this.comsumer_name = comsumer_name;
    }

    public Ticket() {
        formovie=new Movie();
        id=0;
        price=0;
        comsumer_name="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Movie getFormovie() {
        return formovie;
    }

    public void setFormovie(Movie formovie) {
        this.formovie = formovie;
    }

    public String getComsumer_name() {
        return comsumer_name;
    }

    public void setComsumer_name(String comsumer_name) {
        this.comsumer_name = comsumer_name;
    }

    @Override
    public String toString() {
        return id + "-" + price + "-" + formovie + "-" + comsumer_name;
    }
    
    public void inputTicket(){
        boolean tieptuc=false;
        Scanner sc=new Scanner(System.in);
        do{
            try{
                sc=new Scanner(System.in);
                System.out.print("Input ID: ");
                id=sc.nextInt();
                tieptuc=false;
            }catch(Exception e){
                System.out.println("Your Input must be number!");
                tieptuc=true;
            }
        }while(tieptuc);
        
        do{
            try{
                sc=new Scanner(System.in);
                System.out.print("Input Price: ");
                price=sc.nextInt();
                tieptuc=false;
            }catch(Exception e){
                System.out.println("");
                tieptuc=true;
            }
        }while(tieptuc);
        
        formovie.inputMovie();
        
        do{
            try{
                sc=new Scanner(System.in);
                System.out.print("Input Consumer name: ");
                comsumer_name=sc.nextLine();
                boolean ketqua=Validation.kiemtraString(comsumer_name, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                tieptuc=false;
            }catch(Exception e){
                System.out.println("Something wrong!");
                tieptuc=true;
            }
        }while(tieptuc);        
    }

    @Override
    public int compareTo(Ticket o) {
        if(id>o.getId()) return -1;
        else if(id<o.getId()) return 1;
        return 0;
    }
}
