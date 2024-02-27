package medicine.repository.impl;

import medicine.db.item.RecipeSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeSpecJPARepository extends JpaRepository<RecipeSpec, Long>{

}
