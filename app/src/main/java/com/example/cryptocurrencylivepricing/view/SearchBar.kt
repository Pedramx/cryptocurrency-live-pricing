package com.example.cryptocurrencylivepricing.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencylivepricing.model.Ticker

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit,
              tickersList:List<Ticker>, onListChanged: (List<Ticker>) -> Unit) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        value = query,
        onValueChange = { newValue ->
            onQueryChanged(newValue)
            onListChanged(tickersList)
                        },
        label = {
            Text(text = "Search")
                },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {keyboardController?.hide()}),
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
        },
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    )
}