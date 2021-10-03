import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Demo {
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "Kanewilliamson");

	}
	
	public void employee() {
		
		try(Connection connection = getConnection()){
			String sql = "SELECT * FROM employee";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ArrayList names = new ArrayList();
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				System.out.println(name);
				names.add(name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
// statement
//	prepared statement
//	callable statement
	
}
