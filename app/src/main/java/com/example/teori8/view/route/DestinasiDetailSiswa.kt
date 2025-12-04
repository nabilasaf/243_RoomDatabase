package com.example.teori8.view.route

import com.example.teori8.R

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "item_detail"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}


