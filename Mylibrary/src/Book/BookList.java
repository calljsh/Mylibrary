package Book;

import java.util.*;
import Book.BOOK;
public class BookList
{
  public int usedsize;
  public BOOK[] bookinfermation;
    public BookList()
    {
        this.bookinfermation = new BOOK[1000];
        this.bookinfermation[0]=new BOOK("红楼梦","曹雪芹",20,"小说");
        this.bookinfermation[1]=new BOOK("西游记","吴承恩",20,"小说");
        this.bookinfermation[2]=new BOOK("水浒传","施耐庵",20,"小说");
        this.bookinfermation[3]=new BOOK("三国演义","罗贯中",20,"小说");
        this.usedsize = 4;

    }
    public int getUsedsize() {
        return usedsize;
    }
    public void setUsedsize(int usedsize) {
        this.usedsize = usedsize;
    }
    public BOOK getBook(int pos)
    {
        return  bookinfermation[pos];
        // 展示书籍
    }

    public void setBook(int pos, BOOK book)
    {
          bookinfermation[pos]=book;
          // 放置书籍
    }
}
