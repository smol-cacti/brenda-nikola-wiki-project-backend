package com.example.wikiProject.service;
import com.example.wikiProject.dto.ArticleDTO;
import com.example.wikiProject.dto.ArticlePostRequest;
import com.example.wikiProject.dto.CategoryDto;
import com.example.wikiProject.exceptions.ArticleNotFoundException;
import com.example.wikiProject.exceptions.CategoryNotFoundException;
import com.example.wikiProject.exceptions.SpringWikiException;
import com.example.wikiProject.mapper.ArticleMapper;
import com.example.wikiProject.mapper.CategoryMapper;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import com.example.wikiProject.repository.ArticleHistoryRepository;
import com.example.wikiProject.repository.ArticleRepository;
import com.example.wikiProject.repository.CategoryRepository;
import com.example.wikiProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
@AllArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    
    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category save = categoryRepository.save(categoryMapper.mapDtoToCategory(categoryDto));
        categoryDto.setCategoryId(save.getCategoryId());
        return categoryDto;
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapCategoryToDto)
                .collect(toList());
    }

    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new SpringWikiException("No category found with ID - " + id));
        return categoryMapper.mapCategoryToDto(category);
    }


}
