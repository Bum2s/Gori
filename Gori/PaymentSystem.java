package com.project1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.db.DBConn;

public class PaymentSystem {
    public void performPayment(String userId) {
        try {
            Connection conn = DBConn.getConnection();
            Scanner sc = new Scanner(System.in);
            while (true) {
            	System.out.println("╔═══════════════════════════════════════════════════════════╗");
        		System.out.println("║               ⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀                 ║");
        		System.out.println("║               ⢸⣿⠉⠉⠉⣹⡟⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⢿⣏⠉⠉⠉⣿⡇                ║");
        		System.out.println("║               ⢸⣿ ⢀⣴⡿⠁   ⢀⣴⣶⠾⠿⢶⣦⣀   ⠈⢿⣦⡀ ⣿⡇⢰⣿              ║");
        		System.out.println("║               ⢸⣿⠿⠟⠋    ⣴⡟⠉⢠⣿⣿⡄⠈⢻⣦    ⠙⠻⠿⣿⡇⢸⣿ ⣴⡆           ║");
        		System.out.println("║               ⢸⣿      ⢰⣿  ⠸⢿⣿⡀  ⣿⡄      ⣿⡇⢸⣿ ⣿⡇           ║");
        		System.out.println("║               ⢸⣿      ⠈⣿⡄ ⢴⣿⣿⠟ ⢠⣿⠁      ⣿⡇⢸⣿ ⣿⡇           ║");
        		System.out.println("║               ⢸⣿⠛⠿⣶⣄   ⠈⠿⣦⣄⣀⣀⣠⣴⡿⠃   ⣠⣶⠟⠛⣿⡇⢸⣿ ⣿⡇           ║");
        		System.out.println("║               ⢸⣿  ⠈⢿⡆    ⠈⠉⠛⠛⠉⠁    ⣰⡿⠁  ⣿⡇⢸⣿ ⣿⡇           ║");
        		System.out.println("║               ⠸⠿⠶⠶⠶⠾⠿⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠿⠷⠶⠶⠶⠿⠇⢸⣿ ⣿⡇           ║");
        		System.out.println("║                  ⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⣿ ⣿⡇           ║");
        		System.out.println("║                    ⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿⡇           ║");
        		System.out.println("║                    ⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁           ║");
        		System.out.println("╠═══════════════════════════════════════════════════════════╣");
        		System.out.println("║            ██████╗        █████╗       ██╗   ██╗          ║");
        		System.out.println("║            ██╔══██╗      ██╔══██╗      ╚██╗ ██╔╝          ║");
        		System.out.println("║            ██████╔╝      ███████║       ╚████╔╝           ║");
        		System.out.println("║            ██╔═══╝       ██╔══██║        ╚██╔╝            ║");
        		System.out.println("║            ██║           ██║  ██║         ██║             ║");
        		System.out.println("║            ╚═╝           ╚═╝  ╚═╝         ╚═╝             ║");
        		System.out.println("╚═══════════════════════════════════════════════════════════╝");
                System.out.println(" [1. 5000원 결제]   [2. 10000원 결제]  [3.돌아가기] ");
                System.out.print("선택: ");
                int choice = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                switch (choice) {
                    case 1:
                        makePayment(userId, 5000);
                        System.out.println("✧ 5000원 결제가 완료되었습니다.✧ ");
                        break;
                    case 2:
                        makePayment(userId, 10000);
                        System.out.println("✧ 10000원 결제가 완료되었습니다.✧ ");
                        break;
                    case 3:
                        System.out.println("✧ 돌아가기✧ ");
                        return;
                    default:
                        System.out.println("✧ 올바른 선택이 아닙니다. 다시 선택하세요.✧ ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makePayment(String userId, int amount) {
        try {
            Connection conn = DBConn.getConnection();
            String sql = "INSERT INTO Pay (user_id, amount) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userId);
                ps.setInt(2, amount);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}