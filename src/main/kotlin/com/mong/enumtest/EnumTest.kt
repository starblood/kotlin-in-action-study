package com.mong.enumtest

import com.mong.enumtest.colors.Color

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor() =
    when (val color = measureColor()) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (Color.RED = ${color.r})"
        Color.GREEN -> "neutral (Color.GREEN = ${color.g})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (Color.BLUE = ${color.b}"
    }

fun mix(
    c1: Color,
    c2: Color,
) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirty color")
}

fun mixOptimized(
    c1: Color,
    c2: Color,
) = when {
    (c1 == Color.RED && c2 == Color.YELLOW) ||
        (c1 == Color.YELLOW && c2 == Color.RED) ->
        Color.ORANGE

    (c1 == Color.YELLOW && c2 == Color.BLUE) ||
        (c1 == Color.BLUE && c2 == Color.YELLOW) ->
        Color.GREEN

    (c1 == Color.BLUE && c2 == Color.VIOLET) ||
        (c1 == Color.VIOLET && c2 == Color.BLUE) ->
        Color.INDIGO

    else -> throw Exception("Dirty color")
}

fun main() {
    println(Color.BLUE.rgb)
    // 255
    Color.GREEN.printColor()
    // Color.GREEN is 65280
    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor())
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.BLUE, Color.YELLOW))
}
