package hubery.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookInfo {
    private Integer bookid;

    private String bookcode;

    private String bookname;

    private Integer booktype;

    private String bookauthor;

    private String publishpress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishdate;

    private Integer isborrow;

    private BookType type;

    public BookInfo(Integer bookid, String bookcode, String bookname, Integer booktype, String bookauthor, String publishpress, Date publishdate, Integer isborrow) {
        this.bookid = bookid;
        this.bookcode = bookcode;
        this.bookname = bookname;
        this.booktype = booktype;
        this.bookauthor = bookauthor;
        this.publishpress = publishpress;
        this.publishdate = publishdate;
        this.isborrow = isborrow;
    }

    public BookInfo(String bookcode, String bookname, Integer booktype, String bookauthor, String publishpress, Date publishdate, Integer isborrow) {
        this.bookcode = bookcode;
        this.bookname = bookname;
        this.booktype = booktype;
        this.bookauthor = bookauthor;
        this.publishpress = publishpress;
        this.publishdate = publishdate;
        this.isborrow = isborrow;
    }

    public BookInfo() {
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookcode() {
        return bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode == null ? null : bookcode.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBooktype() {
        return booktype;
    }

    public void setBooktype(Integer booktype) {
        this.booktype = booktype;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public String getPublishpress() {
        return publishpress;
    }

    public void setPublishpress(String publishpress) {
        this.publishpress = publishpress == null ? null : publishpress.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getIsborrow() {
        return isborrow;
    }

    public void setIsborrow(Integer isborrow) {
        this.isborrow = isborrow;
    }
}