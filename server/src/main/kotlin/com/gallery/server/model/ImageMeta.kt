package com.gallery.server.model

import java.time.Instant
import java.util.UUID

public data class ImageMeta(val id: UUID, val name: String, val uri: String, val size: Long, val created: Instant)