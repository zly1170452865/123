package com.yuntu.utli;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 简化增删改查
 * @author M
 *
 */
public class BaseDao {
	Connection con = null;	//连接数据库
	PreparedStatement ps = null;	//执行语句
	protected ResultSet rs = null;	//获得所有结果集（查询用）

	static String driver;
	static String url;
	static String user;
	static String password;

	//连接数据库的方法
	public boolean getConnection() {
		//jdbc连接方式
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		//jndi数据库连接池连接方式
//		try { //获取与逻辑名相关联的数据源对象
//			Context ctx = new InitialContext();
//			DataSource ds=(DataSource)ctx.lookup("java:comp/envbc/driverschool");
//			conn = ds.getConnection();
//		} catch (SQLException exception){
//			exception.printStackTrace();
//		} catch (NamingException namingException){
//		namingException.printStackTrace();
//	}
		return true;
	};







//	当类被加载的时候执行
	static {
		init();
	}

	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";
		//将文件转换为流对象
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			//将文件内容读取到params里
			params.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
	}
	
	//关闭
	public void close() {

		try {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 增，删，改，优化
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executUpdate(String sql,Object[] params) {
		int updateRows = 0;
		//判断是否连接成功
		if (getConnection()) {
			try {
				ps = con.prepareStatement(sql);
				//使用for循环，填充占位符
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				updateRows = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateRows;
	}
	/**
	 * 查询的优化
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeSql(String sql,Object[] params) {
		if (getConnection()) {
			try {
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
}
