package com.example.fakestore.feature.main.category

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakestore.core.components.CategoryUi

@Composable
fun CategoriesScreen(navController: NavController, viewModel: CategoryViewModel) {


    when {
        viewModel.state.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        viewModel.state.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
                Text(text = viewModel.state.error ?: "", color = Color.Red, fontSize = 18.sp)
            }
        }

        viewModel.state.categories.isNullOrEmpty() -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "",
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = viewModel.state.error ?: "",
                        color = Color.LightGray,
                        fontSize = 18.sp
                    )
                }
            }

        }

        viewModel.state.categories?.isNotEmpty() == true -> {
            val itemModifer = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp)
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(viewModel.state.categories!!) { item ->

                    CategoryUi(modifier = itemModifer, name = item, onclick = {

                    })

                }

            }
        }


    }


}