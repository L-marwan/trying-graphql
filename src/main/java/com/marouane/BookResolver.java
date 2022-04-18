package com.marouane;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorDao authorDao;

    public Author getAuthor(Book book) {
        return authorDao.getAuthor(book.getAuthorId()).orElseThrow(RuntimeException::new);
    }
}
