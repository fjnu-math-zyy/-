package com.fjnu.hotel;

public class InHotel
{  
	private MainRun mr = new MainRun();
	private int room;
	IData iData;
	public InHotel(IData iData) {
		this.iData = iData;
	}
	public InHotel() {
		
	}
	public String in(int roomNo,String name) {
		room = (roomNo%100)-1;
		if (isEmpty(roomNo)) {
			mr.getRoom()[(roomNo/100)-1][room]=name;
			return name+"成功入住"+roomNo+"房间!";
		}else {
			return "该房间已经有人入住";
		}
		
	}

	public boolean isEmpty(int roomNo) {
		String room = mr.getRoom()[(roomNo/100)-1][(roomNo%100)-1];
		if ("EMPTY".equals(room)) {
			return true;
		}else {
			return false;
		}
	}
}