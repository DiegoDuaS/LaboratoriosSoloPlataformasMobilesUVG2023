/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 4
 * Diego Duarte 22075
 */

package com.example.lab4final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Clase que representa la receta.
 * @property name Nombre de la receta.
 * @property imageUrl URL de la imagen de la receta.
 */
data class Recetas(val name: String, val imageUrl: String)

/**
 * Actividad principal.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}

/**
 * Interfaz
 */
@Composable
fun PantallaPrincipal() {
    var Receta by remember { mutableStateOf(TextFieldValue("")) }
    var Imagen by remember { mutableStateOf(TextFieldValue("")) }
    val Lista = remember { mutableStateListOf<Recetas>() }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HEALTHY LIVING +",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = Receta,
            onValueChange = { Receta = it },
            label = { Text("Nombre de la Receta") }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = Imagen,
            onValueChange = { Imagen = it },
            label = { Text("URL de Imagen de la Receta") }
        )
        Button(
            onClick = {
                if (Receta.text.isNotBlank() && Imagen.text.isNotBlank()) {
                    Lista.add(Recetas(name = Receta.text, imageUrl = Imagen.text))
                    Receta = TextFieldValue()
                    Imagen = TextFieldValue()
                }
            }
        ) {
            Text("Agregar receta")
        }
        LazyColumn {
            items(Lista) { receta ->
                Card(receta = receta)
            }
        }
    }
}

/**
 * Tarjeta para mostrar la receta
 * @param receta La receta a mostrar en la tarjeta.
 */
@Composable
fun Card(receta: Recetas) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = receta.imageUrl,
                contentDescription = null
            )
            Text(
                text = receta.name,
                fontWeight = FontWeight.Black
            )
        }
    }
}

/**
 * Vista Previa de la Pantalla Principal
 */
@Preview(showBackground = true)
@Composable
fun Preview1() {
    PantallaPrincipal()
}


