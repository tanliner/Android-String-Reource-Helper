package com.lin.string.helper

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.lang.IllegalArgumentException
import javax.xml.parsers.DocumentBuilderFactory

public object AndroidStringResourceHelper {
    private val mapPool = mutableMapOf<String, String>()
    private val allRStrings = mutableMapOf<Int, String>()

    init {
        if (allRStrings.isEmpty()) {
            allRStrings.putAll(getFieldsWithIndicates())
        }
        if (mapPool.isEmpty()) {
            mapPool.putAll(parseStringXml())
        }
    }

    private fun getString(resId: Int): String {
        val key = allRStrings[resId]
        return mapPool[key] ?: throw IllegalArgumentException("No resource found for id: $resId")
    }

    fun getString(resId: Int, vararg args: Any): String {
        val raw = getString(resId)

        return String.format(raw, *args)
    }

    private fun getFieldsWithIndicates(): Map<Int, String> {
        return R.string::class.java.declaredFields
            .filter { it.name != "\$jacocoData" }
            .associate { it.getInt(R.string::class) to it.name }
    }

    private fun parseStringXml(): Map<String, String> {
        val stringsXml = "src/main/res/values/strings.xml"
        val root = "resources"
        val stringNode = "string"
        val stringAttr = "name"
        val document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(File(stringsXml))
        val resourceNode = document.getElementsByTagName(root).item(0)
        val stringNodes = mutableListOf<Element>()
        for (i in 0 until resourceNode.childNodes.length) {
            val node = resourceNode.childNodes.item(i)
            if (node.nodeType == Node.ELEMENT_NODE && node.nodeName == stringNode) {
                stringNodes.add(node as Element)
            }
        }
        return stringNodes.associate { it.getAttribute(stringAttr) to it.textContent }
    }
}
