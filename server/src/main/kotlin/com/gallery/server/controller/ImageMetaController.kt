package com.gallery.server.controller

import com.gallery.server.repository.ImageMetaRepository
import com.gallery.server.model.ImageMeta
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
public class ImageMetaController(private val imageMetaRepository: ImageMetaRepository) {
    
    @PostMapping("/image-meta")
    public fun postImageMeta(@RequestBody imageMeta: ImageMeta) {
        imageMetaRepository.save(imageMeta)
    }
}