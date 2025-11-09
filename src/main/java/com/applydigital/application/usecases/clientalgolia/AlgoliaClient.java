package com.applydigital.application.usecases.clientalgolia;

import com.applydigital.domain.model.NewsEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public class AlgoliaClient implements  IAlgoliaClient{
    @Override
    public Mono<List<NewsEntity>> fetchData() {
        return null;
    }
}
