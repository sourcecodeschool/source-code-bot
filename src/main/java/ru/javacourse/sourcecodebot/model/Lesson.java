package ru.javacourse.sourcecodebot.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "chapter")
    private String chapter;

    @Column(name = "chapter_id")
    private String chapterId;

    @OneToMany(mappedBy = "lesson")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LessonTask> lessonTasks;

    @OneToOne
    @JoinColumn(name="resource_id")
    private Resource resources;

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

    public String getChapter_id() { return chapterId; }

    public Resource getResources() {
        return resources;
    }

    public void setResources(Resource resources) {
        this.resources = resources;
    }

    public void setChapter_id(String chapter_id) { this.chapterId = chapter_id; }
    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", chapter='" + chapter + '\'' +
                ", chapter_id='" + chapterId +
                '}';
    }

}
