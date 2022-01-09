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
public class MonHoc {
    private String ma;
    private String ten;
    private boolean daxoa;
//--------------Constructor-----------------------------------------------------
    public MonHoc() {
        ma="";
        ten="";     
        daxoa=true;
    }

    public MonHoc(String ma, String ten, boolean daxoa) {
        this.ma = ma;
        this.ten = ten;
        this.daxoa = daxoa;
    }
    
//-------------Getter-Setter----------------------------------------------------
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
//------------------End---------------------------------------------------------    
    public void input(){
        Scanner sc=new Scanner(System.in);
        boolean tieptuc=false;        
        do{
            try{
                do{
                    sc=new Scanner(System.in);
                    System.out.print("Nhap Ma Mon Hoc: ");
                    ma=sc.nextLine();
                    boolean ketqua=Validation.kiemtraString(ma, "([A-Z])\\w+");
                    tieptuc=false;
                    if(ma.length()<4){
                        System.out.println("\tMa Mon Hoc phai >=4!");
                    }
                }while(ma.length()<4);
            }catch(Exception e){
                if(e.getMessage()!=null)
                    System.out.println(e.getMessage());
                tieptuc=true;
            }
        }while(tieptuc);
        
        do{
            try{
                do{
                    sc=new Scanner(System.in);
                    System.out.print("Nhap Ten Mon Hoc: ");
                    ten=sc.nextLine();
                    boolean ketqua=Validation.kiemtraString(ten, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                    tieptuc=false;
                    if(ten.length()<3 || ten.length()>10){
                        System.out.println("\tTen Mon Hoc phai >=3 HOAC <=10!");
                    }
                }while(ten.length()<3 || ten.length()>10);
            }catch(Exception e){
                if(e.getMessage()!=null)
                    System.out.println(e.getMessage());
                tieptuc=true;
            }
        }while(tieptuc);
    }
    
    public void output(){
        System.out.printf("%-9s %-10s %-9s \n",ma, ten, daxoa);
    }

    @Override
    public String toString() {
        return "\t" +ma + "  "  + ten + "  " + daxoa + "(status)";
    }
    
}

