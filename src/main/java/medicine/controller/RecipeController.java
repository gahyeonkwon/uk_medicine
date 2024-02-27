package medicine.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.AddRecipeDTO;
import medicine.db.form.WaterMountDTO;
import medicine.db.item.Material;
import medicine.db.item.Recipe;
import medicine.db.item.RecipeSpec;
import medicine.service.MaterialService;
import medicine.service.RecipeService;
import medicine.service.RecipeSpecService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RecipeController {


     private final RecipeService recipeService;
     private final RecipeSpecService recipeSpecService;

     private final MaterialService materialService;

     @GetMapping("/recipe/list")
     public String recipeList(Model model) {

          List<Recipe> recipes = new ArrayList<>();
          recipes = (List<Recipe>) recipeService.findRecipes();
          model.addAttribute("recipes", recipes);

          return "/recipe/recipeList";
     }


     @GetMapping("/recipe/selectMaterial")
     public String selectMaterial(@ModelAttribute("addRecipe") AddRecipeDTO addRecipeDTO,
                              Model model) {


          // 선택할 재료 목록 출력
          List<Material> materials = materialService.findMaterials();
          model.addAttribute("materials", materials);

          return "/recipe/selectMaterial";
     }


     @PostMapping("/recipe/insertMaterialMount")
     public String inserMaterialMount(@ModelAttribute("addRecipe") @Validated
                                     AddRecipeDTO addRecipeDTO,
                                Model model) {

          List<Material> materials = materialService.setMaterialName(addRecipeDTO.getMaterialIds());
          addRecipeDTO.setMaterialsDto(materials);

          log.info("addRecipeDTO = {} " + addRecipeDTO.toString() );

          return "recipe/insertMaterialMount";
     }


     @PostMapping("/recipe/insertRecipe")
     public String insertRecipe(@ModelAttribute("addRecipe") AddRecipeDTO addRecipeDTO) {

          recipeSpecService.insertRecipe(addRecipeDTO);


          return "redirect:/recipe/list";
     }



     @GetMapping("/recipe/spec/{recipeId}")
     public String recipeSpec(@ModelAttribute("getWaterMount") WaterMountDTO waterMountDTO,
                              @PathVariable("recipeId") Long recipeId,
                              Model model) {

          List<RecipeSpec> recipeSpecs = new ArrayList<>();
          recipeSpecs = recipeSpecService.findRecipeSpec(recipeId);

          for ( RecipeSpec rs : recipeSpecs
               ) {

          }

          if(waterMountDTO.getTotalWaterMount() == 0.0 ) {
               waterMountDTO.initData();
          }

          model.addAttribute("recipeSpecs", recipeSpecs);

          return "/recipe/recipeSpec";
     }







}
