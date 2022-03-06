package ls.hvacaretaker.category;

import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.producent.ProducentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryEntity(Long id) {
        Optional<Category> categoryFound = categoryRepository.findById(id);
        return categoryFound.orElseThrow(CategoryNotFoundException::new);
    }
}
