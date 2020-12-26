package io

import io.rich.colors.{BackgroundColor, FontColor}

trait Console{
  def pl(s: String): Unit
  def p(s: String): Unit
}

object Console {
  def apply(): Console = RichConsole(FontColor.Reset, BackgroundColor.Reset)

  sealed case class RichConsole(font: FontColor, background: BackgroundColor) extends Console {
    def font(color: FontColor): Console = copy(font = color)

    def back(color: BackgroundColor): Console = copy(background = color)

    @deprecated("this function will be removed in a future version.", "back method was added, that is more concise")
    def background(color: BackgroundColor): Console = copy(background = color)

    override def pl(s: String): Unit = {
      p(s)
      p("/n")
    }

    override def p(s: String): Unit = {
      background.p()
      font.p()
      print(f"$s")
      print(f"\u001b[${FontColor.Reset.colorString}")
    }
  }
}