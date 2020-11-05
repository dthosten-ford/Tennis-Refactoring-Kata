//
//  CalculatorTest.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 10/28/20.
//

import XCTest

class CalculatorTest: XCTestCase {
    
    var subject: Calculator!
    
    override func setUp() {
        subject = Calculator()
    }
    
    override func tearDown() {
        subject = nil
    }
    
    func testForEmptyString() {
        let expectedValue = 0
        XCTAssertEqual(expectedValue, subject.add(""))
    }
    
    func testFor1ShouldReturn1() {
        let expectedvalue = 1
        XCTAssertEqual(expectedvalue, subject.add("1"))
    }
    
    func testForInputValueEqualsOutputValue() {
        let expectedValue = 555
        XCTAssertEqual(expectedValue, subject.add("555"))
    }
    
    func testCheckAddingTwoNumbers() {
        let expectedValue = 3
        XCTAssertEqual(expectedValue, subject.add("1,2"))
    }
    
    func testMultipleStringValues() {
        let expectedValue = 21
        XCTAssertEqual(expectedValue, subject.add("1,2,3,4,5,6"))
    }
    
    func testMultipleDelimeters() {
        let expectedValue = 21
        XCTAssertEqual(expectedValue, subject.add("//;\n1;2;3;4;5;6"))
    }
    
    func testCustomDelimiter(){
        let expectedValue = 21
        XCTAssertEqual(expectedValue, subject.add("//9\n19293949596"))
    }
}
