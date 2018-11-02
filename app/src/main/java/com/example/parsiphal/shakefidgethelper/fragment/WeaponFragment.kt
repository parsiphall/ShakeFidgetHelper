package com.example.parsiphal.shakefidgethelper.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.parsiphal.shakefidgethelper.R
import kotlinx.android.synthetic.main.fragment_weapon.*

class WeaponFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weapon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weapon_button.setOnClickListener {
            clearRes()
            calculate()
        }
        weapon_clear_button.setOnClickListener {
            clear()
            clearRes()
        }
    }

    private fun calculate() {
        val weapon1att: Float = if (weapon1_att.text.toString() == "") {
            0f
        } else {
            weapon1_att.text.toString().toFloat()
        }
        val weapon2att: Float = if (weapon2_att.text.toString() == "") {
            0f
        } else {
            weapon2_att.text.toString().toFloat()
        }
        val portalBonus: Float = if (weapon_portal_bonus.text.toString() == "") {
            0f
        } else {
            weapon_portal_bonus.text.toString().toFloat()
        }
        val minDamage1 =
            weapon1_min_damage.text.toString().toInt() * (1 + (weapon_main_att.text.toString().toInt() + weapon1att) / 10)
        val maxDamage1 =
            weapon1_max_damage.text.toString().toInt() * (1 + (weapon_main_att.text.toString().toInt() + weapon1att) / 10)
        val minDamage2 =
            weapon2_min_damage.text.toString().toInt() * (1 + (weapon_main_att.text.toString().toInt() + weapon2att) / 10)
        val maxDamage2 =
            weapon2_max_damage.text.toString().toInt() * (1 + (weapon_main_att.text.toString().toInt() + weapon2att) / 10)
        val averDamage1 = ((minDamage1 + maxDamage1) / 2) * (1 + portalBonus / 100)
        val averDamage2 = ((minDamage2 + maxDamage2) / 2) * (1 + portalBonus / 100)
        weapon1_res.text = averDamage1.toInt().toString()
        weapon2_res.text = averDamage2.toInt().toString()
    }

    private fun clear() {
        weapon1_min_damage.text.clear()
        weapon1_max_damage.text.clear()
        weapon1_att.text.clear()

        weapon2_min_damage.text.clear()
        weapon2_max_damage.text.clear()
        weapon2_att.text.clear()

        weapon_main_att.text.clear()
        weapon_portal_bonus.text.clear()
    }

    private fun clearRes() {
        weapon1_res.text = ""
        weapon2_res.text = ""
    }
}
