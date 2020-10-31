import SwiftUI
import shared

func greet() -> String {
//    TasksKVM().toDoList.collect(
//        collector: Kotlinx_coroutines_coreFlowCollector,
//        completionHandler: (KotlinUnit?, Error?) -> Void
//       )
//    TasksKVM().toDoList.collect(
//        collector: Kotlinx_coroutines_coreFlowCollector,
//        completionHandler: (KotlinUnit?, Error?) -> Void
//       )
    return Greeting().greeting()
}

struct ContentView: View {
    var body: some View {
        Text(greet())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
