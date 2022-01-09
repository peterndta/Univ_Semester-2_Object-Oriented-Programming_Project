/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyLIB;

/**
 *
 * @author Peter
 */
public class Validation {
    public static boolean kiemtraString(String chuoinhap, String pattern) throws Exception {
        if(chuoinhap==null) throw new Exception("\tInput is NULL!");
        if(pattern==null) throw new Exception("\tMau la NULL!");
        if(!chuoinhap.matches(pattern)) throw new Exception("\tInvalid\n");
        return true;
    }
}
