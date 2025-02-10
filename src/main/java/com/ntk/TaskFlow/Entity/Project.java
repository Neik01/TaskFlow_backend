package com.ntk.TaskFlow.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "project")
    private List<Board> boards;

    public void addBoard(Board board){
        if (this.boards == null){
            this.boards = new ArrayList<>();
        }

        boards.add(board);
    }
}
