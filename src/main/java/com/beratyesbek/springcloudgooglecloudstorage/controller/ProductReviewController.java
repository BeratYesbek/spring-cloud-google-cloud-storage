package com.beratyesbek.springcloudgooglecloudstorage.controller;

import com.beratyesbek.springcloudgooglecloudstorage.entity.ProductReview;
import com.beratyesbek.springcloudgooglecloudstorage.service.ProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product_reviews")
public class ProductReviewController {

    private final ProductReviewService service;

    @PostMapping
    public ResponseEntity<ProductReview> review(
            @RequestPart("review") ProductReview review,
            @RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(service.review(review, file));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
    }

}
