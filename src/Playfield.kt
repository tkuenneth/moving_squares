package moving_squares

import java.awt.Color
import java.awt.Dimension
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JPanel

class Playfield : JPanel(null) {

    val ball = Square()

    val leftRacket = Square()
    val rightRacket = Square()

    init {
        background = Color.BLACK
        border = null
        add(ball)
        addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                val percentW = e!!.component!!.width / 100f
                val percentH = e.component!!.height / 100f
                val ratio = percentW / percentH
                val w = (percentW * 4f).toInt()
                val h = (percentH * 4f * ratio).toInt()
                ball.size = Dimension(w, h)
            }
        })
        preferredSize = Dimension(800, 600)
        size = preferredSize
    }

    fun hitTopBorder() = ball.yPos <= 0

    fun hitBottomBorder() = (ball.yPos + ball.height - 1) >= height

    fun hitLeftBorder() = ball.xPos <= 0

    fun hitRightBorder() = (ball.xPos + ball.width - 1) >= width
}
