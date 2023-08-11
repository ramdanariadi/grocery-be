package id.grocery.tunas.category;

import id.grocery.tunas.category.dto.FindAllCategoryDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    public Query getAllCategories(boolean isCount){
        StringBuilder query = new StringBuilder("SELECT ");
        if(isCount){
            query.append("COUNT(1) FROM core_schema.categories WHERE deleted_at IS NULL");
        }else{
            query.append("id\\:\\:text, category, image_url FROM core_schema.categories WHERE deleted_at IS NULL");
        }
        Query nativeQuery = em.createNativeQuery(query.toString());
        return nativeQuery;
    }

}
