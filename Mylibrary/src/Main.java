import Account.AdminUser;
import Account.NomalUser;
import Book.BookList;
import User.Adminuser;
import User.FatherUser;
import User.Nomaluser;
import java.sql.SQLException;
import java.util.Scanner;
public class Main
{
    public static FatherUser login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的身份: 1.管理员 2.用户");
        int identify = sc.nextInt();
        sc.nextLine(); // 清空缓冲区

        if (identify == 1)
        {
            System.out.println("1.登入 2.注册");
            int num = sc.nextInt();
            sc.nextLine(); // 清空缓冲区
            AdminUser adminUser = new AdminUser();
            if (num == 1)
            {
                System.out.println("请输入你的姓名");
                String name = sc.nextLine();
                System.out.println("请输入密码");
                int password = sc.nextInt();
                sc.nextLine(); // 清空缓冲区

                try {
                    if (adminUser.Land(name, password))
                    {
                        System.out.println("登入成功");
                        return new Adminuser(name);
                    } else
                    {
                        System.out.println("登入失败，用户名或密码错误");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("数据库错误，请稍后重试");
                }
            }
            else
            {
                System.out.println("请输入你的姓名和密码");
                String name = sc.nextLine();
                System.out.println("请输入密码");
                int password = sc.nextInt();
                sc.nextLine(); // 清空缓冲区

                try {
                    adminUser.Register(name, password);
                    System.out.println("注册成功");
                    return new Adminuser(name);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("数据库错误，请稍后重试");
                }
            }
        }
        else if (identify == 2)
        {
            System.out.println("1.登入 2.注册");
            int num = sc.nextInt();
            sc.nextLine(); // 清空缓冲区
            NomalUser nomalUser = new NomalUser();
            if (num == 1)
            {
                System.out.println("请输入你的姓名");
                String name = sc.nextLine();
                System.out.println("请输入密码");
                int password = sc.nextInt();
                sc.nextLine(); // 清空缓冲区

                try {
                    if (nomalUser.Land(name, password))
                    {
                        System.out.println("登入成功");
                        return new Nomaluser(name);
                    } else
                    {
                        System.out.println("登入失败，用户名或密码错误");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("数据库错误，请稍后重试");
                }
            }
            else
            {
                System.out.println("请输入你的姓名");
                String name = sc.nextLine();
                System.out.println("请输入密码");
                int password = sc.nextInt();
                sc.nextLine(); // 清空缓冲区

                try {
                    nomalUser.Register(name,password);
                    System.out.println("注册成功");
                    return new Nomaluser(name);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("数据库错误，请稍后重试");
                }
            }
        }
        return null;
    }
    public static void main(String[] args)
    {
        BookList bookList = new BookList();
        FatherUser user;

        while (true)
        {
            user = login();
            System.out.println(user.getName());
            if (user != null)
            {
                break;
            }
        }
        while (true)
        {
            int choice = user.menu();
            try
            {
                user.Doop(choice, bookList);
            } catch (SQLException e)
            {
                e.printStackTrace();
                System.out.println("操作失败，请稍后重试");
            }
        }
    }
}
