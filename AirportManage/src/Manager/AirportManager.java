/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DAO.TextFileDAO;
import DTO.Airport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Peter
 */
public class AirportManager {
    HashMap<String, Airport> map=new HashMap<>();
    
    public void loadData(){
        map = TextFileDAO.readFile("in.txt");
    }
    public void printCountry(){
        TextFileDAO.writeFile1(map, "out1.txt");
    }
    
    public void LargestAirport(){
        String LargestAirportCountry = "";
        Set<String> AirportList=map.keySet();                
        Airport largestAir=null;
        long max=0;
        for(String country : AirportList){
            long area = map.get(country).getArea();
            if(area > max){
                max = area;
                LargestAirportCountry = country;
                largestAir = map.get(country);                
            }
        }
        TextFileDAO.writeFile2(LargestAirportCountry, largestAir.getName(), "out2.txt");                  
    }
   
}
