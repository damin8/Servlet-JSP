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
    FindBooks findBooks;

    @RequestMapping(value = "/index")
    public String root(){
        return "index";
    }

    @RequestMapping(value = "/list")
    public ModelAndView listPage(@RequestParam(required = false) String pageNum){

        if(pageNum==null){
            pageNum = "1";
        }

        ModelAndView modelAndView = new ModelAndView("list");
        List<Book> books = findBooks.findAllBooks(Integer.parseInt(pageNum));
        modelAndView.addObject("books",books);
        return modelAndView;
    }
}
