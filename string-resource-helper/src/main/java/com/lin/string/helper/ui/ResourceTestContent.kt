package com.lin.string.helper.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lin.string.helper.R
import com.lin.string.helper.TextForUI

@Composable
internal fun ResourceTestContent(
    title: String,
    subtitle: TextForUI?,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        Text(
            text = title,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally),
            fontWeight = FontWeight.W900,
            color = Color.Black,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = stringResource(id = R.string.user_current_state),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Red
        )

        Text(
            text = stringResource(id = R.string.show_formatted_tips),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        subtitle?.let {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = it.asString(),
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color.Black
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ResourceTestContent("Android", TextForUI(R.string.title))
}
