//
//  XmlBuilder.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 9/21/20.
//

import Foundation


class XmlBuilder {
    
    func buildXML(firstName: String, lastName: String) -> String {
        //let node1 = XMLElement(name: "first", stringValue: firstName)
        
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
//        return "<names>" +
//            "<name>" +
//            "<first>Donnie</first>" +
//            "<last>Duck</last>" +
//            "</name>" +
//            "</names>"
    }
    

}
    
//    import Cocoa
//
//    let node1 = XMLElement(name: "first", stringValue: "Donnie")
//    let node2 = XMLElement(name: "last", stringValue: "Duck")
//
//    let nameNode = XMLElement(name: "name")
//
//    nameNode.addChild(node1)
//    nameNode.addChild(node2)
//    let root = XMLElement(name: "names")
//    root.addChild(nameNode)
//
//    let document = XMLDocument(rootElement: root)
//    let xmlData = document.xmlData(options: .nodePrettyPrint)
//
//    // swift 3 version:
//    //let xmlData = document.xmlData(withOptions: Int(XMLNode.Options.nodePrettyPrint.rawValue) )
//    try? xmlData.write(to: URL(fileURLWithPath: "/tmp/test.xml"))
//
//    /*
//     
//     cat /tmp/test.xml
//     
//     <names>
//        <name>
//            <first>Donnie</first>
//            <last>Duck</last>
//        </name>
//     </names>
//     */
//}
