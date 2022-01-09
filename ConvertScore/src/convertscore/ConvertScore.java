/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertscore;

import DTO.Score;
import Manager.ScoresList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ConvertScore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ScoresList sl = new ScoresList();
        sl.importScoreList("score.txt");
        boolean loop = true;
        int choice = 0;
        do {
            System.out.println("╔═══════════════════════════╗");
            System.out.println("║        __  ________  ____  __             ║\n"
                    + "║       /  |/  / __/ |/ / / / /             ║\n"
                    + "║      / /|_/ / _//    / /_/ /              ║\n"
                    + "║     /_/  /_/___/_/|_/\\____/               ║");
            System.out.println("╠═══════════════════════════╣");
            System.out.println("║ 1. Thêm Điểm                              ║");
            System.out.println("║ 2. Xem Điểm đã nhập                       ║");
            System.out.println("║ 3. Tính theo U.S.A universities           ║");
            System.out.println("║ 4. Tính theo Standardized University GPAs ║");
            System.out.println("║ 5. Lưu vào 'score.txt'                    ║");
            System.out.println("║ 6. Tính trung bình                        ║");
            System.out.println("║-------------------------------------------║");
            System.out.println("║ 7. Thoát                                  ║");
            System.out.println("╚═══════════════════════════╝");
            boolean liLoop = true;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print(" >> Chọn: ");
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 7) {
                        System.out.println("\tChỉ chọn trong 1-8!\n");
                    }
                    liLoop = false;
                } catch (Exception e) {
                    System.out.println("\tLựa chọn không phù hợp! Xin thử lại!\n");
                    liLoop = true;
                }
            } while (liLoop);
            System.out.print("\n");

            switch (choice) {
                case 1:
                    String confirm;
                    do {
                        Score score = new Score();
                        sc = new Scanner(System.in);
                        score.inputScores();
                        if (sl.addScores(score) == false) {
                            System.out.println("\tThất bại!\n");
                        } else {
                            System.out.println("\tThành công!\n");
                        }

                        do {
                            sc = new Scanner(System.in);
                            //Kiem tra User co tiep tuc hay khong    
                            System.out.print("Bạn muốn tiếp tục?(y/n): ");
                            confirm = sc.nextLine();
                            if (!confirm.equals("y") && !confirm.equals("n")) {
                                System.out.println("\tBuộc chọn yes/no!\n");
                            }
                            if (confirm.equals("y")) {
                                System.out.print("\n");
                            }
                        } while (!confirm.equals("y") && !confirm.equals("n"));
                    } while (!confirm.equals("n"));
                    System.out.println("\tTrở về Menu!\n");

                    break;
                case 2:
                    if (sl.checkEmpty() == true) {
                        System.out.println("\tDanh sách điểm trống!\n");
                        break;
                    } else {
                        sl.outputScores();
                    }
                    break;

                case 3:
                    sl.EducationUSA();
                    break;
                case 4:
                    sl.Standardized();
                    break;

                case 5:
                    // Xuat File
                    sl.exportScoreList("score.txt");
                    System.out.println("\tĐã được lưu vào 'score.txt'!\n");
                    break;
                case 6:
                    int total;
                    sc = new Scanner(System.in);
                    System.out.print("Nhập số môn: ");
                    total = sc.nextInt();
                    sl.average(total);
                    break;
                case 7:
                    System.out.println("\tHẸN GẶP LẠI!");
                    loop = false;
                    break;
            }
        } while (loop);

    }
}
