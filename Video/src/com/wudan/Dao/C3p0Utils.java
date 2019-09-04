package com.wudan.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	
	private static ComboPooledDataSource ds = new ComboPooledDataSource("igeek");

	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
