---
layout: post
title: "Batch Convert PNG into SVG using python"
date: 2013-03-26 01:17
comments: true
categories:
categories:
 - SVG
 - PNG
 - Python
 - conversion
---

 Recently I am working on product where I have been assigned to some interesting charting related tasks. As part of an assignment, I needed to convert bunch of PNGs to SVGs with embedded base64 png image as charting API I was working on written to accept SVG only so I wrote following python script which does this bulk conversion.

{% include_code png2svg.py %}

 Basically we will be converting PNG image to base64 format string and we will be using it an SVG using the template String by string concatenation. A Just run this script in directory where you have your pngs.

{% codeblock %}
sachin@sachin-VPCF226FM:~/download/icons$ python png2svg.py
{% endcodeblock %}


Life is short - you need Python! 

