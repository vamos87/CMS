package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM Article a WHERE a.draft = false ORDER BY a.updated DESC LIMIT ?1",
            nativeQuery = true)
    List<Article> findFirstXOrderByUpdated(int quantity);

    @Query("SELECT a FROM Article a WHERE a.draft = true")
    List<Article> getDrafts();

    @Query("SELECT a FROM Article a WHERE a.draft = false")
    List<Article> getArticles();
}
