package io.rich.colors

import scala.language.implicitConversions

/**
 * Define an abstract color to use in a rich console.
 *
 * @param s color string.
 *          Since it's not simple to remember all color strings, please use
 *          specific case objects.
 */
sealed abstract case class ConsoleColor(s: String) {
  def colorString: String = s

  def p(): Unit = print(f"\u001b[$s")
}

sealed class FontColor(s: String) extends ConsoleColor(s)

object FontColor {

  case object Reset extends FontColor("0m")

  case object Black extends FontColor("30m")

  case object Red extends FontColor("31m")

  case object Green extends FontColor("32m")

  case object Yellow extends FontColor("33m")

  case object Blue extends FontColor("34m")

  case object Magenta extends FontColor("35m")

  case object Cyan extends FontColor("36m")

  case object White extends FontColor("37m")

  implicit def str2color(s: String): FontColor =
    s match {
      case "" | "reset" => Reset
      case "black" => Black
      case "red" => Red
      case "green" => Green
      case "white" => White
      case a => throw new RuntimeException(s"Wrong font color string $a")
    }
}

sealed class BackgroundColor(str: String) extends ConsoleColor(str)

object BackgroundColor {

  case object Reset extends BackgroundColor("0m")

  case object Black extends BackgroundColor("40m")

  case object Red extends BackgroundColor("41m")

  case object Green extends BackgroundColor("42m")

  case object Yellow extends BackgroundColor("43m")

  case object Blue extends BackgroundColor("44m")

  case object Magenta extends BackgroundColor("45m")

  case object Cyan extends BackgroundColor("46m")

  case object White extends BackgroundColor("47m")

  implicit def str2color(s: String): BackgroundColor =
    s match {
      case "" | "reset" => Reset
      case "black" => Black
      case "red" => Red
      case "green" => Green
      case "white" => White
      case a => throw new RuntimeException(s"Wrong background color string $a")
    }
}