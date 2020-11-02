package com.github.line.schedulereadonlyapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.line.schedulereadonlyapi.enums.ClassType;

import javax.persistence.*;

@Entity
@Table(name = "class_details", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class ClassDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_object_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private ClassObject classObject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Lecturer lecturer;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ClassType type;

    @Embedded
    private ClassPeriod classPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grouped_daily_schedule_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private GroupedDailySchedule groupedDailySchedule;

    public ClassDetails() {}

    public ClassDetails(Long id, ClassObject classObject, Lecturer lecturer, ClassType type, ClassPeriod classPeriod, GroupedDailySchedule groupedDailySchedule) {
        this.id = id;
        this.classObject = classObject;
        this.lecturer = lecturer;
        this.type = type;
        this.classPeriod = classPeriod;
        this.groupedDailySchedule = groupedDailySchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassObject getClassObject() {
        return classObject;
    }

    public void setClassObject(ClassObject classObject) {
        this.classObject = classObject;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public ClassType getType() {
        return type;
    }

    public void setType(ClassType type) {
        this.type = type;
    }

    public ClassPeriod getClassPeriod() {
        return classPeriod;
    }

    public void setClassPeriod(ClassPeriod classPeriod) {
        this.classPeriod = classPeriod;
    }

    public GroupedDailySchedule getGroupedDailySchedule() {
        return groupedDailySchedule;
    }

    public void setGroupedDailySchedule(GroupedDailySchedule groupedDailySchedule) {
        this.groupedDailySchedule = groupedDailySchedule;
    }

    @Override
    public String toString() {
        return "ClassDetails{" +
                "id=" + id +
                ", classObject.name='" + this.classObject.getName() + '\'' +
                ", lecturer.surname='" + this.lecturer.getSurname() + '\'' +
                ", classType='" + this.type.toString() + '\'' +
                ", classPeriod='" + this.classPeriod.getStartTime().toString() + "-" + classPeriod.getEndTime().toString() + '\'' +
                ", group='" + this.groupedDailySchedule.getGroupId() + '\'' +
                ", date='" + this.groupedDailySchedule.getDate() + '\'' +
                '}';
    }
}