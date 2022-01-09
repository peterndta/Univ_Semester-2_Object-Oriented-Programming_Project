/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DTO.MonHoc;
import MyLIB.Validation;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class DSMH {
    private MonHoc[] list;
    private int n;
    public static final int MAX = 100;
    public DSMH(){
        list =new MonHoc[MAX];
        n=0;
    }

    public DSMH(MonHoc[] list, int n) {
        this.list = list;
        this.n = n;
    }
    // Cai cac ham contstructor,addMH,updateMH,removeMH,xuatDSMH
    // Them Mon Hoc
    public boolean themMH(MonHoc x) {
        if (x == null || n > 100) {
            return false;
        }
        list[n] = x;
        n++;
        return true;
    }     
    public boolean kiemtraMH(String ma){
        for(int i = 0; i < n; i++){
            if(list[i].getMa().equals(ma))
                return false;            
        }
        return true;
    }
    
    public MonHoc timMonHoc(String ma){
        for(int i = 0; i<n; i++){
            if(list[i].getMa().equals(ma))
                return list[i];
        }
        return null;
    }
    // Cap nhat Mon Hoc 
    public int timViTriMH(String ma) {
        for (int i = 0; i < n; i++) {
            if (list[i].getMa().equals(ma)) {
                return i;
            }
        }
        return -100;  
    }   

    public boolean capnhatMH(String mh) {
        boolean tieptuc=false;
        Scanner sc = new Scanner(System.in);
        int MHcapnhat=timViTriMH(mh);
        String MaMoi = null, TenMoi = null;
        
        if (timViTriMH(mh) == -100) {
            System.out.println("\tCap nhat That Bai!\n");
            return false;
        } else {            
            do{
                try{
                    do{
                        System.out.print("Nhap Ma Mon Hoc moi: ");
                        MaMoi=sc.nextLine();
                        boolean ketqua=Validation.kiemtraString(MaMoi, "([A-Z])\\w+");
                        tieptuc=false;
                        if(MaMoi.length()<4){
                            System.out.println("\tMa Mon Hoc phai >=4!");
                        }
                    }while(MaMoi.length()<4);
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
                        System.out.print("Nhap Ten Mon Hoc moi: ");
                        TenMoi=sc.nextLine();
                        boolean ketqua=Validation.kiemtraString(TenMoi, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                        tieptuc=false;
                        if(TenMoi.length()<3 || TenMoi.length()>10){
                            System.out.println("\tTen Mon Hoc phai >=3 HOAC <=10!");
                        }
                    }while(TenMoi.length()<3 || TenMoi.length()>10);
                }catch(Exception e){
                    if(e.getMessage()!=null)
                        System.out.println(e.getMessage());
                    tieptuc=true;
                }
            }while(tieptuc);
            
            if (MaMoi.equals("")) {
                list[MHcapnhat].setMa(list[MHcapnhat].getMa());
            } else {
                list[MHcapnhat].setMa(MaMoi);
            }
            if (TenMoi.equals("")) {
                list[MHcapnhat].setTen(list[MHcapnhat].getTen());
            } else {
                list[MHcapnhat].setTen(TenMoi);
            }
        }
        return true;        
    }
    
    //Xoa Mon Hoc
        public boolean xoaMH(String ma){
        int i;
        for(i = 0 ; i < n ; i++){
            if(list[i].getMa().equals(ma)){
                list[i].setDaxoa(false);
                return true;
            }
        }
        return false;
    }
    
    // Xuat Mon Hoc
    public void xuatMH() {
        for (int i = 0; i < n; i++) {
            list[i].output();
        }
    }
    public void viewMH(){
        for (int i = 0; i < n; i++) {
            System.out.println(list[i]);
        }  
    }
}
