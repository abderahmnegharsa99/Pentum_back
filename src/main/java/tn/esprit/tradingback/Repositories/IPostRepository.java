package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tradingback.Entities.Post;

import java.time.OffsetDateTime;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long> {
    @Query("select count(p) from Post p")
    Long countPosts();

    @Query("select count(p)from Post p where p.title=:titre")
    Long countPostsByTitle(@Param("titre") String title);


}