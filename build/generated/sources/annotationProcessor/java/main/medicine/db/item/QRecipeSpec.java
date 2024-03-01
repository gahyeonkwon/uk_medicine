package medicine.db.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipeSpec is a Querydsl query type for RecipeSpec
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipeSpec extends EntityPathBase<RecipeSpec> {

    private static final long serialVersionUID = -1442944248L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipeSpec recipeSpec = new QRecipeSpec("recipeSpec");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMaterial material;

    public final NumberPath<Double> materialMount = createNumber("materialMount", Double.class);

    public final QRecipe recipe;

    public QRecipeSpec(String variable) {
        this(RecipeSpec.class, forVariable(variable), INITS);
    }

    public QRecipeSpec(Path<? extends RecipeSpec> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecipeSpec(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecipeSpec(PathMetadata metadata, PathInits inits) {
        this(RecipeSpec.class, metadata, inits);
    }

    public QRecipeSpec(Class<? extends RecipeSpec> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.material = inits.isInitialized("material") ? new QMaterial(forProperty("material")) : null;
        this.recipe = inits.isInitialized("recipe") ? new QRecipe(forProperty("recipe")) : null;
    }

}

