package src.repository;
import java.sql.*;

public class Database {
    public static void main(String[] args)
    {
        String url = "";
        String username = "";
        String password = "";
        try{
            Connection connection = DriverManager.getConnection(url);
            String sql = "input the query from the database which will be run";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String columnValue = resultSet.getString("column1");
                String columnValue2 = resultSet.getString("column2");

                //Afterwards save the data in the best way or process it directly
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
