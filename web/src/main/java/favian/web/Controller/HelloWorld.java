package favian.web.Controller;

import favian.web.Model.Book;
import favian.web.Module.Create.CreateBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HelloWorld {
    @Autowired
    CreateBook createBook;

    //@RequestMapping(value = "/index")
    public String root(){
        return "index";
    }

    /*@RequestMapping(value="/find")
    public ModelAndView findAllBooks(){
        ModelAndView mav = new ModelAndView("Helloworld");
        List<Book> books = findAllBooks.findAllBooks();
        mav.addObject("books",books);
        return mav;
    }*/

    //@RequestMapping(value="/hello")
    public String helloworld(){
        return "Helloworld";
    }

    /*@RequestMapping(value="/create")
    public ModelAndView create(@RequestParam Map<String, String> map){
        ModelAndView mav = new ModelAndView("list");
        int id = Integer.parseInt(map.get("id"));
        String title = map.get("title");
        String author = map.get("author");
        int price = Integer.parseInt(map.get("price"));
        String message = createBook.CreateBook(id,title,author,price);
        mav.addObject("message",message);
        return mav;
    }*/
}
