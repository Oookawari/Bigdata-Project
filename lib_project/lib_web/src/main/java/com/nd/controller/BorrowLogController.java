package com.nd.controller;

import com.nd.dao.BookClassifyDao;
import com.nd.entity.*;
import com.nd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-19 16:41
 */
@Controller
@RequestMapping("/manage/")
public class BorrowLogController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserSumService userSumService;
    @Autowired
    private UserBreakService userBreakService;
    @Autowired
    private HotBookService hotBookService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BorrowLogService borrowLogService;
    @Autowired
    private BookClassifyService bookClassifyService;



    @RequestMapping("index.do")
    public String index(){
        return "index";
    }
    @RequestMapping("query.do")
    public String query(){
        return "query";
    }
    @RequestMapping("view.do")
    public String view(Model model,
                       @RequestParam(name = "bookname",defaultValue = "")String bookname,
                       @RequestParam(name = "month",defaultValue = "")String month) throws UnsupportedEncodingException {
        bookname = new String(bookname.getBytes("ISO-8859-1"),"utf-8");
        List<BorrowLog> borrowLog = borrowLogService.findBorrowLog(bookname, month);
        int length = borrowLog.size();
        model.addAttribute("borrowLogs",borrowLog);
        model.addAttribute("length",length);
        return "view";
    }
    @RequestMapping("booklist.do")
    public String booklist(Model model,
                       @RequestParam(name = "bookname",defaultValue = "")String bookname
                           ) throws UnsupportedEncodingException {
        bookname = new String(bookname.getBytes("ISO-8859-1"),"utf-8");

        model.addAttribute("bookname",bookname);
        bookname = "%"+bookname+"%";
        List<Book> books = bookService.findBook(bookname);
        model.addAttribute("books",books);
        return "booklist";
    }
    @RequestMapping("userlist.do")
    public String userlist(Model model,
                           @RequestParam(name = "userid",defaultValue = "")String userid
    ){
        List<User> users = userService.findUser("%"+userid+"%");
        model.addAttribute("users",users);
        model.addAttribute("userid",userid);
        return "userlist";
    }

    @RequestMapping("viewOfUser.do")
    public String viewOfUser(Model model,
                           @RequestParam(name = "userid",defaultValue = "")String userid
    ){
        List<User> userLogs = userService.findUser(userid);
        model.addAttribute("userLogs",userLogs);
        return "viewOfUser";
    }

    @RequestMapping("userRank.do")
    public String userRank(Model model){
        List<UserSum> userLists = userSumService.findUserSum();
        model.addAttribute("userLists",userLists);
        return "userRank";
    }

    @RequestMapping("viewOfBreak.do")
    public String viewOfBreak(Model model){

        List<UserBreak> userLists = userBreakService.findUserBreak();
        model.addAttribute("userLists",userLists);
        return "viewOfBreak";
    }
    @RequestMapping("bookRank.do")
    public String bookRank(Model model){
        List<BorrowLog> bookLists1 = hotBookService.findHotBook1();
        List<BorrowLog> bookLists2 = hotBookService.findHotBook2();
        List<BorrowLog> bookLists3 = hotBookService.findHotBook3();
        List<BorrowLog> bookLists4 = hotBookService.findHotBook4();
        List<BorrowLog> bookLists5 = hotBookService.findHotBook5();
        List<BorrowLog> bookLists6 = hotBookService.findHotBook6();
        model.addAttribute("bookLists1",bookLists1);
        model.addAttribute("bookLists2",bookLists2);
        model.addAttribute("bookLists3",bookLists3);
        model.addAttribute("bookLists4",bookLists4);
        model.addAttribute("bookLists5",bookLists5);
        model.addAttribute("bookLists6",bookLists6);
        return "bookRank";
    }
    @RequestMapping("sortbooks.do")
    public String sortbooks(Model model) {

        List<BookCategory> bookcategories = bookCategoryService.countBook();
        List<BookSortCount> booksorts = bookCategoryService.sortBook();
        model.addAttribute("bookcategories",bookcategories);
        model.addAttribute("booksorts",booksorts);
        return "sortbooks";
    }
    @RequestMapping("classify.do")
    public String classify(Model model,
                           @RequestParam(name = "cate",defaultValue = "")String cate) throws UnsupportedEncodingException {
        cate = new String(cate.getBytes("ISO-8859-1"),"utf-8");
        List<Book> books = bookClassifyService.BookClassify(cate);
        model.addAttribute("books",books);
        return "classify";
    }
    @RequestMapping("viewTool.do")
    public String viewTool(Model model){
        return "viewTool";
    }
    @RequestMapping("hotBooks.do")
    public String hotBooks(Model model,
                           @RequestParam(name = "month",defaultValue = "")String month){
        List<BorrowLog> bookLists;

        if(month.equals("1") ){
            bookLists= hotBookService.findHotBook1();
        }
        else if(month.equals("2")){
            bookLists= hotBookService.findHotBook2();
        }
        else if(month.equals("3")){
            bookLists= hotBookService.findHotBook3();
        }
        else if(month.equals("4")){
            bookLists= hotBookService.findHotBook4();
    }
        else if(month.equals("5")){
            bookLists= hotBookService.findHotBook5();
        }
        else if(month.equals("6")){
            bookLists= hotBookService.findHotBook6();
        }
        else{
            bookLists= hotBookService.findHotBook6();
        }
        model.addAttribute("books",bookLists);
        model.addAttribute("month", month);
        return "hotBooks";
    }
    @RequestMapping("showlist.do")
    public String showlist(Model model,
                           @RequestParam(name = "month",defaultValue = "")String month){
        List<UserSum> userLists = userSumService.findUserSum();
        model.addAttribute("userLists",userLists);
        return "showlist";
    }
}