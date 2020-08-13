package com.human.project;

import java.util.*;

public class SPUser {
	public static Random rd=new Random();
	public static int totalCount=0;
	public String id=null;
	public String pw=null;
	public int playCount1=0;
	public int playCount2=0;
	public int playCount3=0;
	public double accuracy=0;
	public double totalAccuracy1=0;
	public double totalAccuracy2=0;
	public double totalAccuracy3=0;
	
	String str=new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	String str2[]=new String[str.length()];
	String str3[]= {"apple","banana","Cat","Doll","Green","Foot","Ocean","relax"};
	
	public SPUser() {
		totalCount++;
	}
	public SPUser(String id,String pw) {
		this();
		this.id=id;
		this.pw=pw;
	}
	public boolean isLogin(String id, String pw) {
		boolean returnValue=false;
		if(this.id.equals(id)&&this.pw.equals(pw)) {
			returnValue=true;
		}
		return returnValue;
	}
	public void display() {
		System.out.println("아이디: "+id);
		System.out.println("자리연습: "+playCount1+"회 플레이   정확도: "+String.format("%.1f",totalAccuracy1/playCount1)+"%");
		System.out.println("낱말연습: "+playCount2+"회 플레이   정확도: "+String.format("%.1f",totalAccuracy2/playCount2)+"%");
		System.out.println("짧은글연습: "+playCount3+"회 플레이   정확도: "+String.format("%.1f",totalAccuracy3/playCount3)+"%");
	}
	public void gameMenu() {
		Scanner sc=new Scanner(System.in);
		boolean menuFlag=true;
		while(menuFlag) {
			System.out.println("1.자리연습  2.낱말연습  3.짧은글연습  4.전적조회  5.종료");
			String userInput=sc.nextLine();
			switch(userInput) {
			case "1":
				charPractice();
				playCount1++;
				break;
			case "2":
				wordPractice();
				playCount2++;
				break;
			case "3":
				shortPhrase();
				playCount3++;
				break;
			case "4":
				display();
				break;
			case "5":
				System.out.println("프로그램을 종료합니다.");
				menuFlag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	private void shortPhrase() {
		Scanner sc=new Scanner(System.in);
		//점수대신 글자수/맞춘 횟수 =정확도
		int score=0;//점수
		int count=0;//실행된 횟수
		String shortP[]=new String[5];
		shortP[0]="No house without a mouse.";
		shortP[1]="Pride will have a fall.";
		shortP[2]="No news is good news.";
		shortP[3]="If you laugh, blessings will come your way";
		shortP[4]="A sound mind in a sound body.";
		String shortP2[][]=new String[5][100];
		
		for(int i=0;i<shortP[0].length();i++) {
			shortP2[0][i]=shortP[0].split("")[i];
		}
		for(int i=0;i<shortP[1].length();i++) {
			shortP2[1][i]=shortP[1].split("")[i];
		}
		for(int i=0;i<shortP[2].length();i++) {
			shortP2[2][i]=shortP[2].split("")[i];
		}
		for(int i=0;i<shortP[3].length();i++) {
			shortP2[3][i]=shortP[3].split("")[i];
		}
		for(int i=0;i<shortP[4].length();i++) {
			shortP2[4][i]=shortP[4].split("")[i];
		}
		
		//이중 for문 변경시
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<shortP[i].length();j++) {
//				System.out.println(shortP2[i][j]=shortP[i].split("")[j]);
//			}
//		}
		System.out.println("짧은 글 연습을 시작합니다. (강제 종료시 -1 입력)");
		String userInput[]=new String[5];
		String userInput2[][]=new String[5][100];
		for(int i=0;i<5;i++) {
			System.out.println(shortP[i]);
			userInput[i]=sc.nextLine();
			if(userInput[i].equals("-1")) {
				System.out.println("짧은 글 연습 종료");
				break;
			}else {
				for(int j=0;j<userInput[i].length();j++) {
					userInput2[i][j]=userInput[i].split("")[j];
					if(userInput2[i][j]!=null&&shortP2[i][j]!=null) {
						if(shortP2[i][j].equals(userInput2[i][j])) {
							score++;
						}
					}
				}
			}
			count=count+shortP[i].length();
		}
//			//계산하는 것이 바깥에 있으면 nullpoint 에러뜸
//			//count는 강제종료 후에 더해져야 정확도 계산이 올바르게 됨		
		System.out.println("맞춘 글자 수: "+score);
		System.out.println("총 글자 수: "+count);
		accuracy(score, count);
		totalAccuracy3=totalAccuracy3+accuracy;
	}
	private void wordPractice() {
		Scanner sc=new Scanner(System.in);
		int score=0;//점수
		int count=0;//실행된 횟수
		
		mixWord();
		System.out.println("낱말연습을 시작합니다. (강제 종료시 -1 입력)");
		for(int i=0;i<5;i++,count++) {
			System.out.println(str3[i]);
			String userInput=sc.nextLine();
			if(str3[i].equals(userInput)) {
				score++;
			}
			if(userInput.equals("-1")) {
				System.out.println("낱말연습 종료");
				break;
			}
		}
		score(score, count);
		totalAccuracy2=totalAccuracy2+accuracy;
		
	}
	public void mixWord() {//str3[]랜덤추출
		int rand;
		String temp;
		for(int i=0;i<100;i++) {
			rand=rd.nextInt(str3.length);
			temp=str3[0];
			str3[0]=str3[rand];
			str3[rand]=temp;
		}
	}
	public void mixChar() {//str2[]의 랜덤추출(블랙잭 참고)
		int rand;
		String temp;
		for(int i=0;i<100;i++) {
			rand=rd.nextInt(52);
			temp=str2[0];
			str2[0]=str2[rand];
			str2[rand]=temp;
		}
	}
	private void charPractice() {
		//점수, 확률, 단어 배열
		Scanner sc=new Scanner(System.in);
		int score=0;//점수
		int count=0;//실행된 횟수
		for(int i=0;i<str.length();i++) {
			str2[i]=str.split("")[i];
		}
		mixChar();
		System.out.println("자리연습을 시작합니다. (강제 종료시 -1 입력)");
		for(int i=0;i<5;i++,count++) {
			System.out.println(str2[i]); //추후 랜덤추출로 수정
			String userInput=sc.nextLine();
			if(str2[i].equals(userInput)) {
				score++;
			}
			if(userInput.equals("-1")) {
				System.out.println("자리연습 종료");
				break;
			}
		}
		score(score, count);
		totalAccuracy1=totalAccuracy1+accuracy;
	}
	public void score(double score, double count) {
		accuracy=(score/count)*100;
		System.out.println("점수: "+(int)score);
		if(count!=0) {//count가 0일때 나누기 실행시 컴파일에러발생 방지용
			String str=String.format("정확도: %.1f",accuracy);
			System.out.println(str+"%");
		}else {
			accuracy=0;
			System.out.println("정확도: "+accuracy+"%");
		}
	}
	public void accuracy(double score, double count) {
		accuracy=(score/count)*100;
		if(count!=0) {
			String str=String.format("정확도: %.1f",accuracy);
			System.out.println(str+"%");
		}else {
			accuracy=0;
			System.out.println("정확도: "+accuracy+"%");
		}
	}
}
