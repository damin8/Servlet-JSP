package favian.web.Module.Create;

import favian.web.Model.Book;
import favian.web.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBook {
    @Autowired
    BookRepository bookRepository;

    public boolean CreateBook(int id, String title, String author, int price){
        if (bookRepository.countBy_id(id) != 0)
            return false;

        Book book = new Book(id,title,author,price);
        bookRepository.save(book);

        return true;
    }

    public void CreateBook(Book book){
        bookRepository.save(book);
    }
}
