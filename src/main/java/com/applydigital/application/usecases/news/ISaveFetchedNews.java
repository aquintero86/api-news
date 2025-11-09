package com.applydigital.application.usecases.news;

import com.applydigital.domain.model.NewsEntity;

import java.util.List;

public interface ISaveFetchedNews {
    public void saveAll(List<NewsEntity> newsList);
}
