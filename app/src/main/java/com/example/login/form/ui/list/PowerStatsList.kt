import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.form.R
import com.example.viewmodels.MainViewModel

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PowerStatsList(
    id: Int,
    viewModel: MainViewModel,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val rotateState = animateFloatAsState(
        targetValue = if (expanded) 180F else 0F,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .selectable(
                    selected = expanded,
                    onClick = {
                        expanded = !expanded
                        onClick()
                    }
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Power statistics",
                fontSize = 20.sp
            )
            Icon(
                Icons.Default.ArrowDropDown, "",
                modifier = Modifier.rotate(rotateState.value),
            )
        }

        AnimatedVisibility(
            visible = expanded,
        ) {
            Column {
                IconRow(
                    text = "Power: ${viewModel.characterList[id].powerstats.power}",
                    iconId = R.drawable.ic_baseline_sports_mma_24
                )

                IconRow(
                    text = "Combat: ${viewModel.characterList[id].powerstats.combat}",
                    iconId = R.drawable.ic_baseline_sports_martial_arts_24
                )

                IconRow(
                    text = "Speed: ${viewModel.characterList[id].powerstats.speed}",
                    iconId = R.drawable.ic_baseline_directions_run_24
                )
            }
        }
    }
}

@Composable
fun IconRow(text: String, iconId: Int) {
    Row(Modifier.padding(10.dp)) {
        Text(
            text = text
        )
        Icon(
            painter = painterResource(iconId),
            contentDescription = null
        )
    }
}