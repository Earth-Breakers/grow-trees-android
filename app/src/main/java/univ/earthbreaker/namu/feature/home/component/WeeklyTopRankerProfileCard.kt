package univ.earthbreaker.namu.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun WeeklyTopRankerProfileCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(
            color = GTTheme.colors.bgBlack, shape = RoundedCornerShape(15.dp)
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 12.dp, start = 20.dp, end = 20.dp, bottom = 5.dp),
            painter = painterResource(id = R.drawable.img_top_ranker_mock),
            contentDescription = null
        )
        Row(
            modifier = Modifier.padding(horizontal = 9.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_crown),
                contentDescription = null,
                tint = GTTheme.colors.blue1
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, bottom = 10.dp),
                text = "금주의 나무왕",
                style = GTTheme.typography.detailMedium10,
                color = GTTheme.colors.blue2
            )
        }
    }
}

@Preview
@Composable
fun WeeklyTopRankerProfileCardPreview() {
    WeeklyTopRankerProfileCard()
}

