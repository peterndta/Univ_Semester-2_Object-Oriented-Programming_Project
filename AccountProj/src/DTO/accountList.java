/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author HP
 */
public class accountList{
    TreeSet<account> list;

    public accountList(TreeSet<account> list) {
        this.list = list;
    }
    public accountList(){
        list = new TreeSet();
    }   
    
    public boolean addAccount(account newAccount){
        if(newAccount == null) return false;
        return list.add(newAccount);
    }
    public void displayAll(){
        Iterator<account> userNameList = list.iterator();
        while(userNameList.hasNext()){
            System.out.println(userNameList.next());
        }
    }
    public account checkValidInfor(String username,String password){
        for (account object : list) {
            if(object.getUserName().equals(username) && object.getPassWord().equals(password)) return object;
        }
        return null;
    }
 
}
