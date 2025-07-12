package com.example.buttons.composeButtons


import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withSave
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonSample1(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {},
            shapes = ButtonDefaults.shapes(
                shape = ButtonDefaults.textShape,
                pressedShape = ButtonDefaults.squareShape
            ),
            modifier = Modifier
                .drawBehind {
                    drawIntoCanvas { canvas ->
                        val paint = Paint().asFrameworkPaint().apply {
                            isAntiAlias = false
                            color = android.graphics.Color.TRANSPARENT
                            setShadowLayer(60f, 0f, 0f, android.graphics.Color.RED)
                        }
                        canvas.nativeCanvas.drawRoundRect(
                            -20f,
                            -20f,
                            size.width+20,
                            size.height+20,
                            20f,
                            20f,
                            paint
                        )
                    }
                },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Red,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp,
                focusedElevation = 4.dp,
                hoveredElevation = 16.dp
            ),
            border = BorderStroke(width = 2.dp, color = Color.Blue),
            contentPadding = ButtonDefaults.SmallContentPadding,
        ) {
            Text(
                text = "Click"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonSample2(){
    var isPressing by remember { mutableStateOf(false) }
    val interactionSource= remember { MutableInteractionSource() }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collectLatest { interaction ->
            when(interaction){
                is PressInteraction.Press ->{
                    isPressing=true
                }
                is PressInteraction.Release->{
                    isPressing=false
                }
                is PressInteraction.Cancel->{
                    isPressing=false
                }
            }
        }
    }
    var contentColor=Color.White
    var containerColor=Color.Red
    var shape= ButtonDefaults.elevatedShape
    var shadowColor= android.graphics.Color.CYAN
    if(isPressing){
        containerColor=Color.Green
        contentColor=Color.Black
        shape= ButtonDefaults.squareShape
        shadowColor= android.graphics.Color.MAGENTA

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            shape = shape,
            interactionSource = interactionSource,
            modifier = Modifier.coloredShadow(shadowColor)

        ) {
            Text("Click")
        }
    }
}




@Preview(showBackground = true, backgroundColor = android.graphics.Color.WHITE.toLong())
@Composable
fun ButtonPreview(){

}

fun Modifier.coloredShadow(shadowColor: Int): Modifier{
    return this.drawBehind {
        drawIntoCanvas { canvas ->
           val paint=Paint().asFrameworkPaint().apply {
               isAntiAlias=true
               color= android.graphics.Color.TRANSPARENT
               setShadowLayer(20f,0f,0f,shadowColor)
           }
           canvas.nativeCanvas.drawRoundRect(20f,20f,size.width-20,size.height,20f,20f,paint)
        }
    }
}