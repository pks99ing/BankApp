package com.bank.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private String cust_id;
	private String acc_id;
	private String balance;
	private String password;
	private String tAcct;
	private int amount;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet result;
	private int rowAffected;
	private String helperBalance;

	public String gettAcct() {
		return tAcct;
	}

	public void settAcct(String tAcct) {
		this.tAcct = tAcct;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCust_id() {
		return cust_id;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public String getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean loginToHomePage() {
		try {
			pst = con.prepareStatement("select * from bank_info where cust_id=? and password=?");
			pst.setString(1, cust_id);
			pst.setString(2, password);
			result = pst.executeQuery();
			while (result.next()) {
				acc_id = result.getString(2);
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkBalance() {
		try {
			pst = con.prepareStatement("select balance from bank_info where Acc_no=?");
			pst.setString(1, acc_id);
			result = pst.executeQuery();
			while (result.next()) {
				balance = result.getString(1);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean changePassword() {
		try {
			pst = con.prepareStatement("update bank_info set password=? where Acc_no=?");

			pst.setString(1, password);
			pst.setString(2, acc_id);
			rowAffected = pst.executeUpdate();
			if (rowAffected > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean withDrawal() {
		try {
			pst = con.prepareStatement("select balance from bank_info where Acc_no=?");
			pst.setString(1, acc_id);
			result = pst.executeQuery();

			while (result.next()) {
				balance = result.getString(1);
			}
			if (Integer.parseInt(balance) > amount) {
				balance = Integer.toString(Integer.parseInt(balance) - amount);
				pst = con.prepareStatement("update bank_info set balance=? where Acc_no=?");
				pst.setString(1, balance);
				pst.setString(2, acc_id);
				rowAffected = pst.executeUpdate();
				if (rowAffected != 0)
					return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean amountDeposit() {
		try {
			pst = con.prepareStatement("select balance from bank_info where Acc_no=?");
			pst.setString(1, acc_id);
			result = pst.executeQuery();

			while (result.next()) {
				balance = result.getString(1);
			}

			balance = Integer.toString(Integer.parseInt(balance) + amount);
			pst = con.prepareStatement("update bank_info set balance=? where Acc_no=?");
			pst.setString(1, balance);
			pst.setString(2, acc_id);
			rowAffected = pst.executeUpdate();
			if (rowAffected != 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean transferAmount() {
		try {	
			pst = con.prepareStatement("select balance from bank_info where Acc_no=?");
			pst.setString(1, acc_id);
			result = pst.executeQuery();
			while (result.next()) {
				balance = result.getString(1);
			}
			System.out.println(tAcct+" "+acc_id + " "+amount);
			if(Integer.parseInt(balance)>amount) {
				pst = con.prepareStatement("select balance from bank_info where Acc_no=?");
				pst.setString(1, tAcct);
				result = pst.executeQuery();
				while (result.next()) {
					helperBalance = result.getString(1);
				}
				helperBalance=Integer.toString(Integer.parseInt(helperBalance)+amount);
				pst = con.prepareStatement("update bank_info set balance=? where Acc_no=?");
				pst.setString(1, helperBalance);
				pst.setString(2, tAcct);
				rowAffected=pst.executeUpdate();
				if(rowAffected>0) {
					balance=Integer.toString(Integer.parseInt(balance)-amount);
					pst = con.prepareStatement("update bank_info set balance=? where Acc_no=?");
					pst.setString(1, balance);
					pst.setString(2, acc_id);
					int row=pst.executeUpdate();
					if(row>0)
						return true;
					else
						return false;
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}












