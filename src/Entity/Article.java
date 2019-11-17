package Entity;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Article {

    private String id;
    private String user_id;
    private String article;
    private String title;
    private Timestamp update_time;
    private Time update_time1;
    private Integer visited;




}
