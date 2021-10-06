package com.memer.memeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class MemeController {

    @Autowired
    MemeRepository memeRepository;

    @GetMapping("/all-memes")
    public ResponseEntity<Meme> allMemes(@RequestParam(required = false) String name) {
        return new ResponseEntity(memeRepository.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/meme")
    public ResponseEntity<Meme> meme(@RequestParam(value = "id") String id) {
        System.out.println(id);
        Optional<Meme> meme = memeRepository.findById(id);


        return new ResponseEntity<>(meme.get(), HttpStatus.FOUND);
    }

    @PostMapping("/all-memes")
    public ResponseEntity<Meme> addMeme(@RequestBody Meme meme) {
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
            LocalDateTime now = LocalDateTime.now();

            Meme addMeme = memeRepository.save(new Meme(meme.getMeme_name(), meme.getMeme_url(), new DateTime(now.format(dateFormatter), now.format(timeFormatter))));
            return new ResponseEntity(addMeme, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
