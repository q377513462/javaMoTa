package com.yc.project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
	private static Scanner sc=new Scanner(System.in);
	private static Hero hero;
	private static Monsters ms;
	private static Maps maps=new Maps();
	private static int mapindex=0;		//代表第一关
	private static int hindex=82;		//代表勇士的初始索引下标
	//循环标识，做游戏结束判断
	private static boolean flag=true;
	
	public static void main(String[] args) throws IOException {
		
		
		init(mapindex);
		System.out.println("游戏开始");
		
		System.out.println("请按wsad键进行操作：");
		
		while(flag){
			//行走
			String choice=sc.nextLine();
			if( "w".equals(choice) ){
				walk(-10);
			}else if( "s".equals(choice) ){
				walk(10);
			}else if( "a".equals(choice) ){
				walk(-1);
			}else if( "d".equals(choice) ){
				walk(1);
			}
			
		}
		System.out.println("游戏结束");
		
//		System.out.println("你的状态为："+hero.toString());
//		System.out.println("怪物状态为："+ms.ms[0].toString());
//		System.out.println("战斗开始");
//		
//		fight(hero,ms.ms[0]);
//		
//		System.out.println("你的状态为："+hero.toString());
//		System.out.println("怪物状态为："+ms.ms[1].toString());
//		System.out.println("战斗开始");
//		fight(hero,ms.ms[1]);
//		
//		System.out.println("你的状态为："+hero.toString());
	}

	//英雄行走
	private static void walk(int walkeds) {
		if( Maps.maps[mapindex][hindex+walkeds]=="x" ){
			//索引超出，撞到边界，或者撞到墙，不做任何事情
			//重新创建地图
			createMaps(  maps.maps[mapindex] );
			return;
		}else if( maps.maps[mapindex][hindex+walkeds]=="a" ){
			//加攻击力
			hero.setAttack(  hero.getAttack() + 2 );
			System.out.println("你的状态为："+hero.toString());	
		}else if(  maps.maps[mapindex][hindex+walkeds]=="d"  ){
			//加防御力
			hero.setDefense( hero.getDefense() + 2 );
			System.out.println("你的状态为："+hero.toString());	
		}else if(  maps.maps[mapindex][hindex+walkeds]==" " ){
			//空地，直接交换位置就好了，在这里不做处理，为了剩下的去做判断
		}else{
			//剩下的都是打怪了
			fight( hero,  ms.ms[     Integer.parseInt(maps.maps[mapindex][hindex+walkeds])   ] );
			if(!flag){
				return;
			}
		}
		//交换位置
		maps.maps[mapindex][hindex]=" ";
		maps.maps[mapindex][hindex+walkeds]="h";
		hindex+=walkeds;
		
		//重新创建地图
		createMaps(  maps.maps[mapindex] );
		
	}

	private static void fight(Hero h, Monster m) { 
		//英雄攻击怪物一次的伤害
		int h2m=h.getAttack()-m.getDefense();
		//怪物攻击英雄一次的伤害
		int m2h=m.getAttack()-h.getDefense();
		
		if(h2m<=0){
			//英雄攻击并不能破防，游戏结束
			System.out.println("您砍不动怪物，被怪物乱刀砍死.....");
			flag=false;
			return;
		}
		//英雄坎怪物一刀，怪物坎英雄一刀，循环，直到有一方死亡为止
		do{
			int mblood=m.getBlood()-h2m;
			m.setBlood( mblood  );
			//砍了一刀怪物，判断怪物是否死亡
			if( mblood<=0 ){
				System.out.println("恭喜，胜利，您获得xxxx");
				continue;
			}
			//如果没有死，则怪物砍勇士一刀
			int hblood=h.getBlood()-m2h;
			h.setBlood( hblood );
			if( hblood<=0 ){
				System.out.println("您被怪物乱刀砍死，游戏结束....");
				flag=false;
			}
		}while( h.getBlood()>0 && m.getBlood()>0 );
		System.out.println("你的状态为："+hero.toString());	
	}

	private static void init(int i) {
		System.out.println("请输入您的游戏名：");
		String name=sc.nextLine();
		hero=new Hero(name);
		//创建地图
		createMaps( maps.maps[i] );
		
	}

	private static void createMaps(String[] map) {
		//循环地图，将数组显示到界面上
		for(int i=0;i<map.length;i++){
			switch( map[i] ){
				case "x":
					System.out.print(" x ");
					break;
				case "a":
					System.out.print(" * ");
					break;
				case "d":
					System.out.print(" # ");
					break;
				case "n":
					System.out.print(" n ");
					break;
				case "h":
					System.out.print(" ☺ ");
					break;
				case "0":
					System.out.print(" a ");
					break;
				case "1":
					System.out.print(" b ");
					break;
				case "2":
					System.out.print(" c ");
					break;
				case "3":
					System.out.print(" d ");
					break;
				case "4":
					System.out.print(" e ");
					break;
				case " ":
					System.out.print("   ");
					break;
			}
			//记得换行
			if( (i+1)%10==0 ){
				System.out.println();
			}
		}
	}
}
