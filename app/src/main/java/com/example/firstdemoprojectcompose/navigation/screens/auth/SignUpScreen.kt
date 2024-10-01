package com.example.firstdemoprojectcompose.navigation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstdemoprojectcompose.Extensions.CustomTextField
import com.example.firstdemoprojectcompose.Extensions.isSmallHeight
import com.example.firstdemoprojectcompose.R
import com.example.firstdemoprojectcompose.background.GradientBackgroundColor
import com.example.firstdemoprojectcompose.navigation.AuthRouteScreen
import com.example.firstdemoprojectcompose.navigation.Graph

@Composable
fun RegisterScreen(navController: NavController){
    GradientBackgroundColor(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Register yourself", color = Color.White, fontSize = 20.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.Black), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isSmallHeight()) Spacer(modifier = Modifier.fillMaxSize(0.01f))
                else Spacer(modifier = Modifier.fillMaxSize(0.02f))
                if (isSmallHeight()) Spacer(modifier = Modifier.fillMaxSize(0.01f))
                else Spacer(modifier = Modifier.fillMaxSize(0.02f))
                Image(
                    painter = painterResource(id = R.drawable.signup_register_login_icon),
                    contentDescription = "Custom Icon",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomTextField(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    label = "User Name",
                    keyboardActions = KeyboardActions(),
                    keyboardOptions = KeyboardOptions(),
                    height = 50.dp
                )
                Spacer(modifier = Modifier.height(5.dp))
                CustomTextField(
                    modifier = Modifier.padding( start = 10.dp, end = 10.dp),
                    label = "Email",
                    keyboardActions = KeyboardActions(),
                    keyboardOptions = KeyboardOptions(),
                    height = 50.dp
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    modifier = Modifier.padding( start = 10.dp, end = 10.dp),
                    label = "Password",
                    keyboardActions = KeyboardActions(),
                    keyboardOptions = KeyboardOptions(),
                    height = 50.dp
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    modifier = Modifier.padding( start = 10.dp, end = 10.dp),
                    label = "Confirm Password",
                    keyboardActions = KeyboardActions(),
                    keyboardOptions = KeyboardOptions(),
                    height = 50.dp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                                  navController.navigate(Graph.MainScreenGraph){
                                      popUpTo(AuthRouteScreen.Signup.route){
                                          inclusive = true
                                      }
                                  }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF3A024), contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Register", color = Color.White)

                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                                  navController.navigateUp()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF3A024), contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Already have aoocunt?Login", color = Color.White)

                    }
                }
            }
        }


    }

}