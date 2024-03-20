package univ.earthbreaker.namu.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.feature.book.BookDialog
import univ.earthbreaker.namu.feature.home.component.OpenDialogCard
import univ.earthbreaker.namu.feature.home.component.TreeEnergyCard
import univ.earthbreaker.namu.feature.home.component.UserEnergyCard
import univ.earthbreaker.namu.feature.home.component.WeeklyTopRankerProfileCard
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun HomeScreen(level: Int, exp: Float, energyCount: Int, currentEnergy: Int, requiredEnergy: Int) {
    var doesBookDialogExist by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GTTheme.colors.bgBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        HomeTopCard(
            level,
            exp,
            energyCount,
            onBookClick = { doesBookDialogExist = true },
        )
        Image(
            painter = painterResource(id = R.drawable.img_mock_character),
            contentDescription = null,
        )
        HomeBottomCard(currentEnergy = currentEnergy, requiredEnergy = requiredEnergy)
    }

    if (doesBookDialogExist) {
        BookDialog(
            onDismissRequest = { doesBookDialogExist = false },
        )
    }
}

@Composable
fun HomeTopCard(
    level: Int,
    exp: Float,
    energyCount: Int,
    onBookClick: () -> Unit = {},
) {
    Column {
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
                    width = 72.dp,
                )
            }
            Column {
                UserEnergyCard(energyCount = energyCount)
                Spacer(Modifier.height(7.dp))
                OpenDialogCard(
                    text = stringResource(R.string.book),
                    onClick = onBookClick,
                )
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

@Composable
fun HomeBottomCard(currentEnergy: Int, requiredEnergy: Int) {
    val isReady = currentEnergy == requiredEnergy
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TreeEnergyCard(currentEnergy, requiredEnergy)
        Spacer(modifier = Modifier.height(52.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .background(
                    color = if (isReady) GTTheme.colors.green1 else GTTheme.colors.gray3,
                    shape = RoundedCornerShape(5.dp),
                )
                .clickable(enabled = isReady) { },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = if (isReady) "다음 단계로 성장하기" else "에너지가 2개 모자라요 !",
                style = GTTheme.typography.titleSemiBold18,
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(level = 1, exp = 0.7f, energyCount = 1, currentEnergy = 1, requiredEnergy = 3)
}

@Preview
@Composable
fun HomeTopCardPreview() {
    HomeTopCard(level = 1, exp = 0.7f, energyCount = 1)
}

@Preview
@Composable
fun HomeBottomCardPreview() {
    HomeBottomCard(currentEnergy = 1, requiredEnergy = 3)
}
