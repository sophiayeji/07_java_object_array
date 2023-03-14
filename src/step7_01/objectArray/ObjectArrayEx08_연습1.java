package step7_01.objectArray;



import java.util.Scanner;

class Subject8_{

	String name;
	int score;
	

}


class Student8_{
	
	Subject8[] subjects;
	String name;
	
}


public class ObjectArrayEx08_연습1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Student8[] studentList = new Student8[3];
		int studentCnt = 0; 
	
		while(true) {
			
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name +"학생>>>");
			}
		
			
			System.out.println("[1]학생 추가하기");
			System.out.println("[2]과목 추가하기");
			System.out.println("[3]성적 추가하기");
			System.out.println("[4]종료하기");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.println("이름 입력 :"   );
				String name = scan.next();
				
				studentList[studentCnt] = new Student8();
				studentList[studentCnt].name = name;
				studentCnt++;		
			}
			else if(sel == 2) {
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) +"]" + studentList[i].name );
				}
				System.out.println("학생 선택 :");
				int studentNum = scan.nextInt();
				studentNum --;
				
				System.out.println("과목 입력 :");
				String subject = scan.next();
			
				if(studentList[studentNum].subjects == null) {
					
					studentList[studentNum].subjects = new Subject8[1];
					studentList[studentNum].subjects[0] = new Subject8();
					studentList[studentNum].subjects[0].name = subject;	
				}
				else {
					int size = studentList[studentNum].subjects.length;
					
					Subject8[] temp = studentList[studentNum].subjects;
					studentList[studentNum].subjects = new Subject8[size+1];
					
					for (int i = 0; i < size; i++) {
						studentList[studentNum].subjects[i] = temp[i];
					}
					studentList[studentNum].subjects[size] = new Subject8();
					studentList[studentNum].subjects[size].name = subject;	
					
					temp = null;
				}
			}
			else if (sel ==3) {
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.println("학생 선택 : " );
				int studentNum = scan.nextInt();
				studentNum--;
				
				if(studentList[studentNum].subjects != null) {
					for (int i = 0; i < studentList[studentNum].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + studentList[studentNum].subjects[i].name);
					}
				}
				System.out.println("과목 선택 :");
				int num = scan.nextInt();
				num--;
				
				System.out.println("성적 입력 : ");
				int score = scan.nextInt();
				
				studentList[studentNum].subjects[num].score=score;
			}
			else if (sel == 4) {
				System.out.println("종료");
				break;
			}		
		}
		scan.close();
		
	}
}



