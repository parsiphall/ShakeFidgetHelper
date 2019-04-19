package com.example.parsiphal.shakefidgethelper.fragment

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_dungeon_detail_item.view.*

class DungeonDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val stage = view.dungeon_detail_stage_number!!
    val name = view.dungeon_detail_enemy_name!!
    val level = view.dungeon_detail_enemy_level!!
    val role = view.dungeon_detail_enemy_class!!
    val health = view.dungeon_detail_enemy_health!!
    val strength = view.dungeon_detail_enemy_strength!!
    val agility = view.dungeon_detail_enemy_agility!!
    val intellegence = view.dungeon_detail_enemy_intellegence!!
    val vitality = view.dungeon_detail_enemy_vitality!!
    val luck = view.dungeon_detail_enemy_luck!!
    val experience = view.dungeon_detail_enemy_experience!!
}