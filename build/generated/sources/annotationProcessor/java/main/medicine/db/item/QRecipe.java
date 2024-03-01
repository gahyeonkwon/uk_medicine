package medicine.db.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipe is a Querydsl query type for Recipe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipe extends EntityPathBase<Recipe> {

    private static final long serialVersionUID = 124231085L;

    public static final QRecipe recipe = new QRecipe("recipe");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath comment = _super.comment;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<RecipeSpec, QRecipeSpec> recipeSpecList = this.<RecipeSpec, QRecipeSpec>createList("recipeSpecList", RecipeSpec.class, QRecipeSpec.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regist_date = _super.regist_date;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    public QRecipe(String variable) {
        super(Recipe.class, forVariable(variable));
    }

    public QRecipe(Path<? extends Recipe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecipe(PathMetadata metadata) {
        super(Recipe.class, metadata);
    }

}

