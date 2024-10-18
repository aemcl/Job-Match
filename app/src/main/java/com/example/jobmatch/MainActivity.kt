package com.example.jobmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jobmatch.employer.EmployerCompanyProfile
import com.example.jobmatch.employer.JobCredentials
import com.example.jobmatch.employer.JobToOffer
import com.example.jobmatch.employer.RecommendedWorkers
import com.example.jobmatch.employer.WorkInformation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.home, builder = {
                composable(Routes.home) {
                    Home(navController)
                }

                composable(Routes.login) {
                    LogIn(navController)
                }

                composable(Routes.forgotpass) {
                    ForgotPassword(navController)
                }

                composable(Routes.signup) {
                    SignUp(navController)
                }

                composable(Routes.createprofile) {
                    EmployerCompanyProfile(navController)
                }

                composable(Routes.jobtoOffer) {
                    JobToOffer(navController)
                }

                composable(Routes.workinformation) {
                    WorkInformation(navController)
                }

                composable(Routes.jobcredentials) {
                   JobCredentials(navController)
                }

                composable(Routes.recoWorkers) {
                    RecommendedWorkers(navController)
                }
            })
        }
    }
}

