/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Scanner;
import validation.MyValidation;

/**
 *
 * @author Peter
 */
public class Phone {

    private String model;
    private String cpu;
    private String ram;
    private String primaryCam;
    private String screen_size;
    private double price;
    private String color;
    private String brand;
//---------------Constructor----------------------------------------------------

    public Phone() {
        model = "empty";
        cpu = "empty";
        ram = "0";
        primaryCam = "0";
        screen_size = "0";
        price = 0;
        color = "empty";
        brand = "empty";
    }

    public Phone(String model, String cpu, String ram, String primaryCam,
            String screen_size, double price, String color, String brand) {
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.primaryCam = primaryCam;
        this.screen_size = screen_size;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

//--------------Getter-Setter---------------------------------------------------
    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPrimaryCam() {
        return primaryCam;
    }

    public void setPrimaryCam(String primaryCam) {
        this.primaryCam = primaryCam;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//-----------------End----------------------------------------------------------
    // Ham Nhap Du Lieu
    public void inputPhone() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        // Nhap Model
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Model [begin with char]: ");
                    model = sc.nextLine();
                    MyValidation.checkString(model, "^[a-zA-Z]+(?!\\s).+$");
                    if (model.length() > 11) {
                        System.out.println("\tYour lenght must be under 11 characters!\n");
                    }
                    loop = false;
                } while (model.length() > 11);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);

        // Nhap CPU
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

        // Nhap RAM
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

        // Nhap Primary Camera
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

        // Nhap Screen size
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

        // Nhap price
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

        // Nhap color
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

        // Nhap brand
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Brand [char only]: ");
                    brand = sc.nextLine();
                    MyValidation.checkString(brand, "^[a-zA-Z]+[a-zA-Z ]*$");
                    if (brand.length() > 30) {
                        System.out.println("\tYour lenght must be under 13 characters!\n");
                    }
                    loop = false;
                } while (brand.length() > 30);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
                loop = true;
            }
        } while (loop);
    }

    // Ham Xuat Du Lieu
    // Xuat danh sach
    @Override
    public String toString() {
        return model + "/" + cpu + "/"
                + ram + "/" + primaryCam + "/"
                + screen_size + "/" + price + "/"
                + color + "/" + brand;
    }

    public void outputData() {
        System.out.printf("║ %-12s║ %-18s║ %-12s║ %-12s║ %-17s║%12s$║ %-14s║ %-12s \n",
                model, cpu, ram, primaryCam, screen_size, price, color, brand);
    }

    // Xuat Model
    public void viewModel() {
        System.out.println("     " + model);
    }
}
