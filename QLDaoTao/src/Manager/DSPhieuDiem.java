/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.PhieuDiem;

/**
 *
 * @author Peter
 */
public class DSPhieuDiem {

    private PhieuDiem[] list;
    private int n;

    public DSPhieuDiem() {
        list = new PhieuDiem[100];
        n = 0;
    }

    // Them Phieu Diem
    public void addPhieuDiem(PhieuDiem g) {
        list[n] = g;
        n++;
    }

    // Xuat Phieu Diem
    public int timViTriSV(String ma) {
        for (int i = 0; i < n; i++) {
            if (list[i].getSv().getMa().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void xuatPhieuDiem(String MaSV) {
        list[timViTriSV(MaSV)].output();
    }

}
