package com.pkm.mvptournament.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pkm.mvptournament.R
import com.pkm.mvptournament.navigation.Screen
import com.pkm.mvptournament.ui.theme.MVPTournamentTheme

@Composable
fun LoginScreen(navController: NavController) {
    val focus = LocalFocusManager.current // CHECK
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable( // CHECK
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { focus.clearFocus() }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 56.dp, vertical = 56.dp)
                .align(Alignment.Center)
                .imePadding() // DOING NOTHING
        ) {
            // CHECK THE NO LOADABLE PARTS IN SVG OR USE PNG
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.logo),
                contentDescription = "Pokémon MVP Tournament logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            )

            UserMailTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            UserPasswordTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.Home.route) {
                            // CHECK
                            popUpTo(Screen.Login.route) { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
                ) {
                    Text(
                        "LOG IN",
                        color = MaterialTheme.colorScheme.background,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Button(
                    onClick = { navController.navigate(Screen.Signup.route) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onBackground)
                ) {
                    Text(
                        "CREATE ACCOUNT",
                        color = MaterialTheme.colorScheme.background,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}

@Composable
fun UserMailTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        textStyle = MaterialTheme.typography.titleSmall,
        placeholder = { Text("Mail") },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

// CHECK
@Composable
fun UserPasswordTextField(modifier: Modifier = Modifier) {
    // ELEVATE A VIEWMODEL
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        modifier = modifier,
        textStyle = MaterialTheme.typography.titleSmall,
        placeholder = { Text("Password") },
        visualTransformation =
            if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MVPTournamentTheme {
        LoginScreen(navController = rememberNavController())
    }
}