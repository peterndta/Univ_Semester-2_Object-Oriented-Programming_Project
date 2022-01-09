/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DTO.SinhVien;
import MyLIB.Validation;
import java.util.Scanner;
/**
 *
 * @author Peter
 */
public class DSSV {
    private SinhVien[] list;
    private int n;
    public static final int MAX = 100;
    public DSSV(){
        list =new SinhVien[MAX];
        n=0;
    }
    // Cai cac ham contstructor,addSV,updateSV,removeSV,xuatDSSV
    // Tim kiem sinh vien dua vao ma tra ve dia chi tim thay
    // Em co the viet them cac ham nao cam thay can thiet

    public DSSV(SinhVien[] list, int n) {
        this.list = list;
        this.n = n;
    }
    
    // Them Sinh Vien
    public boolean themSV(SinhVien x) {
        if (x == null || n > 100) {
            return false;
        }
        list[n] = x;
        n++;
        return true;
    } 
    public boolean kiemtraSV(String ma){
        for(int i = 0; i < n; i++){
            if(list[i].getMa().equals(ma))
                return false;            
        }
        return true;
    }
    // Tim Sinh Vien
    public SinhVien timSV(String ma){
        for(int i = 0; i<n; i++){
            if(list[i].getMa().equals(ma))
                return list[i];
        }
        return null;
    }
    
    // Cap nhat Sinh Vien    
    public int timViTriSV(String ma) {
        for (int i = 0; i < n; i++) {
            if (list[i].getMa().equals(ma)) {
                return i;
            }
        }
        return -100;  
    }   
    public boolean capnhatSV(String sv) {
        boolean laplai=false;
        Scanner sc = new Scanner(System.in);
        int SVcapnhat=timViTriSV(sv);
        String TenMoi = null;
        
        if (SVcapnhat == -100) {
            System.out.println("\tCap nhat That Bai!\n");
            return false;
        } else {                                
            do{
                try{
                    sc=new Scanner(System.in);
                    System.out.print("Nhap Ten SV moi: ");
                    TenMoi=sc.nextLine();
                    boolean ketqua=Validation.kiemtraString(TenMoi, "^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
                    laplai=false;
                }catch(Exception e){
                    if(e.getMessage()!=null)
                        System.out.println(e.getMessage());
                    laplai=true;
                }
            }while(laplai);
            
            if (TenMoi.equals("")) {
                list[SVcapnhat].setTen(list[SVcapnhat].getTen());
            } else {
                list[SVcapnhat].setTen(TenMoi);
            }
        }
        return true;        
    }
    
    //Xoa Sinh Vien
    public void xoaSV(){
	Scanner sc = new Scanner(System.in);
	String MaCanxoa;
        int xoa=1;
	System.out.print("MSSV can Xoa: ");
	MaCanxoa = sc.nextLine();
	for(int i = 0; i < n; i++){
            if(list[i].getMa().equals(MaCanxoa)) {
                n--;               
                for(int j = i; j < n; j++)
                    list[j] = list[j+1];	 
                    System.out.println("\tXoa Thanh Cong!\n");
                    xoa=0;
                break;		                 
            }else{
                xoa=1;
            }
        }
        if(xoa==1){
            System.out.println("\tXoa That Bai!\n");
        }
    }
    
    
    // Xuat Sinh Vien
    public void xuatSV() {
        for (int i = 0; i < n; i++) {
            list[i].output();
        }
    }
    public void viewSV(){
        for (int i = 0; i < n; i++) {
            System.out.println(list[i]);
        }  
    }
}

