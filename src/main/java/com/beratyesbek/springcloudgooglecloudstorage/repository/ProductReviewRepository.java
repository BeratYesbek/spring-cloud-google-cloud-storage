package com.beratyesbek.springcloudgooglecloudstorage.repository;

import com.beratyesbek.springcloudgooglecloudstorage.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
