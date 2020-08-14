package com.project.medium.controllers;

import com.project.medium.model.Album;
import com.project.medium.model.Blog;
import com.project.medium.model.auth.Account;
import com.project.medium.model.auth.Role;
import com.project.medium.repository.AlbumRepository;
import com.project.medium.services.Album.AlbumService;
import com.project.medium.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("api/album/")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping(value = "/privateAlbum/{accountId}")
    public List<Album> postByAccount(@PathVariable Long accountId){
        return albumService.findByAccountId(accountId);
    }

    @PostMapping(value = "/privateAlbum/create")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album, UriComponentsBuilder builder){
        albumService.save(album);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{accountId}")
        .buildAndExpand(album.getId()).toUri());
        return new ResponseEntity<>(album,HttpStatus.CREATED);
    }














}
