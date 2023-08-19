package id.grocery.tunas.category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Value("${spring.jpa.properties.hibernate.default_schema}")
    private Optional<String> schema;

    public Query getAllCategories(boolean isCount){
        StringBuilder query = new StringBuilder("SELECT ");
        if(isCount){
            query.append("COUNT(1) ");
        }else{
            query.append("id\\:\\:text, category, image_url ");
        }
        query.append("FROM core_schema.categories " +
                "WHERE deleted_at IS NULL " +
                "GROUP BY id");
        Query nativeQuery = em.createNativeQuery(query.toString());
        return nativeQuery;
    }

}
