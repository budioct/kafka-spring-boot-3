package budhioct.dev.kafka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

    private int id;
    private String author;
    private String title;
    private String category;
    private String year;

}
