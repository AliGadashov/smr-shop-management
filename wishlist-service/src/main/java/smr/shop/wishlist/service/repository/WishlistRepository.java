package smr.shop.wishlist.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smr.shop.wishlist.service.model.WishlistEntity;

import java.util.Optional;
import java.util.UUID;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
    void deleteByUserIdAndProductId(UUID userId, Long productId);
    Optional<WishlistEntity> findByUserIdAndProductId(UUID userId, Long productId);

    void deleteByProductId(Long productId);
}
