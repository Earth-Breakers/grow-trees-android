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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.feature.home.component.EnergyCard
import univ.earthbreaker.namu.feature.home.component.OpenDialogCard
import univ.earthbreaker.namu.feature.home.component.WeeklyTopRankerProfileCard
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GTTheme.colors.bgBlack),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            WeeklyTopRankerProfileCard()
            Column {
                EnergyCard()
                Spacer(Modifier.height(5.dp))
                OpenDialogCard(text = stringResource(R.string.book)) { /* TODO */ }
                Spacer(Modifier.height(5.dp))
                OpenDialogCard(text = stringResource(R.string.my)) { /* TODO */ }
                Spacer(Modifier.height(5.dp))
                OpenDialogCard(text = stringResource(R.string.mission)) { /* TODO */ }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
