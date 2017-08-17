package com.xige.shopping.service;

import java.util.List;

import com.xige.shopping.entities.OderInfo;

public interface OderInfoService {
	
	public int countOderRecord(OderInfo oder) throws Exception;
	
	public List<OderInfo> getOders() throws Exception;


}
