package com.marouane;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final BookDao bookDao;

    public List<Book> getRecentBooks(int counrt, int offset) {
        return bookDao.getRecentBooks(counrt, offset);
    }
}
