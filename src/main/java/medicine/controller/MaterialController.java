package medicine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.db.form.AddMaterialDTO;
import medicine.db.item.Material;
import medicine.service.InputDataValidator;
import medicine.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class MaterialController {

    private final MaterialService materialService;
    private final InputDataValidator inputDataValidator;



    @GetMapping("/material/list")
    public String materialList(Model model) {

        List<Material> materials =  new ArrayList<>();
        materials = (List<Material>) materialService.findMaterials();
        model.addAttribute("materials", materials);

        return "/material/materialList";
    }

    @GetMapping("/material/addMaterial")
    public String addMaterial(@ModelAttribute("addMaterial") AddMaterialDTO addMaterial) {
        return "/material/addMaterial";
    }

    @PostMapping("/material/insertData")
    public String insertData(@ModelAttribute("addMaterial") @Validated AddMaterialDTO addMaterialDTO,
                             BindingResult bindingResult) {

        inputDataValidator.validate(addMaterialDTO, bindingResult);

        if(bindingResult.hasErrors()) {
            return "/material/addMaterial";
        }

        materialService.insertData(addMaterialDTO);

        return "redirect:/material/list";
    }

    @GetMapping("/material/deleteData/{materialId}")
    public String deleteData(@PathVariable("materialId") Long materialId) {
        materialService.deleteData(materialId);
        return "redirect:/material/list";
    }


    @GetMapping("/material/updateMaterial/{materialId}")
    public String updateMaterial(@ModelAttribute("addMaterial") AddMaterialDTO addMaterialDTO,
                                 @PathVariable("materialId") Long materialId,
                                 Model model) {

        Material material = materialService.findMaterial(materialId);

        log.info("material => " + material.toString());

        addMaterialDTO.toDto(material);

        return "/material/updateMaterial";
    }

    @PostMapping("/material/updateData")
    public String updateData(@ModelAttribute("addMaterial") @Validated AddMaterialDTO addMaterialDTO,
                             BindingResult bindingResult) {

        inputDataValidator.validate(addMaterialDTO, bindingResult);

        if(bindingResult.hasErrors()) {
            return "/material/updateMaterial";
        }

        materialService.updateData(addMaterialDTO);

        return "redirect:/material/list";
    }

}
