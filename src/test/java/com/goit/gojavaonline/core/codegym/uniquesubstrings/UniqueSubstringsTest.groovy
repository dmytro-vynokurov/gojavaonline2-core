package com.goit.gojavaonline.core.codegym.uniquesubstrings

import spock.lang.Specification
import spock.lang.Unroll

class UniqueSubstringsTest extends Specification {

    UniqueSubstrings us = new UniqueSubstrings()

    @Unroll
    def "unique substrings should be counted correctly"(){
        expect:
        us.count(input) == count

        where:
        input | count
        "abab" | 4
        "ababgabaabac" | 58
    }
}
