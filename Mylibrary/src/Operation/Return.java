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
public class  Return  implements WORK
{
    @Override
    public void work(BookList bookList) {

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要归还的书的名字:");
            String name = sc.nextLine();

            String sql = "SELECT * FROM lib WHERE name = ? AND state = '已借出'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String sql1 = "UPDATE lib SET state = '未被借出' WHERE name = ?";
                preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setString(1, name);
                int n = preparedStatement1.executeUpdate();
                if (n > 0) {
                    System.out.println("归还成功");
                }
            } else {
                System.out.println("没有找到这本书或这本书未被借出, 归还失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作失败: " + e.getMessage());
        } finally {
            // 按正确顺序关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement1 != null) {
                try {
                    preparedStatement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        int size= bookList.getUsedsize();
//        for(int i=0;i<size;i++)
//        {
//            BOOK temp= bookList.getBook(i);
//            if(temp.getName().equals(name)&&temp.isBorrowed()==true)
//            {
//                System.out.println("成功归还");
//                temp.setBorrowed(false);
//                return ;
//            }
//        }
//        System.out.println("归还失败");
//    }
    }
    }