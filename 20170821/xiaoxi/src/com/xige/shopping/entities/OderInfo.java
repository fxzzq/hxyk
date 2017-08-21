package com.xige.shopping.entities;


public class OderInfo {

	int  id;
	String  productname;
	String  odertime;
	String	oderstate;
	String price;
	String remarks;
	String pay_method;
	String username;
	String tel;
	String address;
	
	String expresscompany;
	String expressID;
	//String OderState;
	
	





	public OderInfo() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "OderInfo [id=" + id + ", productname=" + productname
				+ ", odertime=" + odertime + ", oderstate=" + oderstate
				+ ", price=" + price + ", remarks=" + remarks + ", pay_method="
				+ pay_method + ", username=" + username + ", tel=" + tel
				+ ", address=" + address + ", expresscompany=" + expresscompany
				+ ", expressID=" + expressID + "]";
	}



	public OderInfo(int id,String productname, String username, String tel, String address,
			 String oderstate,String odertime) {
		
		this.id=id;
		this.productname = productname;
		this.odertime = odertime;
		this.oderstate = oderstate;
		this.username = username;
		this.tel = tel;
		this.address = address;
	}
	
	
    //	×´Ì¬ÐÅÏ¢
	public OderInfo(String expresscompany, String expressID, String oderstate) {
		super();
		this.expresscompany = expresscompany;
		this.expressID = expressID;
		this.oderstate = oderstate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getOdertime() {
		return odertime;
	}
	public void setOdertime(String odertime) {
		this.odertime = odertime;
	}
	public String getOderstate() {
		return oderstate;
	}
	public void setOderstate(String oderstate) {
		this.oderstate = oderstate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	public String getExpresscompany() {
		return expresscompany;
	}



	public void setExpresscompany(String expresscompany) {
		this.expresscompany = expresscompany;
	}



	public String getExpressID() {
		return expressID;
	}



	public void setExpressID(String expressID) {
		this.expressID = expressID;
	}



}
