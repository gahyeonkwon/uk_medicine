package medicine.db.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import medicine.db.item.Material;



@Getter @Setter
@NoArgsConstructor
public class AddMaterialDTO {

    @NotEmpty
    private String materialName;
    private  Long materialId;
    private String comment;

    @Builder
    private AddMaterialDTO(String materialName, Long materialId) {
        this.materialName = materialName;
        this.materialId = materialId;
    }

    //dto -> entity
    public Material toEntity(){
            return Material.builder()
                    .id(materialId)
                    .name(materialName)
                    .build();
        }

    //entity -> dto
    public AddMaterialDTO toDto(Material material) {
            this.materialName = material.getName();
            this.materialId = material.getId();
            return this;
    }


}
