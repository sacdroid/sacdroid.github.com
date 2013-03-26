import os
startSvg = """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<svg version="1.1"
xmlns="http://www.w3.org/2000/svg"
xmlns:xlink="http://www.w3.org/1999/xlink"
width="240px" height="240px" viewBox="0 0 240 240">
"""

endSvg = """
</svg>
"""
for files in os.listdir("."):
    if files.endswith(".png"):
    	fIm = open(files, 'rb')
    	dataIm = fIm.read().encode("base64").replace('\n','')
    	addText = '<image xlink:href="data:image/png;base64,{0}" width="20" height="20" x="40" y="40" />'.format(dataIm)

    	f = open(os.path.splitext(files)[0]+".svg",'w')
    	f.write( startSvg + addText + endSvg )
    	print 'Converted '+ files + ' to ' + os.path.splitext(files)[0]+".svg"
