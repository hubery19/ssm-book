package hubery.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hubery.mapper.BookInfoMapper;
import hubery.mapper.BookTypeMapper;
import hubery.pojo.BookInfo;
import hubery.pojo.BookInfoExample;
import hubery.pojo.BookType;
import hubery.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoMapper mapper;
    @Autowired
    private BookTypeMapper typeMapper;

    @Override
    public PageInfo<BookInfo> findByLimit(Integer page, Integer tid, String name, Integer isB) throws SQLException {

        PageHelper.startPage(page,3);

        BookInfoExample cexample = new BookInfoExample();
        BookInfoExample.Criteria criteria = cexample.createCriteria();
        if (tid != -1){
            criteria.andBooktypeEqualTo(tid);
        }
        criteria.andBooknameLike("%"+name+"%");
        if (isB != -1) {
            criteria.andIsborrowEqualTo(isB);
        }
        PageInfo<BookInfo> list = new PageInfo<>(mapper.selectByExample(cexample));

        List<BookType> tList = typeMapper.selectByExample(null);
        for (BookInfo info : list.getList()) {
            for (BookType type : tList) {
                if (info.getBooktype() == type.getId()){
                    info.setType(type);
                }
            }
        }
        return list;
    }

    @Override
    public BookInfo findOne(Integer id) throws SQLException {
        BookInfo info = mapper.selectByPrimaryKey(id);

        List<BookType> tList = typeMapper.selectByExample(null);
        for (BookType type : tList) {
            if (info.getBooktype() == type.getId()){
                info.setType(type);
                break;
            }
        }
        return info;
    }

    @Override
    public void update(BookInfo b) throws SQLException {
        mapper.updateByPrimaryKey(b);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(BookInfo b) throws SQLException {
        mapper.insert(b);
    }


}
