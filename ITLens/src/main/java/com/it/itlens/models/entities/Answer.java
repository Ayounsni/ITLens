package com.it.itlens.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    private Integer selectionCount = 0;

    @ManyToOne
    private Question question;

    public void incrementSelectionCount() {
        this.selectionCount++;
    }
}

