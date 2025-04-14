package com.netexlearning.pokemon.data.mapper

import com.netexlearning.pokemon.api.generations.*
import com.netexlearning.pokemon.data.local.entities.generations.*
import com.netexlearning.pokemon.data.local.entities.generations.entities.GenerationVIAndVIIEntity
import com.netexlearning.pokemon.data.local.entities.generations.entities.IconsEntity

object GenerationMapper {

    fun mapGenerationI(generationI: GenerationI?): GenerationISpritesEntity {
        return GenerationISpritesEntity(
            redBlue = generationI?.red_blue?.let {
                GenerationISpritesEntity.BasicSpritesEntity(
                    back_default = it.back_default,
                    back_gray = it.back_gray,
                    back_transparent = it.back_transparent,
                    front_default = it.front_default,
                    front_gray = it.front_gray,
                    front_transparent = it.front_transparent
                )
            } ?: GenerationISpritesEntity.BasicSpritesEntity("", "", "", "", "", ""),
            yellow = generationI?.yellow?.let {
                GenerationISpritesEntity.BasicSpritesEntity(
                    back_default = it.back_default,
                    back_gray = it.back_gray,
                    back_transparent = it.back_transparent,
                    front_default = it.front_default,
                    front_gray = it.front_gray,
                    front_transparent = it.front_transparent
                )
            } ?: GenerationISpritesEntity.BasicSpritesEntity("", "", "", "", "", "")
        )
    }

    fun mapGenerationIFromEntity(entity: GenerationISpritesEntity): GenerationI {
        return GenerationI(
            red_blue = GenerationI.RedBlue(
                back_default = entity.redBlue.back_default,
                back_gray = entity.redBlue.back_gray,
                back_transparent = entity.redBlue.back_transparent,
                front_default = entity.redBlue.front_default,
                front_gray = entity.redBlue.front_gray,
                front_transparent = entity.redBlue.front_transparent
            ),
            yellow = GenerationI.Yellow(
                back_default = entity.yellow.back_default,
                back_gray = entity.yellow.back_gray,
                back_transparent = entity.yellow.back_transparent,
                front_default = entity.yellow.front_default,
                front_gray = entity.yellow.front_gray,
                front_transparent = entity.yellow.front_transparent
            )
        )
    }

    fun mapGenerationII(generationII: GenerationII?): GenerationIISpritesEntity {
        return GenerationIISpritesEntity(
            crystal = generationII?.crystal?.let {
                GenerationIISpritesEntity.CrystalSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    back_shiny_transparent = it.back_shiny_transparent,
                    back_transparent = it.back_transparent,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    front_shiny_transparent = it.front_shiny_transparent,
                    front_transparent = it.front_transparent
                )
            } ?: GenerationIISpritesEntity.CrystalSpritesEntity("", "", "", "", "", "", "", ""),
            gold = generationII?.gold?.let {
                GenerationIISpritesEntity.BasicShinySpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    front_transparent = it.front_transparent
                )
            } ?: GenerationIISpritesEntity.BasicShinySpritesEntity("", "", "", "", ""),
            silver = generationII?.silver?.let {
                GenerationIISpritesEntity.BasicShinySpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    front_transparent = it.front_transparent
                )
            } ?: GenerationIISpritesEntity.BasicShinySpritesEntity("", "", "", "", "")
        )
    }

    fun mapGenerationIIFromEntity(entity: GenerationIISpritesEntity): GenerationII {
        return GenerationII(
            crystal = GenerationII.Crystal(
                back_default = entity.crystal.back_default,
                back_shiny = entity.crystal.back_shiny,
                back_shiny_transparent = entity.crystal.back_shiny_transparent,
                back_transparent = entity.crystal.back_transparent,
                front_default = entity.crystal.front_default,
                front_shiny = entity.crystal.front_shiny,
                front_shiny_transparent = entity.crystal.front_shiny_transparent,
                front_transparent = entity.crystal.front_transparent
            ),
            gold = GenerationII.Gold(
                back_default = entity.gold.back_default,
                back_shiny = entity.gold.back_shiny,
                front_default = entity.gold.front_default,
                front_shiny = entity.gold.front_shiny,
                front_transparent = entity.gold.front_transparent
            ),
            silver = GenerationII.Silver(
                back_default = entity.silver.back_default,
                back_shiny = entity.silver.back_shiny,
                front_default = entity.silver.front_default,
                front_shiny = entity.silver.front_shiny,
                front_transparent = entity.silver.front_transparent
            )
        )
    }

    fun mapGenerationIII(generationIII: GenerationIII?): GenerationIIISpritesEntity {
        return GenerationIIISpritesEntity(
            emerald = generationIII?.emerald?.let {
                GenerationIIISpritesEntity.EmeraldSpritesEntity(
                    front_default = it.front_default,
                    front_shiny = it.front_shiny
                )
            } ?: GenerationIIISpritesEntity.EmeraldSpritesEntity("", ""),
            firered_leafgreen = generationIII?.firered_leafgreen?.let {
                GenerationIIISpritesEntity.IIIGenerationSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny
                )
            } ?: GenerationIIISpritesEntity.IIIGenerationSpritesEntity("", "", "", ""),
            ruby_sapphire = generationIII?.ruby_sapphire?.let {
                GenerationIIISpritesEntity.IIIGenerationSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny
                )
            } ?: GenerationIIISpritesEntity.IIIGenerationSpritesEntity("", "", "", "")
        )
    }

    fun mapGenerationIIIFromEntity(entity: GenerationIIISpritesEntity): GenerationIII {
        return GenerationIII(
            emerald = GenerationIII.Emerald(
                front_default = entity.emerald.front_default,
                front_shiny = entity.emerald.front_shiny
            ),
            firered_leafgreen = GenerationIII.FireredLeafgreen(
                back_default = entity.firered_leafgreen.back_default,
                back_shiny = entity.firered_leafgreen.back_shiny,
                front_default = entity.firered_leafgreen.front_default,
                front_shiny = entity.firered_leafgreen.front_shiny
            ),
            ruby_sapphire = GenerationIII.RubySapphire(
                back_default = entity.ruby_sapphire.back_default,
                back_shiny = entity.ruby_sapphire.back_shiny,
                front_default = entity.ruby_sapphire.front_default,
                front_shiny = entity.ruby_sapphire.front_shiny
            )
        )
    }

    fun mapGenerationIV(generationIV: GenerationIV?): GenerationIVSpritesEntity {
        return GenerationIVSpritesEntity(
            diamond_pearl = generationIV?.diamond_pearl?.let {
                GenerationIVSpritesEntity.SharedSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    back_female = it.back_female,
                    back_shiny_female = it.back_shiny_female,
                    front_female = it.front_female,
                    front_shiny_female = it.front_female_shiny
                )
            } ?: GenerationIVSpritesEntity.SharedSpritesEntity("", "", "", "", "", "", "", ""),
            heartgold_soulsilver = generationIV?.heartgold_soulsilver?.let {
                GenerationIVSpritesEntity.SharedSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    back_female = it.back_female,
                    back_shiny_female = it.back_shiny_female,
                    front_female = it.front_female,
                    front_shiny_female = it.front_female_shiny
                )
            } ?: GenerationIVSpritesEntity.SharedSpritesEntity("", "", "", "", "", "", "", ""),
            platinum = generationIV?.platinum?.let {
                GenerationIVSpritesEntity.SharedSpritesEntity(
                    back_default = it.back_default,
                    back_shiny = it.back_shiny,
                    front_default = it.front_default,
                    front_shiny = it.front_shiny,
                    back_female = it.back_female,
                    back_shiny_female = it.back_shiny_female,
                    front_female = it.front_female,
                    front_shiny_female = it.front_female_shiny
                )
            } ?: GenerationIVSpritesEntity.SharedSpritesEntity("", "", "", "", "", "", "", "")
        )
    }

    fun mapGenerationIVFromEntity(entity: GenerationIVSpritesEntity): GenerationIV {
        return GenerationIV(
            diamond_pearl = GenerationIV.DiamondPearl(
                back_default = entity.diamond_pearl.back_default,
                back_female = entity.diamond_pearl.back_female,
                back_shiny = entity.diamond_pearl.back_shiny,
                back_shiny_female = entity.diamond_pearl.back_shiny_female,
                front_default = entity.diamond_pearl.front_default,
                front_female = entity.diamond_pearl.front_female,
                front_shiny = entity.diamond_pearl.front_shiny,
                front_female_shiny = entity.diamond_pearl.front_shiny_female
            ),
            heartgold_soulsilver = GenerationIV.HeartgoldSoulsilver(
                back_default = entity.heartgold_soulsilver.back_default,
                back_female = entity.heartgold_soulsilver.back_female,
                back_shiny = entity.heartgold_soulsilver.back_shiny,
                back_shiny_female = entity.heartgold_soulsilver.back_shiny_female,
                front_default = entity.heartgold_soulsilver.front_default,
                front_female = entity.heartgold_soulsilver.front_female,
                front_shiny = entity.heartgold_soulsilver.front_shiny,
                front_female_shiny = entity.heartgold_soulsilver.front_shiny_female
            ),
            platinum = GenerationIV.Platinum(
                back_default = entity.platinum.back_default,
                back_female = entity.platinum.back_female,
                back_shiny = entity.platinum.back_shiny,
                back_shiny_female = entity.platinum.back_shiny_female,
                front_default = entity.platinum.front_default,
                front_female = entity.platinum.front_female,
                front_shiny = entity.platinum.front_shiny,
                front_female_shiny = entity.platinum.front_shiny_female
            )
        )


    }

    fun mapGenerationV(generationV: GenerationV?): GenerationVSpritesEntity {
        return GenerationVSpritesEntity(
            black_white = generationV?.black_white?.let {
                GenerationVSpritesEntity.BlackWhiteSpritesEntity(
                    animated = it.animated?.let { animated ->
                        GenerationVSpritesEntity.AnimatedSpritesEntity(
                            back_default = animated.back_default,
                            back_female = animated.back_female,
                            back_shiny = animated.back_shiny,
                            back_shiny_female = animated.back_shiny_female,
                            front_default = animated.front_default,
                            front_female = animated.front_female,
                            front_shiny = animated.front_shiny,
                            front_shiny_female = animated.front_female_shiny
                        )
                    } ?: GenerationVSpritesEntity.AnimatedSpritesEntity("", "", "", "", "", "", "", ""),
                    back_default = it.back_default,
                    back_female = it.back_female,
                    back_shiny = it.back_shiny,
                    back_shiny_female = it.back_shiny_female,
                    front_default = it.front_default,
                    front_female = it.front_female,
                    front_shiny = it.front_shiny,
                    front_shiny_female = it.front_female_shiny
                )
            } ?: GenerationVSpritesEntity.BlackWhiteSpritesEntity(
                animated = GenerationVSpritesEntity.AnimatedSpritesEntity("", "", "", "", "", "", "", ""),
                back_default = "",
                back_female = "",
                back_shiny = "",
                back_shiny_female = "",
                front_default = "",
                front_female = "",
                front_shiny = "",
                front_shiny_female = ""
            )
        )
    }

    fun mapGenerationVFromEntity(entity: GenerationVSpritesEntity): GenerationV {
        return GenerationV(
            black_white = GenerationV.BlackWhite(
                animated = GenerationV.Animated(
                    back_default = entity.black_white.animated.back_default,
                    back_female = entity.black_white.animated.back_female,
                    back_shiny = entity.black_white.animated.back_shiny,
                    back_shiny_female = entity.black_white.animated.back_shiny_female,
                    front_default = entity.black_white.animated.front_default,
                    front_female = entity.black_white.animated.front_female,
                    front_shiny = entity.black_white.animated.front_shiny,
                    front_female_shiny = entity.black_white.animated.front_shiny_female
                ),
                back_default = entity.black_white.back_default,
                back_female = entity.black_white.back_female,
                back_shiny = entity.black_white.back_shiny,
                back_shiny_female = entity.black_white.back_shiny_female,
                front_default = entity.black_white.front_default,
                front_female = entity.black_white.front_female,
                front_shiny = entity.black_white.front_shiny,
                front_female_shiny = entity.black_white.front_shiny_female
            )
        )
    }

    fun mapGenerationVI(generationVI: GenerationVI?): GenerationVISpritesEntity {
        return GenerationVISpritesEntity(
            omegaruby_alphasapphire = generationVI?.omega_ruby_alpha_sapphire?.let {
                GenerationVIAndVIIEntity(
                    front_default = it.front_default,
                    front_female = it.front_female,
                    front_shiny = it.front_shiny,
                    front_shiny_female = it.front_shiny_female
                )
            } ?: GenerationVIAndVIIEntity("", "", "", ""),
            x_y = generationVI?.x_y?.let {
                GenerationVIAndVIIEntity(
                    front_default = it.front_default,
                    front_female = it.front_female,
                    front_shiny = it.front_shiny,
                    front_shiny_female = it.front_shiny_female
                )
            } ?: GenerationVIAndVIIEntity("", "", "", "")
        )
    }

    fun mapGenerationVIFromEntity(entity: GenerationVISpritesEntity): GenerationVI {
        return GenerationVI(
            omega_ruby_alpha_sapphire = GenerationVI.OmegaRubyAlphaSapphire(
                front_default = entity.omegaruby_alphasapphire.front_default,
                front_female = entity.omegaruby_alphasapphire.front_female,
                front_shiny = entity.omegaruby_alphasapphire.front_shiny,
                front_shiny_female = entity.omegaruby_alphasapphire.front_shiny_female
            ),
            x_y = GenerationVI.XY(
                front_default = entity.x_y.front_default,
                front_female = entity.x_y.front_female,
                front_shiny = entity.x_y.front_shiny,
                front_shiny_female = entity.x_y.front_shiny_female
            )
        )
    }

    fun mapGenerationVII(generationVII: GenerationVII?): GenerationVIISpritesEntity {
        return GenerationVIISpritesEntity(
            icons = generationVII?.icons?.let {
                IconsEntity(
                    front_default = it.front_default,
                    front_female = it.front_female
                )
            } ?: IconsEntity("", ""),
            ultrasun_ultramoon = generationVII?.ultra_sun_ultra_moon?.let {
                GenerationVIAndVIIEntity(
                    front_default = it.front_default,
                    front_female = it.front_female,
                    front_shiny = it.front_shiny,
                    front_shiny_female = it.front_shiny_female
                )
            } ?: GenerationVIAndVIIEntity("", "", "", "")
        )
    }

    fun mapGenerationVIIFromEntity(entity: GenerationVIISpritesEntity): GenerationVII {
        return GenerationVII(
            icons = GenerationVII.Icons(
                front_default = entity.icons.front_default,
                front_female = entity.icons.front_female
            ),
            ultra_sun_ultra_moon = GenerationVII.UltraSunUltraMoon(
                front_default = entity.ultrasun_ultramoon.front_default,
                front_female = entity.ultrasun_ultramoon.front_female,
                front_shiny = entity.ultrasun_ultramoon.front_shiny,
                front_shiny_female = entity.ultrasun_ultramoon.front_shiny_female
            )
        )
    }

    fun mapGenerationVIII(generationVIII: GenerationVIII?): GenerationVIIISpritesEntity {
        return GenerationVIIISpritesEntity(
            icons = generationVIII?.icons?.let {
                IconsEntity(
                    front_default = it.front_default,
                    front_female = it.front_female
                )
            } ?: IconsEntity("", "")
        )
    }

    fun mapGenerationVIIIFromEntity(entity: GenerationVIIISpritesEntity): GenerationVIII {
        return GenerationVIII(
            icons = GenerationVIII.Icons(
                front_default = entity.icons.front_default,
                front_female = entity.icons.front_female
            )
        )
    }
}