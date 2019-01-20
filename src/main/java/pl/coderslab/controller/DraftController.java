package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import pl.coderslab.validator.DraftsValidationGroup;

import java.util.List;

@RequestMapping("/draft")
@Controller
public class DraftController {

    private ArticleDao articleDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DraftController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao, ArticleRepository articleRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
//        model.addAttribute("articles", articleDao.getDrafts());
        model.addAttribute("articles", articleRepository.getDrafts());
        return "drafts";
    }

    @GetMapping("/add")
    public String addGet(@ModelAttribute Article article) {
        return "addDraft";
    }

    @PostMapping("/add")
    public String addPost(@Validated(DraftsValidationGroup.class) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addDraft";
        }
//        articleDao.create(
//                article.getTitle(),
//                article.getAuthor(),
//                article.getContent(),
//                article.getCategories(),
//                true);
        article.setDraft(true);
        articleRepository.save(article);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable long id, Model model) {
//        Article article = articleDao.getArticleById(id);
        Article article = articleRepository.findOne(id);
        model.addAttribute("article", article);
        return "addDraft";
    }

    @PostMapping("/edit/**")
    public String editPost(@Validated({DraftsValidationGroup.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "addDraft";
        }
//        articleDao.update(
//                article.getId(),
//                article.getTitle(),
//                article.getAuthor(),
//                article.getContent(),
//                article.getCategories(),
//                true);
        article.setDraft(true);
        articleRepository.save(article);
        return "redirect:/draft/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
//        articleDao.delete(id);
        articleRepository.delete(id);
        return "redirect:/draft/all";
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
