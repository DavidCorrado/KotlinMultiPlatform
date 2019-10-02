//
//  BaseViewController.swift
//  players
//
//  Created by Michael Mathieu on 10/2/19.
//  Copyright © 2019 Example. All rights reserved.
//

import UIKit
import SharedCode

class BaseViewController: UIViewController {
    
    var lifecycle = KLifecycle()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lifecycle.start()
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        lifecycle.stop()
    }
}
