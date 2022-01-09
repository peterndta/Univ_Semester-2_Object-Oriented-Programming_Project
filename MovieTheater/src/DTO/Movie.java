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
public class Movie {
    private int id;
    private String title;

    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return id + "-" + title;
    }
    
    public void inputMovie(){
        Scanner sc=new Scanner(System.in);
        boolean tieptuc=false;
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
                System.out.print("Input Movie Title: ");
                title=sc.nextLine();
                boolean ketqua=Validation.kiemtraString(title, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                tieptuc=false;
            }catch(Exception e){
                System.out.println("Something wrong!");
                tieptuc=true;
            }
        }while(tieptuc);
    }
    
}
