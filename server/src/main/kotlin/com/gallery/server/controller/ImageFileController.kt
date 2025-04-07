package com.gallery.server.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.http.ResponseEntity
import org.springframework.core.io.Resource
import com.gallery.server.model.ImageMeta

@RestController
public class ImageFileController() {

    @GetMapping("/image-file/{id}")
    public fun getImageById(@PathVariable("id") id: String): ResponseEntity<Resource> {
        return ResponseEntity.badRequest().build()
    }

    @PostMapping("/image-file")
    public fun postImage(@RequestParam("file") file: MultipartFile, @RequestParam("name") name: String): ResponseEntity<ImageMeta?> {
        return ResponseEntity.badRequest().build()
    }

}