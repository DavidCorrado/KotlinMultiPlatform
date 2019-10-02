//
//  ViewController.swift
//  players
//
//  Created by David Corrado on 9/30/19.
//  Copyright © 2019 Example. All rights reserved.
//

import UIKit
import SharedCode

class ViewController: UIViewController {
    
    var lifecycle = KLifecycle()
    
    lazy var viewModel: MainVM = {
        MainVM()
    }()

    override func viewDidLoad() {
        super.viewDidLoad()
        lifecycle.start()
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        view.addSubview(label)
        
        viewModel.name.observe(lifecycle: lifecycle) { value in
            label.text = value as? String
        }
    }

    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        lifecycle.stop()
    }
}

