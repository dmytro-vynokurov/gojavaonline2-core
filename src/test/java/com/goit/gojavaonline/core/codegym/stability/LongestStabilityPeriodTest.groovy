package com.goit.gojavaonline.core.codegym.stability

import spock.lang.Specification

class LongestStabilityPeriodTest extends Specification {

    def counter = new LongestStabilityPeriod()


    def "stability period test"() {
        expect:
        res == counter.count(gdp.stream().mapToInt({x->x}).toArray())

        where:
        res | gdp
        1   | [1000]
        2   | [900, 901, 902]
        4   | [900, 900, 900, 901, 902, 902, 903, 903]
        6   | [901, 901, 901, 902, 902, 903, 903, 902, 902, 901]


    }
}
