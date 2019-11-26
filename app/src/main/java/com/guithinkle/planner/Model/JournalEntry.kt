package com.guithinkle.planner.Model

import java.time.LocalDate

data class JournalEntry(val id: Int,
                        var name: String,
                        var start_date: String,
                        var endDate: String,
                        var description: String,
                        var category: String,
                        val walletAmount: Int)
