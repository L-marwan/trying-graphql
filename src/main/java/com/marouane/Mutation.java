package com.marouane;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private final BookDao bookDao;

    public Book writeBook(String name, String pageCount, String author) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setPageCount(pageCount);
        book.setName(name);
        book.setAuthorId(author);

        bookDao.saveBook(book);
        return book;
    }


}
