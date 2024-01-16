package medicine.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.RecipeSearch;
import medicine.db.item.Recipe;
import medicine.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.directory.SearchResult;
import java.util.*;
import java.nio.channels.SeekableByteChannel;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

        private final HomeService homeService;

        @GetMapping("/home")
        public String home(@ModelAttribute("recipeSearch") RecipeSearch recipeSearch) {
            return "home/home";
        }

        @GetMapping("/home/recipeSearch")
        public String searchResult(@ModelAttribute("recipeSearch") RecipeSearch recipeSearch,
                                   Model model) {

            List<Recipe> recipes =  homeService.recipeSearch(recipeSearch);

            model.addAttribute("recipes", recipes);

            return "/home/recipeSearch";
        }



}
