package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleDao articleDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;


    @Autowired
    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao, ArticleRepository articleRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
//        model.addAttribute("articles", articleDao.read());
        model.addAttribute("articles", articleRepository.getArticles());
        return "articles";
    }

    @GetMapping("/add")
    public String addGet(@ModelAttribute Article article) {
        return "addArticle";
    }

    @PostMapping("/add")
    public String addPost(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addArticle";
        }
//        articleDao.create(
//                article.getTitle(),
//                article.getAuthor(),
//                article.getContent(),
//                article.getCategories(),
//                false);
        article.setCreated(LocalDate.now());
        article.setUpdated(LocalDate.now());
        article.setDraft(false);
        articleRepository.save(article);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable long id, Model model) {
//        Article article = articleDao.getArticleById(id);
        Article article = articleRepository.findOne(id);
        model.addAttribute("article", article);
        return "addArticle";
    }

    @PostMapping("/edit/**")
    public String editPost(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addArticle";
        }
//        articleDao.update(
//                article.getId(),
//                article.getTitle(),
//                article.getAuthor(),
//                article.getContent(),
//                article.getCategories(),
//                false);
        article.getCreated();
        article.setUpdated(LocalDate.now());
        article.setDraft(false);
        articleRepository.save(article);
        return "redirect:/article/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
//        articleDao.delete(id);
        articleRepository.delete(id);
        return "redirect:/article/all";
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
//        return authorDao.read();
        return authorRepository.findAll();
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
//        return categoryDao.read();
        return categoryRepository.findAll();
    }

}
