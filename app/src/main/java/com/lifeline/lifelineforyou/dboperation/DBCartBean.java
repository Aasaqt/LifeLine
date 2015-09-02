package com.lifeline.lifelineforyou.dboperation;

public class DBCartBean {
	
	String prodName,prodId,prodQt,prodPrice,prodtotalprice;
	
	public DBCartBean()
	{
		
	}
	public DBCartBean(String prodName,String prodId,String prodQt,String prodPrice,String prodtotalprice)
	{
		this.prodName=prodName;
		this.prodId=prodId;
		this.prodPrice=prodPrice;
		this.prodQt=prodQt;
		this.prodtotalprice=prodtotalprice;
	}

	public String getProdtotalprice() {
		return prodtotalprice;
	}
	public void setProdtotalprice(String prodtotalprice) {
		this.prodtotalprice = prodtotalprice;
	}
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdQt() {
		return prodQt;
	}

	public void setProdQt(String prodQt) {
		this.prodQt = prodQt;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	

}
