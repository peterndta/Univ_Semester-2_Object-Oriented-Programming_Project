/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Score {

    private String MaMH;
    private double Score;


    public Score(String MaMH, double Score) {
        this.MaMH = MaMH;
        this.Score = Score;
    }

    public Score() {
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }
    
    public void inputScores(){
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        System.out.print("Môn: ");
        MaMH = sc.nextLine().toUpperCase();
        System.out.print("Điểm: ");
        Score = sc.nextDouble();
    }
    
@Override
    public String toString() {
        return MaMH + ":" + Score;
    }
    public void outputScores() {
        System.out.println(MaMH + ": " + Score);
    }

}
