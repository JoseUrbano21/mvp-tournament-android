package com.pkm.mvptournament.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pkm.mvptournament.ui.theme.BgNav
import com.pkm.mvptournament.ui.theme.MVPBrushes
import com.pkm.mvptournament.ui.theme.MVPTournamentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState: ScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Pokémon MVP Tournament",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = BgNav
                )
            }
        },

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                    )

                    Icon(
                        imageVector = Icons.Rounded.Home,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                    )
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            SectionTitleLarge(
                """
                RISING TO THE TOP
                """.trimIndent()
            )

            SectionBodyLarge("6 POKÉMON. 1 WINNER")

            SectionBodyMedium(
                """Watch the contestants compete
                |to become the Regional MVP
                |and earn their place in the
                |HALL OF FAME""".trimMargin()
            )

            SectionTitleLarge(
                """
                    LET THE TOURNAMENT BEGIN!
                """.trimIndent()
            )

            SectionBodyLarge("13 CHALLENGES AHEAD")

            SectionBodyMedium(
                """8 Gym leaders, the Elite Four and the Champion.
               |Only the contestant with the most points will be crowned
               |
               |THE WINNER!""".trimMargin()
            )

            ExpandableCard(
                "RULE #1",
                """Each contestant must face every challenge INDIVIDUALLY at the pertinent LEVEL CAP"""
            )

            ExpandableCard(
                "RULE #2",
                """Each rival pokémon defeated during a challenge earns 1 POINT for the contestant"""
            )

            ExpandableCard(
                "RULE #3",
                """Contestants may SWITCH during their challenge, but any foe defeated by another contestant will NOT count as a point"""
            )
        }
    }
}

@Composable
fun SectionTitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    lineBrush: Brush = MVPBrushes.dividerGlow(),
    lineThickness: Dp = 2.dp
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 40.dp, end = 16.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(lineThickness)
                .background(lineBrush),
        )
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(lineThickness)
                .background(lineBrush)
        )
    }
}

@Composable
fun SectionBodyLarge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun SectionBodyMedium(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun ExpandableCard(cardTitle: String, cardDescription: String) {
    var expanded by remember { mutableStateOf(false) }
    var angle by remember { mutableFloatStateOf(0f) }

    Card(
        onClick = {
            expanded = !expanded
            angle = angle + 180
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(angle)
                )
                Text(cardTitle)
            }

            AnimatedVisibility(expanded) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .padding(16.dp),
                    contentAlignment = Alignment.TopStart
                ) {

                    Text(
                        text = cardDescription,
                        modifier = Modifier,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MVPTournamentTheme {
        HomeScreen(navController = rememberNavController())
    }
}
