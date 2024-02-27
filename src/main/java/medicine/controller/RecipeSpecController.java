package medicine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.WaterMountDTO;
import medicine.service.RecipeSpecService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RecipeSpecController {

    private final RecipeSpecService recipeSpecService;

    @GetMapping("/getWaterMount")
    public String getWaterMount (@ModelAttribute("getWaterMount") WaterMountDTO waterMount,
                                 RedirectAttributes redirectAttributes) {

        double totalWaterMount = recipeSpecService.getWaterMount(waterMount);
        waterMount.updateTotalWaterMount(totalWaterMount);

        redirectAttributes.addFlashAttribute("getWaterMount", waterMount);

        return "redirect:/recipe/spec/" + waterMount.getRecipeId();
    }
}
