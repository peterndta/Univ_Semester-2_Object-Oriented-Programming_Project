/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Score;
import dao.TextFileDAO;

/**
 *
 * @author Admin
 */
public class ScoresList {

    private Score[] list;
    private int count;
    public static final int MAX = 100000;

    public ScoresList(Score[] list, int count) {
        this.list = list;
        this.count = count;
    }

    public ScoresList() {
        list = new Score[MAX];
        count = 0;
    }

    public boolean addScores(Score temp) {
        if (count > 100) {
            return false;
        }
        list[count] = temp;
        count++;
        return true;
    }

    public void outputScores() {
        for (int i = 0; i < count; i++) {
            list[i].outputScores();
        }
    }

    public void EducationUSA() {
        for (int i = 0; i < count; i++) {
            if (list[i].getScore() > 8.9 && list[i].getScore() < 11) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: A+ <=> 4.0" + " Điểm bạn Xuất sắc! <=> Outstanding\n");
            }
            if (list[i].getScore() > 7.9 && list[i].getScore() < 9) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: A <=> 3.5" + " Điểm bạn Giỏi! <=> Excellent / Very Good\n");
            }
            if (list[i].getScore() > 7 && list[i].getScore() < 8) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: B+ <=> 3.0" + " Điểm bạn Khá! <=> Good\n");
            }
            if (list[i].getScore() > 5.9 && list[i].getScore() < 7) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: B <=> 2.5" + " Điểm bạn Trung Bình! <=> Average\n");
            }
            if (list[i].getScore() > 4 && list[i].getScore() < 6) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: C <=> 2.0" + " Điểm bạn Yếu! <=> Marginal\n");
            }
            if (list[i].getScore() < 5) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: D <=> 1.0" + " Điểm bạn Kém! <=> Fail\n");
            }
        }

    }

    public void Standardized() {
        for (int i = 0; i < count; i++) {
            if (list[i].getScore() >= 8 && list[i].getScore() <= 10) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: A <=> 4.0" + " Điểm bạn Giỏi! <=> Excellent / Outstanding\n");
            }
            if (list[i].getScore() > 6.4 && list[i].getScore() < 8) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: B <=> 3.0" + " Điểm bạn Khá! <=> Good\n");
            }
            if (list[i].getScore() > 4 && list[i].getScore() < 6.5) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: C <=> 2.0" + " Điểm bạn Trung Bình! <=> Average\n");
            }
            if (list[i].getScore() > 3 && list[i].getScore() < 5) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: D <=> 1.0" + " Điểm bạn Yếu! <=> Marginal\n");
            }
            if (list[i].getScore() < 4) {
                System.out.print(list[i].getMaMH() + " " + list[i].getScore() + " is: F" + " Điểm bạn Kém! <=> Fail\n");
            }
        }

    }

    public void average(int total) {
        double aver = 0;
        for (int i = 0; i < count; i++) {
            aver += list[i].getScore();
        }
        double temp = aver / total;
        System.out.println("Điểm TB: " + temp + "\n");
        System.out.println("\tEducation USA");
        // USA
        if (temp >= 9 && temp < 11) {
            System.out.print(temp + " is: A+ <=> 4.0" + " Điểm bạn Xuất sắc! <=> Outstanding\n");
        }
        if (temp >= 8 && temp < 9) {
            System.out.print(temp + " is: A <=> 3.5" + " Điểm bạn Giỏi! <=> Excellent / Very Good\n");
        }
        if (temp > 7 && temp < 8) {
            System.out.print(temp + " is: B+ <=> 3.0" + " Điểm bạn Khá! <=> Good\n");
        }
        if (temp >= 6 && temp < 7) {
            System.out.print(temp + " is: B <=> 2.5" + " Điểm bạn Trung Bình! <=> Average\n");
        }
        if (temp >= 5 && temp < 6) {
            System.out.print(temp + " is: C <=> 2.0" + " Điểm bạn Yếu! <=> Marginal\n");
        }
        if (temp < 5) {
            System.out.print(temp + " is: D <=> 1.0" + " Điểm bạn Kém! <=> Fail\n");
        }
        System.out.println("\tStandardized Convert University GPAs");
        // Standard
        if (temp >= 8 && temp <= 10) {
            System.out.print(temp + " is: A <=> 4.0" + " Điểm bạn Giỏi! <=> Excellent / Outstanding\n");
        }
        if (temp > 6.4 && temp < 8) {
            System.out.print(temp + " is: B <=> 3.0" + " Điểm bạn Khá! <=> Good\n");
        }
        if (temp > 4 && temp < 6.5) {
            System.out.print(temp + " is: C <=> 2.0" + " Điểm bạn Trung Bình! <=> Average\n");
        }
        if (temp > 3 && temp < 5) {
            System.out.print(temp + " is: D <=> 1.0" + " Điểm bạn Yếu! <=> Marginal\n");
        }
        if (temp < 4) {
            System.out.print(temp + " is: F" + " Điểm bạn Kém! <=> Fail\n");
        }

    }
//-------File Managing Methods---------------------------------------------- 
    // Luu danh sach vao File

    public void exportScoreList(String filename) {
        TextFileDAO.writeFileScore(list, count, filename);
    }

    // Lay danh sach tu File
    public void importScoreList(String filename) {
        int i;
        Score[] loadedList = TextFileDAO.readFileScore(filename);
        for (i = 0; i < loadedList.length; i++) {
            list[i] = loadedList[i];
        }
        count = i;
    }

// Kiem tra List trống
    public boolean checkEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }
}
