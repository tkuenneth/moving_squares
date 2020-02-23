package moving_squares

import javax.swing.JFrame
import javax.swing.SwingUtilities.invokeLater

const val offset = 2

fun main() {
    invokeLater {
        val f = JFrame("Moving Square")
        val playfield = Playfield()
        f.contentPane = playfield
        f.pack()
        f.setLocationRelativeTo(null)
        var toLeft = Math.random() < .5
        var toTop = Math.random() < .5
        playfield.ball.xPos = (Math.random() * playfield.width).toInt()
        playfield.ball.yPos = (Math.random() * playfield.height).toInt()
        val t = Thread {
            while (true) {
                if (toLeft) {
                    if (playfield.hitLeftBorder()) {
                        toLeft = false
                        playfield.ball.xPos = 0
                    } else
                        playfield.ball.xPos -= offset
                } else {
                    if (playfield.hitRightBorder()) {
                        toLeft = true
                        playfield.ball.xPos = playfield.width - playfield.ball.width - 1
                    } else
                        playfield.ball.xPos += offset
                }
                if (toTop) {
                    if (playfield.hitTopBorder()) {
                        toTop = false
                        playfield.ball.yPos = 0
                    } else
                        playfield.ball.yPos -= offset
                } else {
                    if (playfield.hitBottomBorder()) {
                        toTop = true
                        playfield.ball.yPos = playfield.height - playfield.ball.height - 1
                    } else
                        playfield.ball.yPos += offset
                }
                Thread.sleep(10)
            }
        }
        f.isVisible = true
        f.repaint()
        t.start()
    }
}
