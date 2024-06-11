/**
 *
 *	MIT License
 *
 *	Copyright (c) 2023 Gautam Hazarika
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 *
 **/

package com.example.foodike.presentation.login

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.presentation.login.components.FoodikeTextField
import com.example.foodike.presentation.util.Screen
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val email by viewModel.email
    val password by viewModel.password

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message, duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val context = LocalContext.current as Activity

            context.window.statusBarColor = Color.Gray.toArgb()
            context.window.navigationBarColor = Color.White.toArgb()

            Text(
                text = stringResource(R.string.welcome_back), fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                horizontalAlignment = Alignment.End

            ) {
                FoodikeTextField(
                    value = email.text,
                    onValueChange = { viewModel.onEvent(LoginEvent.EnteredEmail(it)) },
                    hint = email.hint
                )


                Spacer(modifier = Modifier.height(16.dp))

                FoodikeTextField(
                    value = password.text,
                    onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
                    hint = password.hint,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                )


                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.forgot_password),
                    modifier = Modifier
                        .alpha(0.5f)
                        .clickable {
                            Toast
                                .makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT)
                                .show()
                        },
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier.width(200.dp), onClick = {
                viewModel.onEvent(LoginEvent.PerformLogin {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                    }
                })
            }) {
                Text(
                    text = stringResource(R.string.login),
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
                    text = stringResource(R.string.or_sign_in_with),
                    modifier = Modifier.alpha(0.5f),
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.goog_icon),
                    contentDescription = stringResource(R.string.login_with_google),
                    modifier = Modifier
                        .fillMaxSize(0.1f)
                        .clickable {
                            Toast
                                .makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT)
                                .show()
                        })
                Spacer(modifier = Modifier.width(16.dp))
                Image(painter = painterResource(id = R.drawable.fb_icon),
                    contentDescription = stringResource(R.string.login_with_facebook),
                    modifier = Modifier
                        .fillMaxSize(0.1f)
                        .clickable {
                            Toast
                                .makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT)
                                .show()
                        })
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.new_to_foodike),
                modifier = Modifier
                    .alpha(0.5f)
                    .clickable {
                        Toast
                            .makeText(context, R.string.coming_soon, Toast.LENGTH_SHORT)
                            .show()
                    },
            )
        }
    }
}