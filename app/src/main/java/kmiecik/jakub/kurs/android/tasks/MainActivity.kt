package kmiecik.jakub.kurs.android.tasks

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmiecik.jakub.kurs.android.tasks.ui.theme.KotlinTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
//            MyElement()
//            MyColumn()
//            MyRow()
//            MyColumnExercise()
//            MyModifier()
//            MyModifierExercise()
//            MyText()
//            MyTextAlign()
//            MyIcon()
//            MySpacer()
//            MyDivider()
//            MyProgress()
//            MyTextDividerProgressExercise()
//            MyButton()
//            MySurface()
//            MyCard()
//            MyBox()
//            MyLayoutWeight()
//            MyUdemyLayoutExercise()
//            MyClickButtons()
//            MyClickButton()
//            MyCheckBox()
//            MyRadioButton()
//            MySwitch()
//            MySlider()
//            MyIconButton()
//            MyFAB()
//            MyClickModifier()
//            MyShowTimeView()
//            MyShowTimeViewExercise()
            MyTextField()
        }
    }

    @Composable
    fun MyTextField() {
        var text by remember { mutableStateOf("") }
        
        TextField(
            value = text,
            onValueChange = { text = it /* value -> text = value */ },
            label = { Text(text = "label") },
            placeholder = { Text(text = "placeholder") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            trailingIcon = { Icon(imageVector = Icons.Default.Warning, contentDescription = "") },
            isError = true
        )
    }

    @Composable
    fun MyShowTimeViewExercise() {
        var isChecked by remember { mutableStateOf(false) }
        var sliderValue by remember { mutableStateOf(0f) }

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = isChecked, onCheckedChange = { value -> isChecked = value })
                Icon(imageVector = Icons.Default.Settings, contentDescription = "icon settings")
                Text(text = "Ustawienia")
            }

            if (isChecked) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "icon volume min"
                    )
                    Slider(
                        value = sliderValue,
                        onValueChange = { value ->
                            sliderValue = value
                        },
                        modifier = Modifier.width(300.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "icon volume max",
                        tint = if(sliderValue > 0.8f) Color.Red else Color.Black
                    )
                }

                if (sliderValue > 0.8f) {
                    Text(
                        text = "Uważaj, bo ogłuchniesz!",
                        color = Color.Red
                    )
                }
            }
        }
    }

    @Composable
    fun MyShowTimeView() {
        var isShowed by remember { mutableStateOf(false) }

        Row() {
            Button(onClick = { isShowed = !isShowed }) {
                Text(text = if (isShowed) "Schowaj" else "Pokaż")
            }
            if (isShowed) {
                Text(text = "Hej, jestem tutaj!")
            }
        }
    }

    @Composable
    fun MyClickModifier() {
        var isClick by remember { mutableStateOf(false) }
        Text(
            text = if (isClick) "Kliknąłeś mnie!" else "Jeszcze mnie nie klinkąłeś",
            modifier = Modifier
                .clickable { isClick = true }
        )
    }

    @Composable
    fun MyFAB() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add icon",
                )
            }
        }
    }

    @Composable
    fun MyIconButton() {
        var isFavorite by remember { mutableStateOf(false) }
        IconButton(onClick = { isFavorite = !isFavorite }) {
            Icon(
                imageVector = if(isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "favorite icon",
                tint = Color.Red
            )
        }
    }

    @Composable
    fun MySlider() {
        var sliderValue by remember { mutableStateOf(0f) }
        Slider(
            value = sliderValue,
            onValueChange = { value -> sliderValue = value},
            modifier = Modifier.padding(horizontal = 30.dp),
            valueRange = 0f..100f,
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Green,
                activeTickColor = Color.Yellow
            )
        )
        Text(text = "$sliderValue")
    }

    @Composable
    fun MySwitch() {
        var isChecked by remember { mutableStateOf(false) }
        Switch(
            checked = isChecked,
            onCheckedChange = {value -> isChecked = value},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Yellow
            )
        )
    }

    @Composable
    fun MyRadioButton() {
        var isSelected by remember { mutableStateOf(false) }
        RadioButton(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            colors = RadioButtonDefaults.colors(selectedColor = Color.Red)
        )
    }

    @Composable
    fun MyCheckBox() {
        var isChecked by remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked,
            onCheckedChange = { value -> isChecked = value },
            colors = CheckboxDefaults.colors(checkedColor = Color.Green)
        )
    }

    @Composable
    fun MyClickButton() {
        var number: Int by remember{ mutableStateOf(0) }

        Row(
//            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { number-- },
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(2.dp),
                enabled = if (number > 0) true else false
            ) {
                Text(text = "-")
            }
            Text(
                text = "$number",
                modifier = Modifier
                    .size(height = 30.dp, width = 50.dp)
                    .padding(horizontal = 4.dp)
                    .border(1.dp, Color.Black)
                    .wrapContentSize()
            )
            Button(
                onClick = { number++ },
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(2.dp)
            ) {
                Text(text = "+")
            }
        }
    }

    @Composable
    fun MyClickButtons() {
        val countState: MutableState<Int> = remember{ mutableStateOf(0) }
        var count: Int by remember { mutableStateOf(0) }

        Column() {
            Button(onClick = { countState.value++ }) {
                Text(text = "Click countState ${countState.value}")
            }
            Button(onClick = { count++ }) {
                Text(text = "Click count $count")
            }
            MyInnerClickButton(count = count)
            MyInnerClickStateButton(countState = countState)
        }
    }

    @Composable
    fun MyInnerClickButton(count: Int) {
        Button(onClick = { /* count++ */ }) {
            Text(text = "Inner count $count")
        }
    }
    
    @Composable
    fun MyInnerClickStateButton(countState: MutableState<Int>) {
        Button(onClick = { countState.value++ }) {
            Text(text = "Inner count state ${countState.value}")
        }
    }


    @Composable
    fun MyUdemyLayoutExercise() {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MyUdemyInfoView(Modifier.weight(1f))
                MyUdemyPriceView()
            }
        }
    }

    @Composable
    fun MyUdemyInfoView(modifier: Modifier) {
        Column(modifier = modifier) {
            Text(
                text = "Kurs Kotlin + porównanie JAVA vs Kotlin & quizy&zadania",
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "4,7",
                    color = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Ocen: 21",
                    color = Color.Magenta,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "109 uczestnika kursu",
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun MyUdemyPriceView() {
        Row() {
            Column {
                Text(
                    text = "49,99 zł",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "239,99 zł",
                    color =  Color.LightGray,
                    textDecoration = TextDecoration.LineThrough,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(
                    text = "Kup teraz",
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }


    @Composable
    fun MyLayoutWeight() {
        Row() {
            Text(
                text = "Text1",
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Text(
                text = "Text2",
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(1f)
            )
            Text(
                text = "Text3",
                modifier = Modifier
                    .background(Color.Red)
                    .weight(1f)
            )
        }
    }

    @Composable
    fun MyBox() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
//            contentAlignment = Alignment.BottomEnd
        ) {
            Text(text = "Box1", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "Box2", modifier = Modifier.align(Alignment.BottomStart))
            Text(text = "Box3", modifier = Modifier.align(Alignment.BottomEnd))

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Magenta, RoundedCornerShape(8.dp))
                        .align(Alignment.TopStart)
                )

                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Magenta, RoundedCornerShape(8.dp))
                        .align(Alignment.BottomEnd)
                )

                Spacer(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red, RoundedCornerShape(8.dp))
                        .align(Alignment.Center)
                )
            }
        }
    }

    @Composable
    fun MyCard() {
        Card(
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color.Red,
                containerColor = Color.Black
            )
        ) {
            Text(
                text = "Card1",
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Card2",
                modifier = Modifier.padding(10.dp)
            )
        }
    }

    @Composable
    fun MySurface() {
        Surface(
            contentColor = Color.Blue,  // color tekstu
            color = Color.Green, // color tła
            border = BorderStroke(2.dp, Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Surface",
                modifier = Modifier.padding(10.dp)
            )
        }
    }

    @Composable
    fun MyButton() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.DarkGray
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.DarkGray),
                contentPadding = PaddingValues(30.dp),
                modifier = Modifier.padding(10.dp),
                enabled = false
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text(text = "Add")
                }
            }
            
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Outlined Button")
            }
            
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Text Button")
            }
        }
    }

    @Composable
    fun MyTextDividerProgressExercise() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Witaj!",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
            )
            Divider()
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Divider()
            Text(
                text = "Fajny ten Twój progres!@:)",
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun MyProgress() {
        Column(modifier = Modifier.padding(10.dp)) {
            CircularProgressIndicator(color = Color.Green)
            CircularProgressIndicator(progress = 0.8f)

            LinearProgressIndicator(
                color = Color.Red,
                modifier = Modifier.fillMaxWidth(),
                trackColor = Color.Green
            )
            Spacer(modifier = Modifier.padding(10.dp))
            LinearProgressIndicator(
                progress = 0.8f,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }

    @Composable
    fun MyDivider() {
        Column {
            Text(text = "Jestem wyżej")
            Divider(
                color = Color.Red,
                thickness = 5.dp
            )
            Text(text = "A ja niżej")
        }
    }

    @Composable
    fun MySpacer() {
        Column() {
            Text(
                text = "Jestem wyżej",
//                modifier = Modifier.padding(bottom = 20.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
            Text(text = "A ja niżej")
        }
    }

    @Composable
    fun MyIcon() {
        Column() {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email icon")
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email icon")
            Icon(imageVector = Icons.Default.Done, contentDescription = "Done icon", tint = Color.Green)

            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Done icon",
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Green, CircleShape)
                    .border(2.dp, Color.LightGray, CircleShape)
                    .padding(4.dp)
            )
        }
    }

    @Composable
    fun MyTextAlign() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
//            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Text1",
                modifier = Modifier
                    .background(Color.Green)
                    .align(Alignment.End)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Text(
                text = "Text2",
                modifier = Modifier
                    .background(Color.Yellow)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Text3",
                modifier = Modifier
                    .background(Color.Red)
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .height(50.dp)
                    .wrapContentSize()
//                textAlign = TextAlign.Center,
            )
        }
    }

    @Composable
    fun MyText() {
        Text(
            text = "Piszę sobie własny tekst w Text, który jest mało ciekawy i kreatywny",
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(Color.Yellow)
        )
    }

    @Composable
    fun MyModifierExercise() {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Top",
                modifier = Modifier
                    .background(Color.Gray)
            )
            Text(
                text = "Bottom",
                modifier = Modifier
                    .border(1.dp, Color.White, CircleShape)
                    .background(Color.LightGray, CircleShape)
                    .padding(5.dp)
            )
        }
    }

    @Composable
    fun MyModifier() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
//                .fillMaxHeight()
//                .fillMaxWidth()
                .fillMaxSize()
//                .height(100.dp)
//                .width(500.dp)
//                .size(height = 100.dp, width = 200.dp)
//                .padding(50.dp)
//                .padding(top = 16.dp, bottom = 30.dp, start = 10.dp, end = 50.dp)
//                .padding(horizontal = 20.dp) //start i end
                .padding(vertical = 30.dp), //top i bottom
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Proin nec neque nisl. Praesent interdum scelerisque vestibulum. " +
                    "Nunc dictum nisi nec interdum placerat. Curabitur congue sem sem. " +
                    "Curabitur ullamcorper augue a purus dictum aliquam. Praesent sit amet odio " +
                    "viverra, scelerisque sapien eu, pellentesque dui. Nullam elit mi, rutrum vel " +
                    "ipsum id, tempus malesuada ipsum. Donec in libero ut ligula sollicitudin molestie. " +
                    "Aenean vulputate lorem sagittis ligula vestibulum egestas. Vivamus tortor nunc, " +
                    "vestibulum in tempor et, cursus vitae magna. Aliquam et consequat ex, a congue ex. " +
                    "Nulla luctus velit libero, sed rhoncus purus consequat id.",
                modifier = Modifier
                    .width(200.dp)
                    .clip(CircleShape) // wycięcie rzeczy poza background
                    .background(Color.Cyan) //RectangleShape, CircleShape, RoundedCornerShape, CutCornerShape
                    .padding(20.dp)
                    .rotate(45f)
                    .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
            )
            Text(
                text = "android",
                modifier = Modifier
                    .background(Color.Red)
                    .padding(20.dp)
                    .background(Color.Blue)
                    .padding(20.dp)
                    .background(Color.Green)
                    .rotate(45f)
                    .border(1.dp, Color.Black)
            )
        }
    }

    @Composable
    fun MyColumnExercise() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Witaj!")
            Text(text = "Witaj ponownie!")
            Text(text = "Witaj jeszcze raz!")
        }
    }

    @Composable
    fun MyRow() {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically, // Top CenterVertically Bottom
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Witaj!")
            Text(text = "Witaj ponownie!")
            Text(text = "Witaj ponownie!")
        }
    }

    @Composable
    fun MyColumn() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, //Start, CenterHorizontally, End
            verticalArrangement = Arrangement.Center //
        ) {
            Text(text = "Witaj!")
            Text(text = "Witaj ponownie!")
            Text(text = "Witaj ponownie!")
        }
    }

    @Composable
    fun MyElement() {
        Text(text = "Witaj!")
        Text(text = "Witaj ponownie!")
        Text(text = "Witaj ponownie!")
    }
}