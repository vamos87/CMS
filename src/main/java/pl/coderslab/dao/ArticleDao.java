package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Component
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public String create(String title, Author author, String content, List<Category> categories, boolean draft) {
        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        article.setCategories(categories);
        article.setCreated(LocalDate.now());
        article.setUpdated(LocalDate.now());
        article.setDraft(draft);
        entityManager.persist(article);
        return "Created Article ID: " + article.getId();
    }

    public List<Article> read() {
        return entityManager
                .createQuery("SELECT a FROM Article a WHERE a.draft = false")
                .getResultList();
    }

    public List<Article> getDrafts() {
        return entityManager
                .createQuery("SELECT a FROM Article a WHERE a.draft = true")
                .getResultList();
    }

    public String update(long id, String title, Author author, String content, List<Category> categories, boolean draft) {
        Article article = getArticleById(id);
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        article.setCategories(categories);
        article.setUpdated(LocalDate.now());
        article.setDraft(draft);
        entityManager.merge(article);
        return "Updated Article ID: " + id;
    }

    public Article getArticleById(long id) {
        return entityManager.find(Article.class,id);
    }

    public List<Article> getNewestArticles(int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Article a WHERE a.draft = false or a.draft is null ORDER BY a.created DESC")
                .setMaxResults(quantity)
                .getResultList();
    }

//    public List<Article> getArticlesByCategoryId(long id) {
//        return entityManager
//                .createQuery("SELECT a FROM Article a WHERE a.categories.category_id = :id")
//                .setParameter("id", id)
//                .getResultList();
//    }


    public String delete(long id) {
        entityManager.remove(getArticleById(id));
        return "Delete Article ID: " + id;
    }
}
