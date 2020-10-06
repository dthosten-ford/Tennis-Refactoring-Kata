//
//  XmlBuilder.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 9/21/20.
//

import Foundation


class XmlBuilder {
    private let document: XMLDocument = XMLDocument()
    private let nestedNode = XMLElement(name: "name")
    private let root: XMLElement
    private var nodeArray: [XMLElement]
    
    init(_ value: String = "") {
        root = XMLElement(name: value)
        document.setRootElement(root)
        nodeArray = [root]
    }
    
    func toXml() -> String {
        return toString()
    }

    func build() -> XmlBuilder {
        let root = XMLElement(name: "names")
        root.addChild(nestedNode)
        document.setRootElement(root)
        return self
    }
    
    func addChild(_ child: String) {
        let child = XMLElement(name: child)
        nodeArray.last?.addChild(child)
        nodeArray.append(child)
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
