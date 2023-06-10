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

package com.example.foodike.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.presentation.util.Screen

@Composable
fun Profile(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = stringResource(R.string.back))
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Text(
                    text = "Andrew Howard",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "andrewhoward@gmail.com ",
                    modifier = Modifier.alpha(0.5f),
                )

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = stringResource(R.string.display_picture)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.edit),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {

                        },
                        fontWeight = FontWeight.Bold
                    )
                }


            }


        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = Color.Black
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            ProfileCard(
                title = stringResource(R.string.saved_addresses),
                subtext = stringResource(R.string.add_edit_and_delete_saved_addresses),
                onClick = {

                }
            )
            ProfileCard(
                title = stringResource(R.string.payments_and_refunds),
                subtext = stringResource(R.string.information_about_refunds_and_payments),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.online_ordering_help),
                subtext = stringResource(R.string.information_about_ordering_food),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.about),
                subtext = stringResource(R.string.about_the_app),
                onClick = {
                },
                dividerVisibility = false
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.width(200.dp),
                onClick = {
                    viewModel.onEvent(ProfileEvent.PerformLogout {
                        navController.navigate(Screen.Onboarding.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    })
                }
            ) {
                Text(
                    text = stringResource(R.string.log_out),
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun ProfileCard(
    title: String,
    subtext: String,
    onClick: () -> Unit,
    dividerVisibility: Boolean = true
) {
    Column(
        modifier = Modifier
            .padding(32.dp, 0.dp)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = title,
            fontSize = 20.sp
        )
        Text(
            text = subtext,
            modifier = Modifier.alpha(0.5f)
        )
        if (dividerVisibility) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

    }
}
