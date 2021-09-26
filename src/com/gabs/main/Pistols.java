package com.gabs.main;

public class Pistols {
	private int id, price, balasPorPaint, balasReserva, head, body, leg;
	private String name, wallPenetration;
	private byte[] image;
	
	public Pistols(int id, String name, int price, String wallPenetration, int balasPorPaint, int balasReserva, int head, int body, int leg, 
			 byte[] image) {
		super();
		this.id = id;
		this.price = price;
		this.balasPorPaint = balasPorPaint;
		this.balasReserva = balasReserva;
		this.head = head;
		this.body = body;
		this.leg = leg;
		this.name = name;
		this.wallPenetration = wallPenetration;
		this.image = image;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBalasPorPaint() {
		return balasPorPaint;
	}

	public void setBalasPorPaint(int balasPorPaint) {
		this.balasPorPaint = balasPorPaint;
	}

	public int getBalasReserva() {
		return balasReserva;
	}

	public void setBalasReserva(int balasReserva) {
		this.balasReserva = balasReserva;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWallPenetration() {
		return wallPenetration;
	}

	public void setWallPenetration(String wallPenetration) {
		this.wallPenetration = wallPenetration;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
