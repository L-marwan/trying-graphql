package com.marouane;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {
    private final BookDao bookDao;

    public List<Book> getBooks(Author author) {
        return bookDao.getAuthorBooks(author.getId());
    }
}
