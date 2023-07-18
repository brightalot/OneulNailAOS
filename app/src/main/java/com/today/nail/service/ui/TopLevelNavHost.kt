package com.today.nail.service.ui

import android.window.SplashScreen
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.activity
import com.autocrypt.move.kcallpax.extension.fadeComposable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.today.nail.service.ui.scenario.onBoarding.navigationGraph.onBoardingNavigationGraph
import com.today.nail.service.ui.scenario.reuseComponent.view.nailItemDetail.ReUseComponentNailItemDetailViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopLevelNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
    topLevelViewModel: TopLevelViewModel,
    onFinish: () -> Unit
) {
    val fadeDuration = 300

    AnimatedNavHost(
        navController = navHostController,
        startDestination = TopLevelNavigationRoutes.SplashGraph.routes,
        modifier = modifier
    ) {
        fadeComposable(
            duration = fadeDuration,
            route = TopLevelNavigationRoutes.SplashGraph.routes
        ) {
            SplashView(
                activityViewModel = topLevelViewModel,
                navHostController = navHostController
            )
        }

        onBoardingNavigationGraph(
            navHostController = navHostController,
            activityViewModel = topLevelViewModel
        )
    }

}

