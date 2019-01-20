package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {


    private ArticleDao articleDao;
    private CategoryDao categoryDao;
    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public HomePageController(ArticleDao articleDao, CategoryDao categoryDao, CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }


    @RequestMapping("/home")
    public String home(Model model) {
//        List<Article> articles = articleDao.getNewestArticles(5);
        List<Article> articles = articleRepository.findFirstXOrderByUpdated(5);
        model.addAttribute("articles", articles);
//        List<Category> categories = categoryDao.read();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable long id, Model model) {
//        model.addAttribute("category", categoryDao.getCategoryById(id));
        model.addAttribute("category", categoryRepository.findOne(id));
        List<Article> articles = new ArrayList<>();
//        for (Article article : articleDao.read()) {
        for (Article article : articleRepository.findAll()) {
            for (Category category : article.getCategories()) {
                if (category.getId() == id) {
                    articles.add(article);
                }
            }
        }
        model.addAttribute("articles", articles);
        return "category";
    }
}
