//
//  TasksVM.swift
//  iosApp
//
//  Created by David Corrado on 11/1/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

class TasksVM: ObservableObject {
    var tasksKMV = TasksKVM()
    @Published var tasks: [Task] = [Task]()
    
    func updateList() -> Void {
        tasksKMV.toDoList.watch { tasksArray in
            if let tasks = tasksArray as? [Task] {
                self.tasks = tasks
            }
        }
        tasksKMV.updateList { (_, _) in
            
        }
    }
}
