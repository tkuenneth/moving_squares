package moving_squares

import java.awt.Color
import java.awt.Graphics
import java.awt.Point
import javax.swing.JComponent
import javax.swing.SwingUtilities

class Square : JComponent() {

    var xPos: Int = 0
        set(value) {
            SwingUtilities.invokeLater {
                location = Point(value, location.y)
            }
            field = value
        }

    var yPos: Int = 0
        set(value) {
            SwingUtilities.invokeLater {
                location = Point(location.x, value)
            }
            field = value
        }

    override fun paint(g: Graphics?) {
        g?.color = Color.white
        g?.setPaintMode()
        g?.fillRect(0, 0, width, height)
        super.paint(g)
    }
}