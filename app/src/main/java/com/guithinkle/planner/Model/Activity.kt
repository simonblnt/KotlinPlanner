package com.guithinkle.planner.Model

import java.time.LocalDate

data class Activity(val id: Int,
                    var name: String,
                    var start_date: LocalDate,
                    var endDate: LocalDate,
                    var description: String,
                    var categoryId: Int,
                    val walletId: Int?)
