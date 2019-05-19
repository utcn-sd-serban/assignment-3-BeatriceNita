package ro.utcn.sd.btn.assig1.dto;


import lombok.Data;
import org.springframework.util.CollectionUtils;
import ro.utcn.sd.btn.assig1.model.Question;
import ro.utcn.sd.btn.assig1.model.Tag;
import ro.utcn.sd.btn.assig1.model.User;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@Data
public class QuestionDTO {

    private Integer id;
    private User author;
    private String title;
    private Tag tag;
    private String text;
    private String creationDate;

    public static QuestionDTO ofEntity(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setAuthor(question.getAuthor());
        questionDTO.setTitle(question.getTitle());
        //questionDTO.setTag(question.getTag());
        questionDTO.setText(question.getText());
        questionDTO.setCreationDate(question.getCreationDate());
        /*if (!CollectionUtils.isEmpty(question.getGrades())) {
            studentDTO.setGrades(question.getGrades().stream()
                    .map(Grade::getScore)
                    .collect(Collectors.toList()));
        }*/
        return questionDTO;
    }
}

