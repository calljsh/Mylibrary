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

public class Find implements WORK {
    @Override
    public void work(BookList Booklist) throws SQLException {
        System.out.println("输入你要查找的图书的name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        // 1 创建
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");

        // 2 建立链接
        Connection connection = dataSource.getConnection();

        // 3 创建sql语句
        String sql = "SELECT * FROM lib where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        // 4 发送给服务器并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
        {
            System.out.println("找到了");
            String name1 = resultSet.getString("name");
            String author = resultSet.getString("author");
            int price = resultSet.getInt("price");
            String type = resultSet.getString("type");
            String state = resultSet.getString("state");
            System.out.println("书名: " + name + " 作者: " + author + " 价格: " + price + " 类型: " + type + " 状态: " + state);
        } else {
            System.out.println("没找到");
        }

        //5
        resultSet.close();
        preparedStatement.close();
        connection.close();


//        int size= Booklist.getUsedsize();
//        for(int i=0;i<size;i++)
//        {
//            BOOK temp=Booklist.getBook(i);
//            if(temp.getName().equals(name))
//            {
//                System.out.println("找到了,信息如下");
//                System.out.println(temp);
//                return ;
//            }
//        }
//        System.out.println("没有找到!");
//    }
    }
}
