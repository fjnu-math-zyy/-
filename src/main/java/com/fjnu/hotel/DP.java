package com.fjnu.hotel;

public class DP implements IData{
	private static String[][] rooms;
	MainRun mr = new MainRun();

	public void iniRooms() {
		rooms = new String[6][10];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				rooms[i][j] = "EMPTY";
			}
		}
	}

	public String in_Out_Room(int roomNo, String name) {
		// 当name="EMPTY"表示退房
		if (name.equals("EMPTY")) {
			return roomNo+"退房成功！";
		}else if (roomNo(roomNo)==0) {
			return "该房间已经有客人入住";
		}else {
			rooms[(roomNo/100)-1][(roomNo%100)-1]=name;
			return name+"成功入住"+roomNo+"房间！";
		}
	
			
	}


	public String getStation(int roomNo) {
		return rooms[(roomNo/100)-1][(roomNo%100)-1];
	}
	public int roomNo(int roomNo) {
		if ("EMPTY".equals(rooms[(roomNo/100)-1][(roomNo%100)-1])) {
			return roomNo;
		}else {
			return 0;
		}
	}
	
}
