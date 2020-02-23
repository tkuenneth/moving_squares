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
        add(leftRacket)
        add(rightRacket)
        addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                val percentW = e!!.component!!.width / 100f
                val percentH = e.component!!.height / 100f
                val ratio = percentW / percentH
                var w = (percentW * 4f).toInt()
                if (w < 4) {
                    w = 4
                }
                var h = (percentH * 4f * ratio).toInt()
                if (h < 4) {
                    h = 4
                }
                ball.size = Dimension(w, h)
                leftRacket.xPos = w
                leftRacket.yPos = 100
                leftRacket.size = Dimension(w, h * 4)
                rightRacket.xPos = size.width - w - w -1
                rightRacket.yPos = 200
                rightRacket.size = Dimension(w, h * 4)
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
