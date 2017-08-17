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
}
