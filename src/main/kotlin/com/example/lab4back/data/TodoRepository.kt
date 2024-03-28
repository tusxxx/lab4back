package com.example.lab4back.data

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<TodoItem, Long>