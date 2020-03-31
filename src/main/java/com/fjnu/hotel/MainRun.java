package com.fjnu.hotel;

import java.util.Scanner;

public class MainRun {
	private static String[][] rooms;
	private static ListHome lh=new ListHome();
	private static InHotel ih = new InHotel();

	public MainRun(){
		iniRooms();
	}
	private static void iniRooms() {
		rooms = new String[10][10];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				rooms[i][j] = "EMPTY";
			}
		}
	}
	private static void command() {
		String comm;
		while(true) {
			System.out.println("请输入命令：");
			Scanner sca = new Scanner(System.in);
			System.gc();
			comm = sca.next();
			if ("search".equalsIgnoreCase(comm)) {
				lh.search();
			}else if ("in".equalsIgnoreCase(comm)) {
				int roomNo = sca.nextInt();
				try {
					if (validRoomNo(roomNo)) {
						String name = sca.next();
						System.out.println(ih.in(roomNo, name));
					}else {
						System.out.println("房间号错!");
					}
				} catch (Exception e) {
					System.out.println("房间号错!");
				}
			}else if ("exit".equalsIgnoreCase(comm)) {
				System.out.println("程序退出。。。");
				break;
			}else {
				System.out.println("命令错误，重新输入");
			}
		}
	}
	private static boolean validRoomNo(int roomNo) {
		if ((roomNo/100>10)||(roomNo/100<1)||(roomNo%100>12)||(roomNo%100<1)) {
			return false;
		}else {
			return true;
		}
	}
	public String[][] getRoom(){
		return rooms;
	}
}
