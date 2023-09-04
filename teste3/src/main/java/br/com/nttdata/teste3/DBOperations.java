package br.com.nttdata.teste3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DBOperations {

    public static Massas getMassaDados() throws SQLException {
        Massas massa = new Massas();

        String query = "SELECT * FROM massas WHERE NAME_PRODUCT = 'HP PAVILION 15Z TOUCH LAPTOP'";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {

                massa.setNAME_PRODUCT(resultSet.getString("NAME_PRODUCT"));
                massa.setNAME_PRODUCT(resultSet.getString("NAME_PRODUCT"));
                massa.setCUSTOMIZATION(resultSet.getString("CUSTOMIZATION"));
                massa.setDISPLAY(resultSet.getString("DISPLAY"));
                massa.setDISPLAY_RESOLUTION(resultSet.getString("DISPLAY_RESOLUTION"));
                massa.setDISPLAY_SIZE(resultSet.getString("DISPLAY_SIZE"));
                massa.setMEMORY(resultSet.getString("MEMORY"));
                massa.setOPERATING_SYSTEM(resultSet.getString("OPERATING_SYSTEM"));
                massa.setPROCESSOR(resultSet.getString("PROCESSOR"));
                massa.setTOUCHSCREEN(resultSet.getString("TOUCHSCREEN"));
                massa.setWEIGHT(resultSet.getString("WEIGHT"));
                massa.setCOLOR(resultSet.getString("COLOR"));
            }
        } catch (SQLException e) {
        }

        return massa;
    }

    public static void alteraCor(String novaCor, long id) throws SQLException {
        String query = "UPDATE massas SET COLOR = ? WHERE IDMASSAS = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, novaCor);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
