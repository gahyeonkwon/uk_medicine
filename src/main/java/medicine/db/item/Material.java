package medicine.db.item;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "medi_material")
@NoArgsConstructor
public class Material extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(name = "material_nm")
    private String name;

//    @OneToMany(mappedBy = "material")
//    private List<RecipeSpec> recipeSpecList = new ArrayList<>();

    public Material (Long id) {
        this.id = id;
    }

    public Material (String name) {
        this.name = name;
    }

    @Builder
    public Material (Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
