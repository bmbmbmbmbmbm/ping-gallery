package com.gallery.server.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.util.FileSystemUtils
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.io.IOException
import java.util.UUID
import java.net.MalformedURLException
import com.gallery.server.exception.StorageException
import com.gallery.server.exception.StorageFileNotFoundException
import com.gallery.server.util.FileUtils

/***
 * Found a file upload service implementation on Medium. Modified for purposes of image upload and sharing.
 * 
 * Sourced from https://medium.com/@afolayanseyi/how-to-implement-a-simple-file-upload-server-using-spring-boot-and-kotlin-4826daf026ec
 */
@Service
public class ImageFileService {

    @Value("\${gallery.server.image.store}")
    private lateinit var rootPathStr: String

    /**
     * Saves passed image to a UUID named file with the same extension in rootLocation.
     * @returns UUID of file
     */
    public fun saveImage(file: MultipartFile): UUID {
        return try {
            val originalFilename = file.originalFilename ?: ""
            if (file.isEmpty || originalFilename.isBlank()) {
                throw StorageException("Failed to store empty file.")
            }

            val extension = FileUtils.getExtension(originalFilename)
            val identfier = UUID.randomUUID()
            val destinationFilename = identfier.toString() + "." + extension

            val rootLocation = getRootLocation()
            Files.createDirectories(rootLocation)

            val destinationFile = rootLocation.resolve(
                Paths.get(destinationFilename)
            ).normalize().toAbsolutePath()

            if (destinationFile.parent != rootLocation.toAbsolutePath()) {
                throw StorageException("Cannot store file outside current directory")
            }

            file.inputStream.use { inputStream ->
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING)
            }
            
            identfier
        } catch (exception: IOException) {
            throw StorageException("Failed to read stored files", exception)
        } 
    }

    private fun load(fileName: String): Path {
        return getRootLocation().resolve(fileName)
    }

    public fun loadAsResources(fileName: String): Resource = try {
        val resource: Resource = UrlResource(load(fileName).toUri())
        if (resource.exists() || resource.isReadable) {
            resource
        } else {
            throw StorageFileNotFoundException("Could not read file: $fileName")
        }
    } catch (e: MalformedURLException) {
        throw StorageFileNotFoundException("Could not read file: $fileName", e)
    }

    private fun getRootLocation(): Path {
        return Paths.get(rootPathStr)
    }

}