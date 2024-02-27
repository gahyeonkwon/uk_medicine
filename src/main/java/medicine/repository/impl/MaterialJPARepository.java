package medicine.repository.impl;

import medicine.db.item.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialJPARepository extends JpaRepository<Material, Long> {
    boolean existsByName(String name);
}
