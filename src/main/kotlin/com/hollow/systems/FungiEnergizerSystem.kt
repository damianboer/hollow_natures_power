package com.hollow.systems

import com.hollow.components.FungiEnergizer
import com.hypixel.hytale.component.ComponentType
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore
import com.walrusking.wklib.systems.block.BlockEntityTickingData
import com.walrusking.wklib.systems.block.WKBlockEntityTickingSystem

class FungiEnergizerSystem(componentType: ComponentType<ChunkStore, FungiEnergizer>) : WKBlockEntityTickingSystem<FungiEnergizer>(componentType) {
    override fun onTick(data: BlockEntityTickingData<FungiEnergizer>) {
        TODO("Not yet implemented")
    }
}