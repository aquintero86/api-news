package com.applydigital.application.scheduler;

import com.applydigital.application.usecases.clientalgolia.IAlgoliaClient;
import com.applydigital.application.usecases.news.ISaveFetchedNews;
import com.applydigital.domain.model.NewsEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.List;

public class NewsScheduler {
    @Autowired
    private IAlgoliaClient algoliaClient;

    @Autowired
    private ISaveFetchedNews saveFetchedNews;

    @PostConstruct
    //@Scheduled(fixedRate = 3600000) // 1 hour
    public void fetchLatestNews() {
        Mono<List<NewsEntity>> monoNews = algoliaClient.fetchData();
        List<NewsEntity> result = monoNews.block();
        saveFetchedNews.saveAll(result);
    }
}
