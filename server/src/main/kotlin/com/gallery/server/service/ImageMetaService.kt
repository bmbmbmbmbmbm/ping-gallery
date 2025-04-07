package com.gallery.server.service

import com.gallery.server.exception.StorageException
import com.gallery.server.model.ImageMeta
import com.gallery.server.repository.ImageMetaRepository
import com.gallery.server.util.FileUtils
import io.github.oshai.kotlinlogging.KotlinLogging
import java.time.Instant
import java.util.Optional
import java.util.UUID
import kotlin.IllegalArgumentException
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

private val logger = KotlinLogging.logger {}

@Service
public class ImageMetaService(private val imageMetaRepository: ImageMetaRepository) {

    public fun getAll(): List<ImageMeta> {
        return imageMetaRepository.findAll()
    }

    public fun getById(idStr: String): Optional<ImageMeta> {
        try {
            val id = UUID.fromString(idStr)
            println(id)
            return imageMetaRepository.findById(id)
        } catch (exception: IllegalArgumentException) {
            logger.error { "getById(): bad identifier " + idStr }
            return Optional.empty()
        }
    }

    public fun createMeta(id: UUID, name: String, file: MultipartFile): ImageMeta {
        val originalFilename = file.originalFilename ?: ""
        if (file.isEmpty || originalFilename.isBlank()) {
            throw StorageException("Failed to store empty file.")
        }

        val extension = FileUtils.getExtension(originalFilename)
        val uri =
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/image-file/")
                        .path(id.toString() + "." + extension)
                        .toUriString()

        val imageMeta = ImageMeta(id, name, uri, file.size, Instant.now())

        return imageMetaRepository.save(imageMeta)
    }
}
