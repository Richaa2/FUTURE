package com.richa.future.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richa.future.R
import com.richa.future.ui.theme.boldStyle
import com.richa.future.ui.theme.borderColor
import com.richa.future.ui.theme.brownBlack
import com.richa.future.ui.theme.brownishGray
import com.richa.future.ui.theme.darkSlateGray
import com.richa.future.ui.theme.grayNavigationBar
import com.richa.future.ui.theme.mediumTextStyle
import com.richa.future.ui.theme.regularTextStyle
import com.richa.future.ui.theme.semiBoldStyle

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TitleRow("Richard Kochut", R.drawable.avatar_mock)
            SearchFilterRow()
            Categories()
            ProductList()
        }
        BottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
private fun TitleRow(name: String, @DrawableRes image: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
            .height(44.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Hello, Welcome \uD83D\uDC4B",
                style = mediumTextStyle,
                color = darkSlateGray,

                )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                style = mediumTextStyle,
                color = darkSlateGray
            )
        }
        Image(
            painter = painterResource(id = image),
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(22.dp)),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Avatar"
        )
    }
}

@Composable
private fun SearchFilterRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBox()
        Spacer(modifier = Modifier.width(16.dp))
        Filter()
    }
}

@Composable
private fun SearchBox() {
    Box(
        modifier = Modifier
            .width(263.dp)
            .height(49.dp)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .height(48.dp)
            .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = brownishGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Search clothes...")
        }
    }
}

@Composable
private fun Filter() {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(
                color = brownBlack,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(start = 12.dp, top = 13.dp, end = 12.dp, bottom = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter",
            modifier = Modifier.fillMaxSize(),
            tint = Color.White
        )

    }
}

@Composable
fun Categories() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
            .height(40.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),

        ) {
        items(categories) { item ->
            CategoryItem(item, false)
        }
    }
}

@Composable
fun CategoryItem(category: Category, isClicked: Boolean) {
    // TODO: Change Click
    var click by remember { mutableStateOf(false) }
    val backgroundColor = if (click) brownBlack else Color.White
    val textColor = if (!click) brownBlack else Color.White

    Button(
        onClick = {
            click = !click
        },
        enabled = true,
        modifier = Modifier
            .fillMaxHeight(),
        shape = RoundedCornerShape(25),
        border = BorderStroke(
            width = 1.dp,
            color = borderColor,
        ),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = category,
            style = regularTextStyle,
            color = textColor,
            fontWeight = FontWeight(600)
        )
    }
}

//TODO REMOVE Mock data
val categories = listOf("All items", "Men", "Woman", "Children", "Shoes")
typealias Category = String

@Composable
fun ProductList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(listPhotos) { item ->
            ProductItemRow(item)
        }
    }
}

@Composable
fun ProductItemRow(productRow: ProductRow) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductItem(image = productRow.first)
        Spacer(modifier = Modifier.width(15.dp))
        productRow.second?.let {
            ProductItem(image = it)
        } ?: Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ProductItem(image: Int) {
    Column(modifier = Modifier.width(160.dp)) {
        Box(
            modifier = Modifier
                .height(175.dp)
                .clip(RoundedCornerShape(14.dp))
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Product",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(26.dp)
                    .align(Alignment.TopEnd),
            ) {
                Image(
                    modifier = Modifier
                        .background(
                            color = brownBlack,
                            shape = RoundedCornerShape(size = 100.dp)
                        )
                        .fillMaxSize()
                        .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp),
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Favorite",
                    contentScale = ContentScale.FillBounds,

                    )
            }


        }
        Text(
            text = "Modern T-Shirt",
            style = boldStyle,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Collection Name",
            style = regularTextStyle,
            fontSize = 10.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "$99.99", style = boldStyle, fontSize = 14.sp)
            //TODO or not
//            Text(text = "5.0", style = mediumTextStyle, fontSize = 12.sp)
        }
    }
}

val listPhotos = listOf(
    Pair(R.drawable.image_mock, R.drawable.image_mock),
    Pair(R.drawable.image_mock, R.drawable.image_mock),
    Pair(R.drawable.image_mock, R.drawable.image_mock),
    Pair(R.drawable.image_mock, null),
)

typealias ProductRow = Pair<Int, Int?>

@Composable
fun BottomNavigationBar(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(64.dp)
            .background(color = brownBlack, shape = RoundedCornerShape(size = 40.dp))
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationIcon(R.drawable.home_2, true)
            NavigationIcon(R.drawable.shopping_bag)
            NavigationIcon(R.drawable.heart, false)
            NavigationIcon(R.drawable.profile, false)

        }

    }
}

@Composable
fun NavigationIcon(@DrawableRes image: Int, isCurrent: Boolean = false) {
    Box(
        modifier = Modifier.size(40.dp),
    ) {
        Image(
            modifier = Modifier
                .background(
                    color = grayNavigationBar,
                    shape = RoundedCornerShape(size = 100.dp)
                )
                .fillMaxSize()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            painter = painterResource(id = image),
            contentDescription = "Home",
            contentScale = ContentScale.FillBounds,

            )
        if (isCurrent) {
            Box(
                modifier = Modifier
                    .padding(1.dp)
                    .size(4.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.White)
                    .align(Alignment.BottomCenter),
            )
        }
    }
}