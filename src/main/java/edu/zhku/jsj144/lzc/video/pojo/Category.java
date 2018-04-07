package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import java.sql.Timestamp;

public class Category {

    @PathParam("id")
    private String id; // 类别id
    @FormParam("name")
    private String name; // 类别名
    @FormParam("description")
    private String description; // 类别描述
    private Timestamp datetime = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
