package io.dwzrd.example.domain;


import org.hibernate.validator.constraints.Length;

public class Saying {

    private long id;

    @Length(max = 10)
    private String content;

    public Saying() {
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

}
