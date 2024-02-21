package com.example.artspaceapp.model
import androidx.annotation.DrawableRes
import com.example.artspaceapp.R

data class ArtworkData(
    @DrawableRes val imageId: Int,
    val title: String,
    val artist: String,
    val year: String,
    val contentDescription: String
)

// Create instances of ArtworkData
val artwork1 = ArtworkData(
    imageId = R.drawable.thedanceclass,
    title = "The Dance Class",
    artist = "Edgar Degas",
    year = "(1874)",
    contentDescription = "Artwork1"
)

val artwork2 = ArtworkData(
    imageId = R.drawable.viewoftoledo,
    title = "View Of Toledo",
    artist = "Ei Greco",
    year = "(1600)",
    contentDescription = "Artwork2"
)

val artwork3 = ArtworkData(
    imageId = R.drawable.officeinasmallcity,
    title = "Office In A Small City",
    artist = "Edward Hopper",
    year = "(1953)",
    contentDescription = "Artwork3"
)