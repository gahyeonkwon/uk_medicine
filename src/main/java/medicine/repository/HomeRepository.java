package medicine.repository;

import lombok.RequiredArgsConstructor;
import medicine.db.form.RecipeSearch;
import medicine.db.item.Recipe;
import org.springframework.stereotype.Repository;

import javax.naming.directory.SearchResult;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class HomeRepository {

    private final EntityManager em;

    public List<Recipe> findByData(RecipeSearch recipeSearch) {

        List<Recipe> recipes = em.createQuery(" select r from Recipe r where r.name = :name ", Recipe.class)
                .setParameter("name", recipeSearch.getRecipeName())
                .getResultList();


        return recipes;
    }




}
