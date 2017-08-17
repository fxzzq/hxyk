package com.xige.shopping.test;

import java.util.ArrayList;
import java.util.List;

import com.xige.shopping.entities.OderInfo;
import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;

public class queryAll {

	/**
	 * @param args
	 */
	 private static  OderInfoService  oderinfoservice=new OderInfoServiceImpl();
	public static void main(String[] args) {
 
     OderInfo oder=new OderInfo();
     
     try {
		System.out.println("haha:"+oderinfoservice.countOderRecord(oder));
		
		List<OderInfo> list = oderinfoservice.getOders();
		
	/*	for(int i=0;i<list.size();i++){ 
			
	    System.out.println("list2222:"+list.get(i));
	} */ 		
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
