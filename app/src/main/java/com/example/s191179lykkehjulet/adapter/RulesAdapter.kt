package com.example.s191179lykkehjulet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.model.Rules

class RulesAdapter() : RecyclerView.Adapter<RulesAdapter.RulesViewHolder>() {

    val rules = listOf<Rules>(
        Rules(R.string.rule1),
        Rules(R.string.rule2),
        Rules(R.string.rule3),
        Rules(R.string.rule4),
        Rules(R.string.rule5),
        Rules(R.string.rule6),
        Rules(R.string.rule7),
        Rules(R.string.rule8),
        Rules(R.string.rule9),
        Rules(R.string.rule10),
        Rules(R.string.rule11),
        Rules(R.string.rule12),
        Rules(R.string.rule13)
    )

    class RulesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.rules_view)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RulesViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rules_view, parent, false)
        return RulesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RulesViewHolder, position: Int) {
        val ruleitem = rules[position]
        holder.textView.setText(ruleitem.StringResourceId)
    }

    override fun getItemCount(): Int {
        return rules.size
    }


}