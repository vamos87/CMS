package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorDao authorDao;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
//        model.addAttribute("authors", authorDao.read());
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @GetMapping("/add")
    public String addGet(@ModelAttribute Author author) {
        return "addAuthor";
    }

    @PostMapping("/add")
    public String addPost(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
//        authorDao.create(author.getFirstName(), author.getLastName());
        authorRepository.save(author);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable long id, Model model) {
//        Author author = authorDao.getAuthorById(id);
        Author author = authorRepository.findOne(id);
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @PostMapping("/edit/**")
    public String editPost(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
//        authorDao.update(author.getId(),author.getFirstName(),author.getLastName());
        authorRepository.save(author);
        return "redirect:/author/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
//        authorDao.delete(id);
        authorRepository.delete(id);
        return "redirect:/author/all";
    }

}
