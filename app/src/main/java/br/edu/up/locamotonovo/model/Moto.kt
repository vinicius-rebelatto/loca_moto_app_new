package br.edu.up.locamotonovo.model

data class Moto(
    var titulo: String,
    var descricao: String,
    var valorlocacao: Double,
    var id: Int? = null
)
