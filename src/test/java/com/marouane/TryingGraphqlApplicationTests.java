package com.marouane;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TryingGraphqlApplicationTests {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    void getOneBook() throws Exception {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("query.graphql");
        assertThat(graphQLResponse.isOk()).isTrue();
        assertThat(graphQLResponse.getRaw("$.data.recentBooks.[:0].id")).isNotNull();
    }

}
