package univ.earthbreaker.namu.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.noRippleClickable(
    enabled: Boolean = true,
    onClick: () -> Unit,
): Modifier = composed {
    this.noRippleClickable(
        interactionSource = remember { MutableInteractionSource() },
        enabled = enabled,
        onClick = onClick,
    )
}

fun Modifier.noRippleClickable(
    interactionSource: MutableInteractionSource,
    enabled: Boolean = true,
    onClick: () -> Unit,
): Modifier = this.clickable(
    interactionSource = interactionSource,
    indication = null,
    enabled = enabled,
) {
    onClick()
}
