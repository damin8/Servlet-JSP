package favian.web.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@Document(collection = "Books")
public class Book {
    @Id
    private int _id;
    private String title;
    private String author;
    private int price;
    private String rent = "can";
    private int rentCount = 0;

    public Book(int _id, String title, String author, int price) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
