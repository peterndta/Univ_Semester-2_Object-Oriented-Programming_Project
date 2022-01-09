package validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class myValidation {
    public static double checkBalance(double num) throws Exception{
        if(num < 0) throw new Exception("Please input the balnce > 0 : ");
        return num;
    }
}
