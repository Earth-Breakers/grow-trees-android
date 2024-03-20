package univ.earthbreaker.namu.feature.book.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.woong.compose.grid.SimpleGridCells
import io.woong.compose.grid.VerticalGrid
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun CharacterTypeItem(
    characterCategory: String,
    userCharacters: List<String>,
    totalCharacterCount: Int,
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = characterCategory,
                color = GTTheme.colors.gray5,
                style = GTTheme.typography.detailSemiBold14,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier.background(
                    color = GTTheme.colors.green2,
                    shape = RoundedCornerShape(60.dp),
                ),
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    text = "${userCharacters.size}/$totalCharacterCount",
                    style = GTTheme.typography.detailBold11,
                    color = GTTheme.colors.green1,
                )
            }
        }
        Spacer(modifier = Modifier.height(13.dp))
        VerticalGrid(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = GTTheme.colors.gray2,
                    shape = RoundedCornerShape(10.dp),
                )
                .padding(vertical = 10.dp, horizontal = 3.dp),
            columns = SimpleGridCells.Fixed(4),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            userCharacters.forEachIndexed { index, url ->
                Column {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 7.dp)
                            .aspectRatio(1f),
                        model = url,
                        contentDescription = null,
                    )
                    if (index !in (totalCharacterCount - totalCharacterCount % 4) until totalCharacterCount) {
                        Spacer(modifier = Modifier.height(14.dp))
                    }
                }
            }
            repeat(totalCharacterCount - userCharacters.size) { index ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 7.dp)
                            .aspectRatio(1f)
                            .background(
                                color = GTTheme.colors.bg3Black,
                                shape = RoundedCornerShape(10.dp),
                            )
                            .padding(16.dp),
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                    )

                    if (index !in (totalCharacterCount - totalCharacterCount % 4) until totalCharacterCount) {
                        Spacer(modifier = Modifier.height(14.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CharacterTypeItemPreview() {
    CharacterTypeItem(
        characterCategory = "아름다움",
        userCharacters = emptyList(),
        totalCharacterCount = 7,
    )
}
