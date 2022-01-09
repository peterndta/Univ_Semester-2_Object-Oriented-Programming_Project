/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DTO.MonHoc;
import DTO.PhieuDiem;
import DTO.SinhVien;
import Manager.DSMH;
import Manager.DSPhieuDiem;
import Manager.DSSV;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Tester {
    public static void main(String[] args) {
        DSSV ds1=new DSSV();
        DSMH ds2=new DSMH();
        DSPhieuDiem ds3=new DSPhieuDiem();
        int choice=0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("╔==================================╗");
            System.out.println("|        __  ________  ____  __     |\n" +
                                "|       /  |/  / __/ |/ / / / /     |\n" +
                                "|      / /|_/ / _//    / /_/ /      |\n" +
                                "|     /_/  /_/___/_/|_/\\____/       |");
            System.out.println("╠==================================╣");
            System.out.println("| 1. Them Sinh Vien Moi             |");
            System.out.println("| 2. Cap nhat Sinh Vien bang MSSV   |");
            System.out.println("| 3. Xoa Sinh Vien bang MSSV        |");    
            System.out.println("| 4. Hien thi tat ca Sinh Vien      |");
            System.out.println("| 5. Them Mon Hoc Moi               |");
            System.out.println("| 6. Cap nhat Mon Hoc bang MSSV     |");
            System.out.println("| 7. Xoa Mon Hoc bang MSSV          |");
            System.out.println("| 8. Hien thi tat ca Mon Hoc        |");
            System.out.println("| 9. Them Phieu Diem                |");
            System.out.println("| 10. Hien thi Phieu Diem bang MSSV |");
            System.out.println("| 11. Thoat                         |");
            System.out.println("╚==================================╝");             
            boolean laplai=false;
            do{
                try{
                    sc = new Scanner(System.in);
                    System.out.print("Chon so: ");
                    choice = sc.nextInt();
                    if(choice < 1 || choice > 11){
                        System.out.println("\tXin hay chon tu 1-11!\n");
                        laplai = true;
                    }
                    laplai = false;
                }catch (Exception e){
                        System.out.println("\tLua chon khong phu hop! Vui long nhap lai!\n");
                        laplai = true;
                }
            }while(laplai);
            System.out.println("");
            switch(choice){
                case 1:
                    SinhVien tmp=new SinhVien();
                    do{
                        tmp.input();
                        if(ds1.kiemtraSV(tmp.getMa())==false)
                            System.out.println("\tMSSV da ton tai!");                    
                    }while(ds1.kiemtraSV(tmp.getMa())==false);
                    if (ds1.themSV(tmp)==false){
                        System.out.println("\tThat Bai!\n");
                    }else{
                        System.out.println("\tThem Thanh Cong!\n");
                    }
                    break;
                case 2:
                    sc = new Scanner(System.in);
                    System.out.println("Danh Sach Sinh Vien:");
                    ds1.viewSV();
                    System.out.print("\nMSSV can Cap Nhat: ");
                    String MaCapnhat = sc.nextLine();
                    if(ds1.capnhatSV(MaCapnhat)==true){
                        System.out.println("\tCap nhat Thanh Cong!\n");
                    }
                    break;
                case 3:
                    System.out.println("Danh Sach Sinh Vien:");
                    ds1.viewSV();
                    ds1.xoaSV();
                    break;
                case 4:                    
                    System.out.printf("%-9s %-28s \n","MSSV", "TenSV"); 
                    ds1.xuatSV();
                    System.out.println("\n");
                    break;
                case 5:
                    MonHoc tmp2=new MonHoc();
                    do{
                        tmp2.input();
                        if(ds2.kiemtraMH(tmp2.getMa())==false)
                            System.out.println("\tMaMH da ton tai!");                    
                    }while(ds2.kiemtraMH(tmp2.getMa())==false);
                    if (ds2.themMH(tmp2)==true){
                        System.out.println("\tThem Thanh Cong!\n");
                    }else{
                        System.out.println("\tThat Bai!\n");
                    }
                    break;
                case 6:
                    sc = new Scanner(System.in);
                    System.out.println("Danh Sach Mon Hoc:");
                    ds2.viewMH();
                    System.out.print("\nMa Mon Hoc can Cap Nhat: ");
                    String MAcapnhat2 = sc.nextLine();
                    if(ds2.capnhatMH(MAcapnhat2)==true){
                        System.out.println("\tCap nhat Thanh Cong!\n");
                    }
                    break;
                case 7:
                    sc = new Scanner(System.in);
                    System.out.println("Danh Sach Mon Hoc:");
                    ds2.viewMH();
                    System.out.print("\nMa Mon Hoc can Xoa: ");
                    String MaXoa2 = sc.nextLine();
                    if(ds2.xoaMH(MaXoa2)==true){
                        System.out.println("\tXoa Thanh Cong!\n");
                    }else{
                        System.out.println("\tKhong tim duoc Mon Hoc de Xoa!\n");
                    }
                    break;
                case 8:
                    System.out.printf("%-9s %-9s %-1s \n","MaMH", "TenMH", "STATUS");
                    ds2.xuatMH();
                    System.out.println("\n");
                    break;
                case 9:
                    PhieuDiem g=new PhieuDiem();
                    sc=new Scanner(System.in);
                    System.out.print("Nhap MSSV can nhap diem: ");
                    String masv=sc.nextLine();
                    System.out.print("Nhap MaMH can nhap diem: ");
                    sc=new Scanner(System.in);
                    String mamh=sc.nextLine();
                    SinhVien sv=ds1.timSV(masv);
                    MonHoc mh=ds2.timMonHoc(mamh);
                    if(sv==null || mh==null){
                        System.out.println("\tKhong tao diem duoc!\n");
                    }else{
                        boolean tieptuc=false;
                        g.setSv(sv);
                        g.setMh(mh);                       
                        do{
                            try{
                                do{
                                    sc=new Scanner(System.in);
                                    System.out.print("Nhap diem Practical Exam: ");
                                    g.setPE(sc.nextFloat());                                  
                                    tieptuc=false;
                                    if(g.getPE() < 0 || g.getPE() > 10){
                                        System.out.println("\tDiem PE phai >=0 HOAC <=10!\n");
                                    }
                                }while(g.getPE() < 0 || g.getPE() > 10);
                            }catch(Exception e){
                                System.out.println("\tVui long nhap lai!\n");
                                tieptuc=true;
                                }
                        }while(tieptuc);
                        
                        do{
                            try{
                                do{
                                    sc=new Scanner(System.in);
                                    System.out.print("Nhap diem Final Exam: ");
                                    g.setFE(sc.nextFloat());                                 
                                    tieptuc=false;
                                    if(g.getFE() < 0 || g.getFE() > 10){
                                        System.out.println("\tDiem FE phai >=0 HOAC <=10!\n");
                                    }
                                }while(g.getFE() < 0 || g.getFE() > 10);
                            }catch(Exception e){
                                System.out.println("\tVui long nhap lai!\n");
                                tieptuc=true;
                                }
                        }while(tieptuc);
                        ds3.addPhieuDiem(g);
                        System.out.println("\tThem Thanh Cong!\n");
                    }
                    break; 
                case 10:
                    sc = new Scanner(System.in);
                    System.out.print("Nhap MSSV can xuat Phieu Diem: ");
                    String MaSV = sc.nextLine();
                    if(ds3.timViTriSV(MaSV) == -1){
                        System.out.println("\tChua them Sinh Vien, Mon Hoc HOAC Phieu Diem!\n");
                    }else{
                        System.out.printf("%-9s %-24s %-9s %-9s %-10s %-9s %-9s \n","MSSV", "TenSV", "MaMH", "TenMH", "STATUS","PE", "FE");
                        ds3.xuatPhieuDiem(MaSV);
                    }
                    break;
                case 11:
                    System.out.println(" _____  ____   __  __    _____  _  ____  _____ \n" +
"|_   _|/ () \\ |  \\/  |   | () )| || ===||_   _|\n" +
"  |_| /__/\\__\\|_|\\/|_|   |_()_)|_||____|  |_|  ");
                    choice=0;                    
                    break;
            }
        }while(choice!=0);
    }
}
