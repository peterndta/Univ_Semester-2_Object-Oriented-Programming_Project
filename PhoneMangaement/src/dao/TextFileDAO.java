/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Phone;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import manager.PhoneList;

/**
 *
 * @author Peter
 */
public class TextFileDAO {

    // Ham ghi PhoneList vao text File
    public static void writeFile(Phone[] list, int count, String filename) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filename);
            for (int i = 0; i < count; i++) {
                String temp = list[i].toString();
                printWriter.println(temp);
            }
        } catch (Exception e) {
            System.out.println("\tSomething wrong!\n");
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                System.out.println("\tCannot close File!\n");
            }
        }
    }

    // Ham nay de mo text file doc noi dung va convert thanh array Phone
    public static Phone[] readFile(String filename) {
        Phone[] arrayPhone = null;
        ArrayList<Phone> result = new ArrayList<>(); //Tao arraylist luu Phone lay trong file 
        FileReader fileReader = null;
        BufferedReader bufferedReader = null; // dung de doc 1 hang       
        try {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String temp = bufferedReader.readLine(); //Đọc từng dòng trong file 
                if (temp != null && !temp.isEmpty()) {
                    String[] array = temp.split("/"); // split cat chuoi thanh nhieu chuoi con de truyen vao constructor khoi tao phone moi
                    if (array.length == 8) {
                        Phone fileData = new Phone(array[0], array[1], array[2], array[3],
                                array[4], parseDouble(array[5]), array[6], array[7]);
                        result.add(fileData);
                    }
                }                
            }
            arrayPhone = new Phone[result.size()];
            arrayPhone = result.toArray(arrayPhone);
        } catch (Exception e) {
            PhoneList phone= new PhoneList();
            phone.exportPhoneList("data.dat");
            System.out.println("\tPlease restart again!\n");
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                
            } catch (Exception e) {
                System.out.println("\tCannot close File!\n");
                
            }
        }
        return arrayPhone;
    }
}
