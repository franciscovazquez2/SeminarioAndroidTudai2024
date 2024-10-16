package ar.edu.unicen.seminario

import android.app.Application//primera en ejecutarse de la aplicacion, antes de las activities
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SeminarioApp: Application() {
}