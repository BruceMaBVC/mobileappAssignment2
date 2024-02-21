package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.model.artwork1
import com.example.artspaceapp.model.artwork2
import com.example.artspaceapp.model.artwork3
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtworkScreen()
                }
            }
        }
    }
}

@Composable
fun ArtworkScreen() {
    val artworks = listOf(artwork1, artwork2, artwork3) // List of artwork instances
    var currentIndex: Int by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        ArtworkWall(
            imageId = currentArtwork.imageId,
            contentDescription = currentArtwork.contentDescription,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        ArtworkDescriptor(
            title = currentArtwork.title,
            artist = currentArtwork.artist,
            year = currentArtwork.year,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        DisplayController(
            onNext = { currentIndex = (currentIndex + 1) % artworks.size },
            onPrevious = { currentIndex = (currentIndex - 1 + artworks.size) % artworks.size },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
        )
    }
}

@Composable
fun ArtworkWall(imageId: Int, contentDescription: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(top = 30.dp),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .border(
                    BorderStroke(35.dp, Color.White),
                    shape = RoundedCornerShape(0.dp)
                )
                .shadow(15.dp, shape= MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
        ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
}

@Composable
fun ArtworkDescriptor(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
            contentAlignment = Alignment.TopCenter
    ) {
            Card(
                modifier = Modifier.fillMaxSize()
                                   .height(200.dp)
                                   .padding(top = 20.dp),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = artist, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = year)
                    }
                }
            }
    }
}


@Composable
fun DisplayController(
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
        ) {
            Button(
                onClick = onPrevious,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Previous")
            }
        }
        Spacer(modifier = Modifier.width(30.dp))
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
        ) {
            Button(
                onClick = onNext,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtworkScreen()
    }
}