package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.Customerbo;

public class Customerdao {
	private static final String UDAY="INSERT INTO SPRING_CUSTOMER VALUES(CUSTOMER.NEXTVAL,?,?,?,?,?,?)";
	public int record (Customerbo bo) throws Exception {
		InitialContext ic =null;
		DataSource ds=null;
		Connection con =null;
		PreparedStatement ps =null;
		int count=0;
		
		try {
		     ic =new InitialContext();
			ds=(DataSource)ic.lookup("DsJndi");		
		    con=ds.getConnection();
		    ps=con.prepareStatement(UDAY);
		    ps.setString(1, bo.getName());
		    ps.setString(2, bo.getAdd());
		    ps.setFloat(3, bo.getAmt());
		    ps.setFloat(4, bo.getIntrest());
		    ps.setFloat(5, bo.getMonths());
		    ps.setFloat(6, bo.getVaddi());
		    count=ps.executeUpdate();
			
	}catch(Exception e ){
		e.printStackTrace();
	}finally {
		try {
			if(ps!=null)
				ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
			try {
			if(con!=null)
				con.close();
				
		}catch(SQLException se) {
	       se.printStackTrace();		
		}
		
	}
 
		return count;
}
}
