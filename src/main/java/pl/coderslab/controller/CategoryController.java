package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

//    @Autowired
//    Validator validator;

    private CategoryDao categoryDao;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryDao categoryDao, CategoryRepository categoryRepository) {
        this.categoryDao = categoryDao;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
//        model.addAttribute("categories", categoryDao.read());
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/add")
    public String addGet(@ModelAttribute Category category) {
        return "addCategory";
    }

    @PostMapping("/add")
    public String addPost(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "addCategory";
        }
//        categoryDao.create(category.getName(), category.getDescription());
        categoryRepository.save(category);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable long id, Model model) {
//        Category category = categoryDao.getCategoryById(id);
        Category category = categoryRepository.findOne(id);
        model.addAttribute("category", category);
        return "addCategory";
    }

    @PostMapping("/edit/**")
    public String editPost(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "addCategory";
        }
//        categoryDao.update(category.getId(),category.getName(),category.getDescription());
        categoryRepository.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
//        categoryDao.delete(id);
        categoryRepository.delete(id);
        return "redirect:/category/all";
    }

}
