package com.applydigital.application.usecases.news;

import com.applydigital.application.repository.DeletedNewsRepository;
import com.applydigital.application.repository.NewsRepository;
import com.applydigital.domain.model.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SaveFetchesNews implements ISaveFetchedNews{

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private DeletedNewsRepository deletedNewsRepository;

    @Override
    public void saveAll(List<NewsEntity> newsList) {
        newsRepository.saveAll(newsList);
    }
}
