package com.example.teori8.repositori

import com.example.teori8.room.Siswa
import com.example.teori8.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositorySiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositorySiswa(
    private val siswaDao: SiswaDao
) : RepositorySiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}