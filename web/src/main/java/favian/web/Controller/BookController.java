package favian.web.Controller;

import favian.web.Model.Book;
import favian.web.Module.BorrowBook;
import favian.web.Module.Create.CreateBook;
import favian.web.Module.ReturnBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        return new ModelAndView("redirect:/list");
    }

    @RequestMapping(value = "/borrowBook")
    public ModelAndView borrowBook(@RequestParam String id){
        Book book = borrowBook.BorrowBook(Integer.parseInt(id));
        ModelAndView modelAndView = null;
        if(book == null){
            return new ModelAndView("redirect:/borrowFail");
        }

        modelAndView = new ModelAndView("redirect:/borrowSuccess");
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
            return new ModelAndView("redirect:/list");
        }
        return new ModelAndView("redirect:/addFail");
    }

    @RequestMapping(value = "/addFail")
    public String addFail(){
        return "addFail";
    }

    @RequestMapping(value = "/borrowFail")
    public String borrowFail(){
        return "borrowFail";
    }

    @RequestMapping(value = "/borrowSuccess")
    public String borrowSuccess(){
        return "borrowSuccess";
    }
//
//    @RequestMapping(value = "/forTest",method = RequestMethod.POST)
//    public void test(@RequestBody Map<String,String> map){
//        int _id = Integer.parseInt(map.get("_id"));
//        String title = map.get("title");
//        String author = map.get("author");
//        int price = Integer.parseInt(map.get("price"));
//        String rent = map.get("rent");
//        int rentCount = Integer.parseInt(map.get("rentCount"));
//        Book book = new Book(_id,title,author,rent,price,rentCount);
//        System.out.println(book.toString());
//        createBook.CreateBook(book);
//    }
}
