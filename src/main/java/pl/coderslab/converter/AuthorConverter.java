package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;


public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        Author author = authorDao.getAuthorById(Integer.parseInt(source));
        return author;
    }

}
