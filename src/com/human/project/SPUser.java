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
		System.out.println("���̵�: "+id);
		System.out.println("�ڸ�����: "+playCount1+"ȸ �÷���   ��Ȯ��: "+String.format("%.1f",totalAccuracy1/playCount1)+"%");
		System.out.println("��������: "+playCount2+"ȸ �÷���   ��Ȯ��: "+String.format("%.1f",totalAccuracy2/playCount2)+"%");
		System.out.println("ª���ۿ���: "+playCount3+"ȸ �÷���   ��Ȯ��: "+String.format("%.1f",totalAccuracy3/playCount3)+"%");
	}
	public void gameMenu() {
		Scanner sc=new Scanner(System.in);
		boolean menuFlag=true;
		while(menuFlag) {
			System.out.println("1.�ڸ�����  2.��������  3.ª���ۿ���  4.������ȸ  5.����");
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
				System.out.println("���α׷��� �����մϴ�.");
				menuFlag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
	
	private void shortPhrase() {
		Scanner sc=new Scanner(System.in);
		//������� ���ڼ�/���� Ƚ�� =��Ȯ��
		int score=0;//����
		int count=0;//����� Ƚ��
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
		
		//���� for�� �����
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<shortP[i].length();j++) {
//				System.out.println(shortP2[i][j]=shortP[i].split("")[j]);
//			}
//		}
		System.out.println("ª�� �� ������ �����մϴ�. (���� ����� -1 �Է�)");
		String userInput[]=new String[5];
		String userInput2[][]=new String[5][100];
		for(int i=0;i<5;i++) {
			System.out.println(shortP[i]);
			userInput[i]=sc.nextLine();
			if(userInput[i].equals("-1")) {
				System.out.println("ª�� �� ���� ����");
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
//			//����ϴ� ���� �ٱ��� ������ nullpoint ������
//			//count�� �������� �Ŀ� �������� ��Ȯ�� ����� �ùٸ��� ��		
		System.out.println("���� ���� ��: "+score);
		System.out.println("�� ���� ��: "+count);
		accuracy(score, count);
		totalAccuracy3=totalAccuracy3+accuracy;
	}
	private void wordPractice() {
		Scanner sc=new Scanner(System.in);
		int score=0;//����
		int count=0;//����� Ƚ��
		
		mixWord();
		System.out.println("���������� �����մϴ�. (���� ����� -1 �Է�)");
		for(int i=0;i<5;i++,count++) {
			System.out.println(str3[i]);
			String userInput=sc.nextLine();
			if(str3[i].equals(userInput)) {
				score++;
			}
			if(userInput.equals("-1")) {
				System.out.println("�������� ����");
				break;
			}
		}
		score(score, count);
		totalAccuracy2=totalAccuracy2+accuracy;
		
	}
	public void mixWord() {//str3[]��������
		int rand;
		String temp;
		for(int i=0;i<100;i++) {
			rand=rd.nextInt(str3.length);
			temp=str3[0];
			str3[0]=str3[rand];
			str3[rand]=temp;
		}
	}
	public void mixChar() {//str2[]�� ��������(���� ����)
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
		//����, Ȯ��, �ܾ� �迭
		Scanner sc=new Scanner(System.in);
		int score=0;//����
		int count=0;//����� Ƚ��
		for(int i=0;i<str.length();i++) {
			str2[i]=str.split("")[i];
		}
		mixChar();
		System.out.println("�ڸ������� �����մϴ�. (���� ����� -1 �Է�)");
		for(int i=0;i<5;i++,count++) {
			System.out.println(str2[i]); //���� ��������� ����
			String userInput=sc.nextLine();
			if(str2[i].equals(userInput)) {
				score++;
			}
			if(userInput.equals("-1")) {
				System.out.println("�ڸ����� ����");
				break;
			}
		}
		score(score, count);
		totalAccuracy1=totalAccuracy1+accuracy;
	}
	public void score(double score, double count) {
		accuracy=(score/count)*100;
		System.out.println("����: "+(int)score);
		if(count!=0) {//count�� 0�϶� ������ ����� �����Ͽ����߻� ������
			String str=String.format("��Ȯ��: %.1f",accuracy);
			System.out.println(str+"%");
		}else {
			accuracy=0;
			System.out.println("��Ȯ��: "+accuracy+"%");
		}
	}
	public void accuracy(double score, double count) {
		accuracy=(score/count)*100;
		if(count!=0) {
			String str=String.format("��Ȯ��: %.1f",accuracy);
			System.out.println(str+"%");
		}else {
			accuracy=0;
			System.out.println("��Ȯ��: "+accuracy+"%");
		}
	}
}
