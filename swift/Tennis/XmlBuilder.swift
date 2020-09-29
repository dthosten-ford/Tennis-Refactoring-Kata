//
//  XmlBuilder.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 9/21/20.
//

import Foundation


class XmlBuilder {
    let document: XMLDocument = XMLDocument()
    let nestedNode = XMLElement(name: "name")

    func build() -> XmlBuilder {
        let root = XMLElement(name: "names")
        root.addChild(nestedNode)
        document.setRootElement(root)
        return self
    }
    
    func withLastname(lastName: String) -> XmlBuilder {
        let lastNameNode = XMLElement(name: "last", stringValue: lastName)
        nestedNode.addChild(lastNameNode)
        return self
    }
    
    func withFirstName(firstName: String) -> XmlBuilder {
        let firstNameNode = XMLElement(name: "first", stringValue: firstName)
        nestedNode.addChild(firstNameNode)
        return self
    }
    
    func nodeBuilder(nodeName: String, value: String) -> XmlBuilder {
        let node = XMLElement(name: nodeName, stringValue: value)
        nestedNode.addChild(node)
        return self
    }
    
    
     func toString() -> String {
        let xmlData = document.xmlData()
        return String(data: xmlData, encoding: .utf8) ?? ""
    }
    
}
