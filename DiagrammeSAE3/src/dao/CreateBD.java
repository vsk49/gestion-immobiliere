package dao;

import java.sql.*;

public class CreateBD {

	public static void main(String[] args) {
		CreateBD monBD = new CreateBD();
	}
	
	public CreateBD() throws Exception {
		Connection cn = JDBCConnexion.getConnection();
		JDBCConnexion.closeConnection();
	}
	
	private static void createTablesBD(Connection cn) {
		
	}

}
