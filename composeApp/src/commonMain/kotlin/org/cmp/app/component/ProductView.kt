package org.cmp.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.cmp.app.core.domain.model.Product
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProductView(product: Product) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.LightGray),
                onError = {
                    println("Image failed to load: ${it.result.throwable.message}")
                }
            )

            Text(
                text = product.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )

            Text(
                text = product.department,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            Text(
                text = product.description,
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Credit Line: ${product.creditLine}",
                fontSize = 12.sp,
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview
@Composable
fun ProductSkeletonView() {
    LazyColumn {
        repeat(5) {
            item {
                Spacer(Modifier.size(2.5.dp))
                ProductSkeletonViewItem()
                Spacer(Modifier.size(2.5.dp))
            }
        }
    }
}

@Preview
@Composable
fun ProductSkeletonViewItem() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(24.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(18.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(14.dp)
                            .background(
                                brush = shimmerBrush(targetValue = 1300f),
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(12.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    }
}


@Preview
@Composable
fun ProductViewPreview() {
    MaterialTheme {
        ProductView(
            product = Product(
                creditLine = "Maria DeWitt Jesup Fund, 1959",
                department = "The American Wing",
                description = "Oil on wood",
                image = "https://images.metmuseum.org/CRDImages/ad/original/DT64.jpg",
                title = "Still Life with Cake"
            )
        )
    }
}