package com.example.foodike.presentation.history

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodike.presentation.components.SearchBar
import com.example.foodike.presentation.home.FavouriteSection
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun History() {


    val context = LocalContext.current as Activity

    val pagerState = rememberPagerState()


    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        SearchBar()
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
        Spacer(modifier = Modifier.height(16.dp))

    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("History", "Favourites")
    val scope = rememberCoroutineScope()

   TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 0.dp,
                color = Color.White
            )
        },

    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                       text= list[index],
                        fontSize = 16.sp,
                        fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Light,
                    color = Color.Black
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },

            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {

    HorizontalPager(count = 2, state = pagerState) { page ->
        when (page) {
            0 -> HistorySection()
            1 -> FavouritesSection()
        }
    }

}

@Composable
fun FavouritesSection() {
    Column {
        Text(text = "FAVORITEEE")
    }
}

@Composable
fun HistorySection() {
    Column {
        Text(text = "HISTORYYY")
    }
}
