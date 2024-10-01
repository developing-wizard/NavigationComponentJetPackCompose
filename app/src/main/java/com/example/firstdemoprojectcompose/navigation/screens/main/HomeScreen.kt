package com.example.firstdemoprojectcompose.navigation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.firstdemoprojectcompose.R
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.yellow


@Composable
fun HomeScreen(navHostController: NavHostController,innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        val (mainCard, moreAboutBenz, infoText, featureBannerCard, featureBannerImage, featureBannerText, featureCars, featureCarText, relatedCarText, relatedCars) = createRefs()
        Card(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(0.9f)
                .background(Color.Transparent)
                .constrainAs(mainCard) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }, shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mercedes_logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.Yellow
                    ),
                contentScale = ContentScale.Crop
            )

        }
        Text(
            text = "Featured Cars",
            color = Color.White,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(featureCarText) {
                top.linkTo(mainCard.bottom, margin = 10.dp)
                start.linkTo(mainCard.start)
            })
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .fillMaxWidth(0.9f)
                .height(170.dp)
                .constrainAs(featureBannerCard) {
                    top.linkTo(featureCarText.bottom, margin = 15.dp)
                    start.linkTo(featureCarText.start)
                },
            // border = BorderStroke(2.dp,Color.White)
        ) {
            ConstraintLayout {
                Image(
                    painter = painterResource(id = R.drawable.car5),
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            Color.Black
                        )
                        .fillMaxSize()
                        .constrainAs(featureBannerImage) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Mercedes S Class",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(featureBannerText) {
                            bottom.linkTo(featureBannerImage.bottom, margin = 5.dp)
                            start.linkTo(featureBannerImage.start, margin = 10.dp)
                        })
            }


        }
        Box(
            modifier = Modifier
                .background(color = Color.Transparent)
                .constrainAs(featureCars) {
                    top.linkTo(featureBannerCard.bottom, margin = 15.dp)
                    start.linkTo(featureBannerCard.start)
                }) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(getListData()) { item ->
                    FeatureRecyclerItem(item)
                }
            }
        }
        Text(
            text = "Related Cars",
            color = Color.White,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(relatedCarText) {
                top.linkTo(featureCars.bottom, margin = 15.dp)
                start.linkTo(featureCars.start)
            })
        Box(
            modifier = Modifier
                .background(color = Color.Transparent)
                .height(220.dp)
                .constrainAs(relatedCars) {
                    top.linkTo(relatedCarText.bottom, margin = 10.dp)
                    start.linkTo(relatedCarText.start)
                }) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(getListData()) { item ->
                    RelatedRecyclerItem(item)
                }
            }
        }
        Text(text = "Mercedes-Benz, a well-known luxury automobile manufacturer, offers a range of advanced features across its vehicles.\nThese features highlight the blend of luxury, technology, and performance that Mercedes-Benz vehicles offer, aiming to provide a superior driving experience.",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(infoText) {
                    top.linkTo(relatedCars.bottom)
                    start.linkTo(relatedCarText.start)
                    end.linkTo(parent.end)
                })
        Box(
            modifier = Modifier.padding(bottom = 10.dp)
                .constrainAs(moreAboutBenz) {
                    top.linkTo(infoText.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(RoundedCornerShape(12.dp))
                .background(yellow)
        ) {
            TextButton(onClick = {
                navHostController.navigate(Graph.HomeGraph)
            }) {
                Text(text = "More About Benz", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)

            }
        }


    }

}

data class CarList(val name: String, val imageCar: Int) {
}

@Composable
fun FeatureRecyclerItem(items: CarList) {
    ConstraintLayout {
        val (card, image, text) = createRefs()
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .size(150.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            // border = BorderStroke(2.dp,Color.White)
        ) {
            ConstraintLayout {
                Image(
                    painter = painterResource(id = items.imageCar),
                    contentDescription = "",
                    modifier = Modifier
                        .background(
                            Color.Black
                        )
                        .fillMaxSize()
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = items.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(text) {
                            bottom.linkTo(image.bottom, margin = 5.dp)
                            start.linkTo(image.start, margin = 10.dp)
                        })
            }


        }
    }


}

@Composable
fun RelatedRecyclerItem(items: CarList) {
    ConstraintLayout {
        val (card, image, text) = createRefs()
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .fillMaxWidth(0.9f)
                .height(150.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top, margin = 5.dp)
                    start.linkTo(parent.start, margin = 5.dp)
                    bottom.linkTo(parent.bottom, margin = 5.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                },
            // border = BorderStroke(2.dp,Color.White)
        ) {
            ConstraintLayout {
                Image(
                    painter = painterResource(id = items.imageCar),
                    contentDescription = "",
                    modifier = Modifier
                        .background(
                            Color.Black
                        )
                        .fillMaxSize()
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = items.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(text) {
                            top.linkTo(image.top, margin = 5.dp)
                            start.linkTo(image.start, margin = 10.dp)
                        })
            }


        }
    }


}

fun getListData(): MutableList<CarList> {
    val list = mutableListOf<CarList>()
    list.add(
        CarList("Benz CL63", R.drawable.car1),
    )
    list.add(
        CarList("Kompossor 200", R.drawable.car2),

        )
    list.add(
        CarList("AMG CL64", R.drawable.car3)
    )
    list.add(
        CarList("Kompossor 200", R.drawable.car4),

        )
    list.add(
        CarList("AMG CL64", R.drawable.car5)
    )
    return list
}