package hubery.controller;

import com.github.pagehelper.PageInfo;
import hubery.pojo.BookInfo;
import hubery.pojo.BookType;
import hubery.service.BookInfoService;
import hubery.service.BookTypeService;
import hubery.utils.EmptyUtils;
import hubery.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController extends javax.servlet.http.HttpServlet {

    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("/getset")
    @ResponseBody
    public ResponseEntity getset(Integer id) {
        ResponseEntity re = null;
        try {
            BookInfo one = bookInfoService.findOne(id);
            one.setIsborrow(one.getIsborrow()==1?0:1);
            bookInfoService.update(one);
            re = new ResponseEntity("操作成功","/book/list");
        }catch (Exception e){
            e.printStackTrace();
            re = new ResponseEntity("操作失败","/book/list");
        }
        return re;
    }

    @RequestMapping("/show")
    public String show(Integer id,Model model) {
        try {
            model.addAttribute("b",bookInfoService.findOne(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "show";
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity del(Integer id) {
        ResponseEntity re = null;
        try {
            bookInfoService.delete(id);
            re = new ResponseEntity("删除成功","/book/list");
        } catch (SQLException e) {
            e.printStackTrace();
            re = new ResponseEntity("删除失败","/book/list");
        }
        return re;
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseEntity save(BookInfo info) {
        ResponseEntity re = null;

        try {
            if (EmptyUtils.isEmpty(info.getBookid())){
                info.setIsborrow(0);
                bookInfoService.add(info);
            }else {
                bookInfoService.update(info);
            }

            re = new ResponseEntity("发布成功","/book/list");
        }catch (Exception e){
            e.printStackTrace();
            re = new ResponseEntity("发布失败","#");

        }

        return re;

    }

    @RequestMapping("/find")
    public String find(Integer id ,Model model) {
        try {
            BookInfo one = bookInfoService.findOne(id);
            List<BookType> tList = bookTypeService.findAll();

            model.addAttribute("tList",tList);
            model.addAttribute("b",one);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "save";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(required = false,defaultValue = "1") Integer page,
                        @RequestParam(required = false,defaultValue = "-1") Integer tid,
                        @RequestParam(required = false,defaultValue = "") String likename,
                        @RequestParam(required = false,defaultValue = "-1") Integer isb,
                        Model model){


        PageInfo<BookInfo> list = null;
        try {
            list = bookInfoService.findByLimit(page,tid,likename,isb);
            List<BookType> tList = bookTypeService.findAll();

            model.addAttribute("likename" , likename);
            model.addAttribute("tid" , tid);
            model.addAttribute("isb" , isb);

            model.addAttribute("tList" , tList);
            model.addAttribute("pb" , list);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "list";
    }


}
