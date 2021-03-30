package com.example.financask.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.model.Resumo
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {
}