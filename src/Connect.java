import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Connect {
	private Connection connection;
	private static Connect connect;
	
	public Connect() {
		MysqlDataSource source = new MysqlDataSource();
		source.setServerName("localhost");
		source.setUser("root");
		source.setPassword("");
		source.setDatabaseName("pt-pudding");
		try {
			connection = source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connect getConnection() {
		if(connect == null) {
			synchronized(Connect.class) {
				if(connect == null) {	
					connect = new Connect();
				}
			}
		}
		return connect;
	}

	public ResultSet executeQuery(String sql) {
		try {
			Statement st = connection.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean execute(String sql) {
		try {
			Statement st = connection.createStatement();
			return st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PreparedStatement prepareStatement(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
