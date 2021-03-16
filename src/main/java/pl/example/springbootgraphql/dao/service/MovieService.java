package pl.example.springbootgraphql.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.example.springbootgraphql.dao.MovieRepo;
import pl.example.springbootgraphql.dao.entity.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService
{
    private MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo)
    {
        this.movieRepo = movieRepo;
    }

    public Optional<Movie> findById(Long id)
    {
        return movieRepo.findById(id);
    }

    public List<Movie> findAll(int limit)
    {
        return movieRepo.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    public Movie save(String title, String director)
    {
        return movieRepo.save(new Movie(title, director));
    }

    public void delete(Long id)
    {
        movieRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB()
    {
        movieRepo.save(new Movie("Avengers: Endgame", "Anthony Russo"));
        movieRepo.save(new Movie("The Godfather", "Francis Ford Coppola"));
        movieRepo.save(new Movie("Joker", "Todd Phillips"));
        movieRepo.save(new Movie("Se7en", "David Fincher"));
        movieRepo.save(new Movie("Goodfellas", "Martin Scorsese"));
    }
}
