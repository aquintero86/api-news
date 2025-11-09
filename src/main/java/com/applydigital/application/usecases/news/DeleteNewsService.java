package com.applydigital.application.usecases.news;


import com.applydigital.application.repository.DeletedNewsRepository;
import com.applydigital.application.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteNewsService implements IDeleteNewsService{

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private DeletedNewsRepository blacklistRepository;


    @Override
    public void deleteNewsById(String objectId) {

    }
}
