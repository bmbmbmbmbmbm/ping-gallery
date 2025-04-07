package com.gallery.server.util

public class FileUtils {
    companion object {
        /**
         * Get the file extension from a string.
         */
        fun getExtension(fileName: String): String {
            val i = fileName.lastIndexOf('.');
            if (i > 0) {
                return fileName.substring(i+1);
            }
            return ""
        }

        /**
         * Get the file name from a string without the extension.
         */
        fun dropExtension(fileName: String): String {
            val i = fileName.lastIndexOf('.');
            if (i > 0) {
                return fileName.substring(0, i-1);
            }
            return ""
        }
    }
}