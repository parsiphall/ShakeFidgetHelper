package com.example.parsiphal.shakefidgethelper.fragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.parsiphal.shakefidgethelper.R
import com.example.parsiphal.shakefidgethelper.date.DungeonTable
import java.text.MessageFormat

class DungeonDetailAdapter(private var items: List<DungeonTable>, private val context: Context?) :
    RecyclerView.Adapter<DungeonDetailViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DungeonDetailViewHolder {
        return DungeonDetailViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.fragment_dungeon_detail_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DungeonDetailViewHolder, position: Int) {
        holder.stage.text = MessageFormat.format(
            context!!.resources.getString(R.string.dungeon_stage_number),
            items[position].stageNumber.toString()
        )
        holder.name.text = items[position].enemyName
        holder.level.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_level), items[position].level)
        holder.role.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_class), items[position].role)
        holder.health.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_health), items[position].health)
        holder.strength.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_strength), items[position].strength)
        holder.agility.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_agility), items[position].agility)
        holder.intellegence.text = MessageFormat.format(
            context.resources.getString(R.string.dungeon_intellegence),
            items[position].intellegence
        )
        holder.vitality.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_vitality), items[position].vitality)
        holder.luck.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_luck), items[position].luck)
        holder.experience.text =
            MessageFormat.format(context.resources.getString(R.string.dungeon_experience), items[position].experience)
    }

    fun dataChanged(newItems: List<DungeonTable>) {
        items = newItems
        notifyDataSetChanged()
    }
}