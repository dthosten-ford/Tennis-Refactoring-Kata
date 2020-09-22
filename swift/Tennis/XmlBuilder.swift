//
//  XmlBuilder.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 9/21/20.
//

import Foundation


class XmlBuilder {
    
    func buildXML(firstName: String, lastName: String) -> String {
        let firstNameNode = XMLElement(name: "first", stringValue: firstName)
        let lastNameNode = XMLElement(name: "last", stringValue: lastName)
        
        let root = XMLElement(name: "names")
        let nestedNode = XMLElement(name: "name")
        
        root.addChild(nestedNode)
        nestedNode.addChild(firstNameNode)
        nestedNode.addChild(lastNameNode)
        
        let document = XMLDocument(rootElement: root)
        let xmlData = document.xmlData()
        return String(data: xmlData, encoding: .utf8) ?? ""
    }
}
