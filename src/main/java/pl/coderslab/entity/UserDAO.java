package pl.coderslab.entity;

import connections.DBUtil;

import java.sql.*;
import java.util.Arrays;

import static connections.DBUtil.hashPassword;

public class UserDAO {
    private static final String CREATE_USER = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM users where id = ?";
    private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String UPDATE_USER = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";

    public User create(User user){
        try(Connection conn = DBUtil.connect()){
            PreparedStatement st =
                    conn.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getUserName());
            st.setString(2, user.getEmail());
            st.setString(3, hashPassword(user.getPassword()));
            st.executeUpdate();
            ResultSet resultSet = st.getGeneratedKeys();
            if(resultSet.next()){
                int a = resultSet.getInt(1);
                user.setId(a);
            }
            st.close();
            return user;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int id){
        try(Connection conn = DBUtil.connect()){
            PreparedStatement st = conn.prepareStatement(DELETE_USER);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public User read(int id){
        User user = new User();
        try(Connection conn = DBUtil.connect()){
            PreparedStatement st = conn.prepareStatement(SELECT_USER);
            st.setString(1, String.valueOf(id));
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        System.out.println(user);
        return user;
    }

    public void update(User user){
        try(Connection conn = DBUtil.connect()){
            PreparedStatement st = conn.prepareStatement(UPDATE_USER);
            st.setString(1, user.getUserName());
            st.setString(2, user.getEmail());
            st.setString(3, hashPassword(user.getPassword()));
            st.setString(4, String.valueOf(user.getId()));
            st.executeUpdate();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public User[] findAll(){
        User[] users = new User[0];
        try(Connection conn = DBUtil.connect()){
            PreparedStatement st = conn.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = st.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users = addToArray(user, users);
            }
            printAllUsers(users);
            st.close();
            return users;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private User[] addToArray(User user, User[] users){
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
        return users;
    }

    private void printAllUsers(User[] users){
        for(User user : users){
            System.out.println(user);
        }
    }
}
