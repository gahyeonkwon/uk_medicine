package medicine.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.RecipeSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class RecipeSpecRepository {

    private final EntityManager em;


    public List<RecipeSpec> findAll() {

        String query = "select rs from RecipeSpec rs join fetch rs.recipe" +
                "  join fetch rs.material";

        return em.createQuery( query
                , RecipeSpec.class).getResultList();
    }

    public List<RecipeSpec> findById(Long recipeId) {

        String query = "select rs from RecipeSpec rs join fetch rs.recipe" +
                "  join fetch rs.material where rs.recipe.id = :recipeId " ;

        return em.createQuery( query
                , RecipeSpec.class)
                .setParameter("recipeId", recipeId)
                .getResultList();
    }

}
