package pl.coderslab.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.DraftsValidationGroup;
import pl.coderslab.validator.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    @NotBlank(groups = {DraftsValidationGroup.class, Default.class})
    @Size(max = 200, groups = {DraftsValidationGroup.class, Default.class})
    private String title;

    @ManyToOne
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(groups = Default.class)
    @Length(value = 2, groups = Default.class)
    private List<Category> categories = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    @NotBlank(groups = {DraftsValidationGroup.class, Default.class})
    @Size(min = 50, max = 10000, groups = Default.class)
    private String content;

    @Column
    private LocalDate created;

    @Column
    private LocalDate updated;

    @Column
    private boolean draft;

    public Article() {
    }

    public Article(String title, Author author, List<Category> categories, String content, LocalDate created, LocalDate updated, boolean draft) {
        this.title = title;
        this.author = author;
        this.categories = categories;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.draft = draft;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
