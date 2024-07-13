package Operation;
import Book.BOOK;
import Book.BookList;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Delete implements WORK
{
    @Override
    public void work(BookList bookList) throws SQLException
    {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jsh?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("454284665");
        // 声明连接和预处理语句
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 建立连接
            connection = dataSource.getConnection();
            // 获取用户输入
            Scanner sc = new Scanner(System.in);
            System.out.println("输入你要删除图书的名字:");
            String name = sc.nextLine();

            // 创建SQL语句
            String sql = "DELETE FROM lib WHERE name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            // 执行删除操作
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("图书删除成功");
            } else {
                System.out.println("没有找到要删除的图书");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

//        int size=bookList.getUsedsize();
//        int pd=0;
//        int flag=0;
//        for(int i=0;i<size;i++)
//        {
//            BOOK temp=bookList.getBook(i);
//           if(temp.getName().equals(name))
//           {
//               pd=1;
//               flag=i;
//               break;
//           }
//        }
//        if(pd==0)
//        {
//            System.out.println("没有这本书,删除失败");
//            return ;
//        }
//       else
//        {
//            for(int j=flag;j<size;j++)
//            {
//                BOOK book=bookList.getBook(j+1);
//                bookList.setBook(j,book);
//                // 把前一个的信息填进来
//            }
//        }
//       bookList.setBook(size,null);
//       bookList.setUsedsize(size-1);
    }

