# android-constraintlayout-demo

## 简介

本 demo 展示了如何在 Android 应用中使用 ConstraintLayout 进行约束布局。ConstraintLayout 是目前 Android 官方推荐的布局方式，它可以通过约束关系精确控制子视图的位置和大小。

## 基本原理

ConstraintLayout 通过"约束"来定义子视图的位置：

- **相对约束**：子视图与父容器或其他视图的相对位置
- **角度约束**：基于角度和距离定位
- **链式约束**：多个视图之间的链式关系
- **百分比约束**：使用百分比设置尺寸

ConstraintLayout 可以完全替代嵌套布局，大幅减少布局层级，提高渲染性能。

## 启动和使用

### 环境要求
- Android Studio Arctic Fox 或更高版本
- JDK 11 或更高版本
- Android SDK 34

### 安装和运行
1. 使用 Android Studio 打开本项目
2. 连接 Android 设备或启动模拟器
3. 点击 Run 按钮运行应用

## 教程

### 什么是 ConstraintLayout？

ConstraintLayout 是 Android Jetpack 中的布局组件，它既灵活又高性能。通过使用约束来描述子视图之间的关系，可以实现任何复杂的布局，而不需要嵌套多个布局。

### 核心概念

1. **约束（Constraint）**：定义视图与其他视图或父容器的相对位置
2. **锚点（Anchor）**：约束的连接点（top、bottom、start、end 等）
3. **偏差（Bias）**：在两个相反约束之间调整位置比例

### 基本用法

1. 添加依赖：
```kotlin
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```

2. 在布局中使用：
```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/title"
        android:text="标题"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

### 常用约束属性

| 属性 | 说明 |
|------|------|
| `layout_constraintTop_toTopOf` | 顶部与目标顶部对齐 |
| `layout_constraintBottom_toBottomOf` | 底部与目标底部对齐 |
| `layout_constraintStart_toStartOf` | 起始边与目标起始边对齐 |
| `layout_constraintEnd_toEndOf` | 结束边与目标结束边对齐 |
| `layout_constraintTop_toBottomOf` | 顶部与目标底部对齐 |
| `layout_constraintStart_toEndOf` | 起始边与目标结束边对齐 |
| `layout_constraintHorizontal_bias` | 水平偏差 (0-1) |
| `layout_constraintVertical_bias` | 垂直偏差 (0-1) |
| `layout_constraintWidth_percent` | 宽度百分比 |
| `layout_constraintHeight_percent` | 高度百分比 |
| `layout_goneMarginStart` | 目标视图隐藏时的边距 |

### 链式约束（Chains）

链式约束可以在多个视图之间创建双向关系：

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <Button
        android:id="@+id/button1"
        app:layout_constraintHorizontal_chainStyle="spread"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toStartOf="@id/button2" />

    <Button
        android:id="@+id/button2"
        app:layout_constraintStart_toEndOf="@id/button1"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

链样式：
- `spread`：均匀分布（默认）
- `spread_inside`：两端对齐
- `packed`：紧凑排列

### 优点

1. **性能好**：扁平化布局，减少测量次数
2. **灵活**：可以创建任何复杂布局
3. **可视化**：Android Studio 提供可视化编辑器
4. **响应式**：支持百分比和约束，适应不同屏幕尺寸

### 注意事项

1. **推荐使用**：新版 Android 开发首选布局
2. **ConstraintSet**：可以通过代码动态修改约束
3. **GuideLine**：使用辅助线辅助定位
4. **Barrier**：使用屏障处理动态内容
