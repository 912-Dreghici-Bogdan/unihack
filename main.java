
import src.domain.Disease;
import src.domain.User;
import src.repository.DiseaseRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
//        User user1 = new User("Matei", "MiRau", "mancatias@HAzu.com", "Miraut", 1);
//        String restriction = "Gluten";
//        Disease glutens = new Disease("gluten free");
//        glutens.addRestrictions(restriction);
//        DiseaseRepo diseases = new DiseaseRepo();
//        diseases.addItem(glutens);
//        user1.setDisease(diseases);
//        user1.printuser();
    }
        public static String[] getHealthConditionsForUser(int userId) {
            List<String> healthConditionsList = new ArrayList<>();

            try {
                // Load the JDBC driver
                Class.forName("org.sqlite.JDBC");

                // Connect to the database (replace "UNIHACK.db" with your actual database name)
                Connection connection = DriverManager.getConnection("jdbc:sqlite:UNIHACK.db");

                // Execute the SQL query to retrieve health conditions for the specified user
                String query = "SELECT NameCondition FROM IsSuffering WHERE UserId = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, userId);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Process the result set and add health conditions to the list
                    while (resultSet.next()) {
                        String healthCondition = resultSet.getString("NameCondition");
                        healthConditionsList.add(healthCondition);
                    }
                }

                // Close the database connection
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            // Convert the list to an array
            return healthConditionsList.toArray(new String[0]);
        }


        public static String[] getHarmfulIngredientsForHealthCondition(String healthConditionName) {
            List<String> harmfulIngredientsList = new ArrayList<>();

            try {
                // Load the JDBC driver
                Class.forName("org.sqlite.JDBC");

                // Connect to the database (replace "UNIHACK.db" with your actual database name)
                Connection connection = DriverManager.getConnection("jdbc:sqlite:UNIHACK.db");

                // Execute the SQL query to retrieve harmful ingredients for the specified health condition
                String query = "SELECT HarmulIngredients FROM HealthCondition WHERE NameCondition = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, healthConditionName);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Process the result set and add harmful ingredients to the list
                    if (resultSet.next()) {
                        String harmfulIngredients = resultSet.getString("HarmulIngredients");
                        harmfulIngredientsList.add(harmfulIngredients);
                    }
                }

                // Close the database connection
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            // Convert the list to an array
            return harmfulIngredientsList.toArray(new String[0]);}
    }


