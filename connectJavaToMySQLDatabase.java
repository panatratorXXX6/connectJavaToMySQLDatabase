package cursor;

import java.sql.*;

public class connectJavaToMySQLDatabase {

    public static final String URL = "jdbc:mysql://localhost:3306/database_name";
    public static final String USERNAME = "your_user_name";
    public static final String PASSWORD = "your_password";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();

    }
}
