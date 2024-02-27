package medicine.db.item;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "medi_recipe_spec")
@Getter @Setter
@Slf4j
@ToString
@NoArgsConstructor
public class RecipeSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private Long id;
    private Double materialMount;

    @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material material;

    @Builder
    public RecipeSpec(Long recipeId) {
        this.recipe = Recipe.builder().id(recipeId).build();
    }


}
