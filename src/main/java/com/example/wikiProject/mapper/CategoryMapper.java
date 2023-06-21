package com.example.wikiProject.mapper;
import com.example.wikiProject.dto.ArticleDTO;
import com.example.wikiProject.dto.ArticlePostRequest;
import com.example.wikiProject.dto.CategoryDto;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.ArticleHistory;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import com.example.wikiProject.repository.ArticleHistoryRepository;
import com.example.wikiProject.repository.CategoryRepository;
import com.example.wikiProject.service.AuthService;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //@Mapping(target = "numberOfArticles", expression = "java(mapArticles(Category.getArticles()))")
    CategoryDto mapCategoryToDto(Category category);

    default Integer mapArticles(List<Article> articles) {
        return articles.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "articles", ignore = true)
    Category mapDtoToCategory(CategoryDto categoryDto);

}
