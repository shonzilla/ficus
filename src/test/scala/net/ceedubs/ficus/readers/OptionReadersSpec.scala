package net.ceedubs.ficus
package readers

import com.typesafe.config.ConfigFactory

class OptionReadersSpec extends Spec with OptionReader with AnyValReaders { def is =
  "An option value reader should" ^
    "wrap an existing value in a Some" ! optionSome ^
    "return a None for a non-existing value" ! optionNone

  def optionSome = {
    val cfg = ConfigFactory.parseString("myValue = true")
    optionValueReader[Boolean].read(cfg, "myValue") must beSome(true)
  }

  def optionNone = {
    val cfg = ConfigFactory.parseString("")
    optionValueReader[Boolean].read(cfg, "myValue") must beNone
  }
}