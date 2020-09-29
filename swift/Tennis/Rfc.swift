//import Foundation
//
//class RfcCoordinator{
//
//    private let flowStrategies: FlowStrategies
//    private var flowState: FlowState
//
//    required init() {
//        flowStrategies = FlowStrategies()
//        flowState = FlowState(new Coordinator(), new Coordinator())
//    }
//
//    func Go() {
//        while !flowState.CloseProgram {
//            //Get State
//
//            //FindFlow
//            let flow = flowStrategies.findTheFlow(flowState)
//            //Execute FLow
//            flow.goWithTheFlow()
//        //update state
//            flowState =  flow.updateFlowState(flowState: <#T##FlowState#>)
//        }
//    }
//}
//
////this is a sample class for the different depencdencies we will need to refer to for getting state.
////it may be a protocol, it may not be simple.
//class Coordinator{
//    //some prop or method that we want to key off of
//    func fooBar() -> Bool
//    //some way for us to pass on data to another coordinator
//    func updateFooBar(_ newStateVal: Bool)
//}
//
////Consolidate where we get state and where we update state here.
////by moving references to other coordinators and controllers here, little is needed in the other classes.
//class RfcStateMapper{
//    //examples of holding references to other coordinators we care about.
//    var coordinator1: Coordinator
//    var coordinator2: Coordinator
//
//    init(coordinatorParam1: Coordinator, coordinatorParam2:Coordinator){
//        self.coordinator1 = coordinatorParam1
//        self.coordinator2 = coordinatorParam2
//    }
//
//    //all logic to understand the app's state is in here.
//    func getCurrentState() -> FlowState{
//        var flowState: FlowState
//        flowState.IsLogged =  coordinator1.fooBar()
//        flowState.FixBuzzApproved =  coordinator2.fooBar()
//    }
//
//    //Communicating our changes outside resides here
//    func setCurrentState(_ flowState: FlowState){
//        coordinator1.updateFooBar(flowState.IsLogged)
//        coordinator2.updateFooBar(flowState.FixBuzzApproved)
//    }
//
//}
//
////Manage how to get the right flow from all possibilities
////This is purely functional.  No logic directly depends upon anything other than what is supplied from params.
//class FlowStrategies{
//
//    let strategies: [FlowStrategy]
//
//    init(strategiesParam: [FlowStrategy]){
//        strategies = strategiesParam
//    }
//
//    //either pass in the
//    required init() {
//        strategies.append(LoginFlowStrategy())
//        strategies.append(ForgotPasswordFlowStrategy())
//        strategies.append(HomeFlowStrategy())
//        strategies.append(NewFlowStrategy())
//    }
//
//
//    func findTheFlow(_ flowState: FlowState) -> FlowStrategy{
//        for flowStrategy in strategies {
//            if flowStrategy.good(flowStrategy){
//                return flowStrategy
//            }
//        }
//        throw exception_raise(<#T##exception_port: mach_port_t##mach_port_t#>, <#T##thread: mach_port_t##mach_port_t#>, <#T##task: mach_port_t##mach_port_t#>, <#T##exception: exception_type_t##exception_type_t#>, <#T##code: exception_data_t!##exception_data_t!#>, <#T##codeCnt: mach_msg_type_number_t##mach_msg_type_number_t#>)
//
//    }
//}
//
////All possible states are defined here.
//struct FlowState{
//    var IsLogged : Bool
//    var TermsAndConditionsSigned : Bool
//    var CountrySelected : Bool
//    var FixBuzzApproved : Bool
//    var CloseProgram: Bool
//}
////
//protocol FlowStrategy {
//    func isGoodToFlow(_ flowState: FlowState) -> Bool
//    func goWithTheFlow()
//    func updateFlowState(flowState: FlowState) -> FlowState
//}
//
//class LoginFlowStrategy:FlowStrategy {
//    init(){}
//
//    func isGoodToFlow(_ flowState: FlowState) -> Bool {
//        //logic that evaluates the state and checks if this strategy applies.
//        //this combines the knowlwedge of When the strategy should be used with What to do
//        // It's fine to move this to another class as well that maps the state to a strategy.
//        return flowState.IsLogged==false
//    }
//
//    func goWithTheFlow() {
//        //perform login
//        //here is the meaty logic.
//        //we just need to pass in which coordinator or controller to call and delegate  that work off.
//    }
//
//    func updateFlowState(flowState: FlowState) ->FlowState {
//        flowState.IsLogged=true //todo: find what the syntax is to update this.
//        return flowState
//    }
//}
//
//class ForgotPasswordFlowStrategy:FlowStrategy {
//    func isGoodToFlow(_ flowState: FlowState) -> Bool {
//        <#code#>
//    }
//
//    func goWithTheFlow() {
//        <#code#>
//    }
//
//    func updateFlowState(flowState: FlowState) -> FlowState {
//        <#code#>
//    }
//}
//
//class HomeFlowStrategy:FlowStrategy {
//    func isGoodToFlow(_ flowState: FlowState) -> Bool {
//        <#code#>
//    }
//
//    func goWithTheFlow() {
//        <#code#>
//    }
//
//    func updateFlowState(flowState: FlowState) -> FlowState {
//        <#code#>
//    }
//}
