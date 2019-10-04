//
//  ViewController.swift
//  players
//
//  Created by David Corrado on 9/30/19.
//  Copyright © 2019 Example. All rights reserved.
//

import UIKit
import SharedCode

class ViewController: BaseViewController<MainVM> {

    override func viewDidLoad() {
        super.viewDidLoad()
        viewModel = MainVM()
        viewModel!.players.observe(lifecycle: lifecycle) { value in
            
            guard let players = value as? [Player] else {return}
            var padding = 0
            players.forEach({ player in
                let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
                label.center = CGPoint(x: 160, y: 100+padding)
                label.textAlignment = .center
                label.font = label.font.withSize(25)
                label.text = player.name
                self.view.addSubview(label)
                padding = padding+50
            })
        }
    }
}

