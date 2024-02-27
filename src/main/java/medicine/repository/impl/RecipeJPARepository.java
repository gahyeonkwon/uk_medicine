package medicine.repository.impl;

import medicine.db.item.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeJPARepository extends JpaRepository<Recipe, Long> {

    boolean existsByName(String name);

}
