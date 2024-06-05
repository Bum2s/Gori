package com.project1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.db.DBConn;

public class Login {
    private Scanner sc = new Scanner(System.in);

    public String loging() {
        String userId = null;

        try {
            Connection conn = DBConn.getConnection();
            
            int ch;
            while(true) {
            	do {
            		System.out.println("╔═══════════════════════════════════════════════════════════╗");
            		System.out.println("║         ██████╗      ██████╗     ██████╗     ██╗          ║");
            		System.out.println("║        ██╔════╝     ██╔═══██╗    ██╔══██╗    ██║          ║");
            		System.out.println("║        ██║  ███╗    ██║   ██║    ██████╔╝    ██║          ║");
            		System.out.println("║        ██║   ██║    ██║   ██║    ██╔══██╗    ██║          ║");
            		System.out.println("║        ╚██████╔╝    ╚██████╔╝    ██║  ██║    ██║          ║");
            		System.out.println("║         ╚═════╝      ╚═════╝     ╚═╝  ╚═╝    ╚═╝          ║");
            		System.out.println("╠═══════════════════════════════════════════════════════════╣");
            		System.out.println("║             1.계 정 생 성  2.로 그 인  3.E X I T               ║");
            		System.out.println("╚═══════════════════════════════════════════════════════════╝");
                    System.out.print("선택: ");

                ch = sc.nextInt();
                sc.nextLine();
            	}while(ch<1);
                switch (ch) {
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        userId = login();
                        if ("system".equals(userId)) {
                        	System.out.println("!!!!!!!!!!");
                        	break;
                        }else {
                        
                        if (userId != null) {
                            if (!hasPaymentHistory(userId)) {
                                PaymentSystem paymentSystem = new PaymentSystem();
                                paymentSystem.performPayment(userId);
                            } else {
                                System.out.println("✧ 이미 결제한 내역이 있습니다.✧ ");
                                return userId;
                            }
                        }
                        }
                        break;
                    case 3:
                    	System.out.println("╔═══════════════════════════════════════════════════════════╗");
                    	System.out.println("║                    ⣿⡟⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⡇                    ║");
                    	System.out.println("║                    ⣿⡇         ⢀⣠⣾⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                    ⣿⡇  ⣴⣶⣦    ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                    ⣠⣤⣤ ⠻⠿⠟    ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                 ⢀⣴⣿⡿⠿⣿⣿⣿⣧⡀    ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                ⠘⠛⠋ ⣸⣿⣿⡿⢿⣷⣶⣶⡆  ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                  ⢰⣿⣿⣿⠃ ⠉⠉⠉    ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║             ⢰⣶⣶⣶⣶⣿⡿⠻⣿⣷⣄       ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║             ⠈⠉⠉⠉⠉⠁⣴⡇ ⣿⣿       ⢸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                   ⣿⡇ ⣿⣿       ⠸⣿⣿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                   ⣿⡇ ⠛⠛       ⠈⠙⢿⣿⣿⣿⣿⡇                    ║");
                    	System.out.println("║                   ⣿⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⡇                    ║");
                    	System.out.println("╠═══════════════════════════════════════════════════════════╣");
                    	System.out.println("║     ███████╗       ██╗  ██╗       ██╗       ████████╗     ║");
                    	System.out.println("║     ██╔════╝       ╚██╗██╔╝       ██║       ╚══██╔══╝     ║");
                    	System.out.println("║     █████╗          ╚███╔╝        ██║          ██║        ║");
                    	System.out.println("║     ██╔══╝          ██╔██╗        ██║          ██║        ║");
                    	System.out.println("║     ███████╗       ██╔╝ ██╗       ██║          ██║        ║");
                    	System.out.println("║     ╚══════╝       ╚═╝  ╚═╝       ╚═╝          ╚═╝        ║");
                    	System.out.println("╚═══════════════════════════════════════════════════════════╝");
                        conn.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("✧ 올바른 선택이 아닙니다. 다시 선택하세요.✧ ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }

    private boolean hasPaymentHistory(String userId) {
        try {
            Connection conn = DBConn.getConnection();
            String sql = "SELECT * FROM Pay WHERE user_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void registerUser() {
        try {
            System.out.println("✧ 계정생성을 위해 ID, PW, 전화번호를 입력하세요.✧ ");

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("전화번호: ");
            String phoneNumber = sc.nextLine();

            registerUser(id, password, phoneNumber);

            System.out.println("✧ 계정생성이 완료되었습니다.✧ ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerUser(String id, String password, String phoneNumber) {
        try {
            Connection conn = DBConn.getConnection();
            String sql = "INSERT INTO UserAccounts (user_id, password_hash, phone_number) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.setString(2, password);
                ps.setString(3, phoneNumber);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String login() {
        try {
            String loginCorrect = null;

            while (true) {
                System.out.println("ID와 PW를 입력하세요.");
                System.out.print("ID: ");
                String loginId = sc.nextLine();
                System.out.print("Password: ");
                String loginPassword = sc.nextLine();

                if (checkLogin(loginId, loginPassword)) {
                    System.out.println("로그인 성공!");
                    loginCorrect = loginId;
                    break;
                } else {
                    System.out.println("✧ 로그인 실패. ID 또는 비밀번호가 올바르지 않습니다.✧ ");
                    System.out.println("✧ 다시 ID와 PW를 입력해주세요.✧ ");
                }
            }
            return loginCorrect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean checkLogin(String id, String password) {
        try {
            Connection conn = DBConn.getConnection();
            String sql = "SELECT * FROM UserAccounts WHERE user_id = ? AND password_hash = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}