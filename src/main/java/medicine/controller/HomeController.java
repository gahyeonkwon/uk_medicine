package medicine.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.RecipeSearchDTO;
import medicine.db.item.Recipe;
import medicine.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

        private final HomeService homeService;

        @GetMapping("/")
        public String home(@ModelAttribute("recipeSearch") RecipeSearchDTO recipeSearch) {
            return "home/home";
        }

        @GetMapping("/home/recipeSearch")
        public String searchResult(@ModelAttribute("recipeSearch") RecipeSearchDTO recipeSearch,
                                   Model model) {

            List<Recipe> recipes =  homeService.recipeSearch(recipeSearch);

            model.addAttribute("recipes", recipes);

            return "/home/recipeSearch";
        }



}
