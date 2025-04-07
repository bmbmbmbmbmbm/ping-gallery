package com.gallery.server.controller

import com.gallery.server.repository.ImageMetaRepository
import com.gallery.server.model.ImageMeta
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
public class ImageMetaController() {
    
    @GetMapping("/image-meta")
    public fun getImageMeta() {
    }

    @GetMapping("/image-meta/{id}")
    public fun getImageMetaById(@PathVariable("id") id: String) {
    }
}