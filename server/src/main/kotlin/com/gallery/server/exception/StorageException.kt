package com.gallery.server.exception

/***
 * Found a file upload service implementation on Medium. Modified for purposes of image upload and sharing.
 * 
 * Sourced from https://medium.com/@afolayanseyi/how-to-implement-a-simple-file-upload-server-using-spring-boot-and-kotlin-4826daf026ec
 */
open class StorageException : RuntimeException {
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}