package com.xige.shopping.dao;

import java.util.List;

import com.xige.shopping.entities.OderInfo;

public interface OderInfoDao {
	
	  public int RecordNum(OderInfo oder) throws Exception;
	  
	  public List<OderInfo> selects() throws Exception;
}
