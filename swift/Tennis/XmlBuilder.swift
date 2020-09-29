//
//  XmlBuilder.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 9/21/20.
//

import Foundation


class XmlBuilder {
    let document: XMLDocument = XMLDocument()
    
    func build() -> XmlBuilder {
        let root = XMLElement(name: "names")
        document.setRootElement(root)
        return self
    }
    
    func withLastname(lastName: String, nameNode: XMLElement) -> XmlBuilder {
        let lastNameNode = XMLElement(name: "last", stringValue: lastName)
        nameNode.addChild(lastNameNode)
        return self
    }
    
    func withFirstName(firstName: String, nameNode: XMLElement) -> XmlBuilder {
        let firstNameNode = XMLElement(name: "first", stringValue: firstName)
        nameNode.addChild(firstNameNode)
        return self
    }
    
    
    func buildXML(firstName: String, lastName: String) -> String {
        //create a new builder
        //build
//        .withHeader()
//            .withName(firstName)
//            .withLastName()
//            .withAttribute()
        
//        let firstNameNode = XMLElement(name: "first", stringValue: firstName)
        //let lastNameNode = XMLElement(name: "last", stringValue: lastName)
        
        let root = XMLElement(name: "names")
        let nestedNode = XMLElement(name: "name")
        
        root.addChild(nestedNode)
//        nestedNode.addChild(firstNameNode)
       // nestedNode.addChild(lastNameNode)
        withFirstName(firstName: firstName, nameNode: nestedNode)
        withLastname(lastName: lastName, nameNode: nestedNode)
              
        let document = XMLDocument(rootElement: root)
        let xmlData = document.xmlData()
        return String(data: xmlData, encoding: .utf8) ?? ""
    }
}
