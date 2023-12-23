package medicine.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.RecipeSpec;
import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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
}
