package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Arrays;


// MyArrayList 만들기 , 분석,타이핑, 안보기 
class MyArrayList_ {	//setting

	int[] arr; 			// 배열 
	int elementCnt; 	// 요소의 수 
	
	void print() {		// 값을 프린트 
		
		System.out.println(Arrays.toString(arr));
	}

	
	
	void add(int value) {	// 값을 더하기 	

		if(elementCnt ==0) {	// 더하려는 요소의 수가 0개일 떄 
			arr = new int[elementCnt +1 ];	// 요소의 수 + 1
			
		}
		else if (elementCnt > 0) { // 그게 아니면( 더하려는 요소가 0보다 클 떄)
			int[] temp = arr;		// temp배열에 arr 넣어준다 
			arr = new int[elementCnt +1 ]; //	arr = 새로운 요소+1 
			
			for (int i = 0; i < elementCnt; i++) { // 반복 
				arr[i] = temp[i];				// arr => temp 	
			}
			temp = null;						// temp는 초기화 
		}
		arr[elementCnt] = value;
		elementCnt++;
		
	}

	
	void add(int index, int value) {  // add index & value 

		if(elementCnt ==0) {   // 요소가 0개일떄 
			arr= new int[elementCnt +1]; // arr = new(요소+1) 
		}
		else if (elementCnt >0) {	// 요소가 0가보다 크면 
			int[] temp = arr;	// temp 배열에 arr ->
			arr = new int[elementCnt + 1]; // arr = 새로운배열(요소+1)
		
			int j =0;					
			for (int i = 0; i < elementCnt +1 ; i++) { // 데이터 개수만큼 반복
				if(i != index) {	
					arr[i] = temp[j++]; // 1 2 3 4 5 (4앞에 7을 더하는 경우)
				} // 1 2 3 4 
			}	  // 1 2 3 7 
			temp = null;
		}
		arr[index] = value; // 값
		elementCnt++; // 누적 
	}
	
	void remove (int index) { // remove 기능 
		
		if(elementCnt ==1) { // 요소의 수가 1개 뿐일 떄 
			arr = null; 	// 초기화 
		}
		else if (elementCnt > 1) { // 요소의 수가 1보다 많을 떄 
			int[]temp = arr; // temp 배열에 arr -> 
			arr= new int [elementCnt -1]; // arr 새로운 배열(요소-1) 
			
			int j=0; // j값이 등장 
			for (int i = 0; i < elementCnt; i++) { // 데이터개수만큼 반복 
				if(i != index) { // 지우려는 위치가 아니면 
					arr[j++] = temp[i]; // 1 2 3 4 5 (숫자 3을 지우고자 한다면)
				}                       // 1 2 4 5 				
			}
			temp = null; // temp는 초기화됨 
		}
		elementCnt--; // 요소의 수가 감소함 
	}
	
	
	int size() { // size -> elementCnt 
		return elementCnt;
	}
	
	
	int get(int index) { // get -> arr[index]
		return arr[index];
	}
	
	
	void set(int index, int value) {
		arr[index] = value;
	}
	
	
	void clear() {
		arr = null;
		elementCnt= 0;
	}
	
}


public class ObjectArrayEx14_연습1 {

	public void main(String[] args) {
		
		// [ArrayList 사용]
		ArrayList<Integer>List = new ArrayList<Integer>();
		
		//추가하기
		List.add(10);
		List.add(20);
		List.add(30);
		List.add(40);
		List.add(50);
		System.out.print(List);
		
		//삽입하기
		List.add(0,9);
		//출력하기
		System.out.println(List);
		
		//(index로)삭제하기
		List.remove(3);
		System.out.println(List);
		
		//길이구하기
		int elementCnt = List.size();
		System.out.println("elementcnt =" + elementCnt);
		
		//(index로)값 꺼내오기 // 1 2 3 4 5 
		System.out.print("["); // 0 1 2 ** 4
		for (int i = 0; i < elementCnt; i++) {
			System.out.println(List.get(i));
			if(i!=elementCnt-1) {
				System.out.print(",");
			}	
		}
		System.out.println("]");
		
		//특정 위치의 값 수정하기
		List.set(3, 5);
		System.out.println(List);
		
		//모든 데이터를 제거하기
		List.clear();
		System.out.println(List.size());
		
		System.out.println("\n==========================\n");
		
		// 직접 구현한 ArrayList
		MyArrayList myList = new MyArrayList();
		
		//추가하기 
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.print();
		
		//삽입하기
		myList.add(0,9);
		//출력하기
		myList.print();
		
		//(index로)삭제하기
		myList.remove(3);
		myList.print();
		
		
	}

}
