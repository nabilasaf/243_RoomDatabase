package com.example.teori8.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teori8.view.route.DestinasiHome
import com.example.teori8.viewmodel.HomeViewModel
import com.example.teori8.viewmodel.provider.PenyediaViewModel
import com.example.teori8.R
import com.example.teori8.room.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
Scaffold (modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        SiswaTopAppBar(
            title = stringResource(id = R.string.app_name),
            canNavigateBack = false,
            scrollBehavior = scrollBehavior
        )
    },
    floatingActionButton = {
        FloatingActionButton(
            onClick = navigateToItemEntry,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.entry_siswa)
            )
        }
    },
) { innerPadding ->
    val uiStateSiswa by viewModel.homeUiState.collectAsState()
    BodyHome(
        itemSiswa = uiStateSiswa.listSiswa,
        modifier = modifier
            .padding(innerPadding)
            .fillMaxSize()
    )
}
}

@Composable
fun BodyHome(
    itemSiswa : List<Siswa>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier

    ) {
        if (itemSiswa.isEmpty()) {
            Text(
                text = stringResource(id = R.string.deskripsi_no_item),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }
        else{
            ListSiswa(
                itemSiswa = itemSiswa,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
        }
    }
@Composable
fun ListSiswa(
    itemSiswa: List<Siswa>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = itemSiswa, key = { it.id }) { person ->
            DataSiswa(
                siswa = person,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun DataSiswa(siswa: Siswa, modifier: Modifier) {
    TODO("Not yet implemented")
}