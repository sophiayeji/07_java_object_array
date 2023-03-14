package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class StudentEx_{ // 학생정보 (기본) 
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 :" + id + "비밀번호 :" + pw);
	}
}
	

class Controller_{ // 학생 정보 (추가)

	StudentEx_[] List = null;
	int stdCnt = 0;
	
	void addStudentEx(StudentEx_ st) {
		
		if(stdCnt == 0) {
			List = new StudentEx_[1];
		}
		else if (stdCnt > 0) {
			StudentEx_[] temp = List;
			List = new StudentEx_[stdCnt + 1];
			for (int i = 0; i < stdCnt; i++) {
				List[i] = temp[i];
			}
			temp = null;
		}
		List[stdCnt] = st;
		stdCnt++;
	}
	
	StudentEx_ removeStudentEx (int index) { // 학생 정보(삭제)
		
		StudentEx_ deleteObj = List[index];
		if(stdCnt == 1) {
			List = null;
		}
		else if (stdCnt > 1) {
			StudentEx_[] temp = List;
			List = new StudentEx_[stdCnt -1];
			for (int i = 0; i < index; i++) {
				List[i] = temp[i];				
			}
			for (int i = index; i < stdCnt-1; i++) {
				List[i] = temp[i+1];
			}
			temp = null;
		}
		stdCnt--;
		
		return deleteObj; // 굳이 return을 안해주고 데이터만 삭제를 해주어도 되는데
						// 타 언어의 pop()매서드와 같이 삭제하는 데이터를 return 하는 방식으로 구현해본 예시
						
	}	
		
	int checkId(StudentEx_ st) { // 학생 정보(ID확인) 
		
		int check = -1; // 아이디가 중복 X 경우 & 정보가 없는경우 
		for (int i = 0; i < stdCnt; i++) {
			if(List[i].id.equals(st.id)) {
				check = i;
				break;
			}
			
		}
		return check; 
		
	}
		
	void printStudentEx() { // 정보 프린트 
		
		for (int i = 0; i < stdCnt; i++) {
			List[i].printData();
		}
	}
	
	String outData() {
		
		String data = "";
		if(stdCnt ==0) {
			return data;
		}
		data += stdCnt;
		data+= "\n";
		for (int i = 0; i < stdCnt; i++) {
			data += List[i].id;
			data += ",";
			data += List[i].pw;
			if (stdCnt -1 != i) {
				data += "\n";
			}
		}
		
		return data;
	}
	
	void sortData() {
		for (int i = 0; i < stdCnt; i++) {
			for (int j = i; j < stdCnt; j++) {
				if (List[i].id.compareTo(List[j].id) >0 ) {
					StudentEx_ temp = List[i];
					List[i] = List[j];
					List[j] = temp;
					
				}
			}
		}
	}
	
	void loadStudentEx(StudentEx_[] temp, int count) {
		
		this.stdCnt = count;
		this.List = temp;
		
	}
}

public class ObjectArrayEx09_연습1 {

	public void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller controller = new Controller();
		
		String fileName = "student_db.txt";
		
		while(true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int select = scan.nextInt();
			
			if(select ==1) { // 1. 가입
				
				StudentEx temp = new StudentEx();
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				
				if(check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					controller.addStudentEx(temp);
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}
				
				
			}
			else if(select ==2) { // 2. 탈퇴
				
				controller.printStudentEx();
				
				StudentEx temp = new StudentEx();
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				
				if(check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					StudentEx del_st = controller.removeStudentEx(check);
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if(select ==3) { // 3. 정렬 
				
				controller.sortData();
				controller.printStudentEx();
			}
			else if(select ==4) {	// 4. 출력

				controller.printStudentEx();
				
			}
			else if(select ==5) {	// 5. 저장
				
				if(controller.stdCnt == 0) continue;
				
				FileWriter fw = null;
				
					try {
						
						fw = new FileWriter(fileName);
						String data = controller.outData();
						if(!data.equals(""))
							fw.write(data);
							System.out.println(data);
						} 
					 catch (IOException e) {
						e.printStackTrace();
					}
					finally {
						try {fw.close();} catch (IOException e) {e.printStackTrace();}
					}
				
			}
			else if(select ==6) {
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
				
				File file = new File(fileName);
				
				if(file.exists()) {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					String line = br.readLine();
					int count = Integer.parseInt(line);
					StudentEx_[] temp = new StudentEx_[count];
					
					for (int i = 0; i < count; i++) {
						temp[i] = new StudentEx_();
						line = br.readLine();
						String[] value = line.split(",");
						temp[i].id = value[0];
						temp[i].pw = value[1];
					}
					
					controller.loadStudentEx(temp, count);
				}
				
				controller.printStudentEx();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
						
				}
			}
			
			if(select ==7) {
				System.out.println("종료");
				break;
			}		
		}
		
		scan.close();
		
	}
}


