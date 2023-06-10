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

package com.example.foodike.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodike.presentation.home.util.Filter
import com.example.foodike.presentation.home.util.getAllTags
import com.example.foodike.presentation.home.util.getTag


@Composable
fun ChipBar() {
    val selectedFilter: MutableState<Filter?> = remember { mutableStateOf(null) }

    ChipGroup(
        filters = getAllTags(),
        selectedFilter = selectedFilter.value,
        onSelectedChanged = {
            if (selectedFilter.value == getTag(it)) {
                selectedFilter.value = null
            } else {
                selectedFilter.value = getTag(it)
            }
        }
    )

}


@Composable
fun Chip(
    name: String,
    isSelected: Boolean,
    onSelectionChanged: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Black.copy(0.3f)), MaterialTheme.shapes.medium)
            ,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) MaterialTheme.colors.primary else Color.White
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
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ChipGroup(
    filters: List<Filter> = getAllTags(),
    selectedFilter: Filter? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
        LazyRow(
            contentPadding = PaddingValues(
                start = 8.dp,
                end = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filters) {
                Chip(
                    name = it.value,
                    isSelected = selectedFilter == it,
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                )
            }

    }
}

