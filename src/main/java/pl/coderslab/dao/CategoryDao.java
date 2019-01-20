package pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public String create(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        entityManager.persist(category);
        return "Created Category ID: " + category.getId();
    }

    public List<Category> read() {
        return entityManager.createQuery("SELECT a FROM Category a").getResultList();
    }

    public String update(long id, String name, String description) {
        Category category = getCategoryById(id);
        category.setName(name);
        category.setDescription(description);
        entityManager.merge(category);
        return "Updated Category ID: " + id;
    }

    public Category getCategoryById(long id) {
        return entityManager.find(Category.class,id);
    }

    public String delete(long id) {
        entityManager.remove(getCategoryById(id));
        return "Delete Category ID: " + id;
    }
}
