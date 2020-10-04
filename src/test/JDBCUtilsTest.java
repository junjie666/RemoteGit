package test;

import java.sql.Connection;

import org.junit.Test;

import utils.JDBCUtils;

public class JDBCUtilsTest
{
	@Test
	public void getConnectionTest()
	{
		Connection connection=JDBCUtils.getConnection();
		System.out.println(connection.toString());
		JDBCUtils.releaseConnection(connection);
	}
}
