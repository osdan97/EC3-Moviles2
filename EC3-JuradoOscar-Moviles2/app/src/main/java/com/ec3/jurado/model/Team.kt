package com.ec3.jurado.model

data class Team (
    val team_id: Int,
    val rating: Int,
    val wins: Int,
    val losses: Int,
    val name: String,
    val tag: String,
   )