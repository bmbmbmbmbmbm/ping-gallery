package com.gallery.server.controller

import com.gallery.server.repository.ImageMetaRepository
import com.gallery.server.model.ImageMeta
import com.gallery.server.service.ImageMetaService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

@RestController
public class ImageMetaController(private val imageMetaService: ImageMetaService) {
    
    @GetMapping("/image-meta")
    public fun getImageMeta(): List<ImageMeta> {
        return imageMetaService.getAll()
    }

    @GetMapping("/image-meta/{id}")
    public fun getImageMetaById(@PathVariable("id") id: String): ResponseEntity<ImageMeta?> {
        val result = imageMetaService.getById(id)
        if (result.isEmpty) {
            return ResponseEntity.badRequest().build()
        }
        return ResponseEntity.ok(result.get())
    }
}