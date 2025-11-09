package application.usercases;



import com.applydigital.application.model.NewsGetResponseDTO;
import com.applydigital.application.repository.NewsRepository;
import com.applydigital.application.usecases.news.GetNewsService;
import com.applydigital.domain.model.NewsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = GetNewsService.class)
public class GetNewsServiceTest {


    @MockBean
    private NewsRepository newsRepository;

    @MockBean
    private MongoTemplate mongoTemplate;



    @Autowired
    private GetNewsService subject;


    @Test
    public void getAllNewsShouldResponse() {

        List<NewsEntity> queryResponse = List.of(NewsTestData.createFakeNewsDTO());
        Query query = new Query();
        when(mongoTemplate.find(query,NewsEntity.class)).thenReturn(queryResponse);
        List<NewsGetResponseDTO> response = subject.findNewsByComplexCriteria(null,null, null, null);
        verify(mongoTemplate, times(1)).find(query,NewsEntity.class);
        assertEquals(queryResponse.get(0).getAuthor(), response.get(0).getAuthor());
    }



    @Test
    public void getNewsByIdShouldResponse() {
        NewsEntity queryResponse = NewsTestData.createFakeNewsDTO();
        when(newsRepository.findByObjectId(queryResponse.getObjectId())).thenReturn(queryResponse);
        NewsGetResponseDTO response = subject.getNewsByObjectId(queryResponse.getObjectId());
        verify(newsRepository, times(1)).findByObjectId(any());
        assertEquals(queryResponse.getAuthor(), response.getAuthor());
    }


}
