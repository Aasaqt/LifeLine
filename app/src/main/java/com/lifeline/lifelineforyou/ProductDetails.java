package com.lifeline.lifelineforyou;

import java.util.ArrayList;

public class ProductDetails {
	ArrayList<String> prod_list,price_list,pid_list;
	
	public ProductDetails(ArrayList<String> prod_list, ArrayList<String> price_list, ArrayList<String> pid_list)
	{
		this.prod_list=prod_list;
		this.price_list=price_list;
		this.pid_list=pid_list;
		
	}

	public ArrayList<String> getProd_list() {
		return prod_list;
	}

	public void setProd_list(ArrayList<String> prod_list) {
		this.prod_list = prod_list;
	}

	public ArrayList<String> getPrice_list() {
		return price_list;
	}

	public void setPrice_list(ArrayList<String> price_list) {
		this.price_list = price_list;
	}

	public ArrayList<String> getPid_list() {
		return pid_list;
	}

	public void setPid_list(ArrayList<String> pid_list) {
		this.pid_list = pid_list;
	}
	

}
