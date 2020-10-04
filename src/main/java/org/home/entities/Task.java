package org.home.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "description")
    private String description;
    @Column(name = "is_actual")
    private String isActual;
    @Column(name = "begin_data")
    private String beginData;
    @Column(name = "end_data")
    private String endData;
    @Column(name = "is_completed")
    private String isCompleted;
    @Column(name = "task_author")
    private String taskAuthor;

}
