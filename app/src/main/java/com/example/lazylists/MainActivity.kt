package com.example.lazylists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazylists.ui.theme.LazyListsTheme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyListsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun StudentList(modifier: Modifier = Modifier) {
    val students = listOf(
        "Alice", "Bob", "Charlie", "Dana", "Eric",
        "Fatima", "Grace", "Hiro", "Isabel", "Jack",
        "Karen", "Luis", "Maya", "Nate", "Olivia",
        "Priya", "Quinn", "Ravi", "Sara", "Tom"
    )
    // only renders visible items
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(students) { name ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    LazyListsTheme {
        StudentList()
    }
}