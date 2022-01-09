/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DTO.MonHoc;
import DTO.PhieuDiem;
import DTO.SinhVien;
import java.util.Scanner;
/**
 *
 * @author Peter
 */

// Dung Exception cung voi do/while 
public class Tester2 {
    public static void thu() {
        // nhap n tu ban phim, n >=10 && n<=50
        int n;
        boolean tieptuc=false;
        Scanner sc=new Scanner(System.in);
        do{
            try{
                sc=new Scanner(System.in);
                
                System.out.println("nhap n: ");
                n=sc.nextInt();
                if(n<10 || n>50)
                    throw new Exception();
                System.out.println("n da nhap: "+ n);
                tieptuc=false;
            }catch(Exception e){
                System.out.println("nhap n sai");
                tieptuc=true;
            }        
        }while(tieptuc);
    }
           
    public static void main(String[] args) {
        //Tester2.thu();
        SinhVien sv=new SinhVien();
        sv.input();
        //PhieuDiem pd=new PhieuDiem();
        //pd.input();
        //MonHoc mh=new MonHoc();
        //mh.input();
    }
}
