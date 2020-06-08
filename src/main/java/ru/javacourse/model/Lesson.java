package ru.javacourse.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "chapter")
    private String chapter;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "resource_id")
    private Integer resourceId;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    private List<LessonTask> lessonTasks;

    @OneToMany(mappedBy = "resourceId", fetch = FetchType.EAGER)
    private List<Resource> resources;

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", chapter='" + chapter + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", resourceId=" + resourceId +
                '}';
    }

}
