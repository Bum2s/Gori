package com.project1;

public class SogaeDTO {

	private String nik;
	private String name;
	private int age;
	private String sung;
	private int height;
	private String edu;
	private String job;
	private int sal;
	private String hobby;
	private String place;
	private String school;
	private int ranking;
	private String user_id;
	
	
	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getSung() {
		return sung;
	}


	public void setSung(String sung) {
		this.sung = sung;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getSchool() {
		return school;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	public int getRanking() {
		return ranking;
	}



	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



    @Override
	public String toString() {
		String str;
		str = String.format("%6s %6s %6s %6d살 %6dcm %4s %6s %6d만원 %6s %6s %8s %5d등급 ",nik,name,sung,age,height,edu,job,sal,hobby,place,school,ranking);
		return str;
	}
    
    public String toString1() {
    	String str;
		str = String.format(" %5s %3s %3d %4d %3s %6s %5d %5s %4s %6s %2d",name,sung,age,height,edu,job,sal,hobby,place,school,ranking);
		return str;
	}	
   }

/*
private String nik;
private String name;
private int age;
private String sung;
private int height;
private String edu;
private String job;
private int sal;
private String hobby;
private String place;
private String school;
private int rank;
    
*/
