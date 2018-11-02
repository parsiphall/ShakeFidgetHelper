package com.example.parsiphal.shakefidgethelper.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.parsiphal.shakefidgethelper.R
import kotlinx.android.synthetic.main.fragment_quest.*

class QuestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quest_button.setOnClickListener {
            clearRes()
            calculate()
        }
        quest_clear_button.setOnClickListener {
            clear()
            clearRes()
        }
    }

    private fun calculate() {
        val time1s: Int = if (quest_q1_time_s.text.toString() == "") {
            0
        } else {
            quest_q1_time_s.text.toString().toInt()
        }
        val time2s: Int = if (quest_q2_time_s.text.toString() == "") {
            0
        } else {
            quest_q2_time_s.text.toString().toInt()
        }
        val time3s: Int = if (quest_q3_time_s.text.toString() == "") {
            0
        } else {
            quest_q3_time_s.text.toString().toInt()
        }
        val time1 = quest_q1_time_m.text.toString().toInt() * 60 + time1s
        val time2 = quest_q2_time_m.text.toString().toInt() * 60 + time2s
        val time3 = quest_q3_time_m.text.toString().toInt() * 60 + time3s
        val gold1 = quest_q1_gold_g.text.toString().toInt() * 100 + quest_q1_gold_s.text.toString().toInt()
        val gold2 = quest_q2_gold_g.text.toString().toInt() * 100 + quest_q2_gold_s.text.toString().toInt()
        val gold3 = quest_q3_gold_g.text.toString().toInt() * 100 + quest_q3_gold_s.text.toString().toInt()
        val rew1 = gold1 / time1
        val rew2 = gold2 / time2
        val rew3 = gold3 / time3
        val exp1 = quest_q1_exp.text.toString().toInt() / time1
        val exp2 = quest_q2_exp.text.toString().toInt() / time2
        val exp3 = quest_q3_exp.text.toString().toInt() / time3

        if (rew1 > rew2 && rew1 > rew3) {
            quest_q1_res.text = getString(R.string.quest_gold)
        } else if (rew2 > rew3) {
            quest_q2_res.text = getString(R.string.quest_gold)
        } else {
            quest_q3_res.text = getString(R.string.quest_gold)
        }

        if (exp1 > exp2 && exp1 > exp3) {
            if (quest_q1_res.text == "") {
                quest_q1_res.text = getString(R.string.quest_exp)
            } else {
                quest_q1_res.text = getString(R.string.quest_all)
            }
        } else if (exp2 > exp3) {
            if (quest_q2_res.text == "") {
                quest_q2_res.text = getString(R.string.quest_exp)
            } else {
                quest_q2_res.text = getString(R.string.quest_all)
            }
        } else {
            if (quest_q3_res.text == "") {
                quest_q3_res.text = getString(R.string.quest_exp)
            } else {
                quest_q3_res.text = getString(R.string.quest_all)
            }
        }
    }

    private fun clear() {
        quest_q1_gold_g.text.clear()
        quest_q1_gold_s.text.clear()
        quest_q1_exp.text.clear()
        quest_q1_time_m.text.clear()
        quest_q1_time_s.text.clear()

        quest_q2_gold_g.text.clear()
        quest_q2_gold_s.text.clear()
        quest_q2_exp.text.clear()
        quest_q2_time_m.text.clear()
        quest_q2_time_s.text.clear()

        quest_q3_gold_g.text.clear()
        quest_q3_gold_s.text.clear()
        quest_q3_exp.text.clear()
        quest_q3_time_m.text.clear()
        quest_q3_time_s.text.clear()
    }

    private fun clearRes() {
        quest_q1_res.text = ""
        quest_q2_res.text = ""
        quest_q3_res.text = ""
    }
}
