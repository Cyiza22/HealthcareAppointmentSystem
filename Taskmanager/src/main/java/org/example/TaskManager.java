package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final String  user= "postgres";
    private final String  password = "Rwanda";

    private Connection connect () throws SQLException {
        return DriverManager.getConnection(url , user, password);
    }


//    CRUD (CREATE READ UPDATE DELETE)

//    UPDATE/INSERT
    public void add(Task task)  {
        String query  = " insert into task (title, description) values (?, ?)";

        try(Connection conn = connect(); PreparedStatement prepare = conn.prepareStatement(query)){
            prepare.setString(1, task.getTitle());
            prepare.setString(2, task.getDescription());
            prepare.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    READ
    public List<Task> getTask()  {
        String query  = " select * from task";
        List<Task> tasks = new ArrayList<>();
        try(Connection conn = connect() ; Statement statement  = conn.createStatement() ;
            ResultSet result = statement.executeQuery(query)){
            while(result.next()){
                tasks.add(new Task(result.getInt(1),
                        result.getString(2),
                        result.getString(3)));
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }
}
