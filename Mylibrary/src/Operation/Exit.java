package Operation;
import Book.BOOK;
import Book.BookList;
import java.util.Scanner;
public class Exit implements WORK
{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出,谢谢使用");
        System.exit(0);

    }
}
