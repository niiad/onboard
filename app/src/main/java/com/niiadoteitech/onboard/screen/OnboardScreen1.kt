package com.niiadoteitech.onboard.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

import com.niiadoteitech.onboard.R

@Composable
fun OnboardScreen1() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

    }
}

@Composable
fun OnboardScreen1Item(
    title: String,
    subTitle: String,
    description: String,
    image: Painter
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (titleRef, subTitleRef, descriptionRef, imageRef) = createRefs()

        Text(
            text = title,
            modifier = Modifier
                .constrainAs(ref = titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Blue
        )

        Text(
            text = subTitle,
            modifier = Modifier
                .constrainAs(ref = subTitleRef) {
                    top.linkTo(titleRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .constrainAs(ref = imageRef) {
                    top.linkTo(subTitleRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints

                    width = Dimension.value(dp = 0.dp)
                    height = Dimension.value(dp = 0.dp)
                },
            contentScale = ContentScale.Crop
        )

        Text(
            text = description,
            modifier = Modifier
                .constrainAs(ref = descriptionRef) {
                    top.linkTo(imageRef.bottom)
                    start.linkTo(imageRef.start)
                    end.linkTo(imageRef.end)
                },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue
        )
    }
}

@Preview
@Composable
fun OnBoardScreen1ItemPreview() {
    val title = "Create an account"
    val subTitle = "Connect with people around the world"
    val description = "Users will be able to give you live, chat and meet people nearby"
    val image = painterResource(id = R.drawable.ob1_1)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        OnboardScreen1Item(
            title = title,
            subTitle = subTitle,
            description = description,
            image = image
        )
    }
}