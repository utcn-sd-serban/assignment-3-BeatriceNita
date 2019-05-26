package ro.utcn.sd.btn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private Integer id;
    private User author;
    private String title;
    private String text;
    private Tag tag;
    private Timestamp creationDate;

    public Question(User author, Timestamp creationDate, String title, Tag tag, String text){
        this.author = author;
        this.creationDate = creationDate;
        this.title = title;
        this.tag = tag;
        this.text = text;
    }

    public Question(User author, String title, String text){
        this.author = author;
        this.title = title;
        this.text = text;
    }

}
