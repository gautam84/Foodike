package com.example.foodike.presentation.login

import android.app.Activity
import android.view.WindowManager
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.presentation.util.Screen

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,

    ) {
    val email by viewModel.email
    val password by viewModel.password


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current as Activity

        context.window.statusBarColor = Color.Gray.toArgb()
        context.window.navigationBarColor = Color.White.toArgb()



        Text(
            text = "Welcome back!",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            horizontalAlignment = Alignment.End

        ) {
            TextField(
                value = email,
                onValueChange = { viewModel.changeEmail(it) },
                modifier = Modifier.width(280.dp),
                placeholder = {
                    Text(
                        text = "Enter email or phone number",
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                shape = RoundedCornerShape(9.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { viewModel.changePassword(it) },
                modifier = Modifier.width(280.dp),
                placeholder = {
                    Text(
                        text = "Password",
                        Modifier.alpha(0.5f)
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(9.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "forgot password?",
                modifier = Modifier
                    .alpha(0.5f)
                    .clickable {
                        Toast
                            .makeText(context, "Coming soon!", Toast.LENGTH_SHORT)
                            .show()
                    },
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
                navController.popBackStack()
                viewModel.saveOnBoardingState(completed = true)

            }
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(0.1f)
                    .width(1.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "or sign in with",
                modifier = Modifier
                    .alpha(0.5f),
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.width(16.dp))


            Divider(
                modifier = Modifier
                    .weight(0.1f)
                    .width(1.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.goog_icon),
                contentDescription = "google login",
                modifier = Modifier
                    .fillMaxSize(0.1f)
                    .clickable {
                        Toast
                            .makeText(context, "Coming soon!", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.fb_icon),
                contentDescription = "facebook login",
                modifier = Modifier
                    .fillMaxSize(0.1f)
                    .clickable {
                        Toast
                            .makeText(context, "Coming soon!", Toast.LENGTH_SHORT)
                            .show()
                    }
            )

        }
        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "New to Foodika? Sign up",
            modifier = Modifier
                .alpha(0.5f)
                .clickable {
                    Toast
                        .makeText(context, "Coming soon!", Toast.LENGTH_SHORT)
                        .show()
                },
        )


    }


}