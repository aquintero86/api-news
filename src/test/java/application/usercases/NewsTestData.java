package application.usercases;


import com.applydigital.application.model.NewsGetResponseDTO;
import com.applydigital.domain.model.NewsEntity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class NewsTestData {

    public static NewsEntity createFakeNewsDTO() {
        return new NewsEntity(
                "obj-12345",
                "Andrew Doe",
                "This is a sample comment about new tech trends.",
                "Tech Stack  in 2025",
                "https://example.com/tech-stack-2025",
                List.of( "Technology", "Innovation"),
                LocalDateTime.of(2025, 10, 29, 10, 30),
                LocalDateTime.of(2025, 10, 29, 11, 15),
                1001L,
                5005L
        );
    }

    public static NewsGetResponseDTO createFakeNewsGetResponseDTO() {
        NewsEntity field = createFakeNewsDTO();
        return new  NewsGetResponseDTO(
                field.getAuthor(),
                field.getCommentText(),
                field.getStoryTitle(),
                field.getStoryUrl(),
                field.getTags(),
                field.getCreatedAt(),
                field.getObjectId());
    }



}
