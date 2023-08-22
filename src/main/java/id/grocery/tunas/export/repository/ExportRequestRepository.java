package id.grocery.tunas.export.repository;

import id.grocery.tunas.export.ExportRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExportRequestRepository extends CrudRepository<ExportRequest, UUID> {
}
