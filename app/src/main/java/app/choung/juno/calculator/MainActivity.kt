package app.choung.juno.calculator

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var firstnumber :Double = 0.0
    var secondnumber :Double = 0.0
//    var totalnumber = 0
    var operator = "empty"
    var point:Double = 1.0
    val pi :Double = 3.141592
    var bitmodeope :Int = 0
    var zero :Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
        minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
        multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
        equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))

        plusButton.isEnabled = false
        minusButton.isEnabled = false
        multiplyButton.isEnabled = false
        equalButton.isEnabled = false

        numberText.text = firstnumber.toString()

        ten.setOnClickListener {
            point = 10.0
        }

        pai.setOnClickListener {
            if (operator == "empty") {
                firstnumber = firstnumber * 10 + pi
                numberText.text = firstnumber.toString()
            } else {
                secondnumber = secondnumber * 10 + pi
                numberText.text = secondnumber.toString()
            }
        }

        kaijyou.setOnClickListener{
            if (operator == "empty") {
                if (firstnumber % 2.0 == 1.0 || firstnumber % 2.0 == 0.0){
                var i = firstnumber.toInt()
                while (i > 1) {
                    i--
                    firstnumber = firstnumber * i
                }
                }else{
                    val toast = Toast.makeText(this,"整数以外は階乗できません", Toast.LENGTH_SHORT)
                    toast.show()
                }
                    numberText.text = firstnumber.toString()
            } else {
                if (secondnumber % 2.0 == 1.0 || secondnumber % 2.0 == 0.0) {
                    var i = secondnumber
                    while (i > 1) {
                        i--
                        secondnumber = secondnumber * i
                    }
                }else {
                    numberText.text = secondnumber.toString()
                }
            }
            }

        jijyou.setOnClickListener {
            if (operator == "empty") {
                firstnumber = firstnumber * firstnumber
                if (bitmodeope==0) {
                    numberText.text = firstnumber.toString()
                }else if(bitmodeope==1){
                    numberText.text = firstnumber.toInt().toString(2)
                }
            } else {
                secondnumber = secondnumber * secondnumber
                if (bitmodeope==0) {
                    numberText.text = secondnumber.toString()
                }else if(bitmodeope==1){
                    numberText.text = secondnumber.toInt().toString(2)
                }
            }
        }

        bit.setOnClickListener {
            if(bitmodeope==0){
                bitmodeope = 1
                numberButton2.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton3.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton4.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton5.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton6.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton7.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton8.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton9.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                ten.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                pai.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
                numberButton2.isEnabled = false
                numberButton3.isEnabled = false
                numberButton4.isEnabled = false
                numberButton5.isEnabled = false
                numberButton6.isEnabled = false
                numberButton7.isEnabled = false
                numberButton8.isEnabled = false
                numberButton9.isEnabled = false
                ten.isEnabled = false
                pai.isEnabled = false
                if (operator == "plus"){
                    firstnumber = firstnumber + secondnumber
                }else if (operator == "minus"){
                    firstnumber = firstnumber - secondnumber
                }else if (operator == "multiply"){
                    firstnumber = firstnumber * secondnumber
                }

                secondnumber = 0.0
                numberText.text = firstnumber.toInt().toString(2)
//                numberText.text = zero.toString()
            }else if(bitmodeope==1){
                bitmodeope = 0
                numberButton2.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton3.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton4.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton5.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton6.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton7.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton8.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton9.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                ten.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                pai.backgroundTintList = ColorStateList.valueOf(Color.rgb(90, 156, 6))
                numberButton2.isEnabled = true
                numberButton3.isEnabled = true
                numberButton4.isEnabled = true
                numberButton5.isEnabled = true
                numberButton6.isEnabled = true
                numberButton7.isEnabled = true
                numberButton8.isEnabled = true
                numberButton9.isEnabled = true
                ten.isEnabled = true
                pai.isEnabled = true
                if (operator == "plus"){
                    firstnumber = firstnumber + secondnumber
                }else if (operator == "minus"){
                    firstnumber = firstnumber - secondnumber
                }else if (operator == "multiply"){
                    firstnumber = firstnumber * secondnumber
                }
                secondnumber = 0.0
                firstnumber = firstnumber.toInt().toString().toInt(2).toDouble()
                numberText.text = firstnumber.toString()
            }
        }

        numberButton0.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 0
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 0
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (0/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 0 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton1.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 1
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 1
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (1/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 1 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }
        }

        numberButton2.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 2
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 2
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (2/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 2/ point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton3.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 3
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 3
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (3/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 3/ point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton4.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 4
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 4
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (4/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 4/ point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton5.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 5
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 5
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (5/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 5 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton6.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 6
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 6
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (6/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 6/ point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }
        }

        numberButton7.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 7
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 7
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (7/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 7 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton8.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 8
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 8
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (8/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 8 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }

        }

        numberButton9.setOnClickListener {
            if (point==1.0) {
                if (operator == "empty") {
                    firstnumber = firstnumber * 10 + 9
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber * 10 + 9
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
            }else{
                if (operator == "empty") {
                    firstnumber = firstnumber + (9/point)
                    numberText.text = firstnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    plusButton.isEnabled = true
                    minusButton.isEnabled = true
                    multiplyButton.isEnabled = true
                    equalButton.isEnabled = true
                } else {
                    secondnumber = secondnumber + 9 / point
                    numberText.text = secondnumber.toString()
                    plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    multiplyButton.backgroundTintList =
                        ColorStateList.valueOf(Color.rgb(174, 242, 61))
                    equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(114, 190, 7))
                }
                point = point * 10
            }
        }

        plusButton.setOnClickListener{
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            if (operator == "plus"){
                firstnumber = firstnumber + secondnumber
            }else if (operator == "minus"){
                firstnumber = firstnumber - secondnumber
            }else if (operator == "multiply"){
                firstnumber = firstnumber * secondnumber
            }
            secondnumber = 0.0
            if (operator !== "empty") {
                if (bitmodeope == 0) {
                    numberText.text = firstnumber.toString()
                } else if (bitmodeope == 1) {
                    numberText.text = firstnumber.toInt().toString(2)
                }
            }
            operator = "plus"
            point = 1.0
        }

        minusButton.setOnClickListener{
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            if (operator == "plus"){
                firstnumber = firstnumber + secondnumber
            }else if (operator == "minus"){
                firstnumber = firstnumber - secondnumber
            }else if (operator == "multiply"){
                firstnumber = firstnumber * secondnumber
            }
            secondnumber = 0.0
            if (operator !== "empty") {
                if (bitmodeope == 0) {
                    numberText.text = firstnumber.toString()
                } else if (bitmodeope == 1) {
                    numberText.text = firstnumber.toInt().toString(2)
                }
            }
            operator = "minus"
        }

        multiplyButton.setOnClickListener{
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(174, 242, 61))
            if (operator == "plus"){
                firstnumber = firstnumber + secondnumber
            }else if (operator == "minus"){
                firstnumber = firstnumber - secondnumber
            }else if (operator == "multiply"){
                firstnumber = firstnumber * secondnumber
            }
            secondnumber = 0.0
            if (operator !== "empty") {
                if (bitmodeope == 0) {
                    numberText.text = firstnumber.toString()
                } else if (bitmodeope == 1) {
                    numberText.text = firstnumber.toInt().toString(2)
                }
            }
            operator = "multiply"
        }

        equalButton.setOnClickListener{
            if (bitmodeope==1){
                secondnumber = secondnumber.toInt().toString().toInt(2).toDouble()
            }
            if (operator == "plus"){
                firstnumber = firstnumber + secondnumber
            }else if (operator == "minus"){
                firstnumber = firstnumber - secondnumber
            }else if (operator == "multiply"){
                firstnumber = firstnumber * secondnumber
            }
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            secondnumber = 0.0

            if (operator !== "empty") {
                if (bitmodeope == 0) {
                    numberText.text = firstnumber.toString()
                } else if (bitmodeope == 1) {
                    numberText.text = firstnumber.toInt().toString(2)
                }
            }
            operator = "empty"
            point = 1.0
        }

        clearButton.setOnClickListener{
            plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(51,119,119))
            firstnumber = 0.0
            secondnumber = 0.0
            operator = "empty"
            if(firstnumber==0.0){
            numberText.text = 0.toString()
                point = 1.0
            }
        }

    }
//    fun roundOffDecimal(number: Double): Double? {
//        val df = DecimalFormat("#.#########")
//        df.roundingMode = RoundingMode.CEILING
//        return df.format(number).toDouble()
//    }
}
