//
//  Calculator.swift
//  TennisTests
//
//  Created by Dustin Thostenson on 10/28/20.
//

import Foundation

public class Calculator {
    
    func add(_ value: String) -> Int {
        let delimiter:String = getDelimiter(value)
        let calculationValues:String = getCalculationValues(value)

        return calculationValues
            .components(separatedBy: delimiter)
            .compactMap { Int($0) }
            .reduce (0, +)
    }

    func getDelimiter(_ value: String) -> String {
        let defaultDelimiter: String = ","
        return hasEmbeddedDelimiter(value) ?
            getEmbeddedDelimiter(value)
            : defaultDelimiter
    }
    
    func getCalculationValues(_ value: String) -> String {
        hasEmbeddedDelimiter(value) ?
            getEmbeddedData(value)
            : value
    }
    
    fileprivate func hasEmbeddedDelimiter(_ value: String) -> Bool {
        let embeddedDelimiterIndicator = "/"
        return value.hasPrefix(embeddedDelimiterIndicator)
    }
    
    fileprivate func getEmbeddedDelimiter(_ value: String) -> String {
        let embeddedDelimiterSize = 2
        return String(value.dropFirst(embeddedDelimiterSize).first!)
    }
    
    fileprivate func getEmbeddedData(_ value: String) -> String {
        let embeddedDelimiterSize = 4
        return String(value.dropFirst(embeddedDelimiterSize))
    }
    

}
