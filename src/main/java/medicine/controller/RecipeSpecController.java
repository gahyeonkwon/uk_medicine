package medicine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.WaterMount;
import medicine.db.item.RecipeSpec;
import medicine.service.RecipeSpecService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RecipeSpecController {

    private final RecipeSpecService recipeSpecService;

    @GetMapping("/getWaterMount")
    public String getWaterMount (@ModelAttribute("getWaterMount") WaterMount waterMount,
                                 RedirectAttributes redirectAttributes) {

        double totalWaterMount = recipeSpecService.getWaterMount(waterMount);
        waterMount.setTotalWaterMount(totalWaterMount);

        redirectAttributes.addFlashAttribute("getWaterMount", waterMount);

        return "redirect:/recipe/spec/" + waterMount.getRecipeId();
    }
}
