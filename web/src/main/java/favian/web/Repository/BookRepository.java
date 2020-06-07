package favian.web.Repository;

import favian.web.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    int countBy_id(int id);

    Book findBy_id(int id);
}
