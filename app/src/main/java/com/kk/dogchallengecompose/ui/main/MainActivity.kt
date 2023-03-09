package com.kk.dogchallengecompose.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.kk.dogchallengecompose.ui.theme.DogChallengeComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogChallengeComposeTheme {
                val vm : MainViewModel = viewModel()
                Main(vm)
            }
        }
    }
}

@Composable
fun Main(vm: MainViewModel) {
    
    val state = remember { vm.state }
    val context = LocalContext.current
    
    when(val result = state.value){
        is MainViewState.Error -> {
            Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
        }
        MainViewState.Idle -> {}
        is MainViewState.Success -> {
            DogView(url = result.img) {
                vm.getDog()
            }
        }
        else -> {
            Toast.makeText(context, "Que paso?, QUE PASO?", Toast.LENGTH_LONG).show()
        }
    }
}

@Composable
fun DogView(url: String, onClick : () -> Unit){

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = rememberAsyncImagePainter(model = url), contentDescription = "dog", modifier = Modifier.fillMaxWidth().height(400.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onClick.invoke() }){
            Text(text = "Get New Dog")
        }
    }
}