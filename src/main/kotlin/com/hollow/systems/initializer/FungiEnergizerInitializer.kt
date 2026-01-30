package com.hollow.systems.initializer

import com.hollow.components.FungiEnergizer
import com.hypixel.hytale.component.AddReason
import com.hypixel.hytale.component.CommandBuffer
import com.hypixel.hytale.component.ComponentType
import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.RemoveReason
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.component.query.Query
import com.hypixel.hytale.component.system.RefSystem
import com.hypixel.hytale.math.util.ChunkUtil
import com.hypixel.hytale.server.core.modules.block.BlockModule
import com.hypixel.hytale.server.core.universe.world.chunk.WorldChunk
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore
import com.walrusking.wklib.components.Components

class FungiEnergizerInitializer : RefSystem<ChunkStore>() {

    private val energizerType: ComponentType<ChunkStore, FungiEnergizer> by lazy {
        Components.getBlockType<FungiEnergizer>("hollow:fungi_energizer_component")!!
    }

    override fun onEntityAdded(
        ref: Ref<ChunkStore>,
        reason: AddReason,
        store: Store<ChunkStore>,
        buffer: CommandBuffer<ChunkStore>
    ) {
        val info = buffer.getComponent(ref, BlockModule.BlockStateInfo.getComponentType())
            ?: return

        val energizer = buffer.getComponent(ref, energizerType) ?: return

        val idx = info.index
        val x = ChunkUtil.xFromBlockInColumn(idx)
        val y = ChunkUtil.yFromBlockInColumn(idx)
        val z = ChunkUtil.zFromBlockInColumn(idx)

        val worldChunk = buffer.getComponent(info.chunkRef, WorldChunk.getComponentType())
        worldChunk?.setTicking(x, y, z, true)

    }

    override fun onEntityRemove(
        ref: Ref<ChunkStore>,
        reason: RemoveReason,
        store: Store<ChunkStore>,
        buffer: CommandBuffer<ChunkStore>
    ) {
    }

    override fun getQuery(): Query<ChunkStore> {
        return Query.and(
            BlockModule.BlockStateInfo.getComponentType(),
            energizerType
        )
    }

}