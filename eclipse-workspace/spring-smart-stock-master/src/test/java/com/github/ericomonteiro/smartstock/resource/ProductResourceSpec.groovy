package com.github.ericomonteiro.smartstock.resource

import spock.lang.Specification

class ProductResourceSpec extends Specification {

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

}
