package com.jx372.aoptest;

public class ProductVo {
	
	
	public ProductVo(String name ){
		
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
	

}
