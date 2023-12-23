package medicine.db.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "medi_recipe_spec")
@Getter @Setter
public class RecipeSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private String id;
    private double materialMount;

    ///////////////////////////////////////////////////////////////////////////
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material material;


    @Override
    public String toString() {
        return "RecipeSpec{" +
                "materialMount=" + materialMount +
                ", recipe=" + recipe +
                ", material=" + material +
                '}';
    }
}
