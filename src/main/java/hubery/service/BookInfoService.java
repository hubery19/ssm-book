package hubery.service;

import com.github.pagehelper.PageInfo;
import hubery.pojo.BookInfo;
import java.sql.SQLException;

public interface BookInfoService {
    PageInfo<BookInfo> findByLimit(Integer page, Integer tid, String name, Integer isB) throws SQLException;
    BookInfo findOne(Integer id) throws SQLException;
    void update(BookInfo b) throws SQLException;
    void delete(Integer id) throws SQLException;
    void add(BookInfo b) throws SQLException;

}
