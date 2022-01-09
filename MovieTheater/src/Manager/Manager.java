/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DTO.Ticket;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Peter
 */
public class Manager {
    Vector<Ticket> list=new Vector<>();
    int n=0;
    public void addTicket(Ticket x){
        list.add(x);
    }
    
    public void SortTicket(){
        Collections.sort(list);
    }
    public void Display(){
        for (Ticket dog : list) {
            System.out.println(dog);
        }
    }
    public void writeFile(String filename){
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            for (Ticket info : list) {
                w.println(info);
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
        }System.out.println("\tSuccess!");
    }
}
