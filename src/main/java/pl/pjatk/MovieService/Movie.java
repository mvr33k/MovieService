package pl.pjatk.MovieService;

import jakarta.persistence.*;

@Entity
public class Movie {

//    public Movie(String category, String title) {
//        this.id=nextID++;
//        this.category=category;
//        this.title=title;
//    }
//    public Movie() {
//    }

//    private static Integer nextID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private boolean isAvailable;
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



    public Integer getId() {
        return id;
    }



//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
