/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class PhieuDiem {
    private SinhVien sv;
    private MonHoc mh;
    private float PE;
    private float FE;
//------------Getter-Setter-----------------------------------------------------
    public SinhVien getSv() {
        return sv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public float getPE() {
        return PE;
    }

    public float getFE() {
        return FE;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public void setPE(float PE) {
        this.PE = PE;
    }

    public void setFE(float FE) {
        this.FE = FE;
    }
//---------------------End------------------------------------------------------    
    public void output(){
        System.out.printf("%-9s %-24s %-9s %-10s %-9s %-9s %-9s \n",
                sv.getMa(), sv.getTen(), mh.getMa(), mh.getTen(),mh.isDaxoa(), PE, FE);
    }
    
}
