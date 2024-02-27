package medicine.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import medicine.db.form.RecipeSearchDTO;
import medicine.db.item.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HomeRepository {

    private final EntityManager em;

    public List<Recipe> findByData(RecipeSearchDTO recipeSearch) {

        List<Recipe> recipes = em.createQuery(" select r from Recipe r where r.name = :name ", Recipe.class)
                .setParameter("name", recipeSearch.getRecipeName())
                .getResultList();


        return recipes;
    }




}
