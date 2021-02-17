package study.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

public class HelloDto {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
