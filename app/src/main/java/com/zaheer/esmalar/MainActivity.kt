package com.zaheer.esmalar//Esmalar

import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaheer.esmalar.NameMap.getMappedName
import com.zaheer.esmalar.ui.theme.EsmalarTheme
import androidx.core.content.edit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EsmalarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Greeting(innerPadding: PaddingValues) {
    val context = LocalContext.current

    // SharedPreferences کا ہینڈل
    val sharedPref = remember {
        context.getSharedPreferences("EsmalarPrefs", Context.MODE_PRIVATE)
    }

    // 1. ایپ کھلتے ہی سیو شدہ ٹیکسٹ کو ری سٹور (Restore) کریں
    var textInput by remember {
        mutableStateOf(sharedPref.getString("saved_text_input", "اللہ") ?: "اللہ")
    }
    var hukam by remember {
        mutableStateOf(
            "Allahümme sehhır ve harık kalbe fülanın(i) fülânete " +
                    "(yahut fülâne binti fülânete) bi muhabbeti ve aşkı hattâ sâra kel mecnûn"
        )
    }
    LaunchedEffect(textInput) {
        sharedPref.edit { putString("saved_text_input", textInput) }
    }
    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE0F2F1), // اوپر کا رنگ (Purple)
                        Color(0xFF03DAC5)  // نیچے کا رنگ (Teal / Cyan)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            OutlinedTextField(
                value = textInput,
                onValueChange = { input ->
                    textInput = input
                    //save to pref and restore next time always
                },
                label = { Text("Bir isim girin") }, //Enter a name

                textStyle = TextStyle(
                    fontSize = 20.sp, // Set your desired font size here
                    textAlign = TextAlign.Center,
                ),
                trailingIcon = {
                    if (textInput.isNotEmpty()) {
                        IconButton(onClick = { textInput = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear text"
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = getMappedName(textInput),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // 3. Output Text displaying the current input
            if (textInput.isNotBlank()) {
                BasicTextField(
                    value = hukam,
                    onValueChange = { input ->
                        hukam = input
                    },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EsmalarTheme {
        Greeting(innerPadding = PaddingValues(10.dp))
    }
}