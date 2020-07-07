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

    @OneToMany(mappedBy = "lesson")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LessonTask> lessonTasks;

    @OneToOne
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

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", chapter='" + chapter + '\'' +
                '}';
    }

}
