package pl.coderslab.dao;

import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

//data access object
public class UserDao {
    // pola final query oraz hashpassword
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?,?,?);";
    private static final String MODIFY_USER_QUERY = "UPDATE users SET username =?," +
            "email = ?, password = ? WHERE users.id = ?;";
    private static final String PRINT_USER_QUERY = "SELECT * FROM users WHERE users.id = ?;";
    private static final String REMOVE_USER_QUERY = "DELETE FROM users WHERE users.id = ?;";
    private static final String PRINTALL_QUERY = "SELECT * FROM  users;";

    public String hashPassword(String password) {
        return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public User read(int userId) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement st = connection.prepareStatement(PRINT_USER_QUERY)) {
            st.setInt(1, userId);
            ResultSet resultSet = st.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(MODIFY_USER_QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idUser) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_USER_QUERY);) {
            statement.setInt(1, idUser);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User[] findAll() {

        User[] userTab = new User[0];
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(PRINTALL_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1)).setEmail(rs.getString(2)).setUserName(rs.getString(3)).
                        setPassword(rs.getString(4));
                userTab = addToArray(user, userTab);
            }
            return userTab;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }
}
