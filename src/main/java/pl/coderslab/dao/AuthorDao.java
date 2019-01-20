package pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public String create(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        entityManager.persist(author);
        return "Created Author ID: " + author.getId();
    }

    public List<Author> read() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }

    public String update(long id, String firstName, String lastName) {
        Author author = getAuthorById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        entityManager.merge(author);
        return "Updated Author ID: " + id;
    }

    public Author getAuthorById(long id) {
        return entityManager.find(Author.class,id);
    }

    public String delete(long id) {
        entityManager.remove(getAuthorById(id));
        return "Delete Author ID: " + id;
    }
}
