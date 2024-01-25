package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        Author searchAuthor = authorRepository.getAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName());

        if (searchAuthor == null) {
            return this.authorRepository.save(author);
        } else {
            return searchAuthor;
        }
    }

    public Optional<Author> getOneAuthor(Long id) {
        return this.authorRepository.findById(id);
    }

    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }
}
