import XCTest

class BuilderTests: XCTestCase {

    //Builder Test outline
    //1) create code to render XML desired below using Componsite Construction method
    //2) refactor using BuilderPattern
    //  hint addChild, addToParent, addAttribute, AddValue
    func testBuildOneNode(){
        var expected =
            "<flavors/>"+
        "<flavor name='Test-Driven Development'>"+
        "<requirements>"+
        "<requirement type='hardware'>"+
        "1 computer for every 2 participants"+
        "</requirement>"+
        "<requirements>"+
        "<requirement type='software'>"+
        "IDE"+
        "</requirement>"+
        "</requirements>"+
        "</flavor>"
        
        
        var actual 
        XCTAssertEqual(1, 2)
        
    }
}
