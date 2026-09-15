package com.example.ticketapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TicketScreen()
        }
    }
}

@Composable
fun TicketScreen() {

    val hargaTiket = 25000

    var jumlahTiket by remember {
        mutableStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1685E5))
                .padding(top = 35.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🎟",
                fontSize = 45.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pemesanan Tiket",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Pesan tiket dengan Mudah!",
                fontSize = 17.sp,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(20.dp)
            ) {

                Text(
                    text = "Harga Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF263238)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Rp${hargaTiket.formatRupiah()}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )

                Text(
                    text = "per tiket",
                    fontSize = 16.sp,
                    color = Color(0xFF8A99A8)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(20.dp)
            ) {

                Text(
                    text = "Jumlah Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF263238)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            if (jumlahTiket > 1) {
                                jumlahTiket--

                                Log.d(
                                    "TEST",
                                    "Jumlah tiket berkurang : $jumlahTiket"
                                )
                            }
                        },
                        modifier = Modifier.size(70.dp),
                        shape = RoundedCornerShape(50.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1685E5)
                        )
                    ) {
                        Text(
                            text = "−",
                            fontSize = 30.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.size(25.dp))

                    Box(
                        modifier = Modifier
                            .size(width = 140.dp, height = 65.dp)
                            .background(
                                color = Color(0xFFF0F3F7),
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = jumlahTiket.toString(),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF263238)
                        )
                    }

                    Spacer(modifier = Modifier.size(25.dp))

                    Button(
                        onClick = {
                            jumlahTiket++

                            Log.d(
                                "TEST",
                                "Jumlah tiket bertambah : $jumlahTiket"
                            )
                        },
                        modifier = Modifier.size(70.dp),
                        shape = RoundedCornerShape(50.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1685E5)
                        )
                    ) {
                        Text(
                            text = "+",
                            fontSize = 30.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(20.dp)
            ) {

                Text(
                    text = "Total",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF263238)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Rp${totalBayar.formatRupiah()}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00843D)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    jumlahTiket = 1

                    Log.d(
                        "TEST",
                        "Jumlah tiket di-reset : $jumlahTiket"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF3E3E)
                )
            ) {
                Text(
                    text = "↻  RESET",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

fun Int.formatRupiah(): String {
    return String.format("%,d", this).replace(',', '.')
}
