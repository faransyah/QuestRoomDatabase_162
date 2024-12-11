package com.example.myapplication.dependeciesinjection

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override  val  repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswa())
    }
}