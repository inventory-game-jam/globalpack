package com.github.inventoryjam

import net.radstevee.packed.core.asset.impl.ResourceAssetResolutionStrategy
import net.radstevee.packed.core.key.Key
import net.radstevee.packed.core.pack.PackFormat
import net.radstevee.packed.core.pack.ResourcePackBuilder.Companion.resourcePack
import org.apache.commons.lang3.StringEscapeUtils
import java.io.File

fun main() {
    val pack = resourcePack {
        meta {
            description = "Global resources for the Inventory Game Jam"
            format = PackFormat.LATEST
            outputDir = File("run")
        }
        assetResolutionStrategy = ResourceAssetResolutionStrategy(this::class.java)
    }
    val teamNames = listOf(
        "boppers",
        "byte-raiders",
        "circuitbreakers",
        "hi-hats",
        "holocorp",
        "motherboarders",
        "punks",
        "specters"
    )

    pack.addFont {
        key = Key("igj", "teams")
        teamNames.forEachIndexed { i, name ->
            bitmap {
                key = Key("igj", "team/$name.png")
                chars = listOf(StringEscapeUtils.unescapeJava(String.format("\\uE%03d", i)))
                height = 9.0
                ascent = 8.0
            }
        }
    }
    pack.save(deleteOld = true)
    pack.createZip(File(pack.outputDir, "global.zip"))
}