//
//  RangeSlider.swift
//  RangeSlider
//
//  Created by Vinoth Pandian on 25/06/17.
//  Copyright © 2017 Vinoth Pandian. All rights reserved.
//

import Cocoa

@IBDesignable

class RangeSlider: NSView {
    
    // string for testing MUST be REMOVED before submission
    var alert: String = ""
    var alert1: String = ""
    
    //  Horizontal bar color, width, minimum and maximum bar values
    @IBInspectable var barlineColor: NSColor = NSColor.black
    @IBInspectable var barlineWidth: CGFloat = 1.0

    @IBInspectable var minBarValue: Int = 0 {
        didSet{
            fullRange = self.calcRange(x: minBarValue, y: maxBarValue)
            recalculateSliderPosition()
            needsDisplay = true
        }
    }
    @IBInspectable var maxBarValue: Int = 100{
        didSet{
            fullRange = self.calcRange(x: minBarValue, y: maxBarValue)
            recalculateSliderPosition()
            needsDisplay = true
        }
    }
    
    // default values for text size and color
    @IBInspectable var textSize: CGFloat = 14.0
    @IBInspectable var textColor: NSColor = NSColor.black
    
    // color of the slider buttons and the range bar
    @IBInspectable var sliderButtonColor: NSColor = NSColor.black
    @IBInspectable var rangeColor: NSColor = NSColor.red
    
    // stores the left slider position and also checks whether it satisfies the limits
    @IBInspectable var leftSliderPos: Int = 50 {
        didSet{
            if leftSliderPos >= minBarValue && leftSliderPos < rightSliderPos {
                recalculateSliderPosition()
                needsDisplay = true
            }
        }
    }
    
    // stores the right slider position and also checks whether it satisfies the limits
    @IBInspectable var rightSliderPos: Int = 70 {
        didSet {
            if rightSliderPos <= maxBarValue && rightSliderPos > leftSliderPos {
                recalculateSliderPosition()
                needsDisplay = true
            }
        }
    }
    
    // range of left and right slider position
    var selectedRange: Int?
    
    // to store the range of minimum and maximum bar value. It is calculated in pixels too for display
    var fullRange: Int?
    var pixelRange: CGFloat?
    
    // start and end points of Horizontal bar line
    var startPoint:NSPoint?
    var endPoint: NSPoint?
    
    var leftX: CGFloat?
    var rightX: CGFloat?
    
    var leftSliderRect: NSRect?
    var rightSliderRect: NSRect?
    var sliderRangeRect: NSRect?
    var sliderBounds: NSRect?
    
    var lastClickPos: NSPoint?
    
    var leftSliderClicked: Bool = false
    var rightSliderClicked: Bool = false
    var rangelSliderClicked: Bool = false
    
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        
        startPoint = NSMakePoint(bounds.minX+textSize*2, bounds.midY)
        endPoint = NSMakePoint(bounds.maxX-textSize*3, bounds.midY)
        
        // calculate the range and position of left and right slider
        fullRange = calcRange(x: minBarValue, y: maxBarValue)
        pixelRange = endPoint!.x - startPoint!.x
        
        recalculateSliderPosition()
    }

    
    func recalculateSliderPosition(){
        selectedRange = calcRange(x: leftSliderPos, y: rightSliderPos)
        leftX = calculatePosition(x: leftSliderPos)
        rightX = calculatePosition(x: rightSliderPos)
        leftSliderRect = NSMakeRect(leftX!, startPoint!.y - 15.0, 5.0 , 30.0)
        rightSliderRect = NSMakeRect(rightX!, endPoint!.y - 15.0, 5.0 , 30.0)
        sliderRangeRect = NSMakeRect(leftSliderRect!.minX, leftSliderRect!.minY, rightSliderRect!.maxX-leftSliderRect!.minX, 30.0)
        sliderBounds = NSMakeRect(leftSliderRect!.minX, leftSliderRect!.minY, rightSliderRect!.maxX-leftSliderRect!.minX, 30.0)
    }
    
    // function to calculate the range between two values x and y
    func calcRange(x: Int, y:Int) -> Int {
        return y-x
    }
    
    // converts the absolute position to value to its relative value in the slider
    func convertToRange(x:Int) -> CGFloat {
        
        return CGFloat(x-minBarValue)/CGFloat(fullRange!)
    }
    
    func convertToPos(x:CGFloat) -> Int {
        return Int((x-startPoint!.x)/pixelRange!*CGFloat(fullRange!))
    }
    
    func calculatePosition(x: Int) -> CGFloat {
        return convertToRange(x: x)*pixelRange! + startPoint!.x
    }
    
    
    override func mouseDown(with event: NSEvent) {
        
        lastClickPos = superview!.convert(event.locationInWindow, from: nil)
        
        if leftSliderRect!.contains(lastClickPos!) {
            leftSliderClicked = true
        } else if rightSliderRect!.contains(lastClickPos!) {
            rightSliderClicked = true
        } else if sliderRangeRect!.contains(lastClickPos!) {
            rangelSliderClicked = true
        }
    }
    
    override func mouseUp(with event: NSEvent) {
        
//        let clickPos: NSPoint = superview!.convert(event.locationInWindow, from: nil)
//        
//        if leftSliderClicked {
//            leftSliderPos = convertToPos(x: (clickPos.x-lastClickPos!.x)+leftSliderRect!.minX)
//        } else if rightSliderClicked {
//            rightSliderPos = convertToPos(x: (clickPos.x-lastClickPos!.x)+rightSliderRect!.minX)
//        }
        
        leftSliderClicked = false
        rightSliderClicked = false
        rangelSliderClicked = false
    }
    
    override func mouseDragged(with event: NSEvent) {
        let clickPos: NSPoint = superview!.convert(event.locationInWindow, from: nil)
        let deltaX = lastClickPos!.x - clickPos.x
        
        if leftSliderClicked {
            alert = String(describing: lastClickPos!.x)
            alert1 = String(describing: clickPos.x)
            leftSliderRect!.offsetBy(dx: deltaX, dy: 0)
        } else if rightSliderClicked {
            rightSliderPos = convertToPos(x: (clickPos.x-lastClickPos!.x)+rightSliderRect!.minX)
        }
        
        needsDisplay = true
        
    }
    
    // draw the window
    override func draw(_ dirtyRect: NSRect) {
        super.draw(dirtyRect)

        // Drawing code here.
        barlineColor.setStroke()
        
        // Draw line using NSBezierpath
        let barPath = NSBezierPath()
        barPath.lineWidth = barlineWidth
        barPath.move(to: startPoint!)
        barPath.line(to: endPoint!)
        barPath.stroke()
        
        //Draw text of Maximum and Minimum Value of slider
       
        (String(minBarValue) as NSString).draw(
            at: NSMakePoint(bounds.minX+textSize,bounds.midY-textSize/2.0))
        
        (String(maxBarValue) as NSString).draw(
            at: NSMakePoint(bounds.maxX-textSize*2.5,bounds.midY-textSize/2.0))
        
        // draw left, right and range sliders
        rangeColor.setFill()
        NSRectFill(sliderRangeRect!)
        sliderButtonColor.setFill()
        NSRectFill(leftSliderRect!)
        NSRectFill(rightSliderRect!)
        

        // draw respective text value near left and right sliders
        (String(leftSliderPos) as NSString).draw(
            at: NSMakePoint(leftSliderRect!.minX-textSize/2,leftSliderRect!.maxY+textSize))
        
        (String(rightSliderPos) as NSString).draw(
            at: NSMakePoint(rightSliderRect!.minX-textSize/2,rightSliderRect!.minY - textSize*2))
        

        // draw selected range value string
        ("Selected Range: " + String(selectedRange!) as NSString).draw(
            at: NSMakePoint(bounds.midX-50,bounds.minY+textSize))
        
        // test alert
        (alert as NSString).draw(
            at: NSMakePoint(bounds.midX-50,bounds.maxY-20))
        
        // test alert1
        (alert1 as NSString).draw(
            at: NSMakePoint(bounds.midX-50,bounds.maxY-40))
        
    }

}
