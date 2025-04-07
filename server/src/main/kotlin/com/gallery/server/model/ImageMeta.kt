package com.gallery.server.model

import java.time.Instant

public data class ImageMeta(val name: String, val uri: String, val size: Long, val created: Instant)