package Interface;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class DBConnection {
	
	public static Connection connect() {
		
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newinventory","root","");
		//	JOptionPane.showMessageDialog(null, "connection success");
			
		}catch (Exception e) {
		
	}
		return conn;
		
	}

}
