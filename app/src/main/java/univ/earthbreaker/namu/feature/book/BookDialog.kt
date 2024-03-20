package univ.earthbreaker.namu.feature.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.compose.CommonDialogWithXIcon
import univ.earthbreaker.namu.feature.book.component.CharacterTypeItem
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun BookDialog(modifier: Modifier = Modifier, characterCount: Int = 0, onDismissRequest: () -> Unit) {
    val mockCharacterCategoryList = listOf("아름다움", "생명력", "정화력", "아름다움")

    CommonDialogWithXIcon(
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = modifier.padding(top = 22.dp, bottom = 10.dp),
                text = stringResource(id = R.string.book),
                style = GTTheme.typography.titleSemiBold16,
            )
            Row(
                modifier = Modifier
                    .background(
                        color = GTTheme.colors.blue2,
                        shape = RoundedCornerShape(60.dp),
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "전체 획득 수",
                    style = GTTheme.typography.detailMedium12,
                    color = GTTheme.colors.gray6,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    characterCount.toString(),
                    style = GTTheme.typography.detailSemiBold14,
                    color = GTTheme.colors.blue1,
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            LazyColumn(modifier = Modifier.fillMaxHeight(0.7f)) {
                items(mockCharacterCategoryList) {
                    CharacterTypeItem(
                        characterCategory = it,
                        userCharacters = emptyList(),
                        totalCharacterCount = 7,
                    )
                    Spacer(modifier = Modifier.height(27.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun BookContentPreview() {
    BookDialog(onDismissRequest = {})
}
