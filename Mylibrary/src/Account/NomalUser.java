package Account;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NomalUser
{
    public int password;
    public String name;

    // 初始化为空值
    public NomalUser()
    {
        this.password = 0;
        this.name = "";
    }
    public void Register(String name, int password) throws SQLException
    {
        //1
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");

        //2
        Connection connection = dataSource.getConnection();

        //3
        String sql = "INSERT INTO normaluser (name, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, password);

        //4
        int n = preparedStatement.executeUpdate();

        //5
        preparedStatement.close();
        connection.close();
    }

    public boolean Land(String name, int password) throws SQLException
    {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");

        //2
        Connection connection = dataSource.getConnection();

        //3
        String sql = "SELECT * FROM normaluser WHERE name = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, password);

        //4
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean found = resultSet.next();

        //5
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return found;
    }
}
