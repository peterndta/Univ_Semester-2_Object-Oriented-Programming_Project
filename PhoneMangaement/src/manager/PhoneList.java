/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.TextFileDAO;
import dto.Phone;
import java.util.Scanner;
import validation.MyValidation;

/**
 *
 * @author Peter
 */
public class PhoneList {

    private Phone[] list;
    private int count;
    public static final int MAX = 100;

    public PhoneList() {
        list = new Phone[MAX];
        count = 0;
    }

    public PhoneList(Phone[] list, int count) {
        this.list = list;
        this.count = count;
    }

    // Them Dien Thoai    
    public boolean addPhone(Phone temp) {
        if (count > 100) {
            return false;
        }
        list[count] = temp;
        count++;
        return true;
    }

    // Kiem tra trùng
    public boolean duplicateModel(String model) {
        for (int i = 0; i < count; i++) {
            if (list[i].getModel().equals(model)) {
                return true;
            }
        }
        return false;
    }

    // Tìm kiem
    public boolean searchPhone(String model) {
        int check = 0;
        if (model.isEmpty()) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (list[i].getModel().contains(model)) {
                System.out.println(list[i].toString());
                check++;
            }
        }
        if (check == 0) {
            return false;
        }
        return true;
    }

    // Kiem tra List trống
    public boolean checkEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    //Tim Vi Tri dien thoai trong List dua vao Model
    public int locatePhone(String model) {
        for (int i = 0; i < count; i++) {
            if (list[i].getModel().equals(model)) {
                return i;
            }
        }
        return -1;
    }

    // Cap nhat thong tin Phone moi dua vao Model
    public void updateCpu(int location) {
        Scanner sc = new Scanner(System.in);
        String cpu = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("CPU [begin with char]: ");
                    cpu = sc.nextLine();
                    MyValidation.checkString(cpu, "^[a-zA-Z]+(?!\\s).+$");
                    if (cpu.length() > 16) {
                        System.out.println("\tYour lenght must be under 16 characters!\n");
                    }
                    loop = false;
                } while (cpu.length() > 16);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setCpu(cpu);
        
    }

    public void updateRam(int location) {
        Scanner sc = new Scanner(System.in);
        String ram = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("RAM [Ex: 16 GB/MB || RAM >= 1]: ");
                    ram = sc.nextLine();
                    MyValidation.checkString(ram, "^[0-9]+(\\.[0-9]+)*(\\ (GB|MB))$");
                    if (ram.equals("0 GB") || ram.equals("0 MB")) {
                        System.out.println("\tRAM must > 0!\n");
                    }
                    if (ram.length() > 9) {
                        System.out.println("\tYour length must be under 6 digits!\n");
                    }
                    loop = false;
                } while (ram.equals("0 GB") || ram.equals("0 MB") || ram.length() > 9);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setRam(ram);
        
    }

    public void updateCam(int location) {
        Scanner sc = new Scanner(System.in);
        String primaryCam = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Primary Camera [Ex: 12 MP || Cam >= 1]: ");
                    primaryCam = sc.nextLine();
                    MyValidation.checkString(primaryCam, "^[0-9]+(\\.[0-9]+)*(\\ (MP))$");
                    if (primaryCam.equals("0 MP")) {
                        System.out.println("\tPrimary Camera must > 0!\n");
                    }
                    if (primaryCam.length() > 9) {
                        System.out.println("\tYour length must be under 6 digits!\n");
                    }
                    loop = false;
                } while (primaryCam.equals("0 MP") || primaryCam.length() > 9);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setPrimaryCam(primaryCam);
        
    }

    public void updateScreenSize(int location) {
        Scanner sc = new Scanner(System.in);
        String screen_size = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Screen Size [Ex: 5.5 inches]: ");
                    screen_size = sc.nextLine();
                    MyValidation.checkString(screen_size, "^[0-9]+(\\.[0-9]+)*(\\ (inches))$");
                    if (screen_size.equals("0 inches")) {
                        System.out.println("\tScreen Size must > 0!\n");
                    }
                    if (screen_size.length() > 13) {
                        System.out.println("\tYour length must be under 6 digits!\n");
                    }
                    loop = false;
                } while (screen_size.equals("0 inches") || screen_size.length() > 13);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setScreen_size(screen_size);
        
    }

    public void updatePrice(int location) {
        Scanner sc = new Scanner(System.in);
        double price = 0;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Price [number only]: ");
                    price = sc.nextDouble();
                    if (price < 1) {
                        System.out.println("\tPrice must > 0!\n");
                    }
                    if (price > 9999999) {
                        System.out.println("\tYour length must be under 7 digits!\n");
                    }
                    loop = false;
                } while (price < 1 || price > 9999999);
            } catch (Exception e) {
                System.out.println("\tInvalid, Try again!\n");
                loop = true;
            }
        } while (loop);
        list[location].setPrice(price);
        
    }

    public void updateColor(int location) {
        Scanner sc = new Scanner(System.in);
        String color = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Color [char only]: ");
                    color = sc.nextLine();
                    MyValidation.checkString(color, "^[a-zA-Z]+[a-zA-Z ]*$");
                    if (color.length() > 13) {
                        System.out.println("\tYour lenght must be under 13 characters!\n");
                    }
                    loop = false;
                } while (color.length() > 13);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setColor(color);
        

    }

    public void updateBrand(int location) {
        Scanner sc = new Scanner(System.in);
        String brand = null;
        boolean loop = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Brand [char only]: ");
                    brand = sc.nextLine();
                    MyValidation.checkString(brand, "^[a-zA-Z]+[a-zA-Z ]*$");
                    if (brand.length() > 13) {
                        System.out.println("\tYour lenght must be under 13 characters!\n");
                    }
                    loop = false;
                } while (brand.length() > 13);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
        list[location].setBrand(brand);
        
    }

    public boolean updatePhone(String updateModel) {
        Scanner sc = new Scanner(System.in);
        int location = locatePhone(updateModel);
        // Kiem tra tim thay phone can update hay khong
        if (location == -1) {
            System.out.println("\tCannot find phone to update!\n");
            return false;
        } else {
            // Khi tim duoc phone, thuc hien update
            sc = new Scanner(System.in);
            int choice = 0;
            boolean loop = true;
            boolean liLoop = true;
            do {
                System.out.println("╔---------------------------╗");
                System.out.println("    1. CPU");
                System.out.println("    2. RAM");
                System.out.println("    3. Primary Camera");
                System.out.println("    4. Screen size");
                System.out.println("    5. Price");
                System.out.println("    6. Color");
                System.out.println("    7. Brand");
                System.out.println("    8. Update All");
                System.out.println("    9. Back to Menu");
                System.out.println("╚----------------------------╝ ");
                do {
                    try {
                        sc = new Scanner(System.in);
                        System.out.print(" >> Choice: ");
                        choice = sc.nextInt();
                        if (choice < 1 || choice > 9) {
                            System.out.println("\tPlease Input from 1-9!\n");
                            liLoop = true;
                        }
                        liLoop = false;
                    } catch (Exception e) {
                        System.out.println("\tYour choice is inValid! Please Input Again!\n");
                        liLoop = true;
                    }
                } while (liLoop);
                switch (choice) {
                    case 1:
                        updateCpu(location);
                        System.out.println("\tCPU successfully updated!\n");
                        break;
                    case 2:
                        updateRam(location);
                        System.out.println("\tRAM successfully updated!\n");
                        break;
                    case 3:
                        updateCam(location);
                        System.out.println("\tCamera successfully updated!\n");
                        break;
                    case 4:
                        updateScreenSize(location);
                        System.out.println("\tScreen Size successfully updated!\n");
                        break;
                    case 5:
                        updatePrice(location);
                        System.out.println("\tPrice successfully updated!\n");
                        break;
                    case 6:
                        updateColor(location);
                        System.out.println("\tColor successfully updated!\n");
                        break;
                    case 7:
                        updateBrand(location);
                        System.out.println("\tBrand successfully updated!\n");
                        break;
                    case 8:
                        updateCpu(location);
                        updateRam(location);
                        updateCam(location);
                        updateScreenSize(location);
                        updatePrice(location);
                        updateColor(location);
                        updateBrand(location);
                        System.out.println("\tPhone successfully updated!\n");
                        break;
                    case 9:
                        loop = false;
                        break;
                }
            } while (loop);
        }
        return true;
    }

    // Xoa Phone ra khoi List dua vao Model
    public void removePhone() {
        Scanner sc = new Scanner(System.in);
        String removeModel;
        String confirm;
        int check = 1;
        System.out.print("\nModel to remove: ");
        removeModel = sc.nextLine();
        do {
            //Kiem tra User co tiep tuc hay khong                            
            System.out.print("Do you want to remove [" + removeModel + "] (yes/no): ");
            confirm = sc.nextLine();
            if (!confirm.equals("yes") && !confirm.equals("no")) {
                System.out.println("\tMust choose yes/no!\n");
            }
        } while (!confirm.equals("yes") && !confirm.equals("no"));
        
        //Xóa phần tử
        for (int i = 0; i < count; i++) {
            if (list[i].getModel().equals(removeModel) && confirm.equals("yes")) {
                 count--;
                //Đẩy model ra khỏi mảng
                for (int j = i; j < count; j++) { 
                    list[j] = list[j + 1];
                }
                System.out.println("\tPhone successfully removed!\n");
                check = 0;
                break;
            } else {
                check = 1;
            }
        }
        if (check == 1) {
            System.out.println("\tCannot remove this Phone!\n");
        }
    }
    
    // Sắp xếp giảm dần
    public void sortList(){
        int i, j;
        Phone temp;
        for (i = 0; i < count; i++) {
            for (j = i + 1; j < count; j++) {
                if (list[i].getModel().compareTo(list[j].getModel()) < 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
    
    // Ham Xuat         
    // Xuat giam dan
    public void outputList() {
        sortList();
        for (int i = 0; i < count; i++) {
            list[i].outputData();
            System.out.println("╚═════════════════════════════════"
                    + "══════════════════════════════════════════════════╝");
        }
    }

    // Xem danh sach model
    public void viewModelList() {
        sortList();
        for (int i = 0; i < count; i++) {
            list[i].viewModel();
        }
    }

    // Luu danh sach vao File
    public void exportPhoneList(String filename) {
        TextFileDAO.writeFile(list, count, filename);
    }

    // Lay danh sach tu File
    public void inportPhoneList(String filename) {
        int i;
        Phone[] loadedList = TextFileDAO.readFile(filename);
        for (i = 0; i < loadedList.length; i++) {
            list[i] = loadedList[i];
        }
        count = i;
    }

}
