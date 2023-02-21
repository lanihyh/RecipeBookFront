/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HomeGenius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lani
 */
public class RecipeDatabase {

    private Connection connection;

    public RecipeDatabase(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe_app", "root", "Dini0626#");
        System.out.println("Connection to database successful");
        
    }

    public void insertRecipe(String name, int cookingTime, String ingredient, String directions, byte[] image) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO addRecipe (name, cookingTime, ingredient, directions, image) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, name);
        statement.setInt(2, cookingTime);
        statement.setString(3, ingredient);
        statement.setString(4, directions);
        statement.setBytes(5, image);
        statement.executeUpdate();
        statement.close();
    }

    public void close() throws SQLException {
        connection.close();
    }

}

