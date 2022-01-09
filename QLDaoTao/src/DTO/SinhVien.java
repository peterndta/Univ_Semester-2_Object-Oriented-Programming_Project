/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Manager.DSSV;
import MyLIB.Validation;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class SinhVien {
    private String ma;
    private String ten;
//----------------Constructor---------------------------------------------------
    public SinhVien() {
        ma="";
        ten="";
    }

    public SinhVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    
//----=-----------Getter-Setter-------------------------------------------------    
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
//---------------------End------------------------------------------------------    
    public void input(){
        boolean tieptuc=false;
        Scanner sc=new Scanner(System.in);
          do{
            try{
                    sc=new Scanner(System.in);
                    System.out.print("Nhap MSSV (SExxx): ");
                    ma=sc.nextLine();
                    Validation.kiemtraString(ma, "SE[0-9]{3}");
                    if(!ma.matches("SE[0-9]{3}")){
                        System.out.println("Do not matches ");
                    }    
                    tieptuc=false;
            }catch(Exception e){
                if(e.getMessage()!=null)
                    System.out.println(e.getMessage());
                tieptuc=true;
            }
        }while(tieptuc);
        // check ten
        tieptuc=false;
        sc=new Scanner(System.in);
        do{
            try{
                sc=new Scanner(System.in);
                System.out.print("Nhap Ten SV: ");
                ten=sc.nextLine();
                boolean ketqua=Validation.kiemtraString(ten, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                tieptuc=false;
            }catch(Exception e){
                if(e.getMessage()!=null)
                    System.out.println(e.getMessage());
                tieptuc=true;
            }
        }while(tieptuc);
    }

    public void output(){
        System.out.printf("%-9s %-28s \n",ma, ten);
    }

    @Override
    public String toString() {
        return "\t" + ma + " " + ten ;
    }
    
    
}
