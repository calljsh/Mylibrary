package Operation;
import Book.BOOK;
import Book.BookList;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Add implements WORK
{
    @Override
    public void work(BookList bookList)throws SQLException
    {
        //1 创建
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("454284665");

        //2 建立链接
      Connection connection=dataSource.getConnection();

      //3 创建sql语句
        System.out.println("增加图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要添加的图书的书名：");
        String name= scanner.nextLine();
        System.out.println("请输入您要添加的图书的作者名：");
        String author = scanner.nextLine();
        System.out.println("请输入您要添加的图书的类型：");
        String type = scanner.nextLine();
        System.out.println("请输入您要添加的图书的价格：");
        int price = scanner.nextInt();
        String sql="insert into lib (name,author,price,type,state)values(?,?,?,?,default)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
         preparedStatement.setString(1,name);
        preparedStatement.setString(2,author);
        preparedStatement.setInt(3,price);
        preparedStatement.setString(4,type);
        //4 发送给服务器
        int n=preparedStatement.executeUpdate();
        //5 释放资源
        preparedStatement.close();
        connection.close();
    }
}
//        BOOK book=new BOOK( name,author,price,type);
//        int size=bookList.getUsedsize();
//        for(int i=0;i<size;i++)
//        {
//            BOOK temp=bookList.getBook(i);
//            if(temp.equals(book))
//            {
//                System.out.println("不能添加一样的书");
//                return ;
//            }
//        }
//        System.out.println("添加成功");
//        bookList.setBook(size,book);
//        bookList.setUsedsize(size+1);
