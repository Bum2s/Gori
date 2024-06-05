	package com.project1;
	
	import java.util.Scanner;
	
	public class SogaeMain {
		
		
		public static void main(String[] args) {
			Advertisment ad = new Advertisment();
			Scanner sc = new Scanner(System.in);
			Login lg = new Login();
			Sogae ob = new Sogae();
			
			
			ad.start();
			int ch;
			String id = lg.loging();
				while(true) {
				 do {
					    System.out.println("╔═════════════════╗ ╔═════════════════╗ ╔═════════════════╗ ╔═════════════════╗");
						System.out.println("║  ⣴⣿⣿⣦     ⣴⣿⣿⣦  ║ ║   ⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤   ║ ║       ⣴⠟⠻⣦      ║ ║     ⣿⣿⣏⠉⠉⠻⣿⣿    ║");
						System.out.println("║  ⠻⣿⣿⠟ ⣴⣿⣦ ⠻⣿⣿⠟  ║ ║   ⣿⡟⠉⠉⢻⣿⣉⣉⣉⣉⣿   ║ ║      ⢸⣿⣷⡇⣿⡇     ║ ║     ⡟⠛⠛⠓  ⠈⢿    ║");
						System.out.println("║ ⣴⣿⣿⣿⣿⣦⠻⣿⠟⣴⣿⣿⣿⣿⣦ ║ ║   ⣿⣧⣀⣀⣼⣿⣉⣉⣉⣉⣿   ║ ║       ⠻⣗⣻⠟      ║ ║     ⣧⣤⣤⡤  ⢀⣾    ║");
						System.out.println("║ ⢿⣿⣿⣿⣿⣴⣾⣿⣿⣦⣿⣿⣿⣿⡿ ║ ║   ⣿⣤⣤⣤⣤⣿⣉⣉⣉⣉⣿   ║ ║      ⣴⣿⣿⣿⣿⣦     ║ ║     ⣿⣿⣏⣀⣀⣾⣿⣿    ║");
						System.out.println("╠═════════════════╣ ╠═════════════════╣ ╠═════════════════╣ ╠═════════════════╣");
						System.out.println("║   1.회 원 가 입	  ║ ║    2.매 칭 검 색   ║ ║   3.랜 덤 매 칭	  ║ ║    4.E X I T    ║");
						System.out.println("╚═════════════════╝ ╚═════════════════╝ ╚═════════════════╝ ╚═════════════════╝");
						System.out.println("✧ 원하는 번호를 선택해주세요 : ✧ ");
					ch = sc.nextInt();
				 }while(ch<1);
					
				 switch(ch) {
				    case 1:
				    	System.out.println("╔═══════════════════════════════════════════════════════════╗");
						System.out.println("║         ⢀⣴⣶⣶⣶⣶⣦⣄                       ⣠⣴⣶⣶⣶⣶⣶⣦⣄          ║");
						System.out.println("║        ⣴⣿⣿⣿⣿⣿⣿⣿⣿⣦       ⣠⣴⣶⣶⣶⣶⣦⣄      ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦         ║");
						System.out.println("║       ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧    ⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄   ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧        ║");
						System.out.println("║       ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿        ║");
						System.out.println("║       ⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏   ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏        ║");
						System.out.println("║        ⠙⢿⣿⣿⣿⣿⣿⣿⡿⠋    ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠙⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋         ║");
						System.out.println("║          ⠉⠛⠛⠛⠛⠉      ⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏     ⠉⠛⠛⠛⠛⠛⠛⠉          ║");
						System.out.println("║     ⣠⣴⣾⣿⣿⣿⣶⣤⣤⣤⣴⣾⣿⣿⣿⣶⣄ ⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋  ⣠⣾⣿⣿⣷⣦⣤⣤⣤⣴⣾⣿⣿⣿⣿⣄      ║");
						System.out.println("║    ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⢀⣤⠈⠛⠛⠛⠛⠛⠛⠁ ⣤⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦     ║");
						System.out.println("║   ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦    ║");
						System.out.println("║  ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦   ║");
						System.out.println("║ ⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦  ║");
						System.out.println("╠═══════════════════════════════════════════════════════════╣");
						System.out.println("║                                                           ║");
						System.out.println("║              ██╗    ██████╗    ██╗   ███╗   ██╗           ║");
						System.out.println("║              ██║   ██╔═══██╗   ██║   ████╗  ██║           ║");
						System.out.println("║              ██║   ██║   ██║   ██║   ██╔██╗ ██║           ║");
						System.out.println("║         ██   ██║   ██║   ██║   ██║   ██║╚██╗██║           ║");
						System.out.println("║         ╚█████╔╝   ╚██████╔╝   ██║   ██║ ╚████║           ║");
						System.out.println("║          ╚════╝     ╚═════╝    ╚═╝   ╚═╝  ╚═══╝           ║");
						System.out.println("╚═══════════════════════════════════════════════════════════╝");
						ob.Thread();
						ob.insert(id);
				   //     ob.Thread();
				        break;
				    case 2:
				    	ob.Thread();
				        ob.recSaram(id); 
				    		        break;
		
				    case 3:
				    	System.out.println("╔═══════════════════════════════════════════════════════════╗");
						System.out.println("║                    ⢀⣀⣀⣀⣀⣀⣀⡀  ⢀⣀⣀⣀⣀⣀⣀⡀                     ║");
						System.out.println("║                  ⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄                   ║");
						System.out.println("║                ⢠⣾⡿⠋⠁     ⢠⣿⣿⣿⣧      ⠉⠻⣿⣷                  ║");
						System.out.println("║               ⢠⣿⡿⠁      ⢠⣿⡿ ⢿⣿⣧       ⠻⣿⣷                 ║");
						System.out.println("║               ⣼⣿⡇       ⢸⣿⣿  ⣿⣿        ⢿⣿                 ║");
						System.out.println("║               ⢸⣿⡇       ⢸⣿⣿  ⣿⣿        ⣾⣿                 ║");
						System.out.println("║               ⠈⢿⣿⡄      ⠈⢿⣿⣄⣼⣿⠏       ⣼⣿⡿                 ║");
						System.out.println("║          ⣠⣶⣄   ⢿⣿⣿⣦⣄      ⣿⣿⣿⣿     ⣠⣾⣿⣿⡿    ⣠⣶⣄           ║");
						System.out.println("║          ⠙⢿⣿⣷⣤⣾⡿⠋⠛⠻⠿⣿⣿⣿⣿⣿⡿⠿⠛⠻⠿⣿⣿⣿⣾⣿⡿⠟⠋⠙⢿⣿⣷⣤⣾⡿⠋            ║");
						System.out.println("║            ⣿⣿⣿⣿⣿                        ⣿⣿⣿⣿⣿             ║");
						System.out.println("║          ⣠⣾⣿⡿⠛⢿⣿⣷⣄                    ⣠⣾⣿⡿⠛⢿⣿⣷⣄           ║");
						System.out.println("║          ⠙⠿⠋   ⠙⠿⠋                    ⠙⠿⠋   ⠙⠿⠋           ║");
						System.out.println("╠═══════════════════════════════════════════════════════════╣");
						System.out.println("║██████╗   █████╗  ███╗   ██╗ ██████╗   ██████╗  ███╗   ███╗║");
						System.out.println("║██╔══██╗ ██╔══██╗ ████╗  ██║ ██╔══██╗ ██╔═══██╗ ████╗ ████║║");
						System.out.println("║██████╔╝ ███████║ ██╔██╗ ██║ ██║  ██║ ██║   ██║ ██╔████╔██║║");
						System.out.println("║██╔══██╗ ██╔══██║ ██║╚██╗██║ ██║  ██║ ██║   ██║ ██║╚██╔╝██║║");
						System.out.println("║██║  ██║ ██║  ██║ ██║ ╚████║ ██████╔╝ ╚██████╔╝ ██║ ╚═╝ ██║║");
						System.out.println("║╚═╝  ╚═╝ ╚═╝  ╚═╝ ╚═╝  ╚═══╝ ╚═════╝   ╚═════╝  ╚═╝     ╚═╝║");
						System.out.println("╚═══════════════════════════════════════════════════════════╝");
				    	ob.Thread();
				    	ob.ranMain(id);
				        break;
		
				    case 4:
				    	ob.image2();
				    	System.exit(0);
				        break;
				    
				    case 5:
				        ob.info();
				        ob.selectAll();
				        break;
				}
				
			}
		}
	
}