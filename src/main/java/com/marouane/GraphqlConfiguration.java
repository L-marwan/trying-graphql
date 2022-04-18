package com.marouane;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public BookDao bookDao() {
        List<Book> books = new ArrayList<>();
        for (int bookId = 0; bookId < 10; ++bookId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Book book = new Book();
                book.setId("Book" + authorId + bookId);
                book.setName("Book " + authorId + ":" + bookId);
                book.setPageCount(new Random().nextInt(400) + "");
                book.setAuthorId("Author" + authorId);
                books.add(book);
            }
        }
        return new BookDao(books);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setFirstName("Author " + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public BookResolver postResolver(AuthorDao authorDao) {
        return new BookResolver(authorDao);
    }

    @Bean
    public AuthorResolver authorResolver(BookDao bookDao) {
        return new AuthorResolver(bookDao);
    }

    @Bean
    public Query query(BookDao bookDao) {
        return new Query(bookDao);
    }

    @Bean
    public Mutation mutation(BookDao bookDao) {
        return new Mutation(bookDao);
    }
}