package ls.hvacaretaker.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Klasa warstwy usług dla typu Category
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Konstruktor klasy CategoryService
     *
     * @param categoryRepository używany do wstrzyknięcia zależnosci typu CategoryRepository
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Wyszukuje wszystkie obiekty typu Category w bazie danych.
     *
     * @return zwraca wszystkie kategorie w formie listy.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Wyszukuje w bazie danych encję typu Category o wskazanym id.
     *
     * @param id encji w bazie danych.
     * @return zwraca encję typu Category.
     * @throws CategoryNotFoundException w przypadku nie odnalezienia encji w bazie danych.
     */
    public Category getCategoryEntity(Long id) throws CategoryNotFoundException {
        Optional<Category> categoryFound = categoryRepository.findById(id);
        return categoryFound.orElseThrow(CategoryNotFoundException::new);
    }
}
