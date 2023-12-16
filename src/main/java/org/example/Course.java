package org.example;


import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String titleCourse;

    @Column(name = "duration")
    private String durationCourse;

    //endregion

    //region Constructors
    public Course(String titleCourse, String durationCourse) {
        this.titleCourse = titleCourse;
        this.durationCourse = durationCourse;
    }

    public Course(){};

    //endregion

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitleCourse() {
        return titleCourse;
    }

    public String getDurationCourse() {
        return durationCourse;
    }

    public void setTitleCourse(String titleCourse) {
        this.titleCourse = titleCourse;
    }

    public void setDurationCourse(String durationCourse) {
        this.durationCourse = durationCourse;
    }

    //endregion

    //region Methods

    @Override
    public String toString() {
        return "Номер курса: " + id +
                " Название курса: " + titleCourse +
                " Продолжительность курса: " + durationCourse;
    }

    //endregion
}
