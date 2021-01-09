package com.serwylo.beatgame.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport

abstract class InfoScreen(
        private val heading: String,
        private val subheading: String
): ScreenAdapter() {

    private val stage = Stage(FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT))

    private var bigFont = BitmapFont().apply { data.scale(0.5f) }
    private var smallFont = BitmapFont().apply { data.scale(-0.5f) }

    override fun show() {

        val group = VerticalGroup()
        group.align(Align.center)
        group.pad(PADDING)
        group.setFillParent(true)
        group.space(SPACE)
        stage.addActor(group)

        val largeLabel = Label.LabelStyle()
        largeLabel.font = bigFont

        val headingLabel = Label(heading, largeLabel)
        headingLabel.setPosition(20f, 0f)
        group.addActor(headingLabel)

        val smallLabel = Label.LabelStyle()
        smallLabel.font = smallFont

        val subheadingLabel = Label(subheading, smallLabel)
        subheadingLabel.setPosition(0f, 0f)
        group.addActor(subheadingLabel)

    }

    override fun render(delta: Float) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        stage.act(delta)
        stage.draw()

    }

    override fun dispose() {
        stage.dispose()
    }

    companion object {

        @JvmStatic
        private val VIEWPORT_WIDTH = 400f

        @JvmStatic
        private val VIEWPORT_HEIGHT = 200f

        @JvmStatic
        private val PADDING = 20f

        @JvmStatic
        private val SPACE = 10f

    }
}