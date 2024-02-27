package medicine.controller;

import medicine.db.form.AddRecipeDTO;
import medicine.db.item.Material;
import medicine.repository.impl.RecipeJPARepository;
import medicine.repository.impl.RecipeSpecJPARepository;
import medicine.service.MaterialService;
import medicine.service.RecipeSpecService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RecipeControllerTest {

    @Autowired
    MaterialService materialService;


    @Autowired
    RecipeSpecService recipeSpecService;

    @Autowired
    RecipeJPARepository recipeJPARepository;

    @Autowired
    RecipeSpecJPARepository recipeSpecJPARepository;

    @DisplayName("재료값을_ID_Material_MaterialDTO순으로 변환하기")
    @Test
    public void transMaterialTest() {

        //given
        AddRecipeDTO addRecipeDTO = new AddRecipeDTO();

        addRecipeDTO.setRecipeName("테스트레시피");
        addRecipeDTO.setMaterialIds(new ArrayList<>(Arrays.asList("1","2","3")));


        //when
        List<Material> materials = materialService.setMaterialName(addRecipeDTO.getMaterialIds());
        addRecipeDTO.setMaterialsDto(materials);

        //then
        assertNotNull(materials, "materials is null");
        assertNotNull(addRecipeDTO.getMaterials(), "materialsDTO is null");

    }



    @DisplayName("recipeSpec 저장하기")
    @Test
    public void saveAllData() {

        //given
        AddRecipeDTO addRecipeDTO = new AddRecipeDTO();

        addRecipeDTO.setRecipeName("테스트레시피");
        addRecipeDTO.setMaterialIds(new ArrayList<>(Arrays.asList("1","2","3")));
        addRecipeDTO.setMaterialMounts(new ArrayList<>(Arrays.asList("5","6","7.5")));


        //when
        recipeSpecService.insertRecipe(addRecipeDTO);

        //then
        assertTrue(recipeJPARepository.existsByName("테스트레시피"), "recipe insert 실패");


    }

}