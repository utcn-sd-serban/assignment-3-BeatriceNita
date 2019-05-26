package ro.utcn.sd.btn.backend.dto;

import lombok.Data;
import ro.utcn.sd.btn.backend.model.Question;
import ro.utcn.sd.btn.backend.model.Tag;
import ro.utcn.sd.btn.backend.model.User;

import java.sql.Timestamp;

@Data
public class QuestionDTO {

    private Integer id;
    //private User author;
    private String author;
    private String title;
    private Tag tag;
    //private String tag;
    private String text;
    private Timestamp creationDate;

    public static QuestionDTO ofEntity(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setAuthor(question.getAuthor().getUserName());
        questionDTO.setTitle(question.getTitle());
        questionDTO.setTag(question.getTag());
        questionDTO.setText(question.getText());
        questionDTO.setCreationDate(question.getCreationDate());
        return questionDTO;
    }
}
