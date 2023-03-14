package step7_01.objectArray;

class Client{
	
	String id;
	String passwd;
	String name;
	String birth;
	int age;
	String contact;
	String address;
	
	void setData(String id, String passwd, String name, String birth,
				int age, String contact, String address) {
		this.id = id; // 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.passwd = passwd;// 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.name = name;// 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.birth = birth;// 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.age = age;// 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.contact = contact;// 파라메타로 전달된 데이터를 필드에 대입한다. 
		this.address = address;// 파라메타로 전달된 데이터를 필드에 대입한다. 
	}
	
		void printData() {
			System.out.println("id : " + this.id);
			System.out.println("passwd : " + this.passwd);
			System.out.println("name : " + this.name);
			System.out.println("birth : " + this.birth);
			System.out.println("age : " + this.age);
			System.out.println("contact : " + this.contact);
			System.out.println("address : " + this.address);
		}
}

// 멤버변수 초기화 
public class ObjectArrayEx05_연습 {

	public static void main(String[] args) {

		Client client1 = new Client();
		
		client1.id = "user1";
		client1.passwd = "1111";
		client1.name = "사용자1";
		client1.birth = "1990-01-01";
		client1.age = 34;
		client1.contact = "010-1111-2222";
		client1.address = "서울";
		client1.printData();
		
		Client client2 = new Client();
		client2.setData("user2" , "2222" , "사용자2" , "2000-01-01" , 24 , "010-3333-4444" , " 경기");
		client2.printData();
		
		Client client3 = new Client();
		client3.setData("user3" , "3333" , "사용자3" , "2010-01-01" , 14 , "010-3333-4444" , " 경기");
		client3.printData();
		
	}

}
