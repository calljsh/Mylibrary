package User;
import Book.BOOK;
import Book.BookList;
import Operation.*;

import java.util.Scanner;

public class Nomaluser extends FatherUser
{
    public Nomaluser(String name)
    {
        super(name);
        this.works =new WORK[]{new Exit(),new Find(),new Borrow(),new Return(),new Show()};
    }

    public int menu ()
    {
        System.out.println("**********用户***********");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("*********************");
        System.out.println("请输入你的操作:");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        return choice;
    }
}
