package pro.ksart.tmdbmoviescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pro.ksart.tmdbmoviescompose.ui.theme.TMDBMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBMoviesTheme {
            }
        }
    }
}
