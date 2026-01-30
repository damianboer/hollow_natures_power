package com.hollow

import com.hollow.components.FungiEnergizer
import com.hollow.systems.FungiEnergizerSystem
import com.hollow.systems.initializer.FungiEnergizerInitializer
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import com.walrusking.wklib.components.Components
import com.walrusking.wklib.logging.WKLogger
import com.walrusking.wklib.plugins.WKPlugin

class Main(init: JavaPluginInit): WKPlugin("Hollow_Natures_Power", init){

    companion object {
        val HOLLOW_LOGGER = WKLogger("Hollow_Natures_Power")
    }

    override fun setup() {
        Components.registerBlockBoth(FungiEnergizer::class.java, FungiEnergizerSystem::class.java )
        chunkStoreRegistry.registerSystem(FungiEnergizerInitializer())
    }
}