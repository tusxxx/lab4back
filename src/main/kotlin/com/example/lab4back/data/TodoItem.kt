package com.example.lab4back.data

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TodoItem(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val text: String = "",
        @ElementCollection
        val subtasksIds: List<String> = emptyList(),
        val state: Boolean = false
)
