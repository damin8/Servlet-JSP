package favian.web.Controller;

import favian.web.Model.Book;
import favian.web.Module.BorrowBook;
import favian.web.Module.Create.CreateBook;
import favian.web.Module.ReturnBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private PageController pageController;
    @Autowired
    private ReturnBook returnBook;
    @Autowired
    private BorrowBook borrowBook;
    @Autowired
    private CreateBook createBook;

    @RequestMapping(value = "/returnBook")
    public ModelAndView returnBook(@RequestParam String id){

        boolean isit = returnBook.returnBook(Integer.parseInt(id));

        return pageController.listPage("1");
    }

    @RequestMapping(value = "/borrowBook")
    public ModelAndView borrowBook(@RequestParam String id){
        Book book = borrowBook.BorrowBook(Integer.parseInt(id));
        ModelAndView modelAndView = null;
        if(book == null){
            modelAndView = new ModelAndView("borrowFail");
            return modelAndView;
        }

        modelAndView = new ModelAndView("borrowSuccess");
        modelAndView.addObject("book",book);

        return modelAndView;
    }

    @RequestMapping(value="/createBook")
    public ModelAndView create(@RequestParam Map<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        String title = map.get("name");
        String author = map.get("author");
        int price = Integer.parseInt(map.get("price"));

        boolean isit = createBook.CreateBook(id,title,author,price);

        if(isit==true){
            return pageController.listPage("1");
        }

        ModelAndView modelAndView = new ModelAndView("addFail");
        return modelAndView;

    }
}
