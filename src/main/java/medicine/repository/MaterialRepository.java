package medicine.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import medicine.db.item.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MaterialRepository {

    private final EntityManager em;

    public List<Material> findAll() {
        return em.createQuery("select i from Material i", Material.class).getResultList();
    }

    public Long insert(Material material) {
        em.persist(material);
        return material.getId();
    }
}
