package favian.web.Module;

import favian.web.Model.Book;
import favian.web.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReturnBook {
    @Autowired
    BookRepository bookRepository;

    public boolean returnBook(int id){

        if (bookRepository.countBy_id(id) == 0)
            return false;

        Book book = bookRepository.findBy_id(id);
        book.setRent("Yes");
        bookRepository.save(book);
        return true;
    }
}
