package com.yc.project3;

public class Hero {
	private String name;		//姓名
	private int blood;			//血量
	private int attack;			//攻击力
	private int defense;		//防御
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public Hero(String name) {
		super();
		this.name = name;
		//初始血量：1000   攻击10 防御10
		this.blood=1000;
		this.attack=10;
		this.defense=10;
	}
	public Hero() {
		super();
	}
	@Override
	public String toString() {
		return "英雄：" + name + ", 您目前的血量为：" + blood + ", 您的攻击为：" + attack + ", 您的防御为：" + defense;
	}
	
	
}
