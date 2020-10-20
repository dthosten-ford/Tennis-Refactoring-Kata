//
//  BuilderTests.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 10/20/20.
//

import XCTest

class BuilderTests: XCTestCase {

    
    func testBuilder() {
        let subject = XmlBuilder()
        let expected =
        "<names>" +
        "<name>" +
        "<first>Donnie</first>" +
        "<last>Duck</last>" +
        "</name>" +
        "</names>"
        
        let result = subject.build()
            .withFirstName(firstName: "Donnie")
            .withLastname(lastName: "Duck")
            .toString()
        XCTAssertEqual(expected, result)
        
    }
    
    func testNewXMLBuilder() {
        let subject = XmlBuilder("flavors")
        let expected = "<flavors></flavors>"
        let actual = subject.toXml()
        XCTAssertEqual(expected, actual)
    }
    
    func testAddChild() {
        let subject = XmlBuilder("anyName")
        let expected = "<anyName></anyName>"
        let actual = subject.toXml()
        XCTAssertEqual(expected, actual)
    }
    
    func testNestedAddChild() {
        let subject = XmlBuilder("flavors")
        let expected = "<flavors><flavor></flavor></flavors>"
        
        _ = subject.addChild("flavor")
        let actual = subject.toXml()
        
        XCTAssertEqual(expected, actual)
    }
    
    func testNestedAddChildRequirements() {
        let subject = XmlBuilder("flavors")
        let expected = "<flavors><flavor><requirements></requirements></flavor></flavors>"
        
        _ = subject.addChild("flavor")
            .addChild("requirements")
        let actual = subject.toXml()
        
        XCTAssertEqual(expected, actual)
    }
    
    func testNestedAddChildRequirement() {
        let expected = "<flavors><flavor><requirements><requirement></requirement></requirements></flavor></flavors>"
        let subject = XmlBuilder("flavors")
        .addChild("flavor")
        .addChild("requirements")
        .addChild("requirement")

        let actual = subject.toXml()
        
        XCTAssertEqual(expected, actual)
    }
    
    func testAddSibling() {
        let expected = "<flavors><flavor1></flavor1><flavor2></flavor2></flavors>"
        let subject = XmlBuilder("flavors")
            .addChild("flavor1")
            .addSibling("flavor2")
        let actual = subject.toXml()
        XCTAssertEqual(expected, actual)
    }

}
