package favian.web.Module.Find;

import favian.web.Model.Book;
import favian.web.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindBooks extends Find {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks(int pageNum) {
        return getBooks("_id", pageNum,"ASC", null);
    }

    public List<Book> findAllBooksByRentCount(int pageNum) {
        return getBooks("rentCount", pageNum,"DESC", null);
    }

    public List<Book> findBorrowableBooks(int pageNum) {
        Criteria criteria = new Criteria("rent");
        criteria.is("Yes");
        return getBooks("_id", pageNum,"ASC", criteria);
    }

    public List<Book> findBorrowedBooks(int pageNum) {
        Criteria criteria = new Criteria("rent");
        criteria.is("No");
        return getBooks("_id", pageNum,"ASC", criteria);
    }

    public Book findBookById(int id){

        if(bookRepository.countBy_id(id)==0)
            return null;

        return bookRepository.findBy_id(id);
    }
}
