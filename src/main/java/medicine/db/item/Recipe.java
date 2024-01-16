package medicine.db.item;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
@Table(name = "medi_recipe")
public class Recipe extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(name = "recipe_nm")
    private String name;

   /* @OneToMany(mappedBy = "recipe")
    private List<RecipeSpec> recipeSpecList = new ArrayList<>();*/



}
