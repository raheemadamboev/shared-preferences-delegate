package xyz.teamgravity.sharedpreferencesdelegate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import xyz.teamgravity.sharedpreferencesdelegate.ui.theme.SharedPreferencesDelegateTheme

class MainActivity : ComponentActivity() {

    private var name by sharedPreferences("name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("raheem", "onCreate: $name")
        name = "pump it"
        Log.d("raheem", "onCreate: $name")
        setContent {
            SharedPreferencesDelegateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}