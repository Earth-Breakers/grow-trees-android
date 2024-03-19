package univ.earthbreaker.namu.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.feature.home.component.EnergyCard
import univ.earthbreaker.namu.feature.home.component.OpenDialogCard
import univ.earthbreaker.namu.feature.home.component.WeeklyTopRankerProfileCard
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun HomeScreen(level: Int, exp: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GTTheme.colors.bgBlack),
    ) {
        Row(
            modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Lv. $level",
                style = GTTheme.typography.detailBold11,
                color = GTTheme.colors.white,
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 7.dp)
                    .height(11.dp)
                    .clip(RoundedCornerShape(20.dp)),
                progress = exp,
                color = GTTheme.colors.green1,
                trackColor = GTTheme.colors.bg2Black,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                WeeklyTopRankerProfileCard()
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(
                    text = stringResource(R.string.adding_friends),
                    onClick = {},
                    width = 85.dp,
                )
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(
                    text = stringResource(R.string.guestbook),
                    onClick = {},
                    width = 70.dp,
                )
            }
            Column {
                EnergyCard()
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(text = stringResource(R.string.book), onClick = {})
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(text = stringResource(R.string.mission), onClick = {})
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(text = stringResource(R.string.my), onClick = {})
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(text = stringResource(R.string.notification), onClick = {})
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(level = 1, exp = 0.7f)
}
