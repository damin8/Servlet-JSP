package favian.web.Module;

import favian.web.Model.Book;
import favian.web.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowBook {
    @Autowired
    BookRepository bookRepository;

    public Book BorrowBook(int id){

        if (bookRepository.countBy_id(id) == 0)
            return null;

        Book book = bookRepository.findBy_id(id);

        if(book.getRent().equals("No"))
            return null;

        book.setRent("No");
        int rentCount = book.getRentCount() + 1;
        book.setRentCount(rentCount);

        return bookRepository.save(book);
    }
}
