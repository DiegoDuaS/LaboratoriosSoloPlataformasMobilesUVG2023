package com.example.lab5_diegoduarte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5_diegoduarte.ui.theme.BlueCito
import com.example.lab5_diegoduarte.ui.theme.BlueOscuro
import com.example.lab5_diegoduarte.ui.theme.LAB5_DiegoDuarteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB5_DiegoDuarteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla1()
                }
            }
        }
    }
}
@Composable
fun Pantalla1(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = BlueCito),
            horizontalAlignment = Alignment.CenterHorizontally

        ){

        Text(
            text = "Todo Eventos",
            style = androidx.compose.material.MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 8.dp, top = 8.dp),
            color = BlueOscuro
        )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            EventosConjuntos("Young Miko", "9 de Septiembre, 2023", R.drawable.youngmiko, "Latin Mafia", "4 de Diciembre, 2023",R.drawable.latinmafia)
            EventosConjuntos(artista1 = "Twice", fecha1 = "4 de Noviembre, 2023", imagen1 = R.drawable.twice, artista2 = "Feid", fecha2 = "20 de Octubre, 2023", imagen2 =  R.drawable.ferxxo)
        }
    }

}

@Composable
fun EventosConjuntos(artista1: String, fecha1: String, imagen1: Int, artista2: String, fecha2: String, imagen2: Int){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = BlueCito),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = imagen1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = artista1,
                        style = androidx.compose.material.MaterialTheme.typography.h6,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        color = BlueOscuro,
                        textAlign = TextAlign.Center

                    )
                    Text(
                        text = fecha1,
                        style = androidx.compose.material.MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                            .fillMaxWidth(),
                        color = BlueOscuro,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = BlueCito),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = imagen2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = artista2,
                        style = androidx.compose.material.MaterialTheme.typography.h6,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        color = BlueOscuro,
                        textAlign = TextAlign.Center

                    )
                    Text(
                        text = fecha2,
                        style = androidx.compose.material.MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                            .fillMaxWidth(),
                        color = BlueOscuro,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
}
@Composable
fun Pantalla2(){

}

@Composable
fun Pantalla3(){

}

@Composable
fun Pantalla4(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LAB5_DiegoDuarteTheme {
        Pantalla1()
    }
}