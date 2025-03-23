package com.beratyesbek.springcloudgooglecloudstorage.service;

import com.beratyesbek.springcloudgooglecloudstorage.config.BucketConfig;
import com.google.cloud.storage.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GcsService {

    private final Storage storage;
    private final BucketConfig bucketConfig;

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = bucketConfig.getSubdirectory() + "/" + file.getOriginalFilename();
        Blob blob = storage.create(
                BlobInfo.newBuilder(bucketConfig.getBucketName(), fileName).build(),
                file.getBytes()
        );
        return blob.getMediaLink();
    }

    public void deleteFile(String fileName) {
        BlobId blobId = BlobId.of(bucketConfig.getBucketName(), bucketConfig.getSubdirectory() + "/" + fileName);
        storage.delete(blobId);
    }

    public Blob getFile(String fileName) {
        return storage.get(bucketConfig.getBucketName(), fileName);
    }
}
