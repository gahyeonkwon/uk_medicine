package medicine.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import medicine.db.item.Recipe;
import medicine.db.item.RecipeSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {
    private final EntityManager em;

    public List<Recipe> findAll() {

        return em.createQuery("select i from Recipe i", Recipe.class).getResultList();

    }

    public Long saveRecipe(Recipe recipe) {
        em.persist(recipe);
        return recipe.getId();
    }

    public void saveMaterials(RecipeSpec recipeSpec) {
        em.persist(recipeSpec);
    }
}

