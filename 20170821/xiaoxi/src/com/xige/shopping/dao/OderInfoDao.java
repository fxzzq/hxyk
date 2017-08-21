package com.xige.shopping.dao;

import java.util.List;

import com.xige.shopping.entities.OderInfo;

public interface OderInfoDao {
	
	  public int RecordNum(OderInfo oder) throws Exception;
	  
	  public List<OderInfo> selects() throws Exception;
	  
	  public  String checkUser(String username,String password) throws Exception;
	  
	  public int ModifyAdminPwd(String Newpwd,String adminname) throws Exception;
	  
	  public List<OderInfo> selectByid(String id)  throws Exception;
	  
	  //更新状态而用
	  public OderInfo orderinfo(int id) throws Exception;

	  public int insertOderState(OderInfo oderinfo) throws Exception;

	
}
