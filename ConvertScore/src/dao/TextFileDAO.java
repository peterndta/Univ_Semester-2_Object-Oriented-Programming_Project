/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import DTO.Score;
import Manager.ScoresList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;


/**
 *
 * @author Peter
 */
public class TextFileDAO {


    public static void writeFileScore(Score[] list, int count, String filename) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filename);
            for (int i = 0; i < count; i++) {
                String temp = list[i].toString();
                printWriter.println(temp);
            }
        } catch (Exception e) {
            System.out.println("\tSomething wrong!\n");
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                System.out.println("\tCannot close File!\n");
            }
        }
    }

    public static Score[] readFileScore(String filename) {
        Score[] arrayBook = null;
        ArrayList<Score> result = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;      
        try {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String temp = bufferedReader.readLine(); 
                if (temp != null && !temp.isEmpty()) {
                    String[] array = temp.split(":");
                    if (array.length == 2) {
                        Score fileData = new Score(array[0], parseDouble(array[1]));
                        result.add(fileData);
                    }
                }
            }
            arrayBook = new Score[result.size()];
            arrayBook = result.toArray(arrayBook);
        } catch (Exception e) {
            ScoresList book = new ScoresList();
            book.exportScoreList("score.txt");
            System.out.println("\tPlease restart again!\n");
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (Exception e) {
                System.out.println("\tCannot close File!\n");

            }
        }
        return arrayBook;
    }


}
