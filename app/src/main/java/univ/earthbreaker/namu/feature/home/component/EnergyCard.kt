package univ.earthbreaker.namu.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun EnergyCard(energyCount: Int = 0) {
    Row(
        modifier = Modifier
            .width(62.dp)
            .height(26.dp)
            .background(color = GTTheme.colors.green1, shape = RoundedCornerShape(100.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 11.dp),
            painter = painterResource(id = R.drawable.ic_energy),
            contentDescription = null,
            tint = GTTheme.colors.white,
        )
        Text(
            modifier = Modifier
                .padding(start = 7.dp, end = 12.dp)
                .weight(1f),
            text = energyCount.toString(),
            style = GTTheme.typography.detailMedium14,
            color = GTTheme.colors.white,
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
fun EnergyCardPreview() {
    EnergyCard()
}
