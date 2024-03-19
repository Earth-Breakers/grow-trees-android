package univ.earthbreaker.namu.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import univ.earthbreaker.namu.R

@Composable
fun TreeEnergyCard(currentEnergy: Int, requiredEnergy: Int) {
    Row {
        repeat(requiredEnergy) { index ->
            Image(
                painter = painterResource(
                    id = if (index < currentEnergy) {
                        R.drawable.ic_filled_required_energy
                    } else {
                        R.drawable.ic_empty_required_energy
                    },
                ),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun TreeEnergyCardPreview() {
    TreeEnergyCard(currentEnergy = 1, requiredEnergy = 3)
}
