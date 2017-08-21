package com.xige.shopping.service;

import java.util.List;

import com.xige.shopping.dao.OderInfoDao;
import com.xige.shopping.dao.OderInfoDaoImpl;
import com.xige.shopping.entities.OderInfo;

public class OderInfoServiceImpl implements OderInfoService{

	private OderInfoDao  oderinfodao=new OderInfoDaoImpl();
	 
@Override
public int countOderRecord(OderInfo oder) throws Exception{

	return this.oderinfodao.RecordNum(oder);
}

@Override
public List<OderInfo> getOders() throws Exception {
	
	
	return this.oderinfodao.selects();
}

@Override
public String checkadmin(String username, String password) throws Exception {
    
	return this.oderinfodao.checkUser(username, password);
}


@Override
public int ModifyAdminPwd(String Newpwd,String adminname) throws Exception {
	
	return this.oderinfodao.ModifyAdminPwd(Newpwd,adminname);
}

@Override
public List<OderInfo> getOderByid(String id) throws Exception {

	return this.oderinfodao.selectByid(id);
}



@Override
public OderInfo getOderALLByid(String id) throws Exception {
	System.out.println("转换前oderid:"+id);
	int oderid=Integer.parseInt(id);
	System.out.println("转换后oderid:"+oderid);
	return this.oderinfodao.orderinfo(oderid);
}

@Override
public int AddExpressInfo(String expresscompany, String expressID,
		String OderState, OderInfo oderinfo) throws Exception {
	
		oderinfo.setExpresscompany(expresscompany);
		oderinfo.setExpressID(expressID);
		oderinfo.setOderstate(OderState);
		return this.oderinfodao.insertOderState(oderinfo);
	
}
}
