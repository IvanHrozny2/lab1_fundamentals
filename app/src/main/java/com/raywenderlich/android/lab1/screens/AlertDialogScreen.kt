package com.raywenderlich.android.lab1.screens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

@Composable
fun AlertDialogScreen() {

    MyAlertDialog()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyAlertDialog() {
   val shouldShowDialog = remember { mutableStateOf(true) }

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
                FundamentalsRouter.navigateTo(Screen.Navigation)
            },
            title = { Text(text = stringResource(R.string.title_alertDialog)) },
            text = { Text(text = stringResource(R.string.alertDialog_about))},
            confirmButton = {
                Button(
                    colors = ButtonDefaults.run { buttonColors(backgroundColor = Color.Blue ) },
                    onClick = {}) {
                    Text(
                        text = stringResource(R.string.massage_button),
                        color = Color.White
                    )
                }
            }
        )

    }
}