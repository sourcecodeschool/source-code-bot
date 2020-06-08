package ru.javacourse.model;


import javassist.bytecode.ByteArray;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @Column(name="exercise_id")
    private Integer exercise_id;

    @Column(name = "technology")
    private String technology;

    @Column(name = "tag")
    private String tag;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    private byte[] file;

    @Column(name = "complexity")
    private Integer complexity;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "solution")
    private String solution;

    @Override
    public String toString() {
        return "Exercise{" +
                "exercise_id=" + exercise_id +
                ", technology='" + technology + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", file=" + file +
                ", complexity=" + complexity +
                ", rating=" + rating +
                ", solution='" + solution + '\'' +
                '}';
    }

}
