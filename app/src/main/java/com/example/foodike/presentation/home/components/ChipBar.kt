package com.example.foodike.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ChipBar() {
    LazyRow {
        item {
//            Chip(name = "Sort", isSelected = true, onSelectionChanged = )

        }

    }
}

@Composable
fun Chip(
    name: String,
    isSelected: Boolean ,
    onSelectionChanged: (String) -> Unit,
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else Color.White,
        border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.2f)),
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

