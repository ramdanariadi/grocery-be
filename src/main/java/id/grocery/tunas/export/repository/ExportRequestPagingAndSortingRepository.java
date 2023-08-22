package id.grocery.tunas.export.repository;

import id.grocery.tunas.export.ExportRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExportRequestPagingAndSortingRepository extends PagingAndSortingRepository<ExportRequest, UUID> {
    List<ExportRequest> findAllByUserId(UUID userId, Pageable pageable);
}
