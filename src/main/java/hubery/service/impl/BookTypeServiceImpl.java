package hubery.service.impl;


import hubery.mapper.BookTypeMapper;
import hubery.pojo.BookType;
import hubery.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeMapper mapper;

    @Override
    public List<BookType> findAll() throws SQLException {
        return mapper.selectByExample(null);
    }
}
