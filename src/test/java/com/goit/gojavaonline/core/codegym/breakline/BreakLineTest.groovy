package com.goit.gojavaonline.core.codegym.breakline

import spock.lang.Specification

class BreakLineTest extends Specification {

    BreakLine breakLine = new BreakLine()


    def "line breaking should work correctly"(){

        expect:
        breakLine.format(input, width) == expected

        where:
        input            | width | expected
        "\"\"\"\""       | 5     | "\"\"\"\""
        "\"abc ab c w\"" | 5     | "\"abc\nab c\nw\""
        "\"abc w\""      | 5     | "\"abc w\""
    }



}
