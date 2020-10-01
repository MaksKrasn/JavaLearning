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
    private String taskName;
    private String description;
    private String isActual;
    private String beginData;
    private String endData;
    private String isCompleted;
    private String taskAuthor;
}
