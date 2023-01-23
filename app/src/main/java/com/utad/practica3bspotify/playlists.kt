package com.utad.practica3bspotify

import java.io.Serializable

data class playlists(
    val name: String,
    val surname: String,
    val foto: String,
    val seguidores: String,
    val canciones: List<cancion>
): Serializable

data class cancion(
    val titulo: String,
    val url: String,
    val autor: String
)