package com.lifeline.lifelineforyou.dboperation;

public class DBHistoryBean {
	public int orderNo;
	public String date,totalAmount;
	
	public DBHistoryBean()
	{
		
	}
	
	public DBHistoryBean(int orderNo,String totalAmount,String date)
	{
		this.orderNo=orderNo;
		this.totalAmount=totalAmount;
		this.date=date;
		
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

}
