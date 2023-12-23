package medicine.db.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "medi_material")
public class Material extends BaseEntity{

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(name = "material_nm")
    private String name;

    /*@OneToMany(mappedBy = "material")
    private List<RecipeSpec> recipeSpecList = new ArrayList<>();*/


}
