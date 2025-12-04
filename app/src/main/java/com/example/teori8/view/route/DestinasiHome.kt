package com.example.teori8.view.route
import com.example.teori8.R
object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"

}