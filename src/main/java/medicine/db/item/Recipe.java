package medicine.db.item;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "medi_recipe")
@NoArgsConstructor
public class Recipe extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(name = "recipe_nm")
    private String name;

//    @OneToMany(mappedBy = "recipe")
//    private List<RecipeSpec> recipeSpecList = new ArrayList<>();

    @Builder
    public Recipe(Long id, String name) {
        this.id = id;
        this.name = name;
    }



}
