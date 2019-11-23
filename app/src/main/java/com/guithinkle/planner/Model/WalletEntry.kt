package com.guithinkle.planner.Model

import java.time.LocalDate

data class WalletEntry (val id: Int,
                        var name: String,
                        var date: LocalDate,
                        var description: String,
                        var amount: Int)


/*		○ id: serial
		○ name: string
		○ date: datetime
		○ description: string
amount: int*/