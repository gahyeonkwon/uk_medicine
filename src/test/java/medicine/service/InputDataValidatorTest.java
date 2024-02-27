package medicine.service;

import medicine.db.item.Material;
import medicine.repository.impl.MaterialJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class InputDataValidatorTest {

    @Autowired
    MaterialJPARepository materialJPARepository;
    

    @Test
    public void test() {
        
        Material material = new Material();
        assertTrue(materialJPARepository.existsByName(material.getName()));

        
    }
}