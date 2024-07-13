package Operation;

import Book.BookList;

import java.sql.SQLException;

public interface WORK
{
    public  void work(BookList  bookList) throws SQLException;
}
