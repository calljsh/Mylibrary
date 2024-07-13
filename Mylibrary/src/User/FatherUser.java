package User;
import Book.BOOK;
import Book.BookList;
import Operation.WORK;

import java.sql.SQLException;

public  abstract class  FatherUser
{
    public FatherUser(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  abstract int menu();
    protected  String name;
    protected  WORK[] works;
    public   void Doop(int choice,BookList bookList) throws SQLException {
        works[choice].work(bookList);
    }
}
