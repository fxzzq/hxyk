package com.xige.shopping.service;

import java.util.List;

import com.xige.shopping.entities.OderInfo;

public interface OderInfoService {
	
	public int countOderRecord(OderInfo oder) throws Exception;
	
	public List<OderInfo> getOders() throws Exception;
	
	public String checkadmin(String username,String password) throws Exception;
	
	public int ModifyAdminPwd(String Newpwd,String adminname) throws Exception;
   
	public List<OderInfo> getOderByid(String id) throws Exception;
	//更新状态而用
	public OderInfo getOderALLByid(String id) throws Exception;
	
	public int AddExpressInfo(String expresscompany, String expressID, String OderState, OderInfo oderinfo) throws Exception;
}
