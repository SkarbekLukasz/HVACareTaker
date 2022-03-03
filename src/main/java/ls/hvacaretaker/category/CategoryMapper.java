package ls.hvacaretaker.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryDto toDto(Category category) {
        CategoryDto categoryToDto = new CategoryDto();
        categoryToDto.setId(category.getId());
        categoryToDto.setName(category.getName());
        categoryToDto.setDescription(category.getDescription());
        return categoryToDto;
    }
}
