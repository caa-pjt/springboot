package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return this.authorService.createAuthor(author);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public Author getOneAuthor(@PathVariable Long id) {
        Optional<Author> author = this.authorService.getOneAuthor(id);

        if (author.isPresent()) {
            return author.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public List<Author> Authors() {
        return this.authorService.getAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id) {
        this.authorService.deleteAuthor(id);
    }
}
