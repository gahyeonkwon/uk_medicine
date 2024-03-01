package medicine.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.RecipeSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

import static medicine.db.item.QMaterial.material;
import static medicine.db.item.QRecipe.recipe;
import static medicine.db.item.QRecipeSpec.recipeSpec;

@Repository
@Slf4j
@RequiredArgsConstructor
public class RecipeSpecRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<RecipeSpec> findAll() {

//        String query = "select rs from RecipeSpec rs join fetch rs.recipe" +
//                "  join fetch rs.material";
//
//        return em.createQuery( query
//                , RecipeSpec.class).getResultList();

        return jpaQueryFactory.selectFrom(recipeSpec)
                .join(recipeSpec.recipe, recipe)
                .join(recipeSpec.material, material)
                .fetch();
    }

    public List<RecipeSpec> findById(Long recipeId) {

//        String query = "select rs from RecipeSpec rs join fetch rs.recipe" +
//                "  join fetch rs.material where rs.recipe.id = :recipeId " ;
//
//        return em.createQuery( query
//                , RecipeSpec.class)
//                .setParameter("recipeId", recipeId)
//                .getResultList();

        return jpaQueryFactory.selectFrom(recipeSpec)
                .join(recipeSpec.recipe, recipe)
                .join(recipeSpec.material, material)
                .where(recipeSpec.recipe.id.eq(recipeId))
                .fetch();

    }

}
