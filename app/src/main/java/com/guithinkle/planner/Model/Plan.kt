package com.guithinkle.planner.Model

import java.time.LocalDate

data class Plan(val id: Int,
                var name: String,
                var date: LocalDate?,
                var description: String,
                var categoryId: Int,
                val activityId: Int?,
                var completed: Boolean)