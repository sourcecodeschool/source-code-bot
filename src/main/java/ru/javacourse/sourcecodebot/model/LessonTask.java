package ru.javacourse.sourcecodebot.model;


import javax.persistence.*;
//
//@Entity
//@Table(name = "lesson_task")
public class LessonTask {

    @Id
    @Column(name = "lt_id")
    private Integer ltId;


    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Integer getLtId() {
        return ltId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setLtId(Integer ltId) {
        this.ltId = ltId;
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

    @Override
    public String toString() {
        return "LessonTask{" +
                "ltId=" + ltId +
                ", lesson=" + lesson +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
