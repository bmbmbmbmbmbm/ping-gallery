package com.gallery.server.repository

import java.util.UUID
import org.springframework.data.mongodb.repository.MongoRepository
import com.gallery.server.model.ImageMeta

public interface ImageMetaRepository : MongoRepository<ImageMeta, UUID> {
}