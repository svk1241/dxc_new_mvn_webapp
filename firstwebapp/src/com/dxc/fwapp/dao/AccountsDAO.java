package com.dxc.fwapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dxc.fwapp.bean.Accounts;
public class AccountsDAO 
{
	public double getAccountBalance(String  username)
	{
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		double balance=0.0;
		try
		{
			con=DBConnection.getConnection();
			pst=con.prepareStatement("select balance from accounts where username=?");
			pst.setString(1,username);
			rs=pst.executeQuery();
			if(rs.next()) balance=rs.getDouble(1);
		}
		catch(Exception ex)
		
			{
				ex.printStackTrace();
			}
			finally
			{
				DBConnection.closeResultSet(rs);
				DBConnection.closeStatement(pst);
				DBConnection.closeConnection(con);
				
			}
			return balance;
			
			
		}
	public boolean modifyAccountBalance(String username,double amount,char transType)
	{
		Connection con=null;
		PreparedStatement pst = null;
		int count=0;
		String qry = "update accounts set balance=balance+? where username=?";
		if(transType=='w' || transType=='W')
			qry="update accounts set balance=balance-? where username=?";
		try
		{
			con=DBConnection.getConnection();
			pst=con.prepareStatement(qry);
			pst.setDouble(1, amount);
			pst.setString(2,username);
			count = pst.executeUpdate();
		}
		catch(Exception ex)
		
			{
				ex.printStackTrace();
			}
			finally
			{
				
				DBConnection.closeStatement(pst);
				DBConnection.closeConnection(con);
				
			}
			return count == 1;
			
			
		}
	}

		
	


