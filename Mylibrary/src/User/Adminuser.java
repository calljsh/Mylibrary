package User;
import Book.BOOK;
import Book.BookList;
import Operation.*;

import java.util.Scanner;

public  class Adminuser extends FatherUser
{
    public Adminuser(String name)
    {
        super(name);
        this.works=new WORK[]{new Exit(),new Find(),new Add(),new Delete(),new Show()};
    }
public int menu ()
{
    System.out.println("*********管理员************");
    System.out.println("1.查找图书");
    System.out.println("2.增加图书");
    System.out.println("3.删除图书");
    System.out.println("4.显示图书");
    System.out.println("0.退出系统");
    System.out.println("*********************");
    System.out.println("请输入你的操作:");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    return choice;
}
}
