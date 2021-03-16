package pl.example.springbootgraphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.example.springbootgraphql.dao.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>
{
}
