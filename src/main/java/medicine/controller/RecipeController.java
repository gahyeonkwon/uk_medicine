package medicine.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.WaterMount;
import medicine.db.item.Recipe;
import medicine.db.item.RecipeSpec;
import medicine.service.RecipeService;
import medicine.service.RecipeSpecService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

     @GetMapping("/recipe/list")
     public String recipeList(Model model) {

          List<Recipe> recipes = new ArrayList<>();
          recipes = (List<Recipe>) recipeService.findRecipes();
          model.addAttribute("recipes", recipes);

          return "/recipe/recipeList";
     }



     @GetMapping("/recipe/spec/{recipeId}")
     public String recipeSpec(@ModelAttribute("getWaterMount") WaterMount waterMount,
                              @PathVariable("recipeId") Long recipeId,
                              Model model) {

          List<RecipeSpec> recipeSpecs = new ArrayList<>();
          recipeSpecs = recipeSpecService.findRecipeSpec(recipeId);

          for ( RecipeSpec rs : recipeSpecs
               ) {

               System.out.println("rs.tostring" + rs.toString());
          }

          if(waterMount.getTotalWaterMount() == 0.0 ) {
               log.info(" waterMount init !");
               waterMount.initData();
          }

          model.addAttribute("recipeSpecs", recipeSpecs);

          return "/recipe/recipeSpec";
     }



}
