package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.User;


public class UserManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		User user = new User();
		user.setRid(rs.getInt("RID"));
		user.setLoginName(rs.getString("LoginName").trim());
		user.setPassWord(rs.getString("PassWord").trim());
		user.setName(rs.getString("Name").trim());
		user.setEmail(rs.getString("Email").trim());
		user.setUserType(rs.getInt("UserType"));
		return user;
	}

	public User getUser(int rid){
		String sql = "";
		sql += "Select * from UserInfo Where ";
		sql += " RID = "+rid;
		return (User)getRecord(sql);
	}

	public String getUserName(int rid){
		String sql = "";
		sql += "Select * from UserInfo Where ";
		sql += " RID = "+rid;

		User result = (User)getRecord(sql);
		String name= result.getName();
		return name;
	}


	public User getUser(String loginName,String passWord){
		String sql = "";
		sql += "Select * from UserInfo Where ";
		sql += " LoginName = '"+loginName +"'";
		sql += " AND ";
		sql += " PassWord = '"+passWord +"'";
		return (User)getRecord(sql);
	}

	public User getUserAdmin(String loginName,String passWord){
		String sql = "";
		sql += "Select * from UserInfo Where ";
		sql += " LoginName = '"+loginName +"'";
		sql += " AND ";
		sql += " PassWord = '"+passWord +"'";
		sql += " AND ";
		sql += " UserType = 1";

		return (User)getRecord(sql);
	}

	public LinkedList<User> getUsers(){
		String sql = "";
		sql += "Select * from UserInfo";

		return (LinkedList<User>)getRecords(sql);
	}
}
