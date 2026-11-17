package com.example.campusgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.campusgallery.ui.theme.CampusGalleryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CampusGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Red
                ) {
                    CampusGallery()
                }
            }
        }
    }
}

@Composable
fun CampusGallery() {

    var imageIndex by remember { mutableStateOf(0) }

    val image = when (imageIndex) {
        0 -> R.drawable.colehall
        1 -> R.drawable.redhawk
        else -> R.drawable.students
    }

    val title = when (imageIndex) {
        0 -> "Cole Hall"
        1 -> "Red Hawk"
        else -> "Student Life"
    }

    val description = when (imageIndex) {
        0 -> "Montclair State University campus"
        1 -> "Montclair State University campus"
        else -> "Montclair State University campus"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    imageIndex = if (imageIndex > 0) {
                        imageIndex - 1
                    } else {
                        2
                    }
                }
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    imageIndex = if (imageIndex < 2) {
                        imageIndex + 1
                    } else {
                        0
                    }
                }
            ) {
                Text("Next")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Image ${imageIndex + 1} of 3",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}