package medicine.repository;

import lombok.RequiredArgsConstructor;
import medicine.db.item.Material;
import medicine.db.item.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {
    private final EntityManager em;

    public List<Recipe> findAll() {
        return em.createQuery("select i from Recipe i", Recipe.class).getResultList();
    }

}

