package com.gallery.server.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.multipart.MultipartFile
import org.springframework.http.ResponseEntity
import org.springframework.core.io.Resource
import com.gallery.server.model.ImageMeta
import com.gallery.server.service.ImageFileService
import com.gallery.server.service.ImageMetaService
import com.gallery.server.exception.StorageFileNotFoundException

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {} 
/***
 * Found a file upload service implementation on Medium. Modified for purposes of image upload and sharing.
 * 
 * Sourced from https://medium.com/@afolayanseyi/how-to-implement-a-simple-file-upload-server-using-spring-boot-and-kotlin-4826daf026ec
 */
@RestController
public class ImageFileController(private val imageFileService: ImageFileService, private val imageMetaService: ImageMetaService) {

    @GetMapping("/image-file/{fileName}")
    public fun getImageById(@PathVariable("fileName") fileName: String): ResponseEntity<Resource> {
        try {
            val image = imageFileService.loadAsResources(fileName)
            return ResponseEntity.ok(image)
        } catch (exception: StorageFileNotFoundException) {
            return ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/image-file")
    public fun postImage(@RequestParam("file") file: MultipartFile, @RequestParam("name") name: String): ResponseEntity<ImageMeta?> {
        try {
            val id = imageFileService.saveImage(file)
            val imageMeta = imageMetaService.
        }
        return ResponseEntity.badRequest().build()
    }

    @DeleteMapping("/image-file/{id}")
    public fun postImage(@PathVariable("id") id: String): ResponseEntity<ImageMeta?> {
        return ResponseEntity.badRequest().build()
    }
}