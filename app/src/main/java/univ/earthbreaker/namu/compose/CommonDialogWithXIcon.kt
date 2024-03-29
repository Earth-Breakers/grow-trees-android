package univ.earthbreaker.namu.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import univ.earthbreaker.namu.R
import univ.earthbreaker.namu.ui.theme.GTTheme

@Composable
fun CommonDialogWithXIcon(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties.let {
            DialogProperties(
                dismissOnBackPress = it.dismissOnBackPress,
                dismissOnClickOutside = it.dismissOnClickOutside,
                securePolicy = it.securePolicy,
                usePlatformDefaultWidth = false,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(GTTheme.colors.white)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                content()
            }

            Spacer(Modifier.height(23.dp))
            Box(
                modifier = Modifier
                    .size(size = 64.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
                    .background(GTTheme.colors.white)
                    .noRippleClickable(onClick = onDismissRequest),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_x),
                    contentDescription = null,
                    tint = GTTheme.colors.gray5,
                )
            }
        }
    }
}

@Preview
@Composable
fun CommonDialogWithXIconPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        CommonDialogWithXIcon(
            content = {
                Column {
                    repeat(15) {
                        Text(text = "Hello World!", style = GTTheme.typography.titleSemiBold20)
                    }
                }
            },
            onDismissRequest = {},
        )
    }
}
