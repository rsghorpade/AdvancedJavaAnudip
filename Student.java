package com.example.studEntity;

public class Student {
     private int  id ;
     
     private int  Name ;
     
     private int  RollCall ;

	public Long getId() {
		return (long) id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return Name;
	}

	public void setName(int name) {
		Name = name;
	}

	public int getRollCall() {
		return RollCall;
	}

	public void setRollCall(int rollCall) {
		RollCall = rollCall;
	}
     

	
}
