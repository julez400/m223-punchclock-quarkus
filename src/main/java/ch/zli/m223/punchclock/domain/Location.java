package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String branchName;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return branchName;
    }

    public void setName(String branchName) {
        this.branchName = branchName;
    }
}

