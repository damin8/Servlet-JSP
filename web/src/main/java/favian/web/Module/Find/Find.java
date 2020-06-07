package favian.web.Module.Find;

import favian.web.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class Find {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Book> getBooks(String param, int pageNum, String sort ,Criteria criteria){
        Query query;

        if (criteria == null)
            query = new Query();
        else query = new Query(criteria);

        if(sort.equals("DESC"))
            query.with(Sort.by(Sort.Direction.DESC, param));
        else
            query.with(Sort.by(Sort.Direction.ASC, param));

        query.limit(5);
        query.skip((pageNum - 1) * 5);

        List<Book> books = this.mongoTemplate.find(query,Book.class);
        return books;
    }

}
