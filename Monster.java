package com.yc.project3;

public class Monster {
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
	public Monster(String name, int blood, int attack, int defense) {
		super();
		this.name = name;
		this.blood = blood;
		this.attack = attack;
		this.defense = defense;
	}
	public Monster() {
		super();
	}
	
	@Override
	public String toString() {
		return "怪物：" + name + ", 血量为：" + blood + ", 攻击为：" + attack + ", 防御为：" + defense;
	}
	
	
}
