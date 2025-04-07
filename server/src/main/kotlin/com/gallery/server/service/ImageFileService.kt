package com.gallery.server.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value

/***
 * Found a file upload service implementation on Medium. Modified for purposes of image upload and sharing.
 * 
 * Sourced from https://medium.com/@afolayanseyi/how-to-implement-a-simple-file-upload-server-using-spring-boot-and-kotlin-4826daf026ec
 */
@Service
public class ImageFileService {

    @Value("\${gallery.server.image.store}")
    lateinit var rootLocation: String

}