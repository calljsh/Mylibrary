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
public class Borrow  implements WORK
{
    @Override
    public void work(BookList bookList) throws SQLException
    {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("454284665");
        //2 建立链接
        Connection connection=dataSource.getConnection();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要借的书的名字");
        String name=sc.nextLine();
        //3
        String sql = "select * from lib where name= ?and state ='未被借出'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        // 4 发送给服务器并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
        {
            String sql1="update lib set state ='已借出' where name=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
            preparedStatement1.setString(1,name);
           int n= preparedStatement1.executeUpdate();
           if(n>0)
           {
               System.out.println("借阅成功");
               preparedStatement1.close();
           }
        }
        else
        {
            System.out.println("没有找到这本书,借阅失败");
        }
        //5 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
//        String sql=""

//        int size= bookList.getUsedsize();
//        for(int i=0;i<size;i++)
//        {
//            BOOK temp= bookList.getBook(i);
//             if(temp.getName().equals(name)&&temp.isBorrowed()==false)
//             {
//                 System.out.println("成功借出");
//                 temp.setBorrowed(true);
//                 return ;
//             }
//        }
//        System.out.println("借阅失败");
    }
}
