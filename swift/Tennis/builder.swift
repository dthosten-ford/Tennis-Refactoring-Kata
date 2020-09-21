// Playground - noun: a place where people can play

import Foundation

protocol XMLChild {
    var XMLNode: NSXMLNode { get }
}

extension String: XMLChild {
    var XMLNode: NSXMLNode {
        return NSXMLNode.textWithStringValue(self) as NSXMLNode
    }
}

extension NSXMLNode: XMLChild {
    var XMLNode: NSXMLNode {
        return self
    }
}

struct XMLAttributes: ExpressibleByNilLiteral {
    var XMLAttributeNodes: [NSXMLNode] = []

    init() {}
    init(nilLiteral: ()) {}

    init(dictionaryLiteral elements: (String, String)...) {
        for (name, value) in elements {
            self[name] = value
        }
    }

    subscript (name: String) -> String? {
        get {
            for attr in XMLAttributeNodes {
                if attr.name == attr {
                    return attr.stringValue
                }
            }
            return nil
        }
        set {
            for (i, attr) in enumerate(XMLAttributeNodes) {
                if attr.name == attr {
                    if let newValue = newValue {
                        attr.stringValue = newValue
                    }
                    else {
                        XMLAttributeNodes.removeAtIndex(i)
                    }
                    return
                }
            }

            // Add a new one
            if let newValue = newValue {
                let node = NSXMLNode(kind: NSXMLNodeKind.NSXMLAttributeKind)
                node.name = name
                node.stringValue = newValue
                XMLAttributeNodes.append(node)
            }
        }
    }
}

func XMLTag(name: String)(attrs: XMLAttributes, builder: Void -> [XMLChild]) -> NSXMLElement {
    let elem = NSXMLElement(name: name)

    elem.attributes = attrs.XMLAttributeNodes
    elem.setChildren(
        builder().map { $0.XMLNode }
    )

    return elem
}

func emptyXMLTag(name: String)(attrs: XMLAttributes) -> NSXMLElement {
    let elem = NSXMLElement(kind: .NSXMLElementKind, options: Int(NSXMLNodeCompactEmptyElement))
    elem.name = name

    elem.attributes = attrs.XMLAttributeNodes

    return elem
}

let html = XMLTag("html")
let head = XMLTag("head")
let title = XMLTag("title")
let body = XMLTag("body")
let p = XMLTag("p")
let img = emptyXMLTag("img")

let rootElem = html(attrs: nil) {[
    head(attrs: nil) {[
        title(attrs: nil) {[ "Hello, world!" ]}
    ]},
    body(attrs: nil) {[
        p(attrs: nil) {[
            "Hello, world!"
        ]},
        p(attrs: nil) {[
            img(attrs: ["src": "urock.jpg"])
        ]}
    ]}
]}

rootElem.XMLStringWithOptions(Int(NSXMLNodePrettyPrint))
