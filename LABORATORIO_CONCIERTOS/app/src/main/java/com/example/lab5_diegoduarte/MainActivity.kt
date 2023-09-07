package com.example.lab5_diegoduarte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5_diegoduarte.ui.theme.BlueCito
import com.example.lab5_diegoduarte.ui.theme.BlueOscuro
import com.example.lab5_diegoduarte.ui.theme.Fondo
import com.example.lab5_diegoduarte.ui.theme.Fondo1
import com.example.lab5_diegoduarte.ui.theme.LAB5_DiegoDuarteTheme
import com.example.lab5_diegoduarte.ui.theme.Tarjetitas

data class Venues(val name: String, val place:String)
data class Conciertos(val name: String, val date: String, val image: Int)

//Prueba Committ Lab 6
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
                    //Pantalla1()
                    //Pantalla2()
                    //Pantalla3()
                    Pantalla4()

                }
            }
        }
    }
}

@Composable
fun Pantalla1(){
    val ConciertosFav = remember { mutableStateListOf<Conciertos>() }
    val ConciertosAll = remember { mutableStateListOf<Conciertos>() }
    ConciertosFav.add(Conciertos("Young Miko", "9 de Septiembre, 2023",R.drawable.youngmiko))
    ConciertosFav.add(Conciertos("Latin Mafia", "20 de Octube, 2023", R.drawable.latinmafia))
    ConciertosFav.add(Conciertos("Twice", "2 de Noviembre, 2023", R.drawable.twice))
    ConciertosFav.add(Conciertos("Feid", "4 de Diciembre, 2023", R.drawable.ferxxo))
    ConciertosAll.add(Conciertos("Young Miko", "9 de Septiembre, 2023",R.drawable.youngmiko))
    ConciertosAll.add(Conciertos("Latin Mafia", "20 de Octube, 2023", R.drawable.latinmafia))
    ConciertosAll.add(Conciertos("Twice", "2 de Noviembre, 2023", R.drawable.twice))
    ConciertosAll.add(Conciertos("Feid", "4 de Diciembre, 2023", R.drawable.ferxxo))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .background(color = Fondo1)
                .fillMaxWidth()
        ){
            Text(
                text = "Todo Eventos",
                style = androidx.compose.material.MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(bottom = 8.dp, top = 8.dp)
                    .align(Alignment.Center),
                color = Color.White
            )
        }
        Text(
            text = "Eventos Favoritos",
            style = androidx.compose.material.MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(bottom = 8.dp, top = 8.dp),
            color = BlueOscuro,
            textAlign = TextAlign.Start,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ){
            ConciertosFav.forEach { concierto ->
                CardConcierto(concierto = concierto)
            }
        }
        Text(
            text = "Todos Los Conciertos",
            style = androidx.compose.material.MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp, top = 8.dp),
            color = BlueOscuro
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ){
            ConciertosAll.forEach { concierto ->
                CardConcierto(concierto = concierto)
            }
        }
    }
}

@Composable
fun CardConcierto(concierto: Conciertos){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Fondo)
            .width(150.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Tarjetitas),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Tarjetitas)
            ){
                Image(
                    painter = painterResource(id = concierto.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(170.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = concierto.name,
                style = androidx.compose.material.MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                color = BlueOscuro,
                textAlign = TextAlign.Center

            )
            Text(
                text = concierto.date,
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

@Composable
fun Pantalla2(){
    val Lista = remember { mutableStateListOf<Venues>() }
    Lista.add(Venues("Bad Bunny", "Explanada Cayala"))
    Lista.add(Venues("Martin Garrix", "Forum Majadas"))
    Lista.add(Venues("Latin Mafia", "Parque de la Industria"))
    Lista.add(Venues("Taylor Swift", "Foro Sol"))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn {
            items(Lista) { venue ->
                Lugares(lugar = venue)
            }
        }
    }
}

@Composable
fun Lugares(lugar:Venues) {
    val firstLetter = lugar.name.take(1).uppercase()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Fondo),
        colors = CardDefaults.cardColors(
            containerColor = Fondo1
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Fondo)
                    .align(Alignment.CenterVertically)
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    text = firstLetter,
                    style = androidx.compose.material.MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = Color.Black,
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = lugar.name,
                    style = androidx.compose.material.MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
                Text(
                    text = lugar.place,
                    style = androidx.compose.material.MaterialTheme.typography.body2,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    color = Color.White,
                    textAlign = TextAlign.Start,
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

            ) {
                Text("...")
            }
        }
    }
}
@Composable
fun Pantalla3(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(400.dp)
                .background(color = Fondo1)
        ){
            Image(
                painter = painterResource(id = R.drawable.taylorswith),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp),
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Fondo)
            ){
                Text(
                    text = "Taylor Swift: The Eras Tour - Night 2",
                    style = androidx.compose.material.MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Foro Sol",
                    style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    textAlign = TextAlign.Start
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.calendaricon),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "25 de Agosto, 2023",
                style =  androidx.compose.material.MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .padding(horizontal = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.clockicon),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "7:20 p.m",
                style =  androidx.compose.material.MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Fondo)
            ){
                Text(
                    text = "ABOUT",
                    style =  androidx.compose.material.MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(vertical = 2.dp)
                        .padding(horizontal = 4.dp)
                )
                Text(
                    text = "La gira de tour de Taylor número 6. La primera vez que sale en gira desde la pandemia. Es un concierto que te llevará por todas las eras de Taylor Swift desde sus origenes con el album 'Taylor Swift' hasta su era actual con '1989: Taylor's Version'. ",
                    style =  androidx.compose.material.MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(vertical = 2.dp)
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

            ) {
                Text("Favorito")
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

            ) {
                Text("Comprar")
            }
        }
    }
}

@Composable
fun Pantalla4(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(500.dp, 250.dp)
                .background(color = Color.Transparent)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondouser1),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ){
            Image(
                painter = painterResource(id = R.drawable.usericon1),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 0.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "USUARIO PRUEBA",
                style =  androidx.compose.material.MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
                .background(color = Fondo)
        ){
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Fondo)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Fondo1
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color.White)
                            .align(Alignment.CenterVertically)
                            .align(Alignment.CenterVertically)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.usericon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "Editar Perfil",
                        style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(vertical = 2.dp),
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

                    ) {
                        Text("...")
                    }

                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 2.dp)
                .background(color = Fondo)
        ){
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Fondo)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Fondo1
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color.White)
                            .align(Alignment.CenterVertically)
                            .align(Alignment.CenterVertically)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lockicon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "Reiniciar Contraseña",
                        style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(vertical = 2.dp),
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

                    ) {
                        Text("...")
                    }

                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
                .background(color = Fondo)
        ){
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Fondo)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Fondo1
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color.White)
                            .align(Alignment.CenterVertically)
                            .align(Alignment.CenterVertically)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.bellicon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "Notificaciones",
                        style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(vertical = 2.dp),
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    val checkedState = remember { mutableStateOf(true) }
                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it },
                        modifier = Modifier
                            .padding(0.dp),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Fondo,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color.Black
                        )
                    )

                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
                .background(color = Fondo)
        ){
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Fondo)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Fondo1
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color.White)
                            .align(Alignment.CenterVertically)
                            .align(Alignment.CenterVertically)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.staricon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "Favoritos",
                        style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(vertical = 2.dp),
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Fondo1)

                    ) {
                        Text("...")
                    }

                }
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LAB5_DiegoDuarteTheme {
        Pantalla2()
    }
}