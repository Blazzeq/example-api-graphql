package pl.example.springbootgraphql.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String director;
    //brak pola daty produkcji, ponieważ GraphQl nie ma typu prostego Daty, możemy stworzyć skalar, który by odwzorowywał datę

    public Movie()
    {
    }

    public Movie(String title, String director)
    {
        this.title = title;
        this.director = director;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

}
