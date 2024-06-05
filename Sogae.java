package com.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.db.DBConn;
public class Sogae {

	
	
	SogaeDAO dao = new SogaeDAO();
	Scanner sc = new Scanner(System.in);
	
	int result = 0;
	
	public void insert(String id) {
		
		SogaeDTO dto = new SogaeDTO();
		SogaeDAO dao = new SogaeDAO();
		System.out.println("✧ 닉네임을 입력해주세요 : ✧ ");
		dto.setNik(sc.next());
		System.out.println("✧ 이름을 입력해주세요 : ✧ ");
		dto.setName(sc.next());
		System.out.println("✧ 나이를 입력해주세요 : ✧ ");
		dto.setAge(sc.nextInt());
		System.out.println("✧ 성별을 입력해주세요 : ✧ ");
		dto.setSung(sc.next());
		System.out.println("✧ 키를 입력해주세요 : ✧ ");
		dto.setHeight(sc.nextInt());
		System.out.println("✧ 학력을 입력해주세요 : ✧ ");
		dto.setEdu(sc.next());
		System.out.println("✧ 직업을 입력해주세요 : ✧ ");
		dto.setJob(sc.next());
		System.out.println("✧ 연봉을 입력해주세요(~천만원) : ✧ ");
		dto.setSal(sc.nextInt());
		System.out.println("✧ 취미를 입력해주세요 : ✧ ");
		dto.setHobby(sc.next());
		System.out.println("✧ 사는곳을 입력해주세요 : ✧ ");
		dto.setPlace(sc.next());
		System.out.println("✧ 출신학교를 입력해주세요 : ✧ ");
		dto.setSchool(sc.next());
		
		if ("대졸".equals(dto.getEdu())) {
		    if (dto.getAge() >= 20 && dto.getAge() <= 31 && dto.getSal() >= 6000 ) {
		        dto.setRanking(1); 
		    } else if (dto.getAge() >= 32 && dto.getAge() <= 35 && dto.getSal() >= 4500 ) {
		        dto.setRanking(2); 
		    } else if (dto.getAge() >= 36 && dto.getSal() >= 3800 ) {
		        dto.setRanking(3);
		    } else {
		        dto.setRanking(4); 
		    }
		} else {
		    if (dto.getAge() >= 20 && dto.getAge() <= 31 && dto.getSal() >= 6500 ) {
		        dto.setRanking(1); 
		    } else if (dto.getAge() >= 32 && dto.getAge() <= 35 && dto.getSal() >= 4800) {
		        dto.setRanking(2); 
		    } else if (dto.getAge() >= 36  && dto.getSal() >= 4000) {
		        dto.setRanking(3); 
		    } else {
		        dto.setRanking(4); 
		    }
		}
		 dto.setUser_id(id);
		
		 result = dao.insertData(dto);
		
		if(result!=0) {
			System.out.println("✧ 회원가입 성공!✧ ");
		}else {
			System.out.println("✧ 회원가입 실패!✧ ");
		}
	
	
}

	public void selectAll() {
		SogaeDAO dao = new SogaeDAO();
		List<SogaeDTO> lists = dao.getList();
		Iterator<SogaeDTO> it = lists.iterator();
		while(it.hasNext()) {
			SogaeDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}


public void rankingSort(String ui) {
	
	SogaeDTO dto = new SogaeDTO();
     SogaeDAO dao = new SogaeDAO();
     int selectRank;
     
    
     
      System.out.println("✧ 최소등급을 설정하세요: ✧ ");
      selectRank = sc.nextInt();
    
     
     List<SogaeDTO> result = dao.searchRanking(ui,selectRank);
     for (SogaeDTO dto1 : result) {
    	 
    	 System.out.printf( "%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto1.getNik(),dto1.getName() , dto1.getSung(), dto1.getAge() ,dto1.getHeight()  ,dto1.getEdu(),dto1.getJob()
		         ,dto1.getSal(),dto1.getHobby(),dto1.getPlace(),dto1.getSchool(),dto1.getRanking());
		         System.out.println();
          
     }
     //시간날때 do while 추가
}
public void eduSort(String ui) {
	SogaeDTO dto = new SogaeDTO();
     SogaeDAO dao = new SogaeDAO();

    System.out.println("✧ 학력을 선택해주세요(고졸,대졸) : ✧ ");
    String selectEdu = sc.next();

    List<SogaeDTO> result = dao.searchEdu(ui,selectEdu);
    for (SogaeDTO dto1 : result) {
    	  System.out.printf( "%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto1.getNik(),dto1.getName() , dto1.getSung(), dto1.getAge() ,dto1.getHeight()  ,dto1.getEdu(),dto1.getJob()
    		         ,dto1.getSal(),dto1.getHobby(),dto1.getPlace(),dto1.getSchool(),dto1.getRanking());
    		         System.out.println();
    	// dto.toString1();
    }
}

public void salSort(String ui) {
	 SogaeDTO dto =  new SogaeDTO();
     SogaeDAO dao = new SogaeDAO();

    System.out.println("✧ 최소 연봉을 설정해주세요 : ✧  ");
    int selectSal = sc.nextInt();

    List<SogaeDTO> result = dao.searchSal(ui,selectSal);

    for (SogaeDTO dto1 : result) {
    	 System.out.printf( "%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급", dto1.getNik(), dto1.getName() , dto1.getSung(), dto1.getAge() ,dto1.getHeight()  ,dto1.getEdu(),dto1.getJob()
		         ,dto1.getSal(),dto1.getHobby(),dto1.getPlace(),dto1.getSchool(),dto1.getRanking());
		         System.out.println();
    }
}

public void ageSort(String  ui) {
	 SogaeDTO dto = new SogaeDTO();
     SogaeDAO dao = new SogaeDAO();

   System.out.println("✧ 최대 나이를 설정해주세요 : ✧ ");
   int selectAge = sc.nextInt();

   List<SogaeDTO> result = dao.searchAge(ui,selectAge);

   for (SogaeDTO dto1 : result) {
	   System.out.printf( "%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto1.getNik(), dto1.getName() , dto1.getSung(), dto1.getAge() ,dto1.getHeight()  ,dto1.getEdu(),dto1.getJob()
		         ,dto1.getSal(),dto1.getHobby(),dto1.getPlace(),dto1.getSchool(),dto1.getRanking());
		         System.out.println();
   }
}

public void randomSearch(String ui) {
    SogaeDAO dao = new SogaeDAO();
    System.out.println("✧ 랜덤한 인원을 불러옵니다✧ ");

    List<SogaeDTO> result = dao.getRandom(ui);
    
    for (SogaeDTO dto : result) {
    	info();
        System.out.printf("%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto.getNik(),
                dto.getName(), dto.getSung(), dto.getAge(), dto.getHeight(), dto.getEdu(), dto.getJob(),
                dto.getSal(), dto.getHobby(), dto.getPlace(), dto.getSchool(), dto.getRanking());
        System.out.println();
    }
}
public void recSaram(String ui) {
    SogaeDAO dao = new SogaeDAO();
    
    List<SogaeDTO> result = dao.getRecommand(ui);
    
    if (result.isEmpty()) {
        System.out.println("✧ 존재하는 회원정보가 없습니다✧ ");
        return;
    } else {
        System.out.println("✧ 추천 해주는 소개팅 상대✧ ");
        info();
        for (SogaeDTO dto : result) {
            System.out.printf("%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto.getNik(),dto.getName(),dto.getSung(), dto.getAge() ,dto.getHeight() ,dto.getEdu(),dto.getJob()
                ,dto.getSal(),dto.getHobby(),dto.getPlace(),dto.getSchool(),dto.getRanking());
            System.out.println();
        }
    }
    int ch;

    while(true) {
        do {    
            System.out.println("[1.매칭 신청 ] [2.등급별 선택]  [3.학력별 선택] [4.연봉별 선택] [5.나이별 선택] [6.뒤로가기]");
            ch = sc.nextInt();
        } while(ch < 1);

        switch(ch) {
            case 1: 
                match();
                image1();
                System.out.println("✧ 매칭신청이 완료되었습니다✧ ");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                if (isAmountValid(ui, 5000)) {
                    System.out.println("✧ 10000원을 결제하지 않아서 선택이 불가능합니다✧ ");
                } else {
                    switch(ch) {
                        case 2: rankingSort(ui); break;
                        case 3: eduSort(ui); break;
                        case 4: salSort(ui); break;
                        case 5: ageSort(ui); break;
                    }
                }
                break;
            case 6: 
                return;
            default: 
                System.out.println("✧ 올바른 번호를 입력해주세요✧ ");
        }
    }
}

private boolean isAmountValid(String user_id, int expectedAmount) {
    try {
        Connection conn = DBConn.getConnection();
        String sql = "SELECT amount FROM Pay WHERE user_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user_id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int amount = rs.getInt("amount");
                    return amount == expectedAmount;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

public void match() {
	SogaeDTO dto = new SogaeDTO();
    SogaeDAO dao = new SogaeDAO();

  System.out.println("✧ 신청할 상대의 닉네임을 입력해주세요 : ✧ ");
  String snik = sc.next();

  List<SogaeDTO> result = dao.getSogaeNik(snik);

  for (SogaeDTO dto1 : result) {
	   System.out.printf( "%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급",dto1.getNik(), dto1.getName() , dto1.getSung(), dto1.getAge() ,dto1.getHeight()  ,dto1.getEdu(),dto1.getJob()
		         ,dto1.getSal(),dto1.getHobby(),dto1.getPlace(),dto1.getSchool(),dto1.getRanking());
		         System.out.println();
  }
}

public void back() {
    System.out.println("\n[8. 뒤로가기]");
    String command = sc.nextLine();
    if (command.equals("8")) {
      return;
    }
  }

public void Thread() {
	LoadingBar loadingBar = new LoadingBar();

    Thread loadingThread = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i += 25) {
                loadingBar.updateProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println();
        }
    });

    loadingThread.start();

    try {
        loadingThread.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}


public void ranMain(String ui) {
     while (true) {
    	 randomSearch(ui);
         System.out.println("1. 랜덤 상대 재검색");
         System.out.println("2. 매칭 신청하기");
         System.out.println("3. 뒤로가기");
         System.out.print("선택: ");

         int ch = sc.nextInt();

         switch (ch) {
             case 1:
                 randomSearch(ui);
                 break;
             case 2:
            	 System.out.println("✧ 매칭할 상대의 닉네임을 알려주세요 :✧ ");
            	 String mnik = sc.next();
            	 image1();
            	 System.out.println("          ✧ 매칭 신청이 완료 되었습니다 ✧         ");
            	 break;
             case 3:
            	 return;
             default:
                 System.out.println("✧ 올바른 선택이 아닙니다. 다시 선택해주세요.✧ ");
         }
}
}













public void info() {
	System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════╗");
	System.out.println("║  닉네임 ｜ 이 름 ｜  성 별  ｜ 나 이 ｜  신 장  ｜ 학력 ｜ 직 업 ｜  연 봉  ｜  취 미 ｜ 거주지 ｜ 출 신 학 교 ｜　등 급  ║ ");
	System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");
}

						
public void image1() {
	System.out.println("╔═══════════════════════════════════════════════════════════╗");
	System.out.println("║                     ⣶⣶⣶⣶⣶⡆     ⣶⣶⣶⣶⣶⡆                     ║");
	System.out.println("║                   ⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆                   ║");
	System.out.println("║                 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                  ║");
	System.out.println("║                 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                  ║");
	System.out.println("║                 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                  ║");
	System.out.println("║                 ⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿                  ║");
	System.out.println("║                   ⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠇                   ║");
	System.out.println("║                     ⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠇                     ║");
	System.out.println("║                      ⠸⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠇                       ║");
	System.out.println("║                        ⠘⠛⢻⣿⣿⣿⣿⣿⠛⠃                         ║");
	System.out.println("║                          ⠘⠛⣿⣿⠛⠛                           ║");
	System.out.println("║                            ⠛⠛                             ║");
	System.out.println("╠═══════════════════════════════════════════════════════════╣");
	System.out.println("║   ███╗   ███╗   █████╗   ████████╗   ██████╗  ██╗  ██╗    ║");
	System.out.println("║   ████╗ ████║  ██╔══██╗  ╚══██╔══╝  ██╔════╝  ██║  ██║    ║");
	System.out.println("║   ██╔████╔██║  ███████║     ██║     ██║       ███████║    ║");
	System.out.println("║   ██║╚██╔╝██║  ██╔══██║     ██║     ██║       ██╔══██║    ║");
	System.out.println("║   ██║ ╚═╝ ██║  ██║  ██║     ██║     ╚██████╗  ██║  ██║    ║");
	System.out.println("║   ╚═╝     ╚═╝  ╚═╝  ╚═╝     ╚═╝      ╚═════╝  ╚═╝  ╚═╝    ║");
	System.out.println("╚═══════════════════════════════════════════════════════════╝");
}
public void image2() {
	System.out.println("╔═══════════════════════════════════════════════════════════╗");
	System.out.println("║                                     ⢀⣠⣤⠆                  ║");
	System.out.println("║         ⣀⣀⣀                     ⢀⠄⠈⣿⣿⠋                    ║");
	System.out.println("║         ⢻⣿⡗⠐⠄⡀               ⢀⡔⠉  ⡤⠋                      ║");
	System.out.println("║          ⠙⢧   ⠁⠢⡀           ⣰⠋  ⡴⠚⠁                       ║");
	System.out.println("║           ⠈⠳⢤    ⠳⠤⠒⠛⠋⠛⠛⠛⠛⠛⠛ ⣀⠔⠊        ⣀⡠⠔⢦⡀             ║");
	System.out.println("║              ⠉⠓⠢⢤            ⠢     ⢀⡠⠴⠊⠁    ⠱⣄            ║");
	System.out.println("║                  ⡆⢀⣠⢤     ⢰⣉⣿⡄⠈⡀⣀⡤⠚⠉         ⠘⢆           ║");
	System.out.println("║                  ⡇⠸⣷⣾⠇ ⠰⠆ ⠈⠛⠛⣠⣤⣫ ⣰⠷⠷⣦          ⢧          ║");
	System.out.println("║                  ⣧⣤⣌⠁ ⢶⣾⣿⣿⡇ ⢸⣿⣿⣿⠟⠁ ⢨⣿⣿⣿⣿⣿⣶⣶⣶⠖⠒⠒⠁          ║");
	System.out.println("║                  ⢿⣿⣿⠂ ⠘⣿⣿⣿⠃  ⢉⠟⠁   ⡼⠿⠛⠋⠉⠁                 ║");
	System.out.println("║                   ⠙⢅⡀  ⠈⠛⠋  ⠸⠁   ⢀⣸⣆                      ║");
	System.out.println("║                    ⡜⠉  ⠘⠻⠿⠟⠁      ⠾⣿⣿⣧⡀                   ║");
	System.out.println("╠═══════════════════════════════════════════════════════════╣");
    System.out.println("║     ███████╗       ██╗  ██╗       ██╗       ████████╗     ║");
    System.out.println("║     ██╔════╝       ╚██╗██╔╝       ██║       ╚══██╔══╝     ║");
    System.out.println("║     █████╗          ╚███╔╝        ██║          ██║        ║");
    System.out.println("║     ██╔══╝          ██╔██╗        ██║          ██║        ║");
    System.out.println("║     ███████╗       ██╔╝ ██╗       ██║          ██║        ║");
    System.out.println("║     ╚══════╝       ╚═╝  ╚═╝       ╚═╝          ╚═╝        ║");
    System.out.println("╚═══════════════════════════════════════════════════════════╝");
}
}
