package medicine.db.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import medicine.db.item.Material;
import medicine.db.item.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@ToString
@Slf4j
public class AddRecipeDTO {

     @NotEmpty
     private String recipeName;
     private Long recipeId;
     private String comment;

     @NotEmpty(message = "재료는 반드시 하나 이상 선택 되어야 합니다.")
     private List<String> materialIds;

     private List<String> materialMounts;

     private List<AddMaterialDTO> materials;

     public void setMaterialsDto(List<Material> materials) {

          List<AddMaterialDTO> addMaterialDTOList = materials.stream().map(material -> AddMaterialDTO.builder()
                  .materialName(material.getName())
                  .materialId(material.getId())
                  .build()).collect(Collectors.toList());


          this.materials = addMaterialDTOList;

     }

     //dto -> entity
     public Recipe toEntity(){
          return Recipe.builder()
                  .id(recipeId)
                  .name(recipeName)
                  .build();
     }

     //entity -> dto
     public AddRecipeDTO toDto(Recipe recipe) {
          this.recipeName = recipe.getName();
          this.recipeId = recipe.getId();
          return this;
     }


}
