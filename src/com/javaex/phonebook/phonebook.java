package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phonebook {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("******************************************");
		System.out.println("*            전화번호 관리 프로그램            *");
		System.out.println("******************************************");
		
	//사람리스트
		List<Person> personList = new ArrayList<Person>();
		
	//파일 읽어오기
		Reader re = new FileReader("C:\\javaStudy\\phonebook\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(re); //버퍼를 사용해서 좀 더 효율적으로 사용가능
		
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			try {
				String[] personInfo = str.split(",");
				String name = personInfo[0];
				String hp = personInfo[1];
				String company = personInfo[2];
				
				Person person = new Person(name, hp, company);	//Person클래스에 연결
				personList.add(person);	//인원을 리스트에 추가
			}
			catch(Exception e) {
				
			}
		}
	
		
		
		
		
		
	//메뉴선택
		while(true) {
			
			//메뉴			
		    System.out.println("");
			System.out.println("1.리스트    2.등록    3.삭제    4.검색    5.종료");
			System.out.println("------------------------------------------");
			
			System.out.print(">메뉴번호: ");
			int number = sc.nextInt();
			switch (number) {
			case 1: number = 1;
					System.out.println("<1.리스트>");
					int id = 1;
					for(Person person : personList) {
						System.out.println(id+".   " + person.getName() +"  "+ person.getHp() +"  "+ person.getCompany());
						id++;
					}
					
					break;
			case 2: number = 2;
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String name = sc.next();
					System.out.print(">휴대전화: ");
					String hp = sc.next();
					System.out.print(">회사전화: ");
					String company = sc.next();
					System.out.println("[등록되었습니다.]");
					
					//사람추가								
					Person p1 = new Person(name, hp, company);
					personList.add(p1);
					break;
			
			case 3: number = 3;
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					int num = sc.nextInt();
					for(int i=1; i<=personList.size(); i++) {
						if(num == i) {
							personList.remove(i-1);
						}
					}												
					System.out.println("[삭제되었습니다.]");								
					break;
			
			case 4: number = 4;
			
				
				
			
			case 5: number = 5;
					System.out.println("");
					System.out.println("******************************************");
					System.out.println("*                 감사합니다                *");
					System.out.println("******************************************");
					break;
			
			default:
					System.out.println("[다시 입력해 주세요.]");
					break;
			}
			if(number == 5) {
				break;
			}
			else {
				continue;
			}
		}
		
		//파일 쓰기
			Writer wr = new FileWriter("C:\\javaStudy\\phonebook\\PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(wr); //버퍼를 사용해서 좀 더 효율적으로 사용가능
				
			for(Person person : personList) {
				String saveNew = person.getName() + "," + person.getHp() + "," + person.getCompany();
				//System.out.println(saveNew);
				bw.write(saveNew); //파일에 새로운 인원 쓰기
				bw.newLine(); //한줄씩 작성
			}
			
		br.close();
		bw.close();
		sc.close();
	}


}