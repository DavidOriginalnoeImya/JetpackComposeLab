package com.example.login.form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.form.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(R.drawable.ellipse_1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.width(180.dp).height(130.dp).align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 40.dp, top = 15.dp)
            )
            Image(
                painter = painterResource(R.drawable.ellipse_2),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(165.dp)
                    .height(240.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.study_in),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(95.dp))
                Input("Create Username")
                Spacer(modifier = Modifier.height(20.dp))
                Input("Create Password")
                Spacer(modifier = Modifier.height(20.dp))
                Input("Email ID")
                Spacer(modifier = Modifier.height(35.dp))
                Button(
                    contentPadding = PaddingValues(bottom = 3.dp),
                    onClick = {},
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults
                        .buttonColors(backgroundColor = Color.Black, contentColor = Color.White),
                    modifier = Modifier
                        .width(170.dp)
                        .height(45.dp),
                )
                {
                    Text("Join Us", fontSize = 25.sp, fontWeight = FontWeight(700))
                }
            }
            Image(
                painter = painterResource(R.drawable.ellipse_3),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(170.dp)
                    .height(130.dp)
                    .align(Alignment.BottomEnd)
            )
        }
}

@Composable
fun Input(placeholder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(
            text = placeholder,
            fontSize = 20.sp,
        ) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
//            .width(287.dp)
//            .height(56.dp)
            .background(Color.Transparent)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        Login()
    }
}