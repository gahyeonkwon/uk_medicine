package medicine.service;

import medicine.db.form.AddRecipeDTO;
import medicine.repository.impl.RecipeJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeJPARepository recipeJPARepository;

    @Test
    public void 레시피_저장() {

        //given
        List<String> materials = of("1","2","3");

        AddRecipeDTO addRecipeDTO = new AddRecipeDTO();
        addRecipeDTO.setRecipeName("보중익기탕");
        //addRecipeDTO.setMaterials(materials);

        //when
        //recipeService.insertMaterialsAndRecipeName(addRecipeDTO);

        //then
        assertTrue(recipeJPARepository.existsByName("보중익기탕"));

    }

}