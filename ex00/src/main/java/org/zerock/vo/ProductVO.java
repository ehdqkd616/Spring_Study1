package org.zerock.vo;


public class ProductVO {//중간에 데이터 저장하는 데이터 저장빈 클래스
	
	private String name;//상품명
	private int price;//상품가격. 2개의 멤버변수 선언
	
	public ProductVO(String name, int price) {
		this.name=name;
		this.price=price;//멤버변수 초기화
	}//매개변수 개수를 다르게 한 생성자 오버로딩
	//생성자를 통해서 멤버변수를 초기화하기 때문에 setter를 대신한다. 생성자 매개변수 = setter

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public int getPrice() {
		return price;
	}

//	public void setPrice(int price) {
//		this.price = price;
//	}

	
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
}
