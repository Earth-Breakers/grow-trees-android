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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.compose.noRippleClickable
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun OpenDialogCard(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .width(62.dp)
            .height(26.dp)
            .background(color = GTTheme.colors.bgBlack, shape = RoundedCornerShape(100.dp))
            .noRippleClickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 13.dp),
            text = text,
            color = GTTheme.colors.white,
            style = GTTheme.typography.detailMedium12,
        )
        Icon(
            modifier = Modifier.padding(start = 4.dp, end = 6.dp),
            painter = painterResource(id = R.drawable.ic_right_arrow),
            contentDescription = null,
            tint = GTTheme.colors.gray2
        )
    }
}

@Preview
@Composable
fun OpenDialogCardPreview() {
    OpenDialogCard(stringResource(id = R.string.book)) {}
}
