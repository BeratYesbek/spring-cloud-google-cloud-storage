package com.beratyesbek.springcloudgooglecloudstorage.service;

import com.beratyesbek.springcloudgooglecloudstorage.entity.ProductReview;
import com.beratyesbek.springcloudgooglecloudstorage.repository.ProductReviewRepository;
import com.google.cloud.storage.Blob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProductReviewService {

    private final GcsService gcsService;
    private final ProductReviewRepository repository;


    public ProductReview review(ProductReview review, MultipartFile file) throws IOException {
        String imageUri = gcsService.uploadFile(file);
        review.setImageUri(imageUri);
        review.setImageFileName(file.getOriginalFilename());
        repository.save(review);
        return review;
    }

    public void deleteReview(Long id) {
        ProductReview productReview = repository.findById(id).orElseThrow();
        gcsService.deleteFile(productReview.getImageFileName());
        repository.deleteById(id);
    }
}
