import SwiftUI
import shared

struct TasksView: View {
    @ObservedObject var viewModel = TasksVM()
    var body: some View {
        Text(viewModel.tasks.first?.title ?? "NULL")
        .onAppear {
            self.viewModel.updateList()
        }
    }
}

struct TasksView_Previews: PreviewProvider {
    static var previews: some View {
        TasksView()
    }
}
