package ls.hvacaretaker.category;

import org.springframework.stereotype.Service;

/**
 * Klasa mapująca encje Category do obiektów DTO i z obiektów DTO do encji.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class CategoryMapper {

    /**
     * Metoda przyjmująca obiekt typu Category i mapująca go do obiektu DTO typu Category
     *
     * @param category obiekt typu Category podlegający zamianie na obiekt DTO.
     * @return obiektu typu CategoryDto
     */
    public CategoryDto toDto(Category category) {
        CategoryDto categoryToDto = new CategoryDto();
        categoryToDto.setId(category.getId());
        categoryToDto.setName(category.getName());
        categoryToDto.setDescription(category.getDescription());
        return categoryToDto;
    }
}
