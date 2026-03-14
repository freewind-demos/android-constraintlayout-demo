package com.example.demo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

/**
 * ConstraintLayout 示例程序
 *
 * 展示如何在 Android 中使用 ConstraintLayout 进行约束布局
 * ConstraintLayout 是目前最推荐使用的布局方式，它可以通过约束关系精确定位子视图
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建 ConstraintLayout 作为根布局
        val constraintLayout = ConstraintLayout(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            setPadding(16, 16, 16, 16)
        }

        // 创建标题 TextView
        val titleText = TextView(this).apply {
            id = View.generateViewId()
            text = "ConstraintLayout 示例"
            textSize = 24f
        }

        // 创建说明文字
        val descriptionText = TextView(this).apply {
            id = View.generateViewId()
            text = "ConstraintLayout 通过约束关系来定位子视图，可以实现复杂的布局而无需嵌套多个布局"
            textSize = 14f
        }

        // 创建按钮 A
        val buttonA = Button(this).apply {
            id = View.generateViewId()
            text = "按钮 A"
        }

        // 创建按钮 B
        val buttonB = Button(this).apply {
            id = View.generateViewId()
            text = "按钮 B"
        }

        // 创建按钮 C
        val buttonC = Button(this).apply {
            id = View.generateViewId()
            text = "按钮 C"
        }

        // 创建按钮 D
        val buttonD = Button(this).apply {
            id = View.generateViewId()
            text = "按钮 D"
        }

        // 将所有视图添加到 ConstraintLayout
        constraintLayout.addView(titleText)
        constraintLayout.addView(descriptionText)
        constraintLayout.addView(buttonA)
        constraintLayout.addView(buttonB)
        constraintLayout.addView(buttonC)
        constraintLayout.addView(buttonD)

        // 使用 ConstraintSet 设置约束
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        // 标题：水平居中，位于顶部
        constraintSet.connect(titleText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 16)
        constraintSet.connect(titleText.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(titleText.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

        // 说明文字：在标题下方，水平居中
        constraintSet.connect(descriptionText.id, ConstraintSet.TOP, titleText.id, ConstraintSet.BOTTOM, 16)
        constraintSet.connect(descriptionText.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 16)
        constraintSet.connect(descriptionText.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 16)

        // 按钮 A：在说明文字下方，左侧
        constraintSet.connect(buttonA.id, ConstraintSet.TOP, descriptionText.id, ConstraintSet.BOTTOM, 32)
        constraintSet.connect(buttonA.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 32)

        // 按钮 B：在按钮 A 右侧，顶部对齐
        constraintSet.connect(buttonB.id, ConstraintSet.TOP, buttonA.id, ConstraintSet.TOP)
        constraintSet.connect(buttonB.id, ConstraintSet.START, buttonA.id, ConstraintSet.END, 16)
        constraintSet.connect(buttonB.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 32)

        // 按钮 C：位于底部左侧
        constraintSet.connect(buttonC.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 32)
        constraintSet.connect(buttonC.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 32)

        // 按钮 D：位于按钮 C 右侧，底部对齐
        constraintSet.connect(buttonD.id, ConstraintSet.BOTTOM, buttonC.id, ConstraintSet.BOTTOM)
        constraintSet.connect(buttonD.id, ConstraintSet.START, buttonC.id, ConstraintSet.END, 16)
        constraintSet.connect(buttonD.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 32)

        // 应用约束
        constraintSet.applyTo(constraintLayout)

        // 设置内容视图
        setContentView(constraintLayout)
    }
}
