package com.gallery.server.service

import com.gallery.server.repository.ImageMetaRepository
import com.gallery.server.model.ImageMeta
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional
import java.time.Instant
import kotlin.IllegalArgumentException

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {} 

@Service
public class ImageMetaService(private val imageMetaRepository: ImageMetaRepository) {

    private final val logstr: String = "ImageMetaService"

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

}