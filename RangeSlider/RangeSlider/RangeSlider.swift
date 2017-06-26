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
    
    var alert: String = ""
    
    private var lastDragLocation : NSPoint?
    private var clicked : Bool = false
    
    @IBInspectable var lineColor: NSColor = NSColor.white
    @IBInspectable var rangeColor: NSColor = NSColor.red
    @IBInspectable var lineWidth: CGFloat = 1.0
    
    @IBInspectable var textColor: NSColor = NSColor.black
    @IBInspectable var minSliderValue: Int = 0 {
        didSet{
            fullRange = self.calcRange(x: minSliderValue, y: maxSliderValue)
        }
    }
    @IBInspectable var maxSliderValue: Int = 100{
        didSet{
            fullRange = self.calcRange(x: minSliderValue, y: maxSliderValue)
        }
    }
    
    var fullRange: Int =  0
    var pixelRange: CGFloat = 0
    
    @IBInspectable var textSize: CGFloat = 14.0
    @IBInspectable var sliderButtonColor: NSColor = NSColor.black
    
    @IBInspectable var sliderMinPosition: Int = 50 {
        didSet{
            
            
            if sliderMinPosition >= minSliderValue && sliderMinPosition < sliderMaxPosition {
                selectedRange = calcRange(x: sliderMinPosition, y: sliderMaxPosition)
                needsDisplay = true
            } else {
                alert = "Incorrect range value"
                selectedRange = 0
            }
        }
    }
    @IBInspectable var sliderMaxPosition: Int = 70 {
        
        didSet {
            
            if sliderMaxPosition <= maxSliderValue && sliderMaxPosition > sliderMinPosition {
                selectedRange = calcRange(x: sliderMinPosition, y: sliderMaxPosition)
                needsDisplay = true
            } else {
                alert = "Incorrect range value"
                selectedRange = 0
            }
        }
    }
    var selectedRange: Int = 0

    
    func calcRange(x: Int, y:Int) -> Int {
        return y-x
    }
    
    func convertToRange(x:Int) -> CGFloat {
        
        return CGFloat(x)/CGFloat(fullRange)
    }
    
    func calculatePosition(){
    }
    
    override func draw(_ dirtyRect: NSRect) {
        super.draw(dirtyRect)

        // Drawing code here.
        lineColor.setStroke()
        
        // Draw line using NSBezierpath
        let barPath = NSBezierPath()
        barPath.lineWidth = lineWidth
        let startPoint:NSPoint = NSMakePoint(bounds.minX+textSize*2, bounds.midY)
        let endPoint: NSPoint = NSMakePoint(bounds.maxX-textSize*3, bounds.midY)
        barPath.move(to: startPoint)
        barPath.line(to: endPoint)
        barPath.stroke()
        
        //Draw text of Maximum and Minimum Value of slider
       
        (String(minSliderValue) as NSString).draw(
            at: NSMakePoint(bounds.minX+textSize,bounds.midY-textSize/2.0))
        
        (String(maxSliderValue) as NSString).draw(
            at: NSMakePoint(bounds.maxX-textSize*2.5,bounds.midY-textSize/2.0))
        
        fullRange = calcRange(x: minSliderValue, y: maxSliderValue)
//        let sliderMin: CGFloat = startPoint.x + convertToRange(x: sliderMinPosition)
//        let sliderMax: CGFloat = startPoint.x + convertToRange(x: sliderMaxPosition)
        
        pixelRange = endPoint.x - startPoint.x
        
        let start: CGFloat = convertToRange(x: sliderMinPosition)*pixelRange + startPoint.x
        let end: CGFloat = convertToRange(x: sliderMaxPosition)*pixelRange + startPoint.x
        
        //
//        var sliderStartRect: NSRect = NSMakeRect(startPoint.x, startPoint.y - 20, 5.0 , 40)
//        var sliderEndRect: NSRect = NSMakeRect(endPoint.x, endPoint.y - 20, 5.0 , 40)
        
        let sliderStartRect: NSRect = NSMakeRect(start, startPoint.y - 20.0, 5.0 , 40.0)
        let sliderEndRect: NSRect = NSMakeRect(end, endPoint.y - 20.0, 5.0 , 40.0)
        let sliderRangeRect: NSRect = NSMakeRect(sliderStartRect.minX, sliderStartRect.minY+7, sliderEndRect.maxX-sliderStartRect.minX, 26.0)
        
        
        rangeColor.setFill()
        NSRectFill(sliderRangeRect)
        
        sliderButtonColor.setFill()
        NSRectFill(sliderStartRect)
        NSRectFill(sliderEndRect)
        

        
        (String(sliderMinPosition) as NSString).draw(
            at: NSMakePoint(sliderStartRect.minX-textSize/2,sliderStartRect.maxY+textSize))
        
        (String(sliderMaxPosition) as NSString).draw(
            at: NSMakePoint(sliderEndRect.minX-textSize/2,sliderEndRect.minY - textSize*2))
        

        
        ("Selected Range: "+String(selectedRange) as NSString).draw(
            at: NSMakePoint(bounds.midX-50,bounds.minY+textSize))
        
        alert = String(describing: clicked)
        (alert as NSString).draw(
            at: NSMakePoint(bounds.midX-50,bounds.minY+100))
        
    }
    
    override func mouseDown(with event: NSEvent) {
        alert = "Mouse DOwn!"
        needsDisplay = true
    }
}
