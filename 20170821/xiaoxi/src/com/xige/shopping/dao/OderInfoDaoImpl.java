package com.xige.shopping.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.xige.shopping.entities.OderInfo;

public class OderInfoDaoImpl  implements  OderInfoDao{
	
	private static final String count_SQL = "select count(*) from oderinfo";
	private static final String SELECTS_SQL = "SELECT * FROM oderinfo";
	private static final String checkuser_SQL ="SELECT * FROM administrators";
	private static final String  update_SQL="update administrators set managerpwd=? where managername=?";
	private static final String selectByid_SQL="SELECT * FROM oderinfo WHERE oderid=?";
	private static final String updateOderState_SQL="update oderinfo  set oderstate=?,expresscompany=?,expressID=? where oderid=?";
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
	    		 System.out.println("总记录数1:"+totalRecord);
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
	            oder.setId(resultSet.getInt(1));
	            oder.setProductname(resultSet.getString(2));
	            oder.setPrice(resultSet.getString(3));
	            oder.setRemarks(resultSet.getString(4));
	            oder.setOdertime(resultSet.getString(5));  
	            oder.setOderstate(resultSet.getString(6));
	            oder.setPay_method(resultSet.getString(7));
	            oder.setUsername(resultSet.getString(8));
	            oder.setTel(resultSet.getString(9));
	            oder.setAddress(resultSet.getString(10));
	            oder.setExpresscompany(resultSet.getString(11));
            	oder.setExpressID(resultSet.getString(12));
	           
	                
	            
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



	@Override
public String checkUser(String username, String password) throws Exception {
		
		boolean has_username = false;
        boolean password_correct = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
      
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(checkuser_SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                String temp_username = resultSet.getString("managername").trim();

                String temp_password = resultSet.getString("managerpwd").trim();

                if(username.equals(temp_username)){

                    has_username = true;

                    if(password.equals(temp_password)){

                        password_correct = true;

                       return "hasUserNameAndPasswordCorrect";

                    }

                    return "hasUserNameButPasswordInCorrect";

                }

            }

        } catch (SQLException e) {

            System.out.println("操作ResultSet出错");

            e.printStackTrace();

        }
        finally {
            SqlManager.closeResultSet(resultSet);
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }
     

        return "hasNoUserName";
	}





	@Override
	public int ModifyAdminPwd(String Newpwd,String adminname) throws Exception {
	    
		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        int i = 0;
	        try {
	            connection = SqlManager.getConnection();
	            preparedStatement = connection.prepareStatement(update_SQL);
	            preparedStatement.setString(1,Newpwd);
	            preparedStatement.setString(2,adminname);
	          
	            i = preparedStatement.executeUpdate();
	        } finally {
	            SqlManager.closePreparedStatement(preparedStatement);
	            SqlManager.closeConnection(connection);
	        }
	        return i;
		
		
	}



	@Override
	public List<OderInfo> selectByid(String id) throws Exception {
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OderInfo> oders = new ArrayList<OderInfo>();
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(selectByid_SQL);
            preparedStatement.setString(1,id);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	OderInfo oder = new OderInfo();
            oder.setId(resultSet.getInt(1));
            oder.setProductname(resultSet.getString(2));
            oder.setPrice(resultSet.getString(3));
            oder.setRemarks(resultSet.getString(4));
            oder.setOdertime(resultSet.getString(5));  
            oder.setOderstate(resultSet.getString(6));
            oder.setPay_method(resultSet.getString(7));
            oder.setUsername(resultSet.getString(8));
            oder.setTel(resultSet.getString(9));
            oder.setAddress(resultSet.getString(10));
            oder.setExpresscompany(resultSet.getString(11));
        	oder.setExpressID(resultSet.getString(12));
                
            
            oders.add(oder);
            
            }
            System.out.println("oderDetailByid:"+oders);
            
        } finally {
            SqlManager.closeResultSet(resultSet);
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }

        return oders;
    
	}



	@Override
	public int insertOderState(OderInfo oderinfo) throws Exception {
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = SqlManager.getConnection();
            preparedStatement = connection.prepareStatement(updateOderState_SQL);
            
            System.out.println("daoImpl 订单状态："+oderinfo.getOderstate()); 
            preparedStatement.setString(1,oderinfo.getOderstate());
            preparedStatement.setString(2,oderinfo.getExpresscompany());
            preparedStatement.setString(3,oderinfo.getExpressID());
            
            
            
            // 根据订单id更新           
            preparedStatement.setInt(4,oderinfo.getId());
            System.out.println("daoImpl 订单id："+oderinfo.getId()); 
            System.out.println(updateOderState_SQL);
            
            i = preparedStatement.executeUpdate();
            System.out.println("数据库 增加状态信息成功 影响行数i="+i);
            
        } finally {
            SqlManager.closePreparedStatement(preparedStatement);
            SqlManager.closeConnection(connection);
        }
        return i;
	}



	@Override
	public OderInfo orderinfo(int id) throws Exception {
		 Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        OderInfo oderinfo = null;
	        try {
	            connection = SqlManager.getConnection();
	            preparedStatement = connection.prepareStatement(selectByid_SQL);
	            preparedStatement.setInt(1, id);
	            resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	               
	            	oderinfo = new OderInfo();
	            
	            	oderinfo.setId(resultSet.getInt("oderid"));
	            	oderinfo.setProductname(resultSet.getString("productname"));
	            	oderinfo.setOdertime(resultSet.getString("odertime"));
	            	oderinfo.setOderstate(resultSet.getString("oderstate"));
	            	oderinfo.setPrice(resultSet.getString("price"));
	            	oderinfo.setRemarks(resultSet.getString("remarks"));
	            	oderinfo.setPay_method(resultSet.getString("pay_method"));
	            	oderinfo.setUsername(resultSet.getString("username"));
	            	oderinfo.setTel(resultSet.getString("tel"));
	            	oderinfo.setAddress(resultSet.getString("address"));
	            	oderinfo.setExpresscompany(resultSet.getString("expresscompany"));
	            	oderinfo.setExpressID(resultSet.getString("expressID"));

	            }
	        } finally {
	            SqlManager.closeResultSet(resultSet);
	            SqlManager.closePreparedStatement(preparedStatement);
	            SqlManager.closeConnection(connection);
	        }


	        return oderinfo;
	}
}
            
            
         
            


   
