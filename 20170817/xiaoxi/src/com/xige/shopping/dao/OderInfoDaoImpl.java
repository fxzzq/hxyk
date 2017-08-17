package com.xige.shopping.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.xige.shopping.entities.OderInfo;

public class OderInfoDaoImpl  implements  OderInfoDao{
	
	private static final String count_SQL = "select count(*) from oderinfo";
	private static final String SELECTS_SQL = "SELECT productname,username,tel,address,oderstate,odertime FROM oderinfo";
	
	
	@Override
	 public int RecordNum(OderInfo oder) throws Exception{
		
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet rs=null;
	        int  totalRecord=0;
	        try {
	            connection = SqlManager.getConnection();
	            preparedStatement = connection.prepareStatement(count_SQL);
	            rs= preparedStatement.executeQuery();
	           while (rs.next()) {
	    		    totalRecord=rs.getInt(1);
	    		 System.out.println("×Ü¼ÇÂ¼Êý1:"+totalRecord);
	           }
	            
	        } finally {
	            SqlManager.closePreparedStatement(preparedStatement);
	            SqlManager.closeConnection(connection);
	        }
	        return totalRecord;
	     
			
	}



	@Override
	public List<OderInfo> selects() throws Exception {
		
		
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        List<OderInfo> oders = new ArrayList<OderInfo>();
	        try {
	            connection = SqlManager.getConnection();
	            preparedStatement = connection.prepareStatement(SELECTS_SQL);
	            resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	OderInfo oder = new OderInfo();
	            oder.setProductname(resultSet.getString(1));
	            oder.setUsername(resultSet.getString(2));
	            oder.setTel(resultSet.getString(3));
	            oder.setAddress(resultSet.getString(4));
	            oder.setOderstate(resultSet.getString(5));
	            oder.setOdertime(resultSet.getString(6));       
	            
	            oders.add(oder);
	            
	            }
	            System.out.println("list:"+oders);
	            
	        } finally {
	            SqlManager.closeResultSet(resultSet);
	            SqlManager.closePreparedStatement(preparedStatement);
	            SqlManager.closeConnection(connection);
	        }

	        return oders;
	    
	}
}
