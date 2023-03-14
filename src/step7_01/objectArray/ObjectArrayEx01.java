package step7_01.objectArray;

class Product {
	
	String name;
	int price; 
		
}




public class ObjectArrayEx01 {

	public static void main(String[] args) {
		
		//객체배열 생성방법
		//클래스명[] 변수 = new 클래스명[크기]
		
		Product[] productList = new Product[3];
		
		Product product = new Product();
		product.name = "기계식키보드";
		product.price = 45000;
		
		productList[0] = product;
		productList[1] = new Product();
		productList[2] = new Product();
		
		productList[1].name = "무소음마우스";
		productList[1].price = 27000;
		
		productList[2].name = "장패드";
		productList[2].price = 10000;
		
		for(int i =0; i< productList.length; i++ ) {
			System.out.println(productList[i].name);
			System.out.println(productList[i].price);
			System.out.println();
		}		
		
		// [응용] 생각해보기
		Product[] temp1= productList; // (주소) or 데이터 
		Product temp2= productList[0]; // (주소)or 데이터 
		String temp3= productList[0].name; // 주소 or (데이터) 
		int temp4= productList[0].price; // 주소 or (데이터) 
		
		Product temp = productList[2];
		System.out.println("temp : " + temp); // temp : 장패드 
		System.out.println("productList[2] : " + productList[2]);	// productList[2] : 장패드 
		
		System.out.println("temp.name : " + temp.name);// temp.name 장패드 
		System.out.println("productList[2].name : " + productList[2].name); // productList[2].name : 장패드
		
		temp.name = "장패드1";
		System.out.println("temp.name : " + temp.name); // temp.name : 장패드1
		System.out.println("productList[2].name : " + productList[2].name); // productList[2].name :장패드1
		
		productList[2].name = "장패드2";
		System.out.println("temp.name : " + temp.name); // temp.name : 장패드2
		System.out.println("productList[2].name : " + productList[2].name); //productList[2].name : 장패드2
		
			
	}
}
