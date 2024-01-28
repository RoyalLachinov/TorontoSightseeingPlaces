package ca.com.toronto.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ca.com.testtutorials.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val txtViewCNTower = findViewById<View>(R.id.txtViewLocationContent) as TextView
        val imgView = findViewById<View>(R.id.imgView) as ImageView
        val intent = intent
        val bundle = intent.extras
        when (bundle?.getString("detail")?.toInt()) {
            0 -> {
                txtViewCNTower.text = getString(R.string.point_0)
                imgView.setBackgroundResource(R.drawable.point_0)
            }
            1 -> {
                txtViewCNTower.text = getString(R.string.point_1)
                imgView.setBackgroundResource(R.drawable.point_1)
            }
            2 -> {
                txtViewCNTower.text = getString(R.string.point_2)
                imgView.setBackgroundResource(R.drawable.point_2)
            }
            3 -> {
                txtViewCNTower.text = getString(R.string.point_3)
                imgView.setBackgroundResource(R.drawable.point_3)
            }
            4 -> {
                txtViewCNTower.text = getString(R.string.point_4)
                imgView.setBackgroundResource(R.drawable.point_4)
            }
            5 -> {
                txtViewCNTower.text = getString(R.string.point_5)
                imgView.setBackgroundResource(R.drawable.point_5)
            }
            6 -> {
                txtViewCNTower.text = getString(R.string.point_6)
                imgView.setBackgroundResource(R.drawable.point_6)
            }
            7 -> {
                txtViewCNTower.text = getString(R.string.point_7)
                imgView.setBackgroundResource(R.drawable.point_7)
            }
            8 -> {
                txtViewCNTower.text = getString(R.string.point_8)
                imgView.setBackgroundResource(R.drawable.point_8)
            }
            9 -> {
                txtViewCNTower.text = getString(R.string.point_9)
                imgView.setBackgroundResource(R.drawable.point_9)
            }
            10 -> {
                txtViewCNTower.text = getString(R.string.point_10)
                imgView.setBackgroundResource(R.drawable.point_10)
            }
            11 -> {
                txtViewCNTower.text = getString(R.string.point_11)
                imgView.setBackgroundResource(R.drawable.point_11)
            }
            12 -> {
                txtViewCNTower.text = getString(R.string.point_12)
                imgView.setBackgroundResource(R.drawable.point_12)
            }
            13 -> {
                txtViewCNTower.text = getString(R.string.point_13)
                imgView.setBackgroundResource(R.drawable.point_13)
            }
            14 -> {
                txtViewCNTower.text = getString(R.string.point_14)
                imgView.setBackgroundResource(R.drawable.point_14)
            }
            15 -> {
                txtViewCNTower.text = getString(R.string.point_15)
                imgView.setBackgroundResource(R.drawable.point_15)
            }
            16 -> {
                txtViewCNTower.text = getString(R.string.point_16)
                imgView.setBackgroundResource(R.drawable.point_16)
            }
            17 -> {
                txtViewCNTower.text = getString(R.string.point_17)
                imgView.setBackgroundResource(R.drawable.point_17)
            }
            18 -> {
                txtViewCNTower.text = getString(R.string.point_18)
                imgView.setBackgroundResource(R.drawable.point_18)
            }
            19 -> {
                txtViewCNTower.text = getString(R.string.point_19)
                imgView.setBackgroundResource(R.drawable.point_19)
            }
            20 -> {
                txtViewCNTower.text = getString(R.string.point_20)
                imgView.setBackgroundResource(R.drawable.point_20)
            }
            21 -> {
                txtViewCNTower.text = getString(R.string.point_21)
                imgView.setBackgroundResource(R.drawable.point_21)
            }
            22 -> {
                txtViewCNTower.text = getString(R.string.point_22)
                imgView.setBackgroundResource(R.drawable.point_22)
            }
            23 -> {
                txtViewCNTower.text = getString(R.string.point_23)
                imgView.setBackgroundResource(R.drawable.point_23)
            }
            24 -> {
                txtViewCNTower.text = getString(R.string.point_24)
                imgView.setBackgroundResource(R.drawable.point_24)
            }
            25 -> {
                txtViewCNTower.text = getString(R.string.point_25)
                imgView.setBackgroundResource(R.drawable.point_25)
            }
            26 -> {
                txtViewCNTower.text = getString(R.string.point_26)
                imgView.setBackgroundResource(R.drawable.point_26)
            }
            27 -> {
                txtViewCNTower.text = getString(R.string.point_27)
                imgView.setBackgroundResource(R.drawable.point_27)
            }
            28 -> {
                txtViewCNTower.text = getString(R.string.point_28)
                imgView.setBackgroundResource(R.drawable.point_28)
            }
            29 -> {
                txtViewCNTower.text = getString(R.string.point_29)
                imgView.setBackgroundResource(R.drawable.point_29)
            }
            30 -> {
                txtViewCNTower.text = getString(R.string.point_30)
                imgView.setBackgroundResource(R.drawable.point_30)
            }
            31 -> {
                txtViewCNTower.text = getString(R.string.point_31)
                imgView.setBackgroundResource(R.drawable.point_31)
            }
            32 -> {
                txtViewCNTower.text = getString(R.string.point_32)
                imgView.setBackgroundResource(R.drawable.point_32)
            }
            33 -> {
                txtViewCNTower.text = getString(R.string.point_33)
                imgView.setBackgroundResource(R.drawable.point_33)
            }
            34 -> {
                txtViewCNTower.text = getString(R.string.point_34)
                imgView.setBackgroundResource(R.drawable.point_34)
            }
            35 -> {
                txtViewCNTower.text = getString(R.string.point_35)
                imgView.setBackgroundResource(R.drawable.point_35)
            }
            36 -> {
                txtViewCNTower.text = getString(R.string.point_36)
                imgView.setBackgroundResource(R.drawable.point_36)
            }
            37 -> {
                txtViewCNTower.text = getString(R.string.point_37)
                imgView.setBackgroundResource(R.drawable.point_37)
            }
            38 -> {
                txtViewCNTower.text = getString(R.string.point_38)
                imgView.setBackgroundResource(R.drawable.point_38)
            }
            39 -> {
                txtViewCNTower.text = getString(R.string.point_39)
                imgView.setBackgroundResource(R.drawable.point_39)
            }
            40 -> {
                txtViewCNTower.text = getString(R.string.point_40)
                imgView.setBackgroundResource(R.drawable.point_40)
            }
            41 -> {
                txtViewCNTower.text = getString(R.string.point_41)
                imgView.setBackgroundResource(R.drawable.point_41)
            }
            42 -> {
                txtViewCNTower.text = getString(R.string.point_42)
                imgView.setBackgroundResource(R.drawable.point_42)
            }
            43 -> {
                txtViewCNTower.text = getString(R.string.point_43)
                imgView.setBackgroundResource(R.drawable.point_43)
            }
            44 -> {
                txtViewCNTower.text = getString(R.string.point_44)
                imgView.setBackgroundResource(R.drawable.point_44)
            }
            45 -> {
                txtViewCNTower.text = getString(R.string.point_45)
                imgView.setBackgroundResource(R.drawable.point_45)
            }
            46 -> {
                txtViewCNTower.text = getString(R.string.point_46)
                imgView.setBackgroundResource(R.drawable.point_46)
            }
            47 -> {
                txtViewCNTower.text = getString(R.string.point_47)
                imgView.setBackgroundResource(R.drawable.point_47)
            }
            48 -> {
                txtViewCNTower.text = getString(R.string.point_48)
                imgView.setBackgroundResource(R.drawable.point_48)
            }
            49 -> {
                txtViewCNTower.text = getString(R.string.point_49)
                imgView.setBackgroundResource(R.drawable.point_49)
            }
        }
    }
}
