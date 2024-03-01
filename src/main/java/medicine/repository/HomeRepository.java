package medicine.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import medicine.db.form.RecipeSearchDTO;
import medicine.db.item.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;

import static medicine.db.item.QRecipe.recipe;

@Repository
@RequiredArgsConstructor
public class HomeRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Recipe> findByData(RecipeSearchDTO recipeSearch) {

//        List<Recipe> recipes = em.createQuery(" select r from Recipe r where r.name = :name ", Recipe.class)
//                .setParameter("name", recipeSearch.getRecipeName())
//                .getResultList();

      // querydsl 로 변경
      return jpaQueryFactory.selectFrom(recipe)
                    .where(recipe.name.eq(recipeSearch.getRecipeName()))
                    .fetch();

    }




}
