package com.applydigital.application.repository;


import com.applydigital.domain.model.NewsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface NewsRepository extends MongoRepository<NewsEntity, String> {

    NewsEntity findByObjectId(String objectID);

}
