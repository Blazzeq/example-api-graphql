package pl.example.springbootgraphql.ql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.example.springbootgraphql.dao.entity.Movie;
import pl.example.springbootgraphql.dao.service.MovieService;

import java.util.List;

@Component
public class MovieMutation implements GraphQLMutationResolver
{
    private MovieService movieService;

    public MovieMutation(MovieService movieService)
    {
        this.movieService = movieService;
    }

    public Movie createMovie(String title, String director)
    {
        return movieService.save(title, director);
    }

    public void deleteMovie(Long index)
    {
        movieService.delete(index);
    }
}
