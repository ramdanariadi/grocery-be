package id.grocery.tunas.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Repository
public class CategoryDAO {

    private EntityManager em;

    @Autowired
    public CategoryDAO(@Qualifier("groceryEntityManager") EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

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
