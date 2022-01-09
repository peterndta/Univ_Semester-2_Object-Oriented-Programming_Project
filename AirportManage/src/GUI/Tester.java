/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Manager.AirportManager;

/**
 *
 * @author Peter
 */
public class Tester {
    public static void main(String[] args) {
        AirportManager am=new AirportManager();
        am.loadData();
        am.printCountry();
        am.LargestAirport();
    }
}
