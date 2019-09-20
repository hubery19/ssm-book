package hubery.service;

import hubery.pojo.BookType;

import java.sql.SQLException;
import java.util.List;

public interface BookTypeService {
    List<BookType> findAll() throws SQLException;
}
