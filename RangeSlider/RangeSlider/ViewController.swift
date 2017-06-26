//
//  ViewController.swift
//  RangeSlider
//
//  Created by Vinoth Pandian on 25/06/17.
//  Copyright © 2017 Vinoth Pandian. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {

    @IBOutlet @IBInspectable weak var sliderMinValue: NSTextField!
    @IBOutlet @IBInspectable weak var sliderMaxValue: NSTextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override var representedObject: Any? {
        didSet {
        // Update the view, if already loaded.
        }
    }


}

