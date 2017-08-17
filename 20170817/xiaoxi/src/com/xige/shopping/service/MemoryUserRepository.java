package com.xige.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.xige.shopping.entities.OderInfo;

public class MemoryUserRepository implements UserRepository  {
	
	
private  OderInfoService  oderinfoservice=new OderInfoServiceImpl();
private int totalrecord;
	

private int count(){
	  try{
  		
    	  OderInfo oder=new OderInfo();
    	
    	  totalrecord=oderinfoservice.countOderRecord(oder);
        //	System.out.println("recoder:"+COUNTS);
    	 
      }
      catch(Exception e){
    	  e.printStackTrace();
      }
	  return totalrecord;
	 
	    
}	 

List<OderInfo> oderList;
@Override
public List<OderInfo> listAlloder(){	   
	 try {
			            oderList =oderinfoservice.getOders();
			              if(oderList != null) {
			                  for(OderInfo oderinfo : oderList) {
			                      System.out.println("∂©µ•–≈œ¢£∫"+oderinfo.toString());
			                  }
			              }
			          } catch (Exception e) {
			              e.printStackTrace();
			          }
			    	 
			 
			return oderList;
			     }
			   
		}

		 
 
	 



