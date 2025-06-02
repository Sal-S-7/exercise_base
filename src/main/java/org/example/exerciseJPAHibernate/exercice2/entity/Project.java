package org.example.exerciseJPAHibernate.exercice2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String projectName;
        private String description;

        @ManyToMany
        @JoinTable(name = "computer_project",
                joinColumns = @JoinColumn(name = "project_id"),
                inverseJoinColumns = @JoinColumn(name = "computer_id"))
        private List<Computer> computers = new ArrayList<>();


        public void addComputer(Computer computer) {
                computers.add(computer);
                computer.getProjects().add(this);
        }

        public void removeComputer(Computer computer) {
                computers.remove(computer);
                computer.getProjects().remove(this);
        }

        public List<Computer> getAllComputers() {
                return computers;
        }
}
