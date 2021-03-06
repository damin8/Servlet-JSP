package favian.web.Controller;

import favian.web.Model.Book;
import favian.web.Module.Find.FindBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private FindBooks findBooks;

    @RequestMapping(value = "/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addPage() {
        return "add";
    }

    @RequestMapping(value = "/borrow")
    public ModelAndView borrowPage(@RequestParam(required = false) String id) {

        ModelAndView modelAndView = new ModelAndView("borrow");

        if (id == null) {
            modelAndView.addObject("book", null);
            modelAndView.addObject("message", null);
            return modelAndView;
        }

        Book book = findBooks.findBookById(Integer.parseInt(id));

        if (book == null) {
            modelAndView.addObject("book", null);
            modelAndView.addObject("message", "Not Found");
            return modelAndView;
        }

        /*if (book.getRent().equals("No")) {
            modelAndView.addObject("book", null);
            modelAndView.addObject("message", null);
            return modelAndView;
        }*/

        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listPage(@RequestParam(required = false, defaultValue = "1") String pageNum,
                                 @RequestParam(required = false, defaultValue = "") String option,
                                 @RequestParam(required = false, defaultValue = "") String searchContent) {


        ModelAndView modelAndView = new ModelAndView("list");
        List<Book> books = findBooks.findAllBooks(Integer.parseInt(pageNum), option, searchContent);
        modelAndView.addObject("books", books);

        int count = findBooks.getBookCount("", option, searchContent);
        modelAndView.addObject("count", count);

        return modelAndView;
    }

    @RequestMapping(value = "/sortedList")
    public ModelAndView sortedListPage(@RequestParam(required = false, defaultValue = "1") String pageNum) {

        ModelAndView modelAndView = new ModelAndView("sortedList");
        List<Book> books = findBooks.findAllBooksByRentCount(Integer.parseInt(pageNum));
        modelAndView.addObject("books", books);
        int count = findBooks.getBookCount("");
        modelAndView.addObject("count", count);

        return modelAndView;
    }

    @RequestMapping(value = "/alreadyBorrow")
    public ModelAndView alreadyBorrowPage(@RequestParam(required = false, defaultValue = "1") String pageNum) {

        ModelAndView modelAndView = new ModelAndView("alreadyBorrow");
        List<Book> books = findBooks.findBorrowedBooks(Integer.parseInt(pageNum));
        modelAndView.addObject("books", books);
        int count = findBooks.getBookCount("Borrowed");
        modelAndView.addObject("count", count);

        return modelAndView;
    }

    @RequestMapping(value = "/return")
    public ModelAndView returnPage(@RequestParam(required = false, defaultValue = "1") String pageNum) {

        ModelAndView modelAndView = new ModelAndView("return");
        List<Book> books = findBooks.findBorrowedBooks(Integer.parseInt(pageNum));
        modelAndView.addObject("books", books);
        int count = findBooks.getBookCount("Borrowed");
        modelAndView.addObject("count", count);
        return modelAndView;
    }

    @RequestMapping(value = "/borrowAble")
    public ModelAndView borrowAblePage(@RequestParam(required = false, defaultValue = "1") String pageNum) {

        ModelAndView modelAndView = new ModelAndView("borrowAble");
        List<Book> books = findBooks.findBorrowableBooks(Integer.parseInt(pageNum));
        modelAndView.addObject("books", books);
        int count = findBooks.getBookCount("Borrowable");
        modelAndView.addObject("count", count);

        return modelAndView;
    }

}
