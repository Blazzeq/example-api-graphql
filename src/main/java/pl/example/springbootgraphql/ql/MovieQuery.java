package pl.example.springbootgraphql.ql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import pl.example.springbootgraphql.dao.entity.Movie;
import pl.example.springbootgraphql.dao.service.MovieService;

import java.util.List;
import java.util.Optional;

@Component
public class MovieQuery implements GraphQLQueryResolver
{
    private MovieService movieService;

    public MovieQuery(MovieService movieService)
    {
        this.movieService = movieService;
    }

    public List<Movie> getMovies(int limit)
    {
        return movieService.findAll(limit);
    }

    public Optional<Movie> getMovieById(Long index)
    {
        return movieService.findById(index);
    }
}
