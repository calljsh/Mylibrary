import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;


public class test1
{
    // JDBC 基本流程
    public static void main(String[] args) throws SQLException
    {
           //1. 创建DataSource
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("454284665");


        //2 和数据库建立连接
        Connection connection= dataSource.getConnection();

        //3.构造 sql
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        String name=scanner.next();
        String sql="insert into jsh values(?,?)";
        String sql2="delete from jsh where name='傻逼'";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        PreparedStatement preparedStatement1=connection.prepareStatement(sql2);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);

        //4.把sql发给服务器
        int n=preparedStatement.executeUpdate();
        System.out.println(n);
         int num=preparedStatement1.executeUpdate();
        System.out.println(num);
        //5.释放资源
        preparedStatement.close();
        connection.close();
    }
}
