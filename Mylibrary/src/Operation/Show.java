package Operation;
import Book.BOOK;
import Book.BookList;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Show  implements WORK
{
    @Override
    public void work(BookList bookList) throws SQLException
    {

        // 1 创建
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");

        // 2 建立链接
        Connection connection = dataSource.getConnection();

        // 3 创建sql语句
        String sql = "SELECT * FROM lib";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 4 发送给服务器并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5 处理结果
        while (resultSet.next())
        {
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            int price = resultSet.getInt("price");
            String type = resultSet.getString("type");
            String state=resultSet.getString("state");
            System.out.println("书名: " + name + " 作者: " + author + " 价格: " + price + " 类型: " + type + " 状态: "+state);
        }
        // 6 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

//        int size= bookList.getUsedsize();
//        for(int i=0;i<size;i++)
//        {
//            System.out.println(bookList.getBook(i));
//            System.out.print(" ");
//        }