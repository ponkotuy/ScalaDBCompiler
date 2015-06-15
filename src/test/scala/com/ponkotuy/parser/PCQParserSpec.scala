package com.ponkotuy.parser

import org.scalatest.FunSpec

class PCQParserSpec extends FunSpec {
  val table = """table ship {
                |  # idは自動付与
                |  user_id Long
                |  name String
                |  lv Int
                |}
              """.stripMargin

  describe("PCQParser") {
    it("should parse table") {
      val result = PCQParser(table)
      println(result)
      assert(result.isRight, result)
    }
  }
}
