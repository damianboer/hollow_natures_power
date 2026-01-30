package com.hollow.components

import com.hypixel.hytale.codec.builder.BuilderCodec
import com.hypixel.hytale.codec.builder.BuilderField
import com.hypixel.hytale.codec.validation.Validators
import com.hypixel.hytale.component.Component
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore
import com.walrusking.wklib.components.WKBlockComponent

class FungiEnergizer(
    var currentEnergy: Double, var maxEnergy: Double, var fungiTier: Int,
): WKBlockComponent<FungiEnergizer>("hollow:fungi_energizer_component") {

    override fun clone(): Component<ChunkStore> {
        return FungiEnergizer(currentEnergy, maxEnergy, fungiTier)
    }

    fun addEnergy(energy: Double) {
        if (currentEnergy < maxEnergy) {
            currentEnergy += energy
        }
    }

    fun removeEnergy(energy: Double) {
        if (currentEnergy >= energy) {
            currentEnergy -= energy
        }
    }

    override fun buildCodec(
        fieldName: String,
        field: BuilderField.FieldBuilder<out Any?, in Any, out BuilderCodec.BuilderBase<out Any?, *>?>
    ) {
        when (fieldName) {
            "currentEnergy" -> field.documentation("Represents the current amount of energy the Fungi Component has.").addValidator(
                Validators.nonNull())
            "maxEnergy" -> field.documentation("Represents the total amount of energy the Fungi Component can hold.").addValidator(
                Validators.nonNull())
            "fungiTier" -> field.documentation("Represents the Fungi tier.")
        }
    }
}