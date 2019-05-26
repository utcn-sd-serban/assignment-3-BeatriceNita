package ro.utcn.sd.btn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    private Integer id;
    private String name;

    public Tag(String name){
        this.name = name;
    }

    public Tag(int id){
        this.id = id;
    }
}
