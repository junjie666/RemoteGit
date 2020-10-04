package utils;
/**
 * 获取和释放数据库连接
 * @author shenjunjie
 *
 */

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCUtils
{
	//1.获取数据库连接池
	private static DataSource dataSource=new ComboPooledDataSource("junjiedatasource");
	
	//2.获取数据库连接
	public static Connection getConnection()
	{
		Connection connection=null;
		
		try
		{
			connection=dataSource.getConnection();
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//3.释放数据库连接
	public static void releaseConnection(Connection connection)
	{
		try
		{
			if(connection!=null)
				connection.close();
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
