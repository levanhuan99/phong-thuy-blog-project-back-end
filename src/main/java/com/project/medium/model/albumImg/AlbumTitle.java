package com.project.medium.model.albumImg;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class AlbumTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean status;
    private Date postTime = Timestamp.valueOf(LocalDateTime.now());
    @ManyToOne()
    private Account account;
    @OneToMany()
    private List<Image> images;
}