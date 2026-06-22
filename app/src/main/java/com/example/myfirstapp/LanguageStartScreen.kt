package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageStartScreen() {
    var showMainContent by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showMainContent) {
            // 1. LANGUAGE SELECTION VIEW
            Text(
                text = stringResource(id = R.string.select_lang), 
                fontSize = 22.sp, 
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))
            
            val buttonColor = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
            
            Button(onClick = { changeLanguage("en"); showMainContent = true }, colors = buttonColor) { Text("English", fontSize = 18.sp) }
            Spacer(modifier = Modifier.height(10.dp))
            
            Button(onClick = { changeLanguage("ur"); showMainContent = true }, colors = buttonColor) { Text("اردو", fontSize = 18.sp) }
            Spacer(modifier = Modifier.height(10.dp))
            
            Button(onClick = { changeLanguage("es"); showMainContent = true }, colors = buttonColor) { Text("Español", fontSize = 18.sp) }
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { changeLanguage("ar"); showMainContent = true }, colors = buttonColor) { Text("العربية", fontSize = 18.sp) }
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { changeLanguage("de"); showMainContent = true }, colors = buttonColor) { Text("Deutsch", fontSize = 18.sp) }
        } else {
            // 2. MAIN APP CONTENT VIEW
            Text(
                text = stringResource(id = R.string.intro_title), 
                fontSize = 28.sp, 
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007AFF)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.intro_body), 
                fontSize = 18.sp,
                lineHeight = 26.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            
            // YouTube Channel Buttons
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF0000))
            ) {
                Text("Visit @McetetcraYEAY2", color = Color.White)
            }
            Spacer(modifier = Modifier.height(10.dp))
            
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF0000))
            ) {
                Text("Visit @redball4gameplay-All", color = Color.White)
            }
            Spacer(modifier = Modifier.height(30.dp))
            
            Button(
                onClick = { showMainContent = false },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Back / پیچھے جائیں")
            }
        }
    }
}

fun changeLanguage(languageCode: String) {
    val appLocale = LocaleListCompat.forLanguageTags(languageCode)
    AppCompatDelegate.setApplicationLocales(appLocale)
}
