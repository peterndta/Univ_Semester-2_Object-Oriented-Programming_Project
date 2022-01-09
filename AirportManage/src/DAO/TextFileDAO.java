/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Airport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Peter
 */
public class TextFileDAO {
    public static HashMap<String, Airport> readFile(String filename) {    
        FileReader f = null;
        BufferedReader r = null; 
        HashMap<String, Airport> list = new HashMap();
        try {
            f = new FileReader(filename);
            r = new BufferedReader(f);
            while (r.ready()) {
                String tam = r.readLine();
                if (tam != null && !tam.isEmpty()) {
                    String[] arr = tam.split(","); 
                    if (arr.length == 5) { 
                        Airport x = new Airport(arr[0], arr[1], arr[2], parseLong(arr[4])); 
                        list.put(arr[3], x);                        
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something wrong");
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
        return list;
    }
    
    public static void writeFile1(HashMap<String, Airport> list, String filename) {
        Airport arr=new Airport();
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            Set<String> AirportList = list.keySet();
            for (String country : AirportList) {
                String a = list.get(country).toString(country);
                w.println(a);
                w.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void writeFile2(String country, String name, String filename) {
      PrintWriter w = null; 
        try {
            w = new PrintWriter(filename);
            String a = country + "-" + name;
            w.write(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }  
}
