package medicine.controller;

import jakarta.persistence.EntityManager;
import medicine.db.item.Material;
import medicine.repository.impl.MaterialJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class MaterialControllerTest {


    @Autowired
    MaterialJPARepository materialJPARepository;
    @Autowired
    EntityManager em;

    @Test
    public void inesrtTest() {

        Material material = new Material("시호2");
        em.persist(material);
    }

    @Test
    public void deleteTest() {

        Long id = 41L;
        materialJPARepository.deleteById(id);
        assertThat(materialJPARepository.findById(id).get().getName()).isEqualTo("맥ㅁㄴ동");
        assertThat(materialJPARepository.findById(id).get().getName()).isEqualTo("맥문동");
    }



}